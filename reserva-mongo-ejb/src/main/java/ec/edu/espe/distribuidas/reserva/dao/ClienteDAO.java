/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.reserva.dao;

import ec.edu.espe.distribuidas.reserva.model.Cliente;
import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.dao.BasicDAO;

/**
 *
 * @author Ing Alvaro Vasquez
 */
public class ClienteDAO extends BasicDAO<Cliente, ObjectId> {
    
     public ClienteDAO(Class<Cliente> objectEntity, Datastore ds) {
        super(objectEntity, ds);
    }
}
