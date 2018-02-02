/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.reserva.model;

import ec.edu.espe.distribuidas.nosql.mongo.BaseEntity;
import java.util.List;
import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.IndexOptions;
import org.mongodb.morphia.annotations.Indexed;

/**
 *
 * @author toshiba
 */
@Entity(noClassnameStored = true, value = "provincia")
public class Provincia extends BaseEntity{
    
    @Indexed(options = @IndexOptions(name = "provincia_codigoUIdx", unique = true))
    private String codigo;
    private String descripcion;
    
    @Embedded
    private List<Canton> cantones;

    public Provincia() {
    }

    public Provincia(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigo != null ? codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Provincia)) {
            return false;
        }
        Provincia other = (Provincia) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        return "ec.edu.espe.distribuidas.hades.model.Provincia[ codProvincia=" + codigo + " ]";
    }
    
}
