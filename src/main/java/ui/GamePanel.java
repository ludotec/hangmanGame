package ui;


import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class GamePanel extends JFrame{

    private  JTextField ingresarCaracter = new JTextField();
    private JButton jugar = new JButton("Jugar");
    private JButton instrucciones = new JButton("Instrucciones");
    private JPanel panelPalabraOculta = new JPanel();
    private JLabel c1 = new JLabel();
    private JLabel c2 = new JLabel();
    private JLabel c3 = new JLabel();
    private JLabel c4 = new JLabel();
    private JLabel c5 = new JLabel();
    private JLabel c6 = new JLabel();
    private JLabel c7 = new JLabel();
    private JLabel c8 = new JLabel();
    private JLabel ingreseAqui;
    private JLabel imgRostro;
    private JLabel imgPoste;
    private JLabel imgTorso;
    private JLabel imgArmRight;
    private JLabel imgArmLeft;
    private JLabel imgLegRight;
    private JLabel imgLegLeft;
    private Boolean noAcierto = false;
    private Boolean yaFueIngresado = false;
    private Integer counter = 0;
    private Integer counterError = 0;
    private Integer counterAcierto = 0;
    private JOptionPane reiniciar = new JOptionPane();
    private ArrayList<String> listCharacter = new ArrayList<String>();


    public GamePanel() {
        super("El Juego Del Ahorcado");
        setResizable(false);


        ingresarCaracter.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);

                if (ingresarCaracter.getText().length()== 1) e.consume();

                char c = e.getKeyChar();
                String cad = ("" + c).toUpperCase();
                c = cad.charAt(0);
                e.setKeyChar(c);
                String t = ingresarCaracter.getText();
                ingresarCaracter.setToolTipText(t);
            }
        });
    }

    public void addComponentsToPane(final Container pane) {
        final JPanel panelMain = new JPanel();
        panelMain.setLayout(new GridLayout(2,4));

        JPanel panelImagen = new JPanel();
        panelImagen.setLayout(null);
        panelImagen.setPreferredSize(new Dimension(360,420));




        panelPalabraOculta.setLayout(new FlowLayout(1,10,0));
        panelPalabraOculta.setPreferredSize(new Dimension(360, 60));

        jugar.setMargin(new Insets(15,15,15,15));
        jugar.setFont(new FontUIResource(Font.SANS_SERIF,1, 14));
        instrucciones.setMargin(new Insets(15,15,15,15));
        instrucciones.setFont(new FontUIResource(Font.SANS_SERIF,1, 14));
        instrucciones.setFocusPainted(false);

        panelMain.add(new Label("   "));
        panelMain.add(new Label("   "));
        panelMain.add(new Label("   "));
        panelMain.add(new Label("   "));
        panelMain.add(new Label("   "));
        panelMain.add(instrucciones);
        panelMain.add(jugar);
        panelMain.add(new Label("   "));

        ImageIcon imagenPoste = new ImageIcon(getClass().getResource("/Images/poste.png"));
        imgPoste = new JLabel(imagenPoste);
        ImageIcon imagenRostro = new ImageIcon(getClass().getResource("/Images/face.png"));
        imgRostro = new JLabel(imagenRostro);
        ImageIcon imagenTorso = new ImageIcon(getClass().getResource("/Images/torso.png"));
        imgTorso = new JLabel(imagenTorso);
        ImageIcon imagenArmRight = new ImageIcon(getClass().getResource("/Images/armRight.png"));
        imgArmRight = new JLabel(imagenArmRight);
        ImageIcon imagenArmLeft = new ImageIcon(getClass().getResource("/Images/armLeft.png"));
        imgArmLeft = new JLabel(imagenArmLeft);
        ImageIcon imagenLegleft = new ImageIcon(getClass().getResource("/Images/legLeft.png"));
        imgLegLeft = new JLabel(imagenLegleft);
        ImageIcon imagenLegRight = new ImageIcon(getClass().getResource("/Images/legRight.png"));
        imgLegRight = new JLabel(imagenLegRight);


        imgPoste.setBounds(110, 10, 360, 380);

        imgRostro.setBounds(295, 70, 63, 63  );

        imgTorso.setBounds(295, 120, 63, 126);

        imgArmRight.setBounds(358, 120, 63, 63  );

        imgArmLeft.setBounds(232, 120, 63, 63);

        imgLegLeft.setBounds(232, 183, 63,63  );

        imgLegRight.setBounds(358, 183, 63, 63);

        panelImagen.add(imgRostro);
        panelImagen.add(imgPoste);
        panelImagen.add(imgTorso);
        panelImagen.add(imgArmRight);
        panelImagen.add(imgArmLeft);
        panelImagen.add(imgLegRight);
        panelImagen.add(imgLegLeft);

        ingresarCaracter.setHorizontalAlignment(0);
        ingresarCaracter.setFont(new FontUIResource(Font.SANS_SERIF, 1, 14));
        ingresarCaracter.setPreferredSize(new Dimension(30,30));
        ingresarCaracter.setVisible(false);

        ImageIcon iconLogo = new ImageIcon(getClass().getResource("/Images/flecha-correcta.png"));

        Image image = iconLogo.getImage();
        Image newimg = image.getScaledInstance(12, 12,  Image.SCALE_SMOOTH); // scale it the smooth way
        ImageIcon imageIcon = new ImageIcon(newimg);

        ingreseAqui = new JLabel("Ingresa aquí");
        ingreseAqui.setFont(new FontUIResource(Font.SANS_SERIF,1, 14));
        ingreseAqui.setHorizontalTextPosition(2);
        ingreseAqui.setIcon(imageIcon);
        ingreseAqui.setVisible(false);

        c1.setFont(new FontUIResource(Font.SANS_SERIF,1, 30));
        c2.setFont(new FontUIResource(Font.SANS_SERIF,1, 30));
        c3.setFont(new FontUIResource(Font.SANS_SERIF,1, 30));
        c4.setFont(new FontUIResource(Font.SANS_SERIF,1, 30));
        c5.setFont(new FontUIResource(Font.SANS_SERIF,1, 30));
        c6.setFont(new FontUIResource(Font.SANS_SERIF,1, 30));
        c7.setFont(new FontUIResource(Font.SANS_SERIF,1, 30));
        c8.setFont(new FontUIResource(Font.SANS_SERIF,1, 30));

        panelPalabraOculta.add(ingreseAqui);
        panelPalabraOculta.add(ingresarCaracter);
        panelPalabraOculta.add(c1);
        panelPalabraOculta.add(c2);
        panelPalabraOculta.add(c3);
        panelPalabraOculta.add(c4);
        panelPalabraOculta.add(c5);
        panelPalabraOculta.add(c6);
        panelPalabraOculta.add(c7);
        panelPalabraOculta.add(c8);

        Color  verde  = new Color(102, 255, 102);
        panelImagen.setBackground(verde);
        panelPalabraOculta.setBackground(verde);
        panelMain.setBackground(verde);

        pane.add(panelMain, BorderLayout.NORTH);
        pane.add(panelImagen, BorderLayout.CENTER);
        pane.add(panelPalabraOculta, BorderLayout.SOUTH);
    }

    public JTextField getIngresarCaracter() {
        return ingresarCaracter;
    }

    public JButton getJugar() {
        return jugar;
    }

    public JButton getInstrucciones() {
        return instrucciones;
    }

    public void setCounter(Integer counter) {
        this.counter = counter;
    }

    public void setCounterError(Integer counterError) {
        this.counterError = counterError;
    }

    public void setCounterAcierto(Integer counterAcierto) {
        this.counterAcierto = counterAcierto;
    }

    public JLabel getIngreseAqui() {
        return ingreseAqui;
    }

    public ArrayList<String> getListCharacter() {
        return listCharacter;
    }

    public void mostrarPalabra(String p){
        for (int i=0;i<p.length();i++){
            if(i == 0){
                char c = p.charAt(i);
                String s = (""+c);
                c1.setText("?");
            }
            if(i == 1){
                char c = p.charAt(i);
                String s = (""+c);
                c2.setText("?");
            }
            if(i == 2){
                char c = p.charAt(i);
                String s = (""+c);
                c3.setText("?");
            }
            if(i == 3){
                char c = p.charAt(i);
                String s = (""+c);
                c4.setText("?");
            }
            if(i == 4){
                char c = p.charAt(i);
                String s = (""+c);
                c5.setText("?");
            }
            if(i == 5){
                char c = p.charAt(i);
                String s = (""+c);
                c6.setText("?");
            }
            if(i == 6){
                char c = p.charAt(i);
                String s = (""+c);
                c7.setText("?");
            }
            if(i == 7){
                char c = p.charAt(i);
                String s = (""+c);
                c8.setText("?");
            }
        }
        imgRostro.setVisible(false);
        imgTorso.setVisible(false);
        imgArmRight.setVisible(false);
        imgArmLeft.setVisible(false);
        imgLegRight.setVisible(false);
        imgLegLeft.setVisible(false);
    }
    public void mostrarCaracteres(String p, String ch){
        if (listCharacter.contains(ch)) {
            JOptionPane.showMessageDialog(null, "Ya fue ingresado!","El Juego Del Ahorcado",
                    JOptionPane.WARNING_MESSAGE);
                    yaFueIngresado = true;
        } else {
            for (int i = 0; i < p.length(); i++) {
                char c = p.charAt(i);
                String s = ("" + c);
                if (s.equals(ch)) {

                    switch (i) {
                        case 0:
                            c1.setText(s);
                            counterAcierto++;
                            break;
                        case 1:
                            c2.setText(s);
                            counterAcierto++;
                            break;
                        case 2:
                            c3.setText(s);
                            counterAcierto++;
                            break;
                        case 3:
                            c4.setText(s);
                            counterAcierto++;
                            break;
                        case 4:
                            c5.setText(s);
                            counterAcierto++;
                            break;
                        case 5:
                            c6.setText(s);
                            counterAcierto++;
                            break;
                        case 6:
                            c7.setText(s);
                            counterAcierto++;
                            break;
                        case 7:
                            c8.setText(s);
                            counterAcierto++;
                            break;
                    }
                }
            }
        }
        listCharacter.add(ch);
        if(counterAcierto == p.length()){
            JOptionPane.showMessageDialog(null, "Eres genial!!",
                    "El juego del ahorcado",
                    JOptionPane.INFORMATION_MESSAGE);
            volverEstadoInicial();
        }
    }

    public void mostrarImagenes(String p, String ch){
        if (yaFueIngresado) {
            yaFueIngresado = false;
        }else {
            yaFueIngresado = false;
            for (int i=0;i<p.length();i++) {
                char c = p.charAt(i);
                String s = ("" + c);
                if (s.equals(ch)) {
                    counter++;
                }
            }
            if (counter > 0) {
                noAcierto = false;
                counter = 0;
            } else {
                noAcierto = true;
                counter = 0;
                counterError++;
             }
            switch(counterError) {
                case 1:
                    if (!imgRostro.isVisible() && noAcierto) imgRostro.setVisible(true);
                    break;
                case 2:
                    if (!imgTorso.isVisible()) imgTorso.setVisible(true);
                    break;
                case 3:
                    if (!imgLegLeft.isVisible()) imgLegLeft.setVisible(true);
                    break;
                case 4:
                    if (!imgLegRight.isVisible()) imgLegRight.setVisible(true);
                    break;
                case 5:
                    if (!imgArmLeft.isVisible()) imgArmLeft.setVisible(true);
                    break;
                case 6:
                    if (!imgArmRight.isVisible()) imgArmRight.setVisible(true);
                    break;
            }
            if(counterError == 6){
                JOptionPane.showMessageDialog(null, "Lo Colgaste! Perdiste! \nLa palabra oculta era "  + p,"El juego del ahorcado",
                        JOptionPane.INFORMATION_MESSAGE);
                volverEstadoInicial();

            }
        }
    }

    public void volverEstadoInicial(){
        imgRostro.setVisible(true);
        imgTorso.setVisible(true);
        imgArmRight.setVisible(true);
        imgArmLeft.setVisible(true);
        imgLegRight.setVisible(true);
        imgLegLeft.setVisible(true);
        setCounter(0);
        setCounterError(0);
        setCounterAcierto(0);
        c1.setText("");
        c2.setText("");
        c3.setText("");
        c4.setText("");
        c5.setText("");
        c6.setText("");
        c7.setText("");
        c8.setText("");
        ingreseAqui.setVisible(false);
        ingresarCaracter.setVisible(false);
        getListCharacter().clear();
    }

}
