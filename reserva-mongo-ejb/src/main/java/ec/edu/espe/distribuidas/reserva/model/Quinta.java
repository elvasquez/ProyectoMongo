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
import org.mongodb.morphia.annotations.Reference;

/**
 *
 * @author user
 */
@Entity(noClassnameStored = true, value = "quinta")
public class Quinta extends BaseEntity{
    
    @Reference
    private Reserva reserva;
    @Reference
    private RepresentanteQuinta representanteQuintas;
    @Reference
    private Direccion direccion;
    private String codigo;
    private String razonSocial;
    private String telefono;
    private String rucQuinta;
    private String email;
    @Embedded
    private List<Servicio> servicios;
    @Embedded
    private List<Sitio> sitios;

    public Quinta() {
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    
    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getRucQuinta() {
        return rucQuinta;
    }

    public void setRucQuinta(String rucQuinta) {
        this.rucQuinta = rucQuinta;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Servicio> getServicios() {
        return servicios;
    }

    public void setServicios(List<Servicio> servicios) {
        this.servicios = servicios;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }
    
    public RepresentanteQuinta getRepresentanteQuintas() {
        return representanteQuintas;
    }

    public void setRepresentanteQuintas(RepresentanteQuinta representanteQuintas) {
        this.representanteQuintas = representanteQuintas;
    }

    public List<Sitio> getSitios() {
        return sitios;
    }

    public void setSitios(List<Sitio> sitios) {
        this.sitios = sitios;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.distribuidas.reserva.model.Quinta[ id=" + super.id.toHexString() + " ]";
    }

    
     @Override
    public int hashCode() {
        int hash = 0;
        hash += (super.id!= null ? super.id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Quinta)) {
            return false;
        }
        Quinta other = (Quinta) object;
        if ((super.id == null && other.id != null) || (super.id != null && !super.id.equals(super.id))) {
            return false;
        }
        return true;
    }
    
}
