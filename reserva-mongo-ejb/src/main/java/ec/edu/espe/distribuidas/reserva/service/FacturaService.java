/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.reserva.service;

import ec.edu.espe.distribuidas.nosql.mongo.MongoPersistence;
import ec.edu.espe.distribuidas.reserva.dao.FacturaDAO;
import ec.edu.espe.distribuidas.reserva.model.Factura;
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
public class FacturaService {
    
    @EJB
    private MongoPersistence mp;
    private FacturaDAO facturaFacade;

    @PostConstruct
    public void init() {
        this.facturaFacade = new FacturaDAO(Factura.class, mp.context());
    }

    public List<Factura> obtenerTodos() {
        return this.facturaFacade.find().asList();
    }

    public Factura obtenerPorCodigo(String codigo) {
        return this.facturaFacade.findOne("codigo", codigo);
    }

    public void crear(Factura factura) {
        this.facturaFacade.save(factura);
    }

    public void modificar(Factura factura) {
        this.facturaFacade.save(factura);
    }

    public void eliminar(String codigo) {
        Factura factura = this.facturaFacade.findOne("codigo", codigo);
        this.facturaFacade.delete(factura);
    }
    
}
