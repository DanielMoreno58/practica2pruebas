package es.s2o.selenium.domain;


import java.util.Date;

/**
 * Created by Daniel Alexis on 26.02.22.
 */
public class FlightSearchDTO {

    private String origen;
    private String destino;
    private String fechaIda;

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getFechaIda() {
        return fechaIda;
    }

    public void setFechaIda(String fechaIda) {
        this.fechaIda = fechaIda;
    }

}
