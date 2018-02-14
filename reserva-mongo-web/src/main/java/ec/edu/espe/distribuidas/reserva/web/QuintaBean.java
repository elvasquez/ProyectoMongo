/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.reserva.web;

import ec.edu.espe.distribuidad.reserva.web.util.FacesUtil;
import ec.edu.espe.distribuidas.reserva.model.Quinta;
import ec.edu.espe.distribuidas.reserva.service.QuintaService;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author user
 */
@Named
@ViewScoped
public class QuintaBean extends BaseBean implements Serializable {
    
    private List<Quinta> quintas;
    private Quinta quinta;
    private Quinta quintaSel;
    
    @Inject
    private QuintaService quintaService;
    
    @PostConstruct
    public void init(){
        this.quintas= this.quintaService.obtenerTodos();
        this.quinta= new Quinta();
    }

    public List<Quinta> getQuintas() {
        return quintas;
    }
    
    @Override
    public void agregar() {
        this.quinta= new Quinta();
        super.agregar(); 
    }
    
    @Override
    public void modificar() {
        super.modificar();
        this.quinta = new Quinta();
        this.quinta.setCodigo(this.quintaSel.getCodigo());
        this.quinta.setRazonSocial(this.quintaSel.getRazonSocial());
        this.quinta.setTelefono(this.quintaSel.getTelefono());
        this.quinta.setRucQuinta(this.quintaSel.getRucQuinta());
        this.quinta.setEmail(this.quintaSel.getEmail());
        this.quinta.setDireccion(this.quintaSel.getDireccion());

    }

    public void eliminar() {
        try {
            this.quintaService.eliminar(this.quintaSel.getCodigo());
            this.quintas = this.quintaService.obtenerTodos();
            FacesUtil.addMessageInfo("Se elimino el registro ");
            this.quintaSel = null;
        } catch (Exception e) {
            FacesUtil.addMessageError(null, "No se puede eliminar el registro seleccionado. Verifique que no tenga informacion relacionada.");
        }
    }

    @Override
    public void detalles() {
        super.detalles();
        this.quinta = this.quintaSel;
    }
    
    public void cancelar() {
        super.reset();
        this.quinta = new Quinta();
    }
    
    public void guardar() {
        try {
            if (this.enAgregar) {
                this.quintaService.crear(this.quinta);
                FacesUtil.addMessageInfo("Se agregó la Quinta: " + this.quinta.getRazonSocial());
            } else {
                this.quintaService.modificar(this.quinta);
                FacesUtil.addMessageInfo("Se modific\u00f3 la Quinta con c\u00f3digo: " + this.quinta.getCodigo());
            }
        } catch (Exception ex) {
            FacesUtil.addMessageError(null, "Ocurrí\u00f3 un error al actualizar la informaci\u00f3n");
        }
        super.reset();
        this.quinta = new Quinta();
        this.quintas = this.quintaService.obtenerTodos();
    }

    public Quinta getQuinta() {
        return quinta;
    }

    public void setQuinta(Quinta quinta) {
        this.quinta = quinta;
    }

    public Quinta getQuintaSel() {
        return quintaSel;
    }

    public void setQuintaSel(Quinta quintaSel) {
        this.quintaSel = quintaSel;
    }

    public QuintaService getQuintaService() {
        return quintaService;
    }

    public void setQuintaService(QuintaService quintaService) {
        this.quintaService = quintaService;
    }
    
    
}

