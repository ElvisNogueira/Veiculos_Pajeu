/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import dao.Relatorio_financeiroDAO;
import dao.Relatorio_locacaoDAO;
import java.util.ArrayList;
import model.Relatorio_financeiro;
import model.Relatorio_locacao;

/**
 *
 * @author Elvis Nogueira
 */
public class Relatorio_locacaoBusiness {
    private static Relatorio_locacaoBusiness instance;
    private Relatorio_locacaoDAO dao;
    
    public static Relatorio_locacaoBusiness getInstance(){
        if (instance == null) {
            instance = new Relatorio_locacaoBusiness();
        }
        return instance;
    }
    
    private Relatorio_locacaoBusiness(){
        dao = Relatorio_locacaoDAO.getInstance();
    }
    
    public Relatorio_locacao getById(int id){
        return dao.getById(id);
    } 
    
    public ArrayList<Relatorio_locacao> getAll(){
        return dao.getAll();
    }
}
