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
import model.Conta;
import model.Endereco;
import model.Motorista;
import util.Util;

/**
 *
 * @author Elvis Nogueira
 */
public class MotoristalogDAO {
    private static MotoristalogDAO instance;
    protected EntityManager entityManager;

    public static MotoristalogDAO getInstance() {
        if (instance == null) {
            instance = new MotoristalogDAO();
        }
        return instance;
    }

    private MotoristalogDAO() {
        entityManager = new ConnectionFactory().getConnetion();
    }

    

    public Motorista getById(final int id) {
        return entityManager.find(Motorista.class, id);
    }

    public ArrayList<Motorista> getAll() {
        return (ArrayList<Motorista>) entityManager.createQuery("FROM "+Motorista.class.getName()+
                " WHERE status = 'true'").getResultList();
    }

    public void persist(Motorista motorista) {
        try {
            if(Util.calcularIdade(motorista.getData_venc_habilitacao())>20){
                entityManager.getTransaction().begin();
                entityManager.persist(motorista);
                entityManager.getTransaction().commit();
            }
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
