package ui;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.plaf.FontUIResource;
import java.awt.*;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.BadLocationException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class InitPanel extends JFrame{

    private JButton comenzar = new JButton("Comenzar");
    private JLabel titulo = new JLabel("Lee las instrucciones!");
    private JTextPane texto = new JTextPane();

    public InitPanel() {
        super("El Juego Del Ahorcado");
        setResizable(false);

    }

    public void addComponentsToPane(final Container pane) {
        final JPanel panelMain = new JPanel();
        panelMain.setLayout(new GridBagLayout());

        JPanel topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout(1,0,20));

        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new FlowLayout(1,0,20));

        comenzar.setMargin(new Insets(15,15,15,15));
        comenzar.setFont(new FontUIResource(Font.SANS_SERIF,1, 14));

        bottomPanel.add(comenzar);

        titulo.setFont(new FontUIResource(Font.SANS_SERIF,1, 22));
        topPanel.add(titulo);

        texto.setEditable(false);
        texto.setBackground(Color.ORANGE);
        texto.setBorder(BorderFactory.createRaisedBevelBorder());
        texto.setCaretPosition(texto.getStyledDocument().getLength());
        JSeparator jSeparator = new JSeparator();
        texto.insertComponent(jSeparator);
        nuevaLinea(texto);
        SimpleAttributeSet attrs = new SimpleAttributeSet();
        textoNegrita(attrs, texto, " Bienvenido a \"El Juego Del Ahorcado\"!");
        nuevaLinea(texto);
        textoNegrita(attrs, texto, " EL Juego elegirá una palabra al azar,");
        nuevaLinea(texto);
        textoNegrita(attrs, texto, " y el desafío es adivinar esta palabra!");
        nuevaLinea(texto);
        textoNegrita(attrs, texto, " Para ello tienes seis oportunidades, ");
        nuevaLinea(texto);
        textoNegrita(attrs, texto, " recuerda que cada vez que falles...");
        nuevaLinea(texto);

        textoRojo(attrs, texto, " El ahorcado estará mas complicado!! ");
        nuevaLinea(texto);

        texto.setCaretPosition(texto.getStyledDocument().getLength());
        JSeparator separator = new JSeparator();
        texto.insertComponent(separator);
        nuevaLinea(texto);

        panelMain.add(texto);

        Color  verde  = new Color(102, 255, 102);
        Border compound;
        Border raisedbevel = BorderFactory.createRaisedBevelBorder();
        Border loweredbevel = BorderFactory.createLoweredBevelBorder();
        compound = BorderFactory.createCompoundBorder(raisedbevel, loweredbevel);
        panelMain.setBorder(compound);

        bottomPanel.setBackground(verde);
        panelMain.setBackground(verde);
        panelMain.setForeground(Color.BLACK);

        pane.add(topPanel, BorderLayout.NORTH);
        pane.add(panelMain, BorderLayout.CENTER);
        pane.add(bottomPanel, BorderLayout.SOUTH);

    }

    private void textoNegrita(SimpleAttributeSet attrs, JTextPane text, String string){

		StyleConstants.setLeftIndent(attrs, 0.6f);
        StyleConstants.setRightIndent(attrs, 0.6f);

        StyleConstants.setSpaceAbove(attrs, 3f);
        StyleConstants.setBold(attrs, true);
        StyleConstants.setFontSize(attrs, 18);
        StyleConstants.setLineSpacing(attrs,1.6f);

		try {
            texto.getStyledDocument().insertString(
                    texto.getStyledDocument().getLength(), string, attrs);
        } catch (BadLocationException ex) {
            Logger.getLogger(InitPanel.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    private void textoRojo(SimpleAttributeSet attrs, JTextPane text, String string){

        StyleConstants.setForeground(attrs, Color.red);
        StyleConstants.setFontSize(attrs, 18);
        StyleConstants.setLineSpacing(attrs,1.6f);
        StyleConstants.setLeftIndent(attrs, 0.6f);
        StyleConstants.setRightIndent(attrs, 0.6f);

        try {
            texto.getStyledDocument().insertString(
                    texto.getStyledDocument().getLength(), string, attrs);
        } catch (BadLocationException ex) {
            Logger.getLogger(InitPanel.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void nuevaLinea(JTextPane text){
        try {
            texto.getStyledDocument().insertString(
                    texto.getStyledDocument().getLength(),
                    System.getProperty("line.separator"), null);
        } catch (BadLocationException ex) {
            Logger.getLogger(InitPanel.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public JButton getComenzar() {
        return comenzar;
    }


}
