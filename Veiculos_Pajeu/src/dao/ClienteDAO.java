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
import model.Endereco;

/**
 *
 * @author Elvis Nogueira
 */
public class ClienteDAO {

    private static ClienteDAO instance;
    protected EntityManager entityManager;

    public static ClienteDAO getInstance() {
        if (instance == null) {
            instance = new ClienteDAO();
        }
        return instance;
    }

    private ClienteDAO() {
        entityManager = new ConnectionFactory().getConnetion();
    }

    public Cliente getById(final int id) {
        return entityManager.find(Cliente.class, id);
    }
    
    public Cliente getLast(){
        String jpaQuery = "select max(c.id) from Cliente c";
        int id = (int) entityManager.createQuery(jpaQuery).getSingleResult();
        return getById(id);
    }

    public ArrayList<Cliente> getAll() {
         return (ArrayList<Cliente>) entityManager.createQuery("FROM " + Cliente.class.getName()
                +" WHERE status = 'true'").getResultList();
    }
    
    public ArrayList<Cliente> getBusca(String busca) {
        return (ArrayList<Cliente>) entityManager.createQuery("from "+
                Cliente.class.getSimpleName()+" where nome like '%"+busca+"%'"+" and status = 'true'"
                ).getResultList();
    }

    public void persist(Cliente cliente) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(cliente);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public void merge(Cliente cliente) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(cliente);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public void remove(Cliente cliente) {
        try {
            entityManager.getTransaction().begin();
//            entityManager.remove(cliente);
            cliente.setStatus(false);
            entityManager.merge(cliente);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public void removeById(int id) {
        try {
            Cliente cliente = getById(id);
            remove(cliente);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
