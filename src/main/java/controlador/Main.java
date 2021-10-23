package controlador;

import dao.PalabraDAO;
import modelo.Palabra;
import ui.GamePanel;
import ui.InitPanel;
import ui.MenuBar;
import ui.PanelDialog;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.List;


public class Main {


    public static void main(String[] args) throws IOException {

        PalabraDAO palabraDAO = new PalabraDAO();
        GamePanel ventanaJuego = new GamePanel();
        InitPanel panelInit = new InitPanel();
        MenuBar menuBar = new MenuBar();
        PanelDialog ventanaInPalabra = new PanelDialog();
        PalabraControl palabraControl = new PalabraControl();

        //Panel de dialogo para el ingreso de palabras.
        ventanaInPalabra.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        ventanaInPalabra.addComponentsToPane(ventanaInPalabra.getContentPane());
        ventanaInPalabra.pack();
        ventanaInPalabra.setLocationRelativeTo(panelInit);
        ventanaInPalabra.setVisible(false);

        //Ventana de Juego.
        ventanaJuego.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventanaJuego.addComponentsToPane(ventanaJuego.getContentPane());
        ventanaJuego.pack();
        ventanaJuego.setLocationRelativeTo(null);
        ventanaJuego.setVisible(false);

        //Ventana de inicio.
        panelInit.setPreferredSize(ventanaJuego.getPreferredSize());
        panelInit.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panelInit.addComponentsToPane(panelInit.getContentPane());
        panelInit.setJMenuBar(menuBar.getMenuBar());
        panelInit.pack();
        panelInit.setLocationRelativeTo(null);
        panelInit.setVisible(true);

        /*Inicia la BD, limpia Array de palabras y vuelve a cargar desde BD.
        Evita así ralentizar la app al querer comenzar el juego.*/
        palabraControl.getPalabras().clear();
        palabraDAO.list().forEach(p -> palabraControl.getPalabras().add(p.getPalabra()));

        //Borra las palabras de la BD y del array de palabraControl.
        menuBar.getBorrarPalabras().addActionListener(e -> {
            int option = JOptionPane.showConfirmDialog(null, "Está por borrar todas" +
                         " las palabras ocultas!\n" + "¿Esta seguro?",
                         "Alerta!", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
            if (option == JOptionPane.YES_OPTION) {
                palabraDAO.list().forEach(e2 ->
                        palabraDAO.delete(e2)
                );
                palabraControl.getPalabras().clear();
            }
        });

        /*Con el botón comenzar pasamos a la ventana de juego y además si previo a eso habíamos
        ingresado alguna palabra nueva la suma al array para que esté disponible al jugar.*/
        panelInit.getComenzar().addActionListener(e -> {
                Integer cantPalabras = palabraControl.getPalabras().size();
            System.out.println(""+cantPalabras);
                panelInit.setVisible(false);
                ventanaJuego.setVisible(true);
                if(palabraControl.getPalabras().isEmpty() || cantPalabras < palabraDAO.list().size()){
                    palabraControl.getPalabras().clear();
                    palabraDAO.list().forEach(p -> palabraControl.getPalabras().add(p.getPalabra()));
                }
        });

        //Con el botón Instruccciones volvemos a la ventana inicial.
        ventanaJuego.getInstrucciones().addActionListener(e -> {
                ventanaJuego.setVisible(false);
                panelInit.setVisible(true);

        });

        //Con el botón Jugar elegimos aleatoriamente la palabra oculta y seteamos los contadores en 0.
        ventanaJuego.getJugar().addActionListener(e -> {
            try {
                ventanaJuego.volverEstadoInicial();
                palabraControl.nroAleatorio();
                palabraControl.setPalabraMain(palabraControl.devPalabra());
                ventanaJuego.mostrarPalabra(palabraControl.devPalabra());
                ventanaJuego.setCounter(0);
                ventanaJuego.setCounterError(0);
                ventanaJuego.setCounterAcierto(0);
                ventanaJuego.getIngresarCaracter().setVisible(true);
                ventanaJuego.getIngresarCaracter().setEnabled(true);
                ventanaJuego.getIngresarCaracter().requestFocusInWindow();
                ventanaJuego.getIngreseAqui().setVisible(true);
                ventanaJuego.getListCharacter().clear();
            }catch (NullPointerException f){
                JOptionPane.showMessageDialog(null, "No hay palabras ingresadas!",
                        "El Juego Del Ahorcado", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        //Toma el caracter elegido por el jugador.
        ventanaJuego.getIngresarCaracter().addActionListener(e -> {
            String ss = ventanaJuego.getIngresarCaracter().getText();
            if(ss.length()!=0){
               ventanaJuego.mostrarCaracteres(palabraControl.getPalabraMain(), ss);
               ventanaJuego.getIngresarCaracter().setText("");
               ventanaJuego.mostrarImagenes(palabraControl.getPalabraMain(), ss);
            }
        });

        //Toma el texto que se ingrese por la ventana de dialogo para ingreso de palabras.
        ventanaInPalabra.getTextDialog().addActionListener(e -> {
            palabraControl.validarPalabra(ventanaInPalabra.getTextDialog().getText());
            if (palabraControl.getValidar()){
                palabraDAO.save(palabraControl.createPalabra());
                ventanaInPalabra.getTextDialog().setText("");
                ventanaInPalabra.getTextDialog().requestFocus();
            }
        });

        //Lo mismo que lo anterior pero dando click en el botón ingresar.
        ventanaInPalabra.getButtonAdd().addActionListener(e -> {
            palabraControl.validarPalabra(ventanaInPalabra.getTextDialog().getText());
            if (palabraControl.getValidar()){
                palabraDAO.save(palabraControl.createPalabra());
                ventanaInPalabra.getTextDialog().setText("");
                ventanaInPalabra.getTextDialog().requestFocus();
            }
        });

        //Toma la acción de botón salir del panel de Dialogo de ingreso de palabras.Sale de la misma.
        ventanaInPalabra.getButtonExit().addActionListener(e -> ventanaInPalabra.setVisible(false));

        //Abre el panel de dialogo para el ingreso de palabras.
        menuBar.getIngresar().addActionListener(e -> {
            ventanaInPalabra.setVisible(true);
            ventanaInPalabra.getTextDialog().requestFocus();
        });

    }

}
