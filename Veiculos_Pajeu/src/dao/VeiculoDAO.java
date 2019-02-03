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
import model.Veiculo;

/**
 *
 * @author Elvis Nogueira
 */
public class VeiculoDAO {
    private static VeiculoDAO instance;
    protected EntityManager entityManager;

    public static VeiculoDAO getInstance() {
        if (instance == null) {
            instance = new VeiculoDAO();
        }
        return instance;
    }

    private VeiculoDAO() {
        entityManager = new ConnectionFactory().getConnetion();
    }

    public Veiculo getById(final int id) {
        return entityManager.find(Veiculo.class, id);
    }

    public ArrayList<Veiculo> getAll() {
        return (ArrayList<Veiculo>) entityManager.createQuery("FROM "+Veiculo.class.getName()+" "
                + "WHERE status = 'true'").getResultList();
    }
    
    public ArrayList<Veiculo> getBusca(String busca) {
        return (ArrayList<Veiculo>) entityManager.createQuery("from "+
                Veiculo.class.getSimpleName()+" where placa like '%"+busca+"%'"
                        + " or fabricante like '%"+busca+"%'"+" and status = 'true'").getResultList();
//  return (ArrayList<Veiculo>) entityManager.createQuery("FROM "+Veiculo.class.getName()).getResultList();
    
    }

    public void persist(Veiculo veiculo) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(veiculo);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public void merge(Veiculo veiculo) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(veiculo);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public void remove(Veiculo veiculo) {
        try {
            entityManager.getTransaction().begin();
//            entityManager.remove(veiculo);
            veiculo.setStatus(false);
            entityManager.merge(veiculo);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public void removeById(int id) {
        try {
            Veiculo veiculo = getById(id);
            remove(veiculo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
