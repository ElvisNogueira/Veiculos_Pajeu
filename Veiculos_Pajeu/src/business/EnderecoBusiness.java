/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import dao.Camioneta_cargaDAO;
import dao.EnderecoDAO;
import java.util.ArrayList;
import model.Camioneta_carga;
import model.Endereco;

/**
 *
 * @author Elvis Nogueira
 */
public class EnderecoBusiness {
    private static EnderecoBusiness instance;
    private EnderecoDAO dao;
    
    public static EnderecoBusiness getInstance(){
        if (instance == null) {
            instance = new EnderecoBusiness();
        }
        return instance;
    }
    
    private EnderecoBusiness(){
        dao = EnderecoDAO.getInstance();
    }
    
    public Endereco getById(int id){
        return dao.getById(id);
    } 
    
    public Endereco getLast(){
        return dao.getLast();
    }
    
    public ArrayList<Endereco> getAll(){
        return dao.getAll();
    }
    
    public void persist(Endereco endereco){
        dao.persist(endereco);
    }
    
    public void merge(Endereco endereco) {
        dao.merge(endereco);
    }
    public void remove(Endereco endereco) {
        dao.remove(endereco);
    }
    public void removeById(int id) {
        dao.removeById(id);
    }
}
