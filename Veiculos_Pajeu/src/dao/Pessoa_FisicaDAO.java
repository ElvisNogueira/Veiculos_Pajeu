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
import javax.persistence.StoredProcedureQuery;
import model.Conta;
import model.Endereco;
import model.Pessoa_Fisica;

/**
 *
 * @author Elvis Nogueira
 */
public class Pessoa_FisicaDAO {
    private static Pessoa_FisicaDAO instance;
    protected EntityManager entityManager;

    public static Pessoa_FisicaDAO getInstance() {
        if (instance == null) {
            instance = new Pessoa_FisicaDAO();
        }
        return instance;
    }

    private Pessoa_FisicaDAO() {
        entityManager = new ConnectionFactory().getConnetion();
    }

    public Pessoa_Fisica getById(final int id) {
        return entityManager.find(Pessoa_Fisica.class, id);
    }
    
    public Pessoa_Fisica getLast() {
        String jpaQuery = "select max(p) from Pessoa_Fisica p";
        int id = (int) entityManager.createQuery(jpaQuery).getSingleResult();
        return getById(id);
    }

    public ArrayList<Pessoa_Fisica> getAll() {
        return (ArrayList<Pessoa_Fisica>) entityManager.createQuery("FROM " + Pessoa_Fisica.class.getName()
                +" WHERE status = 'true'").getResultList();
    }

    public void persist(Pessoa_Fisica Pessoa_Fisica) {
        try {
            StoredProcedureQuery query = entityManager.createNamedStoredProcedureQuery("criarcodigo");
            query.setParameter("tipo", "PF");
            query.execute();
            
            String cod = (String) query.getOutputParameterValue("SAIDA");
            Pessoa_Fisica.setCodigo(cod);
            entityManager.getTransaction().begin();
            entityManager.persist(Pessoa_Fisica);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public void merge(Pessoa_Fisica pessoa_Fisica) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(pessoa_Fisica);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public void remove(Pessoa_Fisica pessoa_Fisica) {
        try {
            entityManager.getTransaction().begin();
//            entityManager.remove(pessoa_Fisica);
            pessoa_Fisica.setStatus(false);
            entityManager.merge(pessoa_Fisica);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public void removeById(int id) {
        try {
            Pessoa_Fisica pessoa_Fisica = getById(id);
            remove(pessoa_Fisica);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
