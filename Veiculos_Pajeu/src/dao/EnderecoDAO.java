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

/**
 *
 * @author Elvis Nogueira
 */
public class EnderecoDAO {

    private static EnderecoDAO instance;
    protected EntityManager entityManager;

    public static EnderecoDAO getInstance() {
        if (instance == null) {
            instance = new EnderecoDAO();
        }
        return instance;
    }

    private EnderecoDAO() {
        entityManager = new ConnectionFactory().getConnetion();
    }


    public Endereco getById(final int id) {
        return entityManager.find(Endereco.class, id);
    }
    
    public Endereco getLast(){
        String jpaQuuery = "select max(e.id) from Endereco e";
        int id = (int) entityManager.createQuery(jpaQuuery).getSingleResult();
        return getById(id);
    }

    public ArrayList<Endereco> getAll() {
        return (ArrayList<Endereco>) entityManager.createQuery("FROM " + Endereco.class.getName()
            +" WHERE status = 'true'").getResultList();
    }

    public void persist(Endereco endereco) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(endereco);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public void merge(Endereco endereco) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(endereco);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public void remove(Endereco endereco) {
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(endereco);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public void removeById(int id) {
        try {
            Endereco endereco = getById(id);
            remove(endereco);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
