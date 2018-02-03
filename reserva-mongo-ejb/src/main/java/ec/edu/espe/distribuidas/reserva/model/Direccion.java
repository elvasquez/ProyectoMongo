/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.reserva.model;

import ec.edu.espe.distribuidas.nosql.mongo.BaseEntity;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Reference;

/**
 *
 * @author Ing Alvaro Vasquez
 */
@Entity(noClassnameStored = true, value = "direccion")
class Direccion extends BaseEntity {
    
    @Reference
    private Parroquia parroquia;
    @Reference
    private Quinta quinta;
    private String callePrincipal;
    private String calleSecundaria;
    private String referencia;
    private String numCasa;

    public Parroquia getParroquia() {
        return parroquia;
    }

    public void setParroquia(Parroquia parroquia) {
        this.parroquia = parroquia;
    }

    public Quinta getQuinta() {
        return quinta;
    }

    public void setQuinta(Quinta quinta) {
        this.quinta = quinta;
    }

    public String getCallePrincipal() {
        return callePrincipal;
    }

    public void setCallePrincipal(String callePrincipal) {
        this.callePrincipal = callePrincipal;
    }

    public String getCalleSecundaria() {
        return calleSecundaria;
    }

    public void setCalleSecundaria(String calleSecundaria) {
        this.calleSecundaria = calleSecundaria;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getNumCasa() {
        return numCasa;
    }

    public void setNumCasa(String numCasa) {
        this.numCasa = numCasa;
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
        if (!(object instanceof Direccion)) {
            return false;
        }
        Direccion other = (Direccion) object;
        if ((super.id == null && other.id != null) || (super.id != null && !super.id.equals(super.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Direccion{" + "parroquia=" + parroquia + ", quinta=" + quinta + ", callePrincipal=" + callePrincipal + ", calleSecundaria=" + calleSecundaria + ", referencia=" + referencia + ", numCasa=" + numCasa + '}';
    }
    
    
    
}
