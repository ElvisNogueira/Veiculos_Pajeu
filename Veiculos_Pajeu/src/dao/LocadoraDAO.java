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
import model.Locacao;
import model.Locadora;
import util.Util;
import view.AppTelas;

/**
 *
 * @author Elvis Nogueira
 */
public class LocadoraDAO {
    private static LocadoraDAO instance;
    protected EntityManager entityManager;

    public static LocadoraDAO getInstance() {
        if (instance == null) {
            instance = new LocadoraDAO();
        }
        return instance;
    }

    private LocadoraDAO() {
        entityManager = getEntityManager();
    }

    private EntityManager getEntityManager() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("Veiculos_PajeuPU");
        if (entityManager == null) {
            entityManager = factory.createEntityManager();
        }
        return entityManager;
    }

    public Locadora getById(final int id) {
        return entityManager.find(Locadora.class, id);
    }

    public ArrayList<Locadora> getAll() {
        return (ArrayList<Locadora>) entityManager.createQuery("FROM "+Locadora.class.getName()+
                " WHERE status = 'true'").getResultList();
    }

    public void persist(Locadora locadora) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(locadora);
            entityManager.getTransaction().commit();
            AppTelas.mostrarAlert(Util.SUCESSO_CADASTRO,"Sucesso ao eftuar cadastro!");
        } catch (Exception e) {
            AppTelas.mostrarAlert(Util.ERRO_CADASTRO,"Erro ao efetuar cadastro");
            e.printStackTrace();
            entityManager.getTransaction().rollback();
            
        }
    }
    
    public Locadora getLastId(){
        try {
            String jpaQuery = "select max(l.id) from Locadora l";
            int id = (int) entityManager.createQuery(jpaQuery).getSingleResult();
            Locadora locadora = getById(id);
            return locadora;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void merge(Locadora locadora) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(locadora);
            entityManager.getTransaction().commit();
            AppTelas.mostrarAlert(Util.SUCESSO_CADASTRO,"Edição realizada com suucesso!!");
        } catch (Exception e) {
            AppTelas.mostrarAlert(Util.ERRO_CADASTRO,"Erro ao editar!");
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public void remove(Locadora locadora) {
        try {
            entityManager.getTransaction().begin();
//            entityManager.remove(locadora);
            locadora.setStatus(false);
            entityManager.merge(locadora);
            entityManager.getTransaction().commit();
        } catch (Exception e) {            
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public void removeById(int id) {
        try {
            Locadora locadora = getById(id);
            remove(locadora);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
