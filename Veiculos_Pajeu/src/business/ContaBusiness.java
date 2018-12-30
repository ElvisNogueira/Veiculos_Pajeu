/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import dao.Camioneta_cargaDAO;
import dao.ContaDAO;
import java.util.ArrayList;
import model.Camioneta_carga;
import model.Conta;

/**
 *
 * @author Elvis Nogueira
 */
public class ContaBusiness {
    private static ContaBusiness instance;
    private ContaDAO dao;
    
    public static ContaBusiness getInstance(){
        if (instance == null) {
            instance = new ContaBusiness();
        }
        return instance;
    }
    
    private ContaBusiness(){
        dao = ContaDAO.getInstance();
    }
    
    public Conta getById(int id){
        return dao.getById(id);
    } 
    
    public Conta getByNome(String nome){
        return dao.getByNome(nome);
    }
    
    public ArrayList<Conta> getAll(){
        return dao.getAll();
    }
    
    public void persist(Conta conta){
        dao.persist(conta);
    }
    
    public void merge(Conta conta) {
        dao.merge(conta);
    }
    public void remove(Conta conta) {
        dao.remove(conta);
    }
    public void removeById(int id) {
        dao.removeById(id);
    }
}
