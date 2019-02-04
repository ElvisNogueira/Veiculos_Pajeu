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
import model.Endereco;
import model.Motorista;
import model.Motoristalog;
import util.Util;

/**
 *
 * @author Elvis Nogueira
 */
public class MotoristalogDAO {
    private static MotoristalogDAO instance;
    protected EntityManager entityManager;

    public static MotoristalogDAO getInstance() {
        if (instance == null) {
            instance = new MotoristalogDAO();
        }
        return instance;
    }

    private MotoristalogDAO() {
        entityManager = new ConnectionFactory().getConnetion();
    }

    

    public Motoristalog getById(final int id) {
        return entityManager.find(Motoristalog.class, id);
    }

    public ArrayList<Motoristalog> getAll() {
        return (ArrayList<Motoristalog>) entityManager.createQuery("FROM "+Motoristalog.class.getName()).getResultList();
    }

}
