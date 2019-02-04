/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import dao.Camioneta_cargaDAO;
import dao.ContaDAO;
import dao.ContalogDAO;
import java.util.ArrayList;
import model.Camioneta_carga;
import model.Conta;
import model.Contalog;

/**
 *
 * @author Elvis Nogueira
 */
public class ContalogBusiness {
    private static ContalogBusiness instance;
    private ContalogDAO dao;
    
    public static ContalogBusiness getInstance(){
        if (instance == null) {
            instance = new ContalogBusiness();
        }
        return instance;
    }
    
    private ContalogBusiness(){
        dao = ContalogDAO.getInstance();
    }
    
    public Contalog getById(int id){
        return dao.getById(id);
    } 
    
    
    public ArrayList<Contalog> getAll(){
        return dao.getAll();
    }
    
}
