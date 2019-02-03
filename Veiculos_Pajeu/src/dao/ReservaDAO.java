/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import fachada.Fachada;
import java.sql.Date;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.Conta;
import model.Locacao;
import model.Reserva;
import model.Veiculo;
import util.Util;
import app.App;
import connection.ConnectionFactory;

/**
 *
 * @author Elvis Nogueira
 */
public class ReservaDAO {

    private static ReservaDAO instance;
    protected EntityManager entityManager;

    public static ReservaDAO getInstance() {
        if (instance == null) {
            instance = new ReservaDAO();
        }
        return instance;
    }

    private ReservaDAO() {
        entityManager = new ConnectionFactory().getConnetion();
    }

    public Reserva getById(final int id) {
        return entityManager.find(Reserva.class, id);
    }

    public ArrayList<Reserva> getAll() {
        return (ArrayList<Reserva>) entityManager.createQuery("FROM "+Reserva.class.getName()
            +" WHERE status = 'true'").getResultList();
    }
    
    public ArrayList<Reserva> getData(Date d1, Date d2) {
        return (ArrayList<Reserva>) entityManager.createQuery("from "+
                Reserva.class.getSimpleName()+" where data_retirada between "+d1+" and "+d2+" WHERE status = 'true'")
                .getResultList();
    }

    public void persist(Reserva reserva) {
        try {
            if(verificarCarrosDisp(reserva)>0){
                entityManager.getTransaction().begin();
                entityManager.persist(reserva);
                entityManager.getTransaction().commit();
                App.mostrarAlert(Util.SUCESSO_CADASTRO, "Reserva realizada com sucesso!");
            }else{
                App.mostrarAlert(Util.ERRO_CADASTRO, "Não temos veículos disoiníveis para essa categoria!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
    
    public int verificarCarrosDisp(Reserva reserva){
        int locados=0,categoria=0;
        for(Locacao l:Fachada.getInstance().getAllLocacao()){
            if(l.getVeiculo().getCategoria().getId()==reserva.getCategoria().getId())
                locados++;
        }
        
        for(Veiculo v : Fachada.getInstance().getAllVeiculo()){
            if(v.getCategoria().getId()==reserva.getCategoria().getId())
                categoria++;
        }
        
        return (categoria-locados);
    }

    public void merge(Reserva reserva) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(reserva);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public void remove(Reserva reserva) {
        try {
            entityManager.getTransaction().begin();
//            entityManager.remove(reserva);
            reserva.setStatus(false);
            entityManager.merge(reserva);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public void removeById(int id) {
        try {
            Reserva reserva = getById(id);
            remove(reserva);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
