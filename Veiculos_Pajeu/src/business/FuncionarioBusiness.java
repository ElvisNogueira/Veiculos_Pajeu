/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import dao.Camioneta_cargaDAO;
import dao.FuncionarioDAO;
import fachada.Fachada;
import java.util.ArrayList;
import model.Camioneta_carga;
import model.Funcionario;

/**
 *
 * @author Elvis Nogueira
 */
public class FuncionarioBusiness {
    private static FuncionarioBusiness instance;
    private FuncionarioDAO dao;
    
    public static FuncionarioBusiness getInstance(){
        if (instance == null) {
            instance = new FuncionarioBusiness();
        }
        return instance;
    }
    
    private FuncionarioBusiness(){
        dao = FuncionarioDAO.getInstance();
    }
    
    public Funcionario getById(int id){
        return dao.getById(id);
    } 
    
    public ArrayList<Funcionario> getAll(){
        return dao.getAll();
    }
    
    public ArrayList<Funcionario> getBusca(String busca){
        return dao.getBusca(busca);                
    }
    
    public void persist(Funcionario funcionario){
        dao.persist(funcionario);
    }
    
    public void merge(Funcionario funcionario) {
        dao.merge(funcionario);
    }
    public void remove(Funcionario funcionario) {
        dao.remove(funcionario);
    }
    public void removeById(int id) {
        dao.removeById(id);
    }
}
