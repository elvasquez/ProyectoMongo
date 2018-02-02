/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.reserva.dao;

import ec.edu.espe.distribuidas.reserva.model.TipoSitio;
import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.dao.BasicDAO;

/**
 *
 * @author toshiba
 */
public class TipoSitioDAO extends BasicDAO<TipoSitio, ObjectId>{
 
     public TipoSitioDAO(Class<TipoSitio> objectEntity, Datastore ds) {
        super(objectEntity, ds);
    }
}
