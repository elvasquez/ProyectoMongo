/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.reserva.model;

import org.mongodb.morphia.annotations.Embedded;

/**
 *
 * @author toshiba
 */
@Embedded
public class Parroquia {
    
    private Canton canton;
    private String descripcion;

    public Canton getCanton() {
        return canton;
    }

    public void setCanton(Canton canton) {
        this.canton = canton;
    }
    
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}
