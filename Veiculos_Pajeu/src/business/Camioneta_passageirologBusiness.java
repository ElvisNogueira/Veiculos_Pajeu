/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import dao.Camioneta_cargaDAO;
import dao.Camioneta_passageiroDAO;
import dao.Camioneta_passageirologDAO;
import java.util.ArrayList;
import model.Camioneta_carga;
import model.Camioneta_passageiro;
import model.Camioneta_passageirolog;

/**
 *
 * @author Elvis Nogueira
 */
public class Camioneta_passageirologBusiness {
    private static Camioneta_passageirologBusiness instance;
    private Camioneta_passageirologDAO dao;
    
    public static Camioneta_passageirologBusiness getInstance(){
        if (instance == null) {
            instance = new Camioneta_passageirologBusiness();
        }
        return instance;
    }
    
    private Camioneta_passageirologBusiness(){
        dao = Camioneta_passageirologDAO.getInstance();
    }
    
    public Camioneta_passageirolog getById(int id){
        return dao.getById(id);
    } 
    
    public ArrayList<Camioneta_passageirolog> getAll(){
        return dao.getAll();
    }
    
}
