/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import dao.Camioneta_cargaDAO;
import dao.FinanceiroDAO;
import dao.FinanceirologDAO;
import java.util.ArrayList;
import model.Camioneta_carga;
import model.Financeiro;
import model.Financeirolog;

/**
 *
 * @author Elvis Nogueira
 */
public class FinanceirologBusiness {
    private static FinanceirologBusiness instance;
    private FinanceirologDAO dao;
    
    public static FinanceirologBusiness getInstance(){
        if (instance == null) {
            instance = new FinanceirologBusiness();
        }
        return instance;
    }
    
    private FinanceirologBusiness(){
        dao = FinanceirologDAO.getInstance();
    }
    
    public Financeirolog getById(int id){
        return dao.getById(id);
    } 
    
    public ArrayList<Financeirolog> getAll(){
        return dao.getAll();
    }
}
