/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import dao.Camioneta_cargaDAO;
import dao.MotoristaDAO;
import dao.MotoristalogDAO;
import java.util.ArrayList;
import model.Camioneta_carga;
import model.Motorista;
import model.Motoristalog;
import util.Util;

/**
 *
 * @author Elvis Nogueira
 */
public class MotoristalogBusiness {
    private static MotoristalogBusiness instance;
    private MotoristalogDAO dao;
    
    public static MotoristalogBusiness getInstance(){
        if (instance == null) {
            instance = new MotoristalogBusiness();
        }
        return instance;
    }
    
    private MotoristalogBusiness(){
        dao = MotoristalogDAO.getInstance();
    }
    
    public Motoristalog getById(int id){
        return dao.getById(id);
    } 
    
    public ArrayList<Motoristalog> getAll(){
        return dao.getAll();
    }
    
    
}
