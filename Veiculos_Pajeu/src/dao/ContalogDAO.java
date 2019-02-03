/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.Cliente;
import model.Conta;
import util.Util;
import app.App;
import model.Contalog;

/**
 *
 * @author Elvis Nogueira
 */
public class ContalogDAO {

    private static ContalogDAO instance;
    protected EntityManager entityManager;

    public static ContalogDAO getInstance() {
        if (instance == null) {
            instance = new ContalogDAO();
        }
        return instance;
    }

    private ContalogDAO() {
        entityManager = getEntityManager();
    }

    private EntityManager getEntityManager() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("Veiculos_PajeuPU");
        if (entityManager == null) {

            entityManager = factory.createEntityManager();
        }
        return entityManager;
    }

    public Contalog getById(final int id) {
        return entityManager.find(Contalog.class, id);
    }

    public ArrayList<Contalog> getAll() {
        return (ArrayList<Contalog>) entityManager.createQuery("from "+
                Contalog.class.getSimpleName()).getResultList();
    }
    
}



