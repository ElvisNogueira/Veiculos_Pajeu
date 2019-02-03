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
import javax.persistence.StoredProcedureQuery;
import model.Conta;
import model.Endereco;
import model.Pessoa_Fisica;
import model.Pessoa_Fisicalog;

/**
 *
 * @author Elvis Nogueira
 */
public class Pessoa_FisicalogDAO {
    private static Pessoa_FisicalogDAO instance;
    protected EntityManager entityManager;

    public static Pessoa_FisicalogDAO getInstance() {
        if (instance == null) {
            instance = new Pessoa_FisicalogDAO();
        }
        return instance;
    }

    private Pessoa_FisicalogDAO() {
        entityManager = getEntityManager();
    }

    private EntityManager getEntityManager() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("Veiculos_PajeuPU");
        if (entityManager == null) {
            entityManager = factory.createEntityManager();
        }
        return entityManager;
    }

    public Pessoa_Fisicalog getById(final int id) {
        return entityManager.find(Pessoa_Fisicalog.class, id);
    }
    public ArrayList<Pessoa_Fisicalog> getAll() {
        return (ArrayList<Pessoa_Fisicalog>) entityManager.createQuery("FROM " + Pessoa_Fisicalog.class.getName()).getResultList();
    }

    
}
