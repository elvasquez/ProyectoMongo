/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.reserva.service;

import ec.edu.espe.distribuidas.nosql.mongo.MongoPersistence;
import ec.edu.espe.distribuidas.reserva.dao.TipoSitioDAO;
import ec.edu.espe.distribuidas.reserva.model.TipoSitio;
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
public class TipoSitioService {
    
    @EJB
    private MongoPersistence mp;
    private TipoSitioDAO tipoSitioFacade;
    
    @PostConstruct
    public void init() {
        this.tipoSitioFacade = new TipoSitioDAO(TipoSitio.class, mp.context());
    }
    
    public List<TipoSitio> obtenerTodos() {
        return this.tipoSitioFacade.find().asList();
    }

    public TipoSitio obtenerPorCodigo(String codigo) {
        return this.tipoSitioFacade.findOne("codigo", codigo);
    }

    public void crear(TipoSitio tipoSitio) {
        this.tipoSitioFacade.save(tipoSitio);
    }

    public void modificar(TipoSitio tipoSitio) {
        this.tipoSitioFacade.save(tipoSitio);
    }

    public void eliminar(String codigo) {
        TipoSitio tipoSitio = this.tipoSitioFacade.findOne("codigo", codigo);
        this.tipoSitioFacade.delete(tipoSitio);
    }
}

