/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import app.App;
import connection.ConnectionFactory;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.Conta;
import model.Endereco;
import model.Motorista;
import util.Util;

/**
 *
 * @author Elvis Nogueira
 */
public class MotoristaDAO {
    private static MotoristaDAO instance;
    protected EntityManager entityManager;

    public static MotoristaDAO getInstance() {
        if (instance == null) {
            instance = new MotoristaDAO();
        }
        return instance;
    }

    private MotoristaDAO() {
        entityManager = new ConnectionFactory().getConnetion();
    }

    public Motorista getById(final int id) {
        return entityManager.find(Motorista.class, id);
    }

    public ArrayList<Motorista> getAll() {
        return (ArrayList<Motorista>) entityManager.createQuery("FROM "+Motorista.class.getName()+
                " WHERE status = 'true'").getResultList();
    }

    public void persist(Motorista motorista) {
        try {
            if(Util.calcularIdade(motorista.getPessoa_Fisica().getData_nasc())>20){
                entityManager.getTransaction().begin();
                entityManager.persist(motorista);
                entityManager.getTransaction().commit();
                App.mostrarAlert(Util.SUCESSO_CADASTRO, "Cadastro realizado com sucesso!");
            }else{
                App.mostrarAlert(Util.ERRO_CADASTRO, "Motoristas devem ter mais de 21 anos!");
            }
        } catch (Exception e) {
            App.mostrarAlert(Util.ERRO_CADASTRO, "Erro ao fazer cadastro!");
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public void merge(Motorista motorista) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(motorista);
            entityManager.getTransaction().commit();
            App.mostrarAlert(Util.SUCESSO_CADASTRO, "Cadastro realizado com sucesso!");
        } catch (Exception e) {
            App.mostrarAlert(Util.ERRO_CADASTRO, "Erro ao editar!");
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public void remove(Motorista motorista) {
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(motorista);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public void removeById(int id) {
        try {
            Motorista motorista = getById(id);
            remove(motorista);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
