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
import model.Relatorio_locacao;

/**
 *
 * @author Elvis Nogueira
 */
public class Relatorio_locacaoDAO {

    private static Relatorio_locacaoDAO instance;
    protected EntityManager entityManager;

    public static Relatorio_locacaoDAO getInstance() {
        if (instance == null) {
            instance = new Relatorio_locacaoDAO();
        }
        return instance;
    }

    private Relatorio_locacaoDAO() {
        entityManager = new ConnectionFactory().getConnetion();
    }

    public Relatorio_locacao getById(final int id) {
        return entityManager.find(Relatorio_locacao.class, id);
    }

    public ArrayList<Relatorio_locacao> getAll() {
        return (ArrayList<Relatorio_locacao>) entityManager.createQuery("FROM "+Relatorio_locacao.class.getName()).getResultList();
    }
    
}
