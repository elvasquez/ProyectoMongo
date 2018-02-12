/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.reserva.model;

import java.math.BigDecimal;
import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Reference;

/**
 *
 * @author user
 */
@Embedded
class Sitio {
    
    @Reference
    private TipoSitio tipoSitio;
    private BigDecimal precio;
    private Integer numPersonasPermitidas;
    

    public Integer getNumPersonasPermitidas() {
        return numPersonasPermitidas;
    }

    public void setNumPersonasPermitidas(Integer numPersonasPermitidas) {
        this.numPersonasPermitidas = numPersonasPermitidas;
    }

    public TipoSitio getTipoSitio() {
        return tipoSitio;
    }

    public void setTipoSitio(TipoSitio tipoSitio) {
        this.tipoSitio = tipoSitio;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }
    
    
}
