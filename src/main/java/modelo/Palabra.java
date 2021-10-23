package modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Palabra {

    @Id
    @GeneratedValue
    private Integer idPalabra;
    @Column(length = 50)
    private String palabra;

    public Palabra() {
        super();
        palabra = "";
    }

    public Palabra(String palabra) {
        this.palabra = palabra;
    }

    public Integer getIdPalabra() {
        return idPalabra;
    }

    public void setIdPalabra(Integer idPalabra) {
        this.idPalabra = idPalabra;
    }

    public String getPalabra() {
        return palabra;
    }

    public void setPalabra(String palabra) {
        this.palabra = palabra;
    }

    @Override
    public String toString() {
        return "Palabra{" +
                "idPalabra=" + idPalabra +
                ", palabra='" + palabra + '\'' +
                '}';
    }

}
