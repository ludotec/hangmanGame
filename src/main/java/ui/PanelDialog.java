package ui;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import java.awt.*;

public class PanelDialog extends JFrame {

    private JPanel panelDialog;
    private JTextField textDialog = new JTextField(12);
    private JButton buttonAdd = new JButton("Ingresar");
    private JButton buttonExit =  new JButton("Salir");

    public PanelDialog() {
        super("El Juego Del Ahorcado");
        setResizable(false);

    }
    public void addComponentsToPane(final Container pane){
        final JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        panelDialog = new JPanel();
        panelDialog.setLayout(new FlowLayout());
        panelDialog.setPreferredSize(new Dimension(300, 70));
        buttonExit.setMargin(new Insets(5,15,5,15));
        buttonExit.setFont(new FontUIResource(Font.SANS_SERIF,1, 14));
        buttonAdd.setMargin(new Insets(0,5,0,5));
        buttonAdd.setFont(new FontUIResource(Font.SANS_SERIF,1, 14));
        buttonExit.setToolTipText("Click aquí para salir");
        buttonAdd.setToolTipText("Click aquí para ingresar la palabra");
        textDialog.setFont(new FontUIResource(Font.SANS_SERIF,1, 14));
        panelDialog.add(textDialog);
        panelDialog.add(buttonAdd);
        panelDialog.add(buttonExit);
        panel.add(panelDialog);
        pane.add(panel,BorderLayout.CENTER);
    }

    public JTextField getTextDialog() {
        return textDialog;
    }

    public JButton getButtonAdd() {
        return buttonAdd;
    }

    public JButton getButtonExit() {
        return buttonExit;
    }
}
