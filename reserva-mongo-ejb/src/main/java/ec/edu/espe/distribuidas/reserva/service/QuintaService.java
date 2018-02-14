/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.reserva.service;

import ec.edu.espe.distribuidas.nosql.mongo.MongoPersistence;
import ec.edu.espe.distribuidas.reserva.dao.QuintaDAO;
import ec.edu.espe.distribuidas.reserva.model.Quinta;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 *
 * @author user
 */
@Stateless
@LocalBean
public class QuintaService {
    
    @EJB
    private MongoPersistence mp;
    private QuintaDAO quintaFacade;
    
    @PostConstruct
    public void init() {
        this.quintaFacade = new QuintaDAO(Quinta.class, mp.context());
    }

    public List<Quinta> obtenerTodos() {
        return this.quintaFacade.find().asList();
    }

    public Quinta obtenerPorCodigo(String codigo) {
        return this.quintaFacade.findOne("codigo", codigo);
    }

    public void crear(Quinta quinta) {
        this.quintaFacade.save(quinta);
    }

    public void modificar(Quinta quinta) {
         Quinta aux = this.quintaFacade.findOne("codigo",quinta.getCodigo());
         quinta.setId(aux.getId());
        this.quintaFacade.save(quinta);
    }

    public void eliminar(String codigo) {
        Quinta quinta = this.quintaFacade.findOne("codigo", codigo);
        this.quintaFacade.delete(quinta);
    }
    
}
