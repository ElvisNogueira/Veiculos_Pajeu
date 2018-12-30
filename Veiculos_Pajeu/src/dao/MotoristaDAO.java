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
import model.Endereco;
import model.Motorista;

/**
 *
 * @author Elvis Nogueira
 */
public class MotoristaDAO {
    private static MotoristaDAO instance;
    protected EntityManager entityManager;

    public static MotoristaDAO getInstance() {
        if (instance == null) {
            instance = new MotoristaDAO();
        }
        return instance;
    }

    private MotoristaDAO() {
        entityManager = getEntityManager();
    }

    private EntityManager getEntityManager() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("Veiculos_PajeuPU");
        if (entityManager == null) {
            entityManager = factory.createEntityManager();
        }
        return entityManager;
    }

    public Motorista getById(final int id) {
        return entityManager.find(Motorista.class, id);
    }

    public ArrayList<Motorista> getAll() {
        return (ArrayList<Motorista>) entityManager.createQuery("FROM "+Motorista.class.getName()).getResultList();
    }

    public void persist(Motorista motorista) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(motorista);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public void merge(Motorista motorista) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(motorista);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public void remove(Motorista motorista) {
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(motorista);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public void removeById(int id) {
        try {
            Motorista motorista = getById(id);
            remove(motorista);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
