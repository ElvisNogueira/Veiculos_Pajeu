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
import model.Categoria;

/**
 *
 * @author Elvis Nogueira
 */
public class CategoriaDAO {

    private static CategoriaDAO instance;
    protected EntityManager entityManager;

    public static CategoriaDAO getInstance() {
        if (instance == null) {
            instance = new CategoriaDAO();
        }
        return instance;
    }

    private CategoriaDAO() {
        entityManager = getEntityManager();
    }

    private EntityManager getEntityManager() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("Veiculos_PajeuPU");
        if (entityManager == null) {
            entityManager = factory.createEntityManager();
        }
        return entityManager;
    }

    public Categoria getById(final int id) {
        return entityManager.find(Categoria.class, id);
    }

    public ArrayList<Categoria> getAll() {
        return (ArrayList<Categoria>) entityManager.createQuery("FROM "+Categoria.class.getName()).getResultList();
    }
    
    public ArrayList<Categoria> getBusca(String busca) {
        return (ArrayList<Categoria>) entityManager.createQuery("from "+
                Categoria.class.getSimpleName()+" where nome like '%"+busca+"%'").getResultList();
    }

    public void persist(Categoria categoria) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(categoria);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public void merge(Categoria categoria) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(categoria);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public void remove(Categoria categoria) {
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(categoria);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public void removeById(int id) {
        try {
            Categoria categoria = getById(id);
            remove(categoria);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
