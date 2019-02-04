/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import dao.Camioneta_cargaDAO;
import dao.ReservaDAO;
import dao.ReservalogDAO;
import java.sql.Date;
import java.util.ArrayList;
import model.Camioneta_carga;
import model.Reserva;
import model.Reservalog;

/**
 *
 * @author Elvis Nogueira
 */
public class ReservalogBusiness {
    private static ReservalogBusiness instance;
    private ReservalogDAO dao;
    
    public static ReservalogBusiness getInstance(){
        if (instance == null) {
            instance = new ReservalogBusiness();
        }
        return instance;
    }
    
    private ReservalogBusiness(){
        dao = ReservalogDAO.getInstance();
    }
    
    public Reservalog getById(int id){
        return dao.getById(id);
    } 
    
    public ArrayList<Reservalog> getAll(){
        return dao.getAll();
    }
    
}
