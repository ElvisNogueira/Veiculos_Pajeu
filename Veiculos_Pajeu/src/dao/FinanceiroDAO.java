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
import model.Financeiro;

/**
 *
 * @author Elvis Nogueira
 */
public class FinanceiroDAO {
    private static FinanceiroDAO instance;
    protected EntityManager entityManager;

    public static FinanceiroDAO getInstance() {
        if (instance == null) {
            instance = new FinanceiroDAO();
        }
        return instance;
    }

    private FinanceiroDAO() {
        entityManager = new ConnectionFactory().getConnetion();
    }


    public Financeiro getById(final int id) {
        return entityManager.find(Financeiro.class, id);
    }

    public ArrayList<Financeiro> getAll() {
        return (ArrayList<Financeiro>) entityManager.createQuery("from "+
                Financeiro.class.getSimpleName()+" WHERE status = 'true'").getResultList();
    }

    public void persist(Financeiro financeiro) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(financeiro);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    public void merge(Financeiro financeiro) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(financeiro);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    public void remove(Financeiro financeiro) {
        try {
            entityManager.getTransaction().begin();
//            entityManager.remove(financeiro);
            financeiro.setStatus(false);
            entityManager.merge(financeiro);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public void removeById(int id) {
        try {
            Financeiro financeiro = getById(id);
            remove(financeiro);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
