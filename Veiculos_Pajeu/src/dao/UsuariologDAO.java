/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import fachada.Fachada;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.NoResultException;
import javax.persistence.ParameterMode;
import javax.persistence.Persistence;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.StoredProcedureQuery;
import model.Conta;
import model.Usuario;
import util.Util;
import app.App;
import connection.ConnectionFactory;
import model.Usuariolog;

/**
 *
 * @author Elvis Nogueira
 */
public class UsuariologDAO {

    private static UsuariologDAO instance;
    protected EntityManager entityManager;

    public static UsuariologDAO getInstance() {
        if (instance == null) {
            instance = new UsuariologDAO();
        }
        return instance;
    }

    private UsuariologDAO() {
        entityManager = new ConnectionFactory().getConnetion();
    }

    public Usuariolog getById(final int id) {
        return entityManager.find(Usuariolog.class, id);
    }

    public ArrayList<Usuariolog> getAll() {
        return (ArrayList<Usuariolog>) entityManager.createQuery("FROM " + Usuariolog.class.getName()).getResultList();
    }
}
