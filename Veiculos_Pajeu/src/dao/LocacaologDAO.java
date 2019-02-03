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
import model.Conta;
import model.Locacao;
import model.Locacaolog;

/**
 *
 * @author Elvis Nogueira
 */
public class LocacaologDAO {
    private static LocacaologDAO instance;
    protected EntityManager entityManager;

    public static LocacaologDAO getInstance() {
        if (instance == null) {
            instance = new LocacaologDAO();
        }
        return instance;
    }

    private LocacaologDAO() {
        entityManager = getEntityManager();
    }

    private EntityManager getEntityManager() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("Veiculos_PajeuPU");
        if (entityManager == null) {
            entityManager = factory.createEntityManager();
        }
        return entityManager;
    }

    public Locacao getById(final int id) {
        return entityManager.find(Locacao.class, id);
    }

    public ArrayList<Locacaolog> getAll() {
        return (ArrayList<Locacaolog>) entityManager.createQuery("FROM "+Locacaolog.class.getName()).getResultList();
    }

}
