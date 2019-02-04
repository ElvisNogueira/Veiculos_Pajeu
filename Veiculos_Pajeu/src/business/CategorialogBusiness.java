/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import dao.Camioneta_cargaDAO;
import dao.CategoriaDAO;
import dao.CategorialogDAO;
import java.util.ArrayList;
import model.Camioneta_carga;
import model.Categoria;
import model.Categorialog;

/**
 *
 * @author Elvis Nogueira
 */
public class CategorialogBusiness {
    private static CategorialogBusiness instance;
    private CategorialogDAO dao;
    
    public static CategorialogBusiness getInstance(){
        if (instance == null) {
            instance = new CategorialogBusiness();
        }
        return instance;
    }
    
    private CategorialogBusiness(){
        dao = CategorialogDAO.getInstance();
    }
    
    public Categorialog getById(int id){
        return dao.getById(id);
    } 
    
    public ArrayList<Categorialog> getAll(){
        return dao.getAll();
    }
    
}
