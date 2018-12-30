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
import model.Reserva;

/**
 *
 * @author Elvis Nogueira
 */
public class ReservaDAO {

    private static ReservaDAO instance;
    protected EntityManager entityManager;

    public static ReservaDAO getInstance() {
        if (instance == null) {
            instance = new ReservaDAO();
        }
        return instance;
    }

    private ReservaDAO() {
        entityManager = getEntityManager();
    }

    private EntityManager getEntityManager() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("Veiculos_PajeuPU");
        if (entityManager == null) {
            entityManager = factory.createEntityManager();
        }
        return entityManager;
    }

    public Reserva getById(final int id) {
        return entityManager.find(Reserva.class, id);
    }

    public ArrayList<Reserva> getAll() {
        return (ArrayList<Reserva>) entityManager.createQuery("FROM "+Reserva.class.getName()).getResultList();
    }

    public void persist(Reserva reserva) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(reserva);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public void merge(Reserva reserva) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(reserva);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public void remove(Reserva reserva) {
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(reserva);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public void removeById(int id) {
        try {
            Reserva reserva = getById(id);
            remove(reserva);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}