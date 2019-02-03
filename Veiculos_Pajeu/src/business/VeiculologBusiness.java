/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import dao.Camioneta_cargaDAO;
import dao.VeiculoDAO;
import java.util.ArrayList;
import model.Camioneta_carga;
import model.Veiculo;

/**
 *
 * @author Elvis Nogueira
 */
public class VeiculologBusiness {
    private static VeiculologBusiness instance;
    private VeiculoDAO dao;
    
    public static VeiculologBusiness getInstance(){
        if (instance == null) {
            instance = new VeiculologBusiness();
        }
        return instance;
    }
    
    private VeiculologBusiness(){
        dao = VeiculoDAO.getInstance();
    }
    
    public Veiculo getById(int id){
        return dao.getById(id);
    } 
    
    public ArrayList<Veiculo> getAll(){
        return dao.getAll();
    }
    
    public ArrayList<Veiculo> getBusca(String busca) {
        return dao.getBusca(busca);
    }
    
    public void persist(Veiculo veiculo){
        dao.persist(veiculo);
    }
    
    public void merge(Veiculo veiculo) {
        dao.merge(veiculo);
    }
    public void remove(Veiculo veiculo) {
        dao.remove(veiculo);
    }
    public void removeById(int id) {
        dao.removeById(id);
    }
}
