/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import dao.Camioneta_cargaDAO;
import dao.Camioneta_passageiroDAO;
import java.util.ArrayList;
import model.Camioneta_carga;
import model.Camioneta_passageiro;

/**
 *
 * @author Elvis Nogueira
 */
public class Camioneta_passageirologBusiness {
    private static Camioneta_passageirologBusiness instance;
    private Camioneta_passageiroDAO dao;
    
    public static Camioneta_passageirologBusiness getInstance(){
        if (instance == null) {
            instance = new Camioneta_passageirologBusiness();
        }
        return instance;
    }
    
    private Camioneta_passageirologBusiness(){
        dao = Camioneta_passageiroDAO.getInstance();
    }
    
    public Camioneta_passageiro getById(int id){
        return dao.getById(id);
    } 
    
    public ArrayList<Camioneta_passageiro> getAll(){
        return dao.getAll();
    }
    
    public void persist(Camioneta_passageiro camioneta_passageiro){
        dao.persist(camioneta_passageiro);
    }
    
    public void merge(Camioneta_passageiro camioneta_passageiro) {
        dao.merge(camioneta_passageiro);
    }
    public void remove(Camioneta_passageiro camioneta_passageiro) {
        dao.remove(camioneta_passageiro);
    }
    public void removeById(int id) {
        dao.removeById(id);
    }
}
