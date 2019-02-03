/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import connection.ConnectionFactory;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.Camioneta_carga;
import model.Camioneta_cargalog;

/**
 *
 * @author Elvis Nogueira
 */
public class Camioneta_cargalogDAO {

    private static Camioneta_cargalogDAO instance;
    protected EntityManager entityManager;

    public static Camioneta_cargalogDAO getInstance() {
        if (instance == null) {
            instance = new Camioneta_cargalogDAO();
        }
        return instance;
    }

    private Camioneta_cargalogDAO() {
        entityManager = new ConnectionFactory().getConnetion();
    }
    
    public Camioneta_cargalog getById(int id){
        return entityManager.find(Camioneta_cargalog.class, id);
    } 
    
    public ArrayList<Camioneta_cargalog> getAll(){
        return (ArrayList<Camioneta_cargalog>) entityManager.createQuery("FROM "+
                Camioneta_cargalog.class.getName()).getResultList();
    }

}
