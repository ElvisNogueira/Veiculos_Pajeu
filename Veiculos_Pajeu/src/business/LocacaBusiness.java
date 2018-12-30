/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import dao.Camioneta_cargaDAO;
import dao.LocacaoDAO;
import java.util.ArrayList;
import model.Camioneta_carga;
import model.Locacao;

/**
 *
 * @author Elvis Nogueira
 */
public class LocacaBusiness {
    private static LocacaBusiness instance;
    private LocacaoDAO dao;
    
    public static LocacaBusiness getInstance(){
        if (instance == null) {
            instance = new LocacaBusiness();
        }
        return instance;
    }
    
    private LocacaBusiness(){
        dao = LocacaoDAO.getInstance();
    }
    
    public Locacao getById(int id){
        return dao.getById(id);
    } 
    
    public ArrayList<Locacao> getAll(){
        return dao.getAll();
    }
    
    public void persist(Locacao locacao){
        dao.persist(locacao);
    }
    
    public void merge(Locacao locacao) {
        dao.merge(locacao);
    }
    public void remove(Locacao locacao) {
        dao.remove(locacao);
    }
    public void removeById(int id) {
        dao.removeById(id);
    }
}
