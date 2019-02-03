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
import model.Financeiro;
import model.Financeirolog;

/**
 *
 * @author Elvis Nogueira
 */
public class FinanceirologDAO {
    private static FinanceirologDAO instance;
    protected EntityManager entityManager;

    public static FinanceirologDAO getInstance() {
        if (instance == null) {
            instance = new FinanceirologDAO();
        }
        return instance;
    }

    private FinanceirologDAO() {
        entityManager = getEntityManager();
    }

    private EntityManager getEntityManager() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("Veiculos_PajeuPU");
        if (entityManager == null) {
            entityManager = factory.createEntityManager();
        }
        return entityManager;
    }

    public Financeirolog getById(final int id) {
        return entityManager.find(Financeirolog.class, id);
    }

    public ArrayList<Financeirolog> getAll() {
        return (ArrayList<Financeirolog>) entityManager.createQuery("from "+
                Financeirolog.class.getSimpleName()).getResultList();
    }
}
