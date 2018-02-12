/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.reserva.model;

import ec.edu.espe.distribuidas.nosql.mongo.BaseEntity;
import java.math.BigDecimal;
import java.util.Date;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Reference;

/**
 *
 * @author user
 */
@Entity(noClassnameStored = true, value = "reserva")
public class Reserva extends BaseEntity{
   
    @Reference
    private Cliente cliente;
    @Reference
    private Quinta quinta;
    private Date fechaEmision;
    private BigDecimal valorFinal;
    

    public Reserva() {
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Date getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public BigDecimal getValorFinal() {
        return valorFinal;
    }

    public void setValorFinal(BigDecimal valorFinal) {
        this.valorFinal = valorFinal;
    }

   
    public Quinta getQuinta() {
        return quinta;
    }

    public void setQuinta(Quinta quinta) {
        this.quinta = quinta;
    }

   @Override
    public String toString() {
        return "ec.edu.espe.distribuidas.reserva.model.Reserva[ id=" + super.id.toHexString() + " ]";
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
        if (!(object instanceof Reserva)) {
            return false;
        }
        Reserva other = (Reserva) object;
        if ((super.id == null && other.id != null) || (super.id != null && !super.id.equals(super.id))) {
            return false;
        }
        return true;
    }
       
}
