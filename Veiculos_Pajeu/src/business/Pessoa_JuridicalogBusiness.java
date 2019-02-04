/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import dao.Camioneta_cargaDAO;
import dao.Pessoa_JuridicaDAO;
import dao.Pessoa_JuridicalogDAO;
import java.util.ArrayList;
import model.Camioneta_carga;
import model.Pessoa_Juridica;
import model.Pessoa_Juridicalog;

/**
 *
 * @author Elvis Nogueira
 */
public class Pessoa_JuridicalogBusiness {
    private static Pessoa_JuridicalogBusiness instance;
    private Pessoa_JuridicalogDAO dao;
    
    public static Pessoa_JuridicalogBusiness getInstance(){
        if (instance == null) {
            instance = new Pessoa_JuridicalogBusiness();
        }
        return instance;
    }
    
    private Pessoa_JuridicalogBusiness(){
        dao = Pessoa_JuridicalogDAO.getInstance();
    }
    
    public Pessoa_Juridicalog getById(int id){
        return dao.getById(id);
    } 
    
    public ArrayList<Pessoa_Juridicalog> getAll(){
        return dao.getAll();
    }
    
}
