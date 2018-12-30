/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import dao.Camioneta_cargaDAO;
import dao.EnderecoDAO;
import dao.LocadoraDAO;
import java.util.ArrayList;
import model.Camioneta_carga;
import model.Endereco;
import model.Locadora;

/**
 *
 * @author Elvis Nogueira
 */
public class LocadoraBusiness {
    private static LocadoraBusiness instance;
    private LocadoraDAO dao;
    
    public static LocadoraBusiness getInstance(){
        if (instance == null) {
            instance = new LocadoraBusiness();
        }
        return instance;
    }
    
    private LocadoraBusiness(){
        dao = LocadoraDAO.getInstance();
    }
    
    public Locadora getById(int id){
        return dao.getById(id);
    } 
    
    public ArrayList<Locadora> getAll(){
        return dao.getAll();
    }
    
    public Locadora getLastId(){
        return dao.getLastId();
    }
    
    public void persist(Locadora locadora){
        EnderecoDAO.getInstance().persist(locadora.getEndereco());
        ArrayList<Endereco> enderecos = EnderecoBusiness.getInstance().getAll();
        Endereco end = enderecos.get(enderecos.size()-1);
        locadora.setEndereco(end);
        dao.persist(locadora);
    }
    
    public void merge(Locadora locadora) {
        EnderecoDAO.getInstance().merge(locadora.getEndereco());
        Endereco end = EnderecoDAO.getInstance().getById(locadora.getId());
        locadora.setEndereco(end);
        dao.merge(locadora);
    }
    public void remove(Locadora locadora) {
        dao.remove(locadora);
    }
    public void removeById(int id) {
        dao.removeById(id);
    }
}
