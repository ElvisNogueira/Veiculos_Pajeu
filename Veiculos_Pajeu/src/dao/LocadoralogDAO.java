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
import model.Locadoralog;

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

    public Locadoralog getById(final int id) {
        return entityManager.find(Locadoralog.class, id);
    }

    public ArrayList<Locadoralog> getAll() {
        return (ArrayList<Locadoralog>) entityManager.createQuery("FROM "+Locadoralog.class.getName()).getResultList();
    }
}
