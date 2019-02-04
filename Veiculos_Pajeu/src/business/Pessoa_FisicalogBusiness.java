/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import dao.Camioneta_cargaDAO;
import dao.Pessoa_FisicaDAO;
import dao.Pessoa_FisicalogDAO;
import fachada.Fachada;
import java.util.ArrayList;
import model.Camioneta_carga;
import model.Endereco;
import model.Pessoa_Fisica;
import model.Pessoa_Fisicalog;

/**
 *
 * @author Elvis Nogueira
 */
public class Pessoa_FisicalogBusiness {
    private static Pessoa_FisicalogBusiness instance;
    private Pessoa_FisicalogDAO dao;
    
    public static Pessoa_FisicalogBusiness getInstance(){
        if (instance == null) {
            instance = new Pessoa_FisicalogBusiness();
        }
        return instance;
    }
    
    private Pessoa_FisicalogBusiness(){
        dao = Pessoa_FisicalogDAO.getInstance();
    }
    
    public Pessoa_Fisicalog getById(int id){
        return dao.getById(id);
    } 
    
    
    public ArrayList<Pessoa_Fisicalog> getAll(){
        return dao.getAll();
    }
    
}
