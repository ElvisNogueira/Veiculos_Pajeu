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
import model.Cliente;
import model.Conta;
import util.Util;
import app.App;

/**
 *
 * @author Elvis Nogueira
 */
public class ContaDAO {

    private static ContaDAO instance;
    protected EntityManager entityManager;

    public static ContaDAO getInstance() {
        if (instance == null) {
            instance = new ContaDAO();
        }
        return instance;
    }

    private ContaDAO() {
        entityManager = getEntityManager();
    }

    private EntityManager getEntityManager() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("Veiculos_PajeuPU");
        if (entityManager == null) {

            entityManager = factory.createEntityManager();
        }
        return entityManager;
    }

    public Conta getById(final int id) {
        return entityManager.find(Conta.class, id);
    }

    public ArrayList<Conta> getAll() {
        return (ArrayList<Conta>) entityManager.createQuery("from "+
                Conta.class.getSimpleName()+" WHERE status = 'true'").getResultList();
    }
    
    public Conta getByNome(String nome){
        Conta conta = null;
        try {
            String jpaQuery = "from "+Conta.class.getSimpleName()+" c where c.nome='"+nome+"'"+" WHERE status = 'true'";
            conta = (Conta) entityManager.createQuery(jpaQuery).getSingleResult();
            
        } catch (Exception e) {
            e.printStackTrace(); 
        }
        return conta;
    }
    
    public ArrayList<Conta> getBusca(String busca) {
        return (ArrayList<Conta>) entityManager.createQuery("from "+
                Conta.class.getSimpleName()+" where nome like '%"+busca+"%'"+" WHERE status = 'true'").getResultList();
    }

    public void persist(Conta conta) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(conta);
            entityManager.getTransaction().commit();
            App.mostrarAlert(Util.SUCESSO_CADASTRO,"Cadastrado com sucesso!");
        } catch (Exception e) {
            App.mostrarAlert(Util.ERRO_CADASTRO, "Erro ao cadastrar!");
            entityManager.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    public void merge(Conta conta) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(conta);
            entityManager.getTransaction().commit();
            
            App.mostrarAlert(Util.SUCESSO_CADASTRO,"Edição feita com sucesso!");
        } catch (Exception e) {
            App.mostrarAlert(Util.ERRO_CADASTRO, "Erro ao editar!");
            entityManager.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    public void remove(Conta conta) {
        try {
            entityManager.getTransaction().begin();
//            entityManager.remove(conta);
            conta.setStatus(false);
            entityManager.merge(conta);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    public void removeById(int id) {
        try {
            Conta conta = getById(id);
            remove(conta);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
