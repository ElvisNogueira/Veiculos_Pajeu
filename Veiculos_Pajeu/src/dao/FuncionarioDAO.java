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
import model.Funcionario;

/**
 *
 * @author Elvis Nogueira
 */
public class FuncionarioDAO {
    private static FuncionarioDAO instance;
    protected EntityManager entityManager;

    public static FuncionarioDAO getInstance() {
        if (instance == null) {
            instance = new FuncionarioDAO();
        }
        return instance;
    }

    private FuncionarioDAO() {
        entityManager = getEntityManager();
    }

    private EntityManager getEntityManager() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("Veiculos_PajeuPU");
        if (entityManager == null) {
            entityManager = factory.createEntityManager();
        }
        return entityManager;
    }

    public Funcionario getById(final int id) {
        return entityManager.find(Funcionario.class, id);
    }

    public ArrayList<Funcionario> getAll() {
        return (ArrayList<Funcionario>) entityManager.createQuery("from "+
                Funcionario.class.getSimpleName()+" WHERE status = false").getResultList();
    }
    
    public ArrayList<Funcionario> getBusca(String busca) {
        return (ArrayList<Funcionario>) entityManager.createQuery("from "+
                Funcionario.class.getSimpleName()+" where nome like '%"+busca+"%' or"
                        + " cpf like '%"+busca+"%'"+" and status = false").getResultList();
    }

    public void persist(Funcionario funcionario) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(funcionario);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public void merge(Funcionario funcionario) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(funcionario);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public void remove(Funcionario funcionario) {
        try {
            entityManager.getTransaction().begin();
//            entityManager.remove(funcionario);
            funcionario.setStatus(false);
            entityManager.merge(funcionario);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public void removeById(int id) {
        try {
            Funcionario funcionario = getById(id);
            remove(funcionario);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
