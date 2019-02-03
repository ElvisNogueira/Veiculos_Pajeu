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
import app.App;
import connection.ConnectionFactory;

/**
 *
 * @author Elvis Nogueira
 */
public class LocadoralogDAO {
    private static LocadoralogDAO instance;
    protected EntityManager entityManager;

    public static LocadoralogDAO getInstance() {
        if (instance == null) {
            instance = new LocadoralogDAO();
        }
        return instance;
    }

    private LocadoralogDAO() {
        entityManager = new ConnectionFactory().getConnetion();
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
            App.mostrarAlert(Util.SUCESSO_CADASTRO,"Sucesso ao eftuar cadastro!");
        } catch (Exception e) {
            App.mostrarAlert(Util.ERRO_CADASTRO,"Erro ao efetuar cadastro");
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
            App.mostrarAlert(Util.SUCESSO_CADASTRO,"Edição realizada com suucesso!!");
        } catch (Exception e) {
            App.mostrarAlert(Util.ERRO_CADASTRO,"Erro ao editar!");
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
