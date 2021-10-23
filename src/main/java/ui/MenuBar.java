package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class MenuBar {
    private JMenuBar menuBar;
    private JMenu menu;
    private JMenuItem salir = new JMenuItem("Salir");
    private ImageIcon imageIcon;
    private JMenuItem ingresar = new JMenuItem("Ingresar palabras");
    private JMenuItem borrarPalabras = new JMenuItem("Borrar palabras");

    public JMenuBar getMenuBar() {
        menuBar = new JMenuBar();
        menu = new JMenu();
        ImageIcon iconLogo = new ImageIcon(getClass().getResource("/Images/iconAdd.png"));
        Image image = iconLogo.getImage();
        Image newimg = image.getScaledInstance(12, 12,  Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(newimg);
        menu.setIcon(imageIcon);
        menuBar.add(menu);

        ingresar.setMnemonic(KeyEvent.VK_I);
        borrarPalabras.setMnemonic(KeyEvent.VK_B);

        menu.add(ingresar);
        menu.add(borrarPalabras);

        salir.setMnemonic(KeyEvent.VK_S);
        salir.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_1, ActionEvent.ALT_MASK));
        salir.addActionListener((event) -> System.exit(0));
        menu.add(salir);

        return menuBar;
    }

    public JMenuItem getIngresar() {
        return ingresar;
    }

    public JMenuItem getBorrarPalabras() {
        return borrarPalabras;
    }


}
