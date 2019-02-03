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
import model.Cliente;
import model.Clientelog;
import model.Endereco;

/**
 *
 * @author Elvis Nogueira
 */
public class ClientelogDAO {

    private static ClientelogDAO instance;
    protected EntityManager entityManager;

    public static ClientelogDAO getInstance() {
        if (instance == null) {
            instance = new ClientelogDAO();
        }
        return instance;
    }

    private ClientelogDAO() {
        entityManager = new ConnectionFactory().getConnetion();
    }


    public Clientelog getById(final int id) {
        return entityManager.find(Clientelog.class, id);
    }

    public ArrayList<Clientelog> getAll() {
         return (ArrayList<Clientelog>) entityManager.createQuery("FROM " + Clientelog.class.getName()).getResultList();
    }
    
    public ArrayList<Clientelog> getBusca(String busca) {
        return (ArrayList<Clientelog>) entityManager.createQuery("from "+
                Clientelog.class.getSimpleName()).getResultList();
    }
}
