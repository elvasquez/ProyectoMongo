/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.reserva.service;

import ec.edu.espe.distribuidas.nosql.mongo.MongoPersistence;
import ec.edu.espe.distribuidas.reserva.dao.RepresentanteQuintaDAO;
import ec.edu.espe.distribuidas.reserva.model.RepresentanteQuinta;
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
public class RepresentanteQuintaService {
    
    @EJB
    private MongoPersistence mp;
    private RepresentanteQuintaDAO representanteQuintaFacade;
    
    @PostConstruct
    public void init() {
        this.representanteQuintaFacade = new RepresentanteQuintaDAO(RepresentanteQuinta.class, mp.context());
    }

    public List<RepresentanteQuinta> obtenerTodos() {
        return this.representanteQuintaFacade.find().asList();
    }

    public RepresentanteQuinta obtenerPorCodigo(String codigo) {
        return this.representanteQuintaFacade.findOne("codigo", codigo);
    }

    public void crear(RepresentanteQuinta representanteQuinta) {
        this.representanteQuintaFacade.save(representanteQuinta);
    }

    public void modificar(RepresentanteQuinta representanteQuinta) {
        this.representanteQuintaFacade.save(representanteQuinta);
    }

    public void eliminar(String codigo) {
        RepresentanteQuinta representanteQuinta = this.representanteQuintaFacade.findOne("codigo", codigo);
        this.representanteQuintaFacade.delete(representanteQuinta);
    }
    
}
