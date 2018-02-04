/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.reserva.service;

import ec.edu.espe.distribuidas.nosql.mongo.MongoPersistence;
import ec.edu.espe.distribuidas.reserva.dao.ReservaDAO;
import ec.edu.espe.distribuidas.reserva.model.Reserva;
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
public class ReservaService {
    
     @EJB
    private MongoPersistence mp;
    private ReservaDAO reservaFacade;
    
    @PostConstruct
    public void init() {
        this.reservaFacade = new ReservaDAO(Reserva.class, mp.context());
    }

    public List<Reserva> obtenerTodos() {
        return this.reservaFacade.find().asList();
    }

    public Reserva obtenerPorCodigo(String codigo) {
        return this.reservaFacade.findOne("codigo", codigo);
    }

    public void crear(Reserva reserva) {
        this.reservaFacade.save(reserva);
    }

    public void modificar(Reserva reserva) {
        this.reservaFacade.save(reserva);
    }

    public void eliminar(String codigo) {
        Reserva reserva = this.reservaFacade.findOne("codigo", codigo);
        this.reservaFacade.delete(reserva);
    }
    
}
