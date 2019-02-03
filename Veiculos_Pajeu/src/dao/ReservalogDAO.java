/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import fachada.Fachada;
import java.sql.Date;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.Conta;
import model.Locacao;
import model.Reserva;
import model.Veiculo;
import util.Util;
import app.App;
import connection.ConnectionFactory;
import model.Reservalog;

/**
 *
 * @author Elvis Nogueira
 */
public class ReservalogDAO {

    private static ReservalogDAO instance;
    protected EntityManager entityManager;

    public static ReservalogDAO getInstance() {
        if (instance == null) {
            instance = new ReservalogDAO();
        }
        return instance;
    }

    private ReservalogDAO() {
        entityManager = new ConnectionFactory().getConnetion();
    }

    public Reservalog getById(final int id) {
        return entityManager.find(Reservalog.class, id);
    }

    public ArrayList<Reservalog> getAll() {
        return (ArrayList<Reservalog>) entityManager.createQuery("FROM "+Reservalog.class.getName()).getResultList();
    }
    
    
}
