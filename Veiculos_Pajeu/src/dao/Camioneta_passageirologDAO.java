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
import model.Camioneta_passageiro;
import model.Camioneta_passageirolog;

/**
 *
 * @author Elvis Nogueira
 */
public class Camioneta_passageirologDAO {
    
    private static Camioneta_passageirologDAO instance;
    protected EntityManager entityManager;

    public static Camioneta_passageirologDAO getInstance() {
        if (instance == null) {
            instance = new Camioneta_passageirologDAO();
        }
        return instance;
    }

    private Camioneta_passageirologDAO() {
        entityManager = getEntityManager();
    }

    private EntityManager getEntityManager() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("Veiculos_PajeuPU");
        if (entityManager == null) {
            entityManager = factory.createEntityManager();
        }
        return entityManager;
    }

    public Camioneta_passageirolog getById(int id) {
        return entityManager.find(Camioneta_passageirolog.class, id);
    }

    public ArrayList<Camioneta_passageirolog> getAll() {
        return (ArrayList<Camioneta_passageirolog>) entityManager.createQuery("FROM "
                +Camioneta_passageirolog.class.getName()).getResultList();
    }

    
}
