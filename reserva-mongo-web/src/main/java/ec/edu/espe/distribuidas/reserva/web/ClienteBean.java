/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.reserva.web;

import ec.edu.espe.distribuidad.reserva.web.util.FacesUtil;
import ec.edu.espe.distribuidas.reserva.enums.TipoIdentificacionEnum;
import ec.edu.espe.distribuidas.reserva.model.Cliente;
import ec.edu.espe.distribuidas.reserva.service.ClienteService;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Ing Alvaro Vasquez
 */
@Named
@ViewScoped
public class ClienteBean extends BaseBean implements Serializable {
    
    private List<Cliente> clientes;
    private Cliente cliente;
    private Cliente clienteSel;

    @Inject
    private ClienteService clienteService;
    
    @PostConstruct
    public void init() {
        this.clientes= this.clienteService.obtenerTodos();
        this.cliente= new Cliente();
    }

     
    @Override
    public void agregar() {
        this.cliente= new Cliente();
        super.agregar();
        
    }
    @Override
    public void modificar() {
        super.modificar();
        this.cliente= new Cliente();
        this.cliente.setIdentificacion(this.clienteSel.getIdentificacion());
        this.cliente.setTipoIdentificacion(this.clienteSel.getTipoIdentificacion());
        this.cliente.setNombre(this.clienteSel.getNombre());
        this.cliente.setApellido(this.clienteSel.getApellido());
        this.cliente.setTelefono(this.clienteSel.getTelefono());        
        this.cliente.setDireccion(this.clienteSel.getDireccion());         
        this.cliente.setEmail(this.clienteSel.getEmail());
        
    }
    
     public void eliminar() {
        try {
            this.clienteService.eliminar(this.clienteSel.getIdentificacion());
            this.clientes = this.clienteService.obtenerTodos();
            FacesUtil.addMessageInfo("Se elimino el registro ");
            this.clienteSel = null;
        } catch (Exception e) {
            FacesUtil.addMessageError(null, "No se puede eliminar el registro seleccionado. Verifique que no tenga informacion relacionada.");
        }
    }

    @Override
    public void detalles() {
        super.detalles();
        this.cliente = this.clienteSel;
    }
    
    public void cancelar() {
        super.reset();
        this.cliente = new Cliente();
    }
    
    public void guardar() {
        try {
            if (this.enAgregar) {
                this.clienteService.crear(this.cliente);
                FacesUtil.addMessageInfo("Se agregó el Cliente: " + this.cliente.getNombre());
            } else {
                this.clienteService.modificar(this.cliente);
                FacesUtil.addMessageInfo("Se modific\u00f3 el Cliente con c\u00f3digo: " + this.cliente.getIdentificacion());
            }
        } catch (Exception ex) {
            FacesUtil.addMessageError(null, "Ocurrí\u00f3 un error al actualizar la informaci\u00f3n");
        }
        super.reset();
        this.cliente = new Cliente();
        this.clientes = this.clienteService.obtenerTodos();
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Cliente getClienteSel() {
        return clienteSel;
    }

    public void setClienteSel(Cliente clienteSel) {
        this.clienteSel = clienteSel;
    }

    public ClienteService getClienteService() {
        return clienteService;
    }

    public void setClienteService(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    

}
