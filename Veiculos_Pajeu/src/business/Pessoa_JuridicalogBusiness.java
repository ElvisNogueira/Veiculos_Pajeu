/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import dao.Camioneta_cargaDAO;
import dao.Pessoa_JuridicaDAO;
import java.util.ArrayList;
import model.Camioneta_carga;
import model.Pessoa_Juridica;

/**
 *
 * @author Elvis Nogueira
 */
public class Pessoa_JuridicalogBusiness {
    private static Pessoa_JuridicalogBusiness instance;
    private Pessoa_JuridicaDAO dao;
    
    public static Pessoa_JuridicalogBusiness getInstance(){
        if (instance == null) {
            instance = new Pessoa_JuridicalogBusiness();
        }
        return instance;
    }
    
    private Pessoa_JuridicalogBusiness(){
        dao = Pessoa_JuridicaDAO.getInstance();
    }
    
    public Pessoa_Juridica getById(int id){
        return dao.getById(id);
    } 
    
    public ArrayList<Pessoa_Juridica> getAll(){
        return dao.getAll();
    }
    
    public void persist(Pessoa_Juridica pessoa_Juridica){
        dao.persist(pessoa_Juridica);
    }
    
    public void merge(Pessoa_Juridica pessoa_Juridica) {
        dao.merge(pessoa_Juridica);
    }
    public void remove(Pessoa_Juridica pessoa_Juridica) {
        dao.remove(pessoa_Juridica);
    }
    public void removeById(int id) {
        dao.removeById(id);
    }
}
