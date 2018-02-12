/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.reserva.model;

import ec.edu.espe.distribuidas.nosql.mongo.BaseEntity;
import ec.edu.espe.distribuidas.reserva.enums.TipoIdentificacionEnum;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Reference;

/**
 *
 * @author user
 */
@Entity(noClassnameStored = true, value = "representanteQuinta")
public class RepresentanteQuinta extends BaseEntity {
   
    @Reference
    private Quinta quinta; 
    private String nombre;
    private String apellido;
    private String telefono;
    private String direccionRep;
    private String identificacion;
    private String cargo;
    private TipoIdentificacionEnum tipoId;
   

    public RepresentanteQuinta() {
    }

    public Quinta getQuinta() {
        return quinta;
    }

    public void setQuinta(Quinta quinta) {
        this.quinta = quinta;
    }
            
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccionRep() {
        return direccionRep;
    }

    public void setDireccionRep(String direccionRep) {
        this.direccionRep = direccionRep;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public TipoIdentificacionEnum getTipoId() {
        return tipoId;
    }

    public void setTipoId(TipoIdentificacionEnum tipoId) {
        this.tipoId = tipoId;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (super.id != null ? super.id.hashCode() : 0);
        return hash;
    }
    
     @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RepresentanteQuinta)) {
            return false;
        }
        RepresentanteQuinta other = (RepresentanteQuinta) object;
        if ((super.id == null && other.id != null) || (super.id != null && !super.id.equals(super.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.distribuidas.reserva.model.RepresentanteQuinta[ id=" + super.id.toHexString() + " ]";
    }
    
}