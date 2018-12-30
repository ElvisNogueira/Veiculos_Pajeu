/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import dao.Camioneta_cargaDAO;
import dao.FinanceiroDAO;
import java.util.ArrayList;
import model.Camioneta_carga;
import model.Financeiro;

/**
 *
 * @author Elvis Nogueira
 */
public class FinanceiroBusiness {
    private static FinanceiroBusiness instance;
    private FinanceiroDAO dao;
    
    public static FinanceiroBusiness getInstance(){
        if (instance == null) {
            instance = new FinanceiroBusiness();
        }
        return instance;
    }
    
    private FinanceiroBusiness(){
        dao = FinanceiroDAO.getInstance();
    }
    
    public Financeiro getById(int id){
        return dao.getById(id);
    } 
    
    public ArrayList<Financeiro> getAll(){
        return dao.getAll();
    }
    
    public void persist(Financeiro financeiro){
        dao.persist(financeiro);
    }
    
    public void merge(Financeiro financeiro) {
        dao.merge(financeiro);
    }
    public void remove(Financeiro financeiro) {
        dao.remove(financeiro);
    }
    public void removeById(int id) {
        dao.removeById(id);
    }
}
