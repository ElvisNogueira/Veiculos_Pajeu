/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import dao.ConfiguracoesDAO;
import java.util.ArrayList;
import model.Configuracoes;

/**
 *
 * @author Elvis Nogueira
 */
public class ConfiguracoesBusiness {
    private static ConfiguracoesBusiness instance;
    private ConfiguracoesDAO dao;
    
    public static ConfiguracoesBusiness getInstance(){
        if (instance == null) {
            instance = new ConfiguracoesBusiness();
        }
        return instance;
    }
    
    
    private ConfiguracoesBusiness(){
        dao = ConfiguracoesDAO.getInstance();
    }
    
    public ArrayList<Configuracoes> getAll(){
        return dao.getAll();
    }
    
    public void persist(Configuracoes configuracoes){
        dao.persist(configuracoes);
    }
    
    public void merge(Configuracoes configuracoes) {
        dao.merge(configuracoes);
    }
}
