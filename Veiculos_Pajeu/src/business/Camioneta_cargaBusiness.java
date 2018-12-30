/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import dao.Camioneta_cargaDAO;
import dao.ContaDAO;
import java.util.ArrayList;
import model.Camioneta_carga;

/**
 *
 * @author Elvis Nogueira
 */
public class Camioneta_cargaBusiness {
    private static Camioneta_cargaBusiness instance;
    private Camioneta_cargaDAO dao;
    
    public static Camioneta_cargaBusiness getInstance(){
        if (instance == null) {
            instance = new Camioneta_cargaBusiness();
        }
        return instance;
    }
    
    private Camioneta_cargaBusiness(){
        dao = Camioneta_cargaDAO.getInstance();
    }
    
    public Camioneta_carga getById(int id){
        return dao.getById(id);
    } 
    
    public ArrayList<Camioneta_carga> getAll(){
        return dao.getAll();
    }
    
    public void persist(Camioneta_carga camioneta_carga){
        dao.persist(camioneta_carga);
    }
    
    public void merge(Camioneta_carga camioneta_carga) {
        dao.merge(camioneta_carga);
    }
    public void remove(Camioneta_carga camioneta_carga) {
        dao.remove(camioneta_carga);
    }
    public void removeById(int id) {
        dao.removeById(id);
    }
}
