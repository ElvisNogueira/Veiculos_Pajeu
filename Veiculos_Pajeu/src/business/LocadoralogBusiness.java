/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import dao.Camioneta_cargaDAO;
import dao.EnderecoDAO;
import dao.LocadoraDAO;
import dao.LocadoralogDAO;
import java.util.ArrayList;
import model.Camioneta_carga;
import model.Endereco;
import model.Locadora;
import model.Locadoralog;

/**
 *
 * @author Elvis Nogueira
 */
public class LocadoralogBusiness {
    private static LocadoralogBusiness instance;
    private LocadoralogDAO dao;
    
    public static LocadoralogBusiness getInstance(){
        if (instance == null) {
            instance = new LocadoralogBusiness();
        }
        return instance;
    }
    
    private LocadoralogBusiness(){
        dao = LocadoralogDAO.getInstance();
    }
    
    public Locadoralog getById(int id){
        return dao.getById(id);
    } 
    
    public ArrayList<Locadoralog> getAll(){
        return dao.getAll();
    }
    
}
