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
import app.App;
import connection.ConnectionFactory;

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
        entityManager = new ConnectionFactory().getConnetion();
    }

    
    public ArrayList<Configuracoes> getAll() {
         return (ArrayList<Configuracoes>) entityManager.createQuery("FROM " + Configuracoes.class.getName()).getResultList();
    }
    
    public void persist(Configuracoes configuracoes) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(configuracoes);
            entityManager.getTransaction().commit();
            App.mostrarAlert(Util.SUCESSO_CADASTRO,"Salvo com suucesso!");
        } catch (Exception e) {
            App.mostrarAlert(Util.ERRO_CADASTRO,"Erro ao Salvar!");
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public void merge(Configuracoes configuracoes) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(configuracoes);
            entityManager.getTransaction().commit();
            
            App.mostrarAlert(Util.SUCESSO_CADASTRO,"Editado com sucesso!");
        } catch (Exception e) {
            App.mostrarAlert(Util.ERRO_CADASTRO,"Erro ao editar!");
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
}
