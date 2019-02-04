/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import dao.Relatorio_financeiroDAO;
import dao.Relatorio_reservaDAO;
import java.util.ArrayList;
import model.Relatorio_reserva;

/**
 *
 * @author Elvis Nogueira
 */
public class Relatorio_reservaBusiness {
    private static Relatorio_reservaBusiness instance;
    private Relatorio_reservaDAO dao;
    
    public static Relatorio_reservaBusiness getInstance(){
        if (instance == null) {
            instance = new Relatorio_reservaBusiness();
        }
        return instance;
    }
    
    private Relatorio_reservaBusiness(){
        dao = Relatorio_reservaDAO.getInstance();
    }
    
    public Relatorio_reserva getById(int id){
        return dao.getById(id);
    } 
    
    public ArrayList<Relatorio_reserva> getAll(){
        return dao.getAll();
    }
    
}
