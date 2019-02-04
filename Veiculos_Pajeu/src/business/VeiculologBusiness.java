/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import dao.Camioneta_cargaDAO;
import dao.VeiculoDAO;
import dao.VeiculologDAO;
import java.util.ArrayList;
import model.Camioneta_carga;
import model.Veiculo;
import model.Veiculolog;

/**
 *
 * @author Elvis Nogueira
 */
public class VeiculologBusiness {
    private static VeiculologBusiness instance;
    private VeiculologDAO dao;
    
    public static VeiculologBusiness getInstance(){
        if (instance == null) {
            instance = new VeiculologBusiness();
        }
        return instance;
    }
    
    private VeiculologBusiness(){
        dao = VeiculologDAO.getInstance();
    }
    
    public Veiculolog getById(int id){
        return dao.getById(id);
    } 
    
    public ArrayList<Veiculolog> getAll(){
        return dao.getAll();
    }
    
}
