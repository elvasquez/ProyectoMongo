/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.reserva.service;

import ec.edu.espe.distribuidas.nosql.mongo.MongoPersistence;
import ec.edu.espe.distribuidas.reserva.dao.DetalleFacturaDAO;
import ec.edu.espe.distribuidas.reserva.model.DetalleFactura;
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
public class DetalleFacturaService {
    
     @EJB
    private MongoPersistence mp;
    private DetalleFacturaDAO detalleFacturaFacade;
    
    @PostConstruct
    public void init() {
        this.detalleFacturaFacade = new DetalleFacturaDAO(DetalleFactura.class, mp.context());
    }

    public List<DetalleFactura> obtenerTodos() {
        return this.detalleFacturaFacade.find().asList();
    }

    public DetalleFactura obtenerPorCodigo(String codigo) {
        return this.detalleFacturaFacade.findOne("codigo", codigo);
    }

    public void crear(DetalleFactura detalleFactura) {
        this.detalleFacturaFacade.save(detalleFactura);
    }

    public void modificar(DetalleFactura detalleFactura) {
        this.detalleFacturaFacade.save(detalleFactura);
    }

    public void eliminar(String codigo) {
        DetalleFactura detalleFactura = this.detalleFacturaFacade.findOne("codigo", codigo);
        this.detalleFacturaFacade.delete(detalleFactura);
    }
    
}
