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
import model.Camioneta_carga;

/**
 *
 * @author Elvis Nogueira
 */
public class Camioneta_cargaDAO {

    private static Camioneta_cargaDAO instance;
    protected EntityManager entityManager;

    public static Camioneta_cargaDAO getInstance() {
        if (instance == null) {
            instance = new Camioneta_cargaDAO();
        }
        return instance;
    }

    private Camioneta_cargaDAO() {
        entityManager = getEntityManager();
    }

    private EntityManager getEntityManager() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("Veiculos_PajeuPU");
        if (entityManager == null) {
            entityManager = factory.createEntityManager();
        }
        return entityManager;
    }
    
    public Camioneta_carga getById(int id){
        return entityManager.find(Camioneta_carga.class, id);
    } 
    
    public ArrayList<Camioneta_carga> getAll(){
        return (ArrayList<Camioneta_carga>) entityManager.createQuery("FROM "+
                Camioneta_carga.class.getName()).getResultList();
    }
    
    public void persist(Camioneta_carga camioneta_carga){
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(camioneta_carga);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
    
    public void merge(Camioneta_carga camioneta_carga) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(camioneta_carga);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
    public void remove(Camioneta_carga camioneta_carga) {
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(camioneta_carga);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
    public void removeById(int id) {
        try {
            Camioneta_carga camioneta_carga = getById(id);
            remove(camioneta_carga);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
