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
import model.Cliente;
import model.Conta;

/**
 *
 * @author Elvis Nogueira
 */
public class ContaDAO {

    private static ContaDAO instance;
    protected EntityManager entityManager;

    public static ContaDAO getInstance() {
        if (instance == null) {
            instance = new ContaDAO();
        }
        return instance;
    }

    private ContaDAO() {
        entityManager = getEntityManager();
    }

    private EntityManager getEntityManager() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("Veiculos_PajeuPU");
        if (entityManager == null) {

            entityManager = factory.createEntityManager();
        }
        return entityManager;
    }

    public Conta getById(final int id) {
        return entityManager.find(Conta.class, id);
    }

    public ArrayList<Conta> getAll() {
        return (ArrayList<Conta>) entityManager.createQuery("from "+
                Cliente.class.getSimpleName()).getResultList();
    }
    
    public Conta getByNome(String nome){
        Conta conta = null;
        try {
            String jpaQuery = "from "+Conta.class.getSimpleName()+" c where c.nome='"+nome+"'";
            conta = (Conta) entityManager.createQuery(jpaQuery).getSingleResult();
            
        } catch (Exception e) {
            e.printStackTrace(); 
        }
        return conta;
    }

    public void persist(Conta conta) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(conta);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    public void merge(Conta conta) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(conta);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    public void remove(Conta conta) {
        try {
            entityManager.getTransaction().begin();
            conta = entityManager.find(Conta.class, conta.getId());
            entityManager.remove(conta);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    public void removeById(int id) {
        try {
            Conta conta = getById(id);
            remove(conta);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
