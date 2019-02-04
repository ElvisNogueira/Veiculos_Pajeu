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
import javax.persistence.StoredProcedureQuery;
import model.Conta;
import model.Endereco;
import model.Pessoa_Juridica;
import model.Pessoa_Juridicalog;

/**
 *
 * @author Elvis Nogueira
 */
public class Pessoa_JuridicalogDAO {
    private static Pessoa_JuridicalogDAO instance;
    protected EntityManager entityManager;

    public static Pessoa_JuridicalogDAO getInstance() {
        if (instance == null) {
            instance = new Pessoa_JuridicalogDAO();
        }
        return instance;
    }

    private Pessoa_JuridicalogDAO() {
        entityManager = new ConnectionFactory().getConnetion();
    }

    public Pessoa_Juridicalog getById(final int id) {
        return entityManager.find(Pessoa_Juridicalog.class, id);
    }

    public ArrayList<Pessoa_Juridicalog> getAll() {
        return (ArrayList<Pessoa_Juridicalog>) entityManager.createQuery("FROM " + Pessoa_Juridicalog.class.getName()).getResultList();
    }

}
