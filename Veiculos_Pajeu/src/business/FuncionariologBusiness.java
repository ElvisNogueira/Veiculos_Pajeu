/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import dao.Camioneta_cargaDAO;
import dao.FuncionarioDAO;
import dao.FuncionariologDAO;
import fachada.Fachada;
import java.util.ArrayList;
import model.Camioneta_carga;
import model.Funcionario;
import model.Funcionariolog;

/**
 *
 * @author Elvis Nogueira
 */
public class FuncionariologBusiness {
    private static FuncionariologBusiness instance;
    private FuncionariologDAO dao;
    
    public static FuncionariologBusiness getInstance(){
        if (instance == null) {
            instance = new FuncionariologBusiness();
        }
        return instance;
    }
    
    private FuncionariologBusiness(){
        dao = FuncionariologDAO.getInstance();
    }
    
    public Funcionariolog getById(int id){
        return dao.getById(id);
    } 
    
    public ArrayList<Funcionariolog> getAll(){
        return dao.getAll();
    }
    
}
