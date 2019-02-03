/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import dao.Camioneta_cargaDAO;
import dao.CategoriaDAO;
import java.util.ArrayList;
import model.Camioneta_carga;
import model.Categoria;

/**
 *
 * @author Elvis Nogueira
 */
public class CategorialogBusiness {
    private static CategorialogBusiness instance;
    private CategoriaDAO dao;
    
    public static CategorialogBusiness getInstance(){
        if (instance == null) {
            instance = new CategorialogBusiness();
        }
        return instance;
    }
    
    private CategorialogBusiness(){
        dao = CategoriaDAO.getInstance();
    }
    
    public Categoria getById(int id){
        return dao.getById(id);
    } 
    
    public ArrayList<Categoria> getAll(){
        return dao.getAll();
    }
    
    public ArrayList<Categoria> getBusca(String busca){
        return dao.getBusca(busca);
    }
    
    public void persist(Categoria categoria){
        dao.persist(categoria);
    }
    
    public void merge(Categoria categoria) {
        dao.merge(categoria);
    }
    public void remove(Categoria categoria) {
        dao.remove(categoria);
    }
    public void removeById(int id) {
        dao.removeById(id);
    }
}
