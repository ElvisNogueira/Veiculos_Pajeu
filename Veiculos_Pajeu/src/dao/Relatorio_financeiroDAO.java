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
import model.Categoria;
import model.Categorialog;
import model.Relatorio_financeiro;

/**
 *
 * @author Elvis Nogueira
 */
public class Relatorio_financeiroDAO {

    private static Relatorio_financeiroDAO instance;
    protected EntityManager entityManager;

    public static Relatorio_financeiroDAO getInstance() {
        if (instance == null) {
            instance = new Relatorio_financeiroDAO();
        }
        return instance;
    }

    private Relatorio_financeiroDAO() {
        entityManager = new ConnectionFactory().getConnetion();
    }

    public Relatorio_financeiro getById(final int id) {
        return entityManager.find(Relatorio_financeiro.class, id);
    }

    public ArrayList<Relatorio_financeiro> getAll() {
        return (ArrayList<Relatorio_financeiro>) entityManager.createQuery("FROM "+Relatorio_financeiro.class.getName()).getResultList();
    }
    
    public ArrayList<Relatorio_financeiro> getBusca(String busca) {
        return (ArrayList<Relatorio_financeiro>) entityManager.createQuery("from "+
                Relatorio_financeiro.class.getSimpleName()).getResultList();
    }
}
