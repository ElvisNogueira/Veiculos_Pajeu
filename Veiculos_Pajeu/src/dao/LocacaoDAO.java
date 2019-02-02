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

/**
 *
 * @author Elvis Nogueira
 */
public class LocacaoDAO {
    private static LocacaoDAO instance;
    protected EntityManager entityManager;

    public static LocacaoDAO getInstance() {
        if (instance == null) {
            instance = new LocacaoDAO();
        }
        return instance;
    }

    private LocacaoDAO() {
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

    public ArrayList<Locacao> getAll() {
        return (ArrayList<Locacao>) entityManager.createQuery("FROM "+Locacao.class.getName()+" WHERE status = 'true'").getResultList();
    }

    public void persist(Locacao locacao) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(locacao);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public void merge(Locacao locacao) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(locacao);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public void remove(Locacao locacao) {
        try {
            entityManager.getTransaction().begin();
//            entityManager.remove(locacao);
            locacao.setAtivo(false);
            entityManager.merge(locacao);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public void removeById(int id) {
        try {
            Locacao locacao = getById(id);
            remove(locacao);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
