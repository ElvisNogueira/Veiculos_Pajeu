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
import model.Veiculo;
import model.Veiculolog;

/**
 *
 * @author Elvis Nogueira
 */
public class VeiculologDAO {
    private static VeiculologDAO instance;
    protected EntityManager entityManager;

    public static VeiculologDAO getInstance() {
        if (instance == null) {
            instance = new VeiculologDAO();
        }
        return instance;
    }

    private VeiculologDAO() {
        entityManager = getEntityManager();
    }

    private EntityManager getEntityManager() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("Veiculos_PajeuPU");
        if (entityManager == null) {
            entityManager = factory.createEntityManager();
        }
        return entityManager;
    }

    public Veiculolog getById(final int id) {
        return entityManager.find(Veiculolog.class, id);
    }

    public ArrayList<Veiculolog> getAll() {
        return (ArrayList<Veiculolog>) entityManager.createQuery("FROM "+Veiculolog.class.getName()).getResultList();
    }
    
    
}
