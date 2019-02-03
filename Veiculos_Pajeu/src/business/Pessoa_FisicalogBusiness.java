/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import dao.Camioneta_cargaDAO;
import dao.Pessoa_FisicaDAO;
import fachada.Fachada;
import java.util.ArrayList;
import model.Camioneta_carga;
import model.Endereco;
import model.Pessoa_Fisica;

/**
 *
 * @author Elvis Nogueira
 */
public class Pessoa_FisicalogBusiness {
    private static Pessoa_FisicalogBusiness instance;
    private Pessoa_FisicaDAO dao;
    
    public static Pessoa_FisicalogBusiness getInstance(){
        if (instance == null) {
            instance = new Pessoa_FisicalogBusiness();
        }
        return instance;
    }
    
    private Pessoa_FisicalogBusiness(){
        dao = Pessoa_FisicaDAO.getInstance();
    }
    
    public Pessoa_Fisica getById(int id){
        return dao.getById(id);
    } 
    
    public Pessoa_Fisica getLast(){
        return dao.getLast();
    }
    
    
    public ArrayList<Pessoa_Fisica> getAll(){
        return dao.getAll();
    }
    
    public void persist(Pessoa_Fisica pessoa_Fisica){
        dao.persist(pessoa_Fisica);
    }
    
    public void merge(Pessoa_Fisica pessoa_Fisica) {
        dao.merge(pessoa_Fisica);
    }
    public void remove(Pessoa_Fisica pessoa_Fisica) {
        dao.remove(pessoa_Fisica);
    }
    public void removeById(int id) {
        dao.removeById(id);
    }
}
