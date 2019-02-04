/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import dao.Camioneta_cargaDAO;
import dao.Camioneta_cargalogDAO;
import java.util.ArrayList;
import model.Camioneta_carga;
import model.Camioneta_cargalog;

/**
 *
 * @author Elvis Nogueira
 */
public class Camioneta_cargalogBusiness {
    private static Camioneta_cargalogBusiness instance;
    private Camioneta_cargalogDAO dao;
    
    public static Camioneta_cargalogBusiness getInstance(){
        if (instance == null) {
            instance = new Camioneta_cargalogBusiness();
        }
        return instance;
    }
    
    private Camioneta_cargalogBusiness(){
        dao = Camioneta_cargalogDAO.getInstance();
    }
    
    public Camioneta_cargalog getById(int id){
        return dao.getById(id);
    } 
    
    public ArrayList<Camioneta_cargalog> getAll(){
        return dao.getAll();
    }
}
