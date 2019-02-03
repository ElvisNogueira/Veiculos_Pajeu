/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.Conta;
import model.Endereco;
import model.Enderecolog;

/**
 *
 * @author Elvis Nogueira
 */
public class EnderecologDAO {

    private static EnderecologDAO instance;
    protected EntityManager entityManager;

    public static EnderecologDAO getInstance() {
        if (instance == null) {
            instance = new EnderecologDAO();
        }
        return instance;
    }

    private EnderecologDAO() {
        entityManager = getEntityManager();
    }

    private EntityManager getEntityManager() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("Veiculos_PajeuPU");
        if (entityManager == null) {
            entityManager = factory.createEntityManager();
        }
        return entityManager;
    }

    public Enderecolog getById(final int id) {
        return entityManager.find(Enderecolog.class, id);
    }
    

    public ArrayList<Enderecolog> getAll() {
        return (ArrayList<Enderecolog>) entityManager.createQuery("FROM " + Enderecolog.class.getName()).getResultList();
    }
}
