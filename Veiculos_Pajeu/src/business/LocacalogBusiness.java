/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import dao.Camioneta_cargaDAO;
import dao.LocacaoDAO;
import dao.LocacaologDAO;
import java.util.ArrayList;
import model.Camioneta_carga;
import model.Locacao;
import model.Locacaolog;

/**
 *
 * @author Elvis Nogueira
 */
public class LocacalogBusiness {
    private static LocacalogBusiness instance;
    private LocacaologDAO dao;
    
    public static LocacalogBusiness getInstance(){
        if (instance == null) {
            instance = new LocacalogBusiness();
        }
        return instance;
    }
    
    private LocacalogBusiness(){
        dao = LocacaologDAO.getInstance();
    }
    
    public Locacaolog getById(int id){
        return dao.getById(id);
    } 
    
    public ArrayList<Locacaolog> getAll(){
        return dao.getAll();
    }
    
}
