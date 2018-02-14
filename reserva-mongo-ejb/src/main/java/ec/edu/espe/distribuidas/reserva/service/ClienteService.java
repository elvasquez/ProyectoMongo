/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.reserva.service;

import ec.edu.espe.distribuidas.nosql.mongo.MongoPersistence;
import ec.edu.espe.distribuidas.reserva.dao.ClienteDAO;
import ec.edu.espe.distribuidas.reserva.model.Cliente;
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
public class ClienteService {
    
     @EJB
    private MongoPersistence mp;
    private ClienteDAO clienteFacade;
    
    @PostConstruct
    public void init(){
    
        this.clienteFacade = new ClienteDAO(Cliente.class, mp.context());
    }
    
    public List<Cliente> obtenerTodos() {
        return this.clienteFacade.find().asList();
    }
    
    public Cliente obtenerPorIdentificacion(String identificacion) {
        return this.clienteFacade.findOne("identificacion",identificacion);
    }
    
    public void crear(Cliente cliente) {
        this.clienteFacade.save(cliente);
    }
    
    public void modificar(Cliente cliente) {
        Cliente aux = this.clienteFacade.findOne("identificacion",cliente.getIdentificacion());
        cliente.setId(aux.getId());
        this.clienteFacade.save(cliente);
        
    }
    
    public void eliminar(String identificacion) {
        Cliente cliente = this.clienteFacade.findOne("identificacion",identificacion);
        this.clienteFacade.delete(cliente);
    }
    
}
