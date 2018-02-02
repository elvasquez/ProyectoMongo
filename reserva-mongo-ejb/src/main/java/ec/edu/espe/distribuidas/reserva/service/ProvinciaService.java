/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.reserva.service;

import ec.edu.espe.distribuidas.nosql.mongo.MongoPersistence;
import ec.edu.espe.distribuidas.reserva.dao.ProvinciaDAO;
import ec.edu.espe.distribuidas.reserva.model.Provincia;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 *
 * @author toshiba
 */
@Stateless
@LocalBean
public class ProvinciaService {
    
    @EJB
    private MongoPersistence mp;
    private ProvinciaDAO provinciaFacade;
    
    @PostConstruct
    public void init() {
        this.provinciaFacade = new ProvinciaDAO(Provincia.class, mp.context());
    }
    
    public List<Provincia> obtenerTodos() {
        return this.provinciaFacade.find().asList();
    }

    public Provincia obtenerPorCodigo(String codigo) {
        return this.provinciaFacade.findOne("codigo", codigo);
    }

    public void crear(Provincia provincia) {
        this.provinciaFacade.save(provincia);
    }

    public void modificar(Provincia provincia) {
        this.provinciaFacade.save(provincia);
    }

    public void eliminar(String codigo) {
        Provincia provincia = this.provinciaFacade.findOne("codigo", codigo);
        this.provinciaFacade.delete(provincia);
    }
    
}
