/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import dao.Relatorio_financeiroDAO;
import java.util.ArrayList;
import model.Relatorio_financeiro;

/**
 *
 * @author Elvis Nogueira
 */
public class Relatorio_financeiroBusiness {
    private static Relatorio_financeiroBusiness instance;
    private Relatorio_financeiroDAO dao;
    
    public static Relatorio_financeiroBusiness getInstance(){
        if (instance == null) {
            instance = new Relatorio_financeiroBusiness();
        }
        return instance;
    }
    
    private Relatorio_financeiroBusiness(){
        dao = Relatorio_financeiroDAO.getInstance();
    }
    
    public Relatorio_financeiro getById(int id){
        return dao.getById(id);
    } 
    
    public ArrayList<Relatorio_financeiro> getAll(){
        return dao.getAll();
    }
    
    public ArrayList<Relatorio_financeiro> getBusca(String busca) {
        return dao.getBusca(busca);
    }
}
