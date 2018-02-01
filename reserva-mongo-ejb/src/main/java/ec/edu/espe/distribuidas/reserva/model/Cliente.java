/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.reserva.model;

import ec.edu.espe.distribuidas.nosql.mongo.BaseEntity;
import java.util.Objects;
import org.mongodb.morphia.annotations.Entity;

/**
 *
 * @author Ing Alvaro Vasquez
 */
@Entity(noClassnameStored = true, value = "cliente")
public class Cliente  extends BaseEntity{
   
    private String identificacion;
    private String tipoIdentificacion;
    private String apellido;
    private String nombre;
    private String direccion;
    private String telefono;
    private String email;

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getTipoIdentificacion() {
        return tipoIdentificacion;
    }

    public void setTipoIdentificacion(String tipoIdentificacion) {
        this.tipoIdentificacion = tipoIdentificacion;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }



    @Override
    public String toString() {
        return "Cliente{" + "identificacion=" + identificacion + ", tipoIdentificacion=" + tipoIdentificacion + ", apellido=" + apellido + ", nombre=" + nombre + ", direccion=" + direccion + ", telefono=" + telefono + ", email=" + email + '}';
    }

    
    
}
