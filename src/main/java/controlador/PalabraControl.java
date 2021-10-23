package controlador;

import modelo.Palabra;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class PalabraControl {

    private String palabra;
    private Boolean validar = false;
    private List<String> palabras = new ArrayList<String>();
    private String palabraOculta = "";
    private String palabraAleatoria = "";
    private int nroLista = 0;

    public void validarPalabra(String p){

        palabra = p;
        if (p.isEmpty()) {
            JOptionPane.showMessageDialog(null, "!! Debes ingresar una palabra !!","El Juego Del Ahorcado",
                    JOptionPane.INFORMATION_MESSAGE);

        }
        if(p.length()>8){
            JOptionPane.showMessageDialog(null, "La palabra no puede superar los 8 caracteres!","El Juego Del Ahorcado",
                    JOptionPane.INFORMATION_MESSAGE);
        }
        if(p.length() != 0 && p.length() <= 8){
            palabra = p.toUpperCase();
            validar = true;
        }

    }

    public Palabra createPalabra(){
        Palabra pal = new Palabra(getPalabra());
        return pal;
    }

    public String getPalabra() {
        return palabra;
    }

    public Boolean getValidar() {
        return validar;
    }

    public List<String> getPalabras() {
        return palabras;
    }

    public void setPalabra(String palabra) {
        this.palabra = palabra;
    }

    public String devPalabra(){
        if(palabras.size()>0){
            palabraAleatoria = palabras.get(nroLista);
            return palabraAleatoria;
        }
        return null;
    }

    public Integer nroAleatorio(){
        nroLista = (int) (Math.random() * palabras.size());
        return nroLista;
    }

    public void setPalabraMain(String palabraOculta) {
        this.palabraOculta = palabraOculta;
    }

    public String getPalabraMain() {
        return palabraOculta;
    }
}