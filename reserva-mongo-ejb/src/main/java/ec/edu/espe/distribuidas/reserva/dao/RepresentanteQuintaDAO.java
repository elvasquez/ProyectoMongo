/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.reserva.dao;

import org.bson.types.ObjectId;
import org.mongodb.morphia.dao.BasicDAO;
import org.mongodb.morphia.Datastore;
import ec.edu.espe.distribuidas.reserva.model.RepresentanteQuinta;

/**
 *
 * @author user
 */
public class RepresentanteQuintaDAO extends BasicDAO<RepresentanteQuinta, ObjectId>  {
    
    public RepresentanteQuintaDAO(Class<RepresentanteQuinta> objectEntity, Datastore ds) {
        super(objectEntity, ds);
    }
}
