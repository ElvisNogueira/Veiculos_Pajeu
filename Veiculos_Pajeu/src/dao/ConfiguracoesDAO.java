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
import model.Configuracoes;
import util.Util;
import view.AppTelas;

/**
 *
 * @author Elvis Nogueira
 */
public class ConfiguracoesDAO {
    private static ConfiguracoesDAO instance;
    protected EntityManager entityManager;

    public static ConfiguracoesDAO getInstance() {
        if (instance == null) {
            instance = new ConfiguracoesDAO();
        }
        return instance;
    }

    private ConfiguracoesDAO() {
        entityManager = getEntityManager();
    }

    private EntityManager getEntityManager() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("Veiculos_PajeuPU");
        if (entityManager == null) {
            entityManager = factory.createEntityManager();
        }
        return entityManager;
    }
    
    public ArrayList<Configuracoes> getAll() {
         return (ArrayList<Configuracoes>) entityManager.createQuery("FROM " + Configuracoes.class.getName()).getResultList();
    }
    
    public void persist(Configuracoes configuracoes) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(configuracoes);
            entityManager.getTransaction().commit();
            AppTelas.mostrarAlert(Util.SUCESSO_CADASTRO);
        } catch (Exception e) {
            AppTelas.mostrarAlert(Util.ERRO_CADASTRO);
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public void merge(Configuracoes configuracoes) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(configuracoes);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
}
