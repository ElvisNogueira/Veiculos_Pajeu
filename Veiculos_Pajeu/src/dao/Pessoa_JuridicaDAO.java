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
import model.Pessoa_Juridica;

/**
 *
 * @author Elvis Nogueira
 */
public class Pessoa_JuridicaDAO {
    private static Pessoa_JuridicaDAO instance;
    protected EntityManager entityManager;

    public static Pessoa_JuridicaDAO getInstance() {
        if (instance == null) {
            instance = new Pessoa_JuridicaDAO();
        }
        return instance;
    }

    private Pessoa_JuridicaDAO() {
        entityManager = new ConnectionFactory().getConnetion();
    }

    public Pessoa_Juridica getById(final int id) {
        return entityManager.find(Pessoa_Juridica.class, id);
    }

    public ArrayList<Pessoa_Juridica> getAll() {
        return (ArrayList<Pessoa_Juridica>) entityManager.createQuery("FROM " + Pessoa_Juridica.class.getName()
                +" WHERE status = 'true'").getResultList();
    }

    public void persist(Pessoa_Juridica pessoa_Juridica) {
        try {
            StoredProcedureQuery query = entityManager.createNamedStoredProcedureQuery("criarcodigo");
            query.setParameter("tipo", "PJ");
            query.execute();
            
            String cod = (String) query.getOutputParameterValue("SAIDA");
            pessoa_Juridica.setCodigo(cod);
            entityManager.getTransaction().begin();
            entityManager.persist(pessoa_Juridica);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public void merge(Pessoa_Juridica pessoa_Juridica) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(pessoa_Juridica);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public void remove(Pessoa_Juridica pessoa_Juridica) {
        try {
            entityManager.getTransaction().begin();
//            entityManager.remove(pessoa_Juridica);
            pessoa_Juridica.setStatus(false);
            entityManager.merge(pessoa_Juridica);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public void removeById(int id) {
        try {
            Pessoa_Juridica pessoa_Juridica = getById(id);
            remove(pessoa_Juridica);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
