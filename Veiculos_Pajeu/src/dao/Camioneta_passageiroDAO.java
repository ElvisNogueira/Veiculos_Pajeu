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

/**
 *
 * @author Elvis Nogueira
 */
public class Camioneta_passageiroDAO {
    
    private static Camioneta_passageiroDAO instance;
    protected EntityManager entityManager;

    public static Camioneta_passageiroDAO getInstance() {
        if (instance == null) {
            instance = new Camioneta_passageiroDAO();
        }
        return instance;
    }

    private Camioneta_passageiroDAO() {
        entityManager = getEntityManager();
    }

    private EntityManager getEntityManager() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("Veiculos_PajeuPU");
        if (entityManager == null) {
            entityManager = factory.createEntityManager();
        }
        return entityManager;
    }

    public Camioneta_passageiro getById(int id) {
        return entityManager.find(Camioneta_passageiro.class, id);
    }

    public ArrayList<Camioneta_passageiro> getAll() {
        return (ArrayList<Camioneta_passageiro>) entityManager.createQuery("FROM "
                +Camioneta_passageiro.class.getName()+" WHERE status = 'true'").getResultList();
    }

    public void persist(Camioneta_passageiro camioneta_passageiro) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(camioneta_passageiro);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public void merge(Camioneta_passageiro camioneta_passageiro) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(camioneta_passageiro);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public void remove(Camioneta_passageiro camioneta_passageiro) {
        try {
            entityManager.getTransaction().begin();
//            entityManager.remove(camioneta_passageiro);
            camioneta_passageiro.setStatus(true);
            entityManager.merge(camioneta_passageiro);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public void removeById(int id) {
        try {
            Camioneta_passageiro camioneta_passageiro = getById(id);
            remove(camioneta_passageiro);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
