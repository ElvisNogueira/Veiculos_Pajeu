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
import model.Funcionario;
import model.Funcionariolog;

/**
 *
 * @author Elvis Nogueira
 */
public class FuncionariologDAO {
    private static FuncionariologDAO instance;
    protected EntityManager entityManager;

    public static FuncionariologDAO getInstance() {
        if (instance == null) {
            instance = new FuncionariologDAO();
        }
        return instance;
    }

    private FuncionariologDAO() {
        entityManager = new ConnectionFactory().getConnetion();
    }

    public Funcionariolog getById(final int id) {
        return entityManager.find(Funcionariolog.class, id);
    }

    public ArrayList<Funcionariolog> getAll() {
        return (ArrayList<Funcionariolog>) entityManager.createQuery("from "+
                Funcionariolog.class.getSimpleName()).getResultList();
    }

}
