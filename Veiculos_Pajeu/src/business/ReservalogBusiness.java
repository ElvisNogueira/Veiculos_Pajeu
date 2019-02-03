/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import dao.Camioneta_cargaDAO;
import dao.ReservaDAO;
import java.sql.Date;
import java.util.ArrayList;
import model.Camioneta_carga;
import model.Reserva;

/**
 *
 * @author Elvis Nogueira
 */
public class ReservalogBusiness {
    private static ReservalogBusiness instance;
    private ReservaDAO dao;
    
    public static ReservalogBusiness getInstance(){
        if (instance == null) {
            instance = new ReservalogBusiness();
        }
        return instance;
    }
    
    private ReservalogBusiness(){
        dao = ReservaDAO.getInstance();
    }
    
    public Reserva getById(int id){
        return dao.getById(id);
    } 
    
    public ArrayList<Reserva> getAll(){
        return dao.getAll();
    }
    
    public ArrayList<Reserva> getData(Date d1, Date d2) {
        return dao.getData(d1, d2);
    }
    
    public void persist(Reserva reserva){
        dao.persist(reserva);
    }
    
    public void merge(Reserva reserva) {
        dao.merge(reserva);
    }
    public void remove(Reserva reserva) {
        dao.remove(reserva);
    }
    public void removeById(int id) {
        dao.removeById(id);
    }
}
