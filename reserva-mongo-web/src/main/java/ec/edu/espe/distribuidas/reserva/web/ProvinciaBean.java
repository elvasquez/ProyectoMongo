/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.reserva.web;

import ec.edu.espe.distribuidad.reserva.web.util.FacesUtil;
import ec.edu.espe.distribuidas.reserva.model.Provincia;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import ec.edu.espe.distribuidas.reserva.service.ProvinciaService;


/**
 *
 * @author toshiba
 */
@Named
@ViewScoped
public class ProvinciaBean extends BaseBean implements Serializable {
    
    private List<Provincia> provincias;
    
    private Provincia provincia;
    
    private Provincia provinciaSel;
    
    @Inject
    private ProvinciaService provinciaService;

    @PostConstruct
    public void init() {
        this.provincias = this.provinciaService.obtenerTodos();
        this.provincia = new Provincia();
    }

    @Override
    public void agregar() {
        this.provincia = new Provincia();
        super.agregar();

    }

    @Override
    public void modificar() {
        super.modificar();
        this.provincia = new Provincia();
        this.provincia.setCodigo(this.provinciaSel.getCodigo());
        this.provincia.setDescripcion(this.provinciaSel.getDescripcion());
    }

    public void eliminar() {
        try {
            this.provinciaService.eliminar(this.provinciaSel.getCodigo());
            this.provincias = this.provinciaService.obtenerTodos();
            FacesUtil.addMessageInfo("Se elimino el registro ");
            this.provinciaSel = null;
        } catch (Exception e) {
            FacesUtil.addMessageError(null, "No se puede eliminar el registro seleccionado. Verifique que no tenga informacion relacionada.");
        }
    }
     
    public void cancelar() {
        super.reset();
        this.provincia = new Provincia();
    }
    
    public void guardar() {
        try {
            if (this.enAgregar) {
                this.provinciaService.crear(this.provincia);
                FacesUtil.addMessageInfo("Se agregó el Tipo de Sitio: " + this.provincia.getDescripcion());
            } else {
                this.provinciaService.modificar(this.provincia);
                FacesUtil.addMessageInfo("Se modific\u00f3 el Tipo de Sitio con c\u00f3digo: " + this.provincia.getCodigo());
            }
        } catch (Exception ex) {
            FacesUtil.addMessageError(null, "Ocurrí\u00f3 un error al actualizar la informaci\u00f3n");
        }
        super.reset();
        this.provincia = new Provincia();
        this.provincias = this.provinciaService.obtenerTodos();
    }

    public List<Provincia> getProvincias() {
        return provincias;
    }

    public Provincia getProvincia() {
        return provincia;
    }

    public void setProvincia(Provincia provincia) {
        this.provincia = provincia;
    }

    public Provincia getProvinciaSel() {
        return provinciaSel;
    }

    public void setProvinciaSel(Provincia provinciaSel) {
        this.provinciaSel = provinciaSel;
    }

    public ProvinciaService getProvinciaService() {
        return provinciaService;
    }

    public void setProvinciaService(ProvinciaService provinciaService) {
        this.provinciaService = provinciaService;
    }
    
    
    
}
