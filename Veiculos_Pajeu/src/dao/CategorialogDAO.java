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
import model.Categorialog;

/**
 *
 * @author Elvis Nogueira
 */
public class CategorialogDAO {

    private static CategorialogDAO instance;
    protected EntityManager entityManager;

    public static CategorialogDAO getInstance() {
        if (instance == null) {
            instance = new CategorialogDAO();
        }
        return instance;
    }

    private CategorialogDAO() {
        entityManager = getEntityManager();
    }

    private EntityManager getEntityManager() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("Veiculos_PajeuPU");
        if (entityManager == null) {
            entityManager = factory.createEntityManager();
        }
        return entityManager;
    }

    public Categorialog getById(final int id) {
        return entityManager.find(Categorialog.class, id);
    }

    public ArrayList<Categorialog> getAll() {
        return (ArrayList<Categorialog>) entityManager.createQuery("FROM "+Categorialog.class.getName()).getResultList();
    }
    
    public ArrayList<Categorialog> getBusca(String busca) {
        return (ArrayList<Categorialog>) entityManager.createQuery("from "+
                Categorialog.class.getSimpleName()).getResultList();
    }
}
