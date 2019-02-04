/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import connection.ConnectionFactory;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.Conta;
import model.Locacao;
import model.Locacaolog;

/**
 *
 * @author Elvis Nogueira
 */
public class LocacaologDAO {
    private static LocacaologDAO instance;
    protected EntityManager entityManager;

    public static LocacaologDAO getInstance() {
        if (instance == null) {
            instance = new LocacaologDAO();
        }
        return instance;
    }

    private LocacaologDAO() {
        entityManager = new ConnectionFactory().getConnetion();
    }

    public Locacaolog getById(final int id) {
        return entityManager.find(Locacaolog.class, id);
    }

    public ArrayList<Locacaolog> getAll() {
        return (ArrayList<Locacaolog>) entityManager.createQuery("FROM "+Locacaolog.class.getName()).getResultList();
    }

}
