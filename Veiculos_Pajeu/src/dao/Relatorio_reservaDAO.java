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
import model.Relatorio_reserva;

/**
 *
 * @author Elvis Nogueira
 */
public class Relatorio_reservaDAO {

    private static Relatorio_reservaDAO instance;
    protected EntityManager entityManager;

    public static Relatorio_reservaDAO getInstance() {
        if (instance == null) {
            instance = new Relatorio_reservaDAO();
        }
        return instance;
    }

    private Relatorio_reservaDAO() {
        entityManager = new ConnectionFactory().getConnetion();
    }

    public Relatorio_reserva getById(final int id) {
        return entityManager.find(Relatorio_reserva.class, id);
    }

    public ArrayList<Relatorio_reserva> getAll() {
        return (ArrayList<Relatorio_reserva>) entityManager.createQuery("FROM "+Relatorio_reserva.class.getName()).getResultList();
    }
    
    public ArrayList<Relatorio_financeiro> getBusca(String busca) {
        return (ArrayList<Relatorio_financeiro>) entityManager.createQuery("from "+
                Relatorio_financeiro.class.getSimpleName()+" where tipo_conta='"+busca+"'").getResultList();
    }
}
