/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import dao.Camioneta_cargaDAO;
import dao.EnderecoDAO;
import dao.EnderecologDAO;
import java.util.ArrayList;
import model.Camioneta_carga;
import model.Endereco;
import model.Enderecolog;

/**
 *
 * @author Elvis Nogueira
 */
public class EnderecoologBusiness {
    private static EnderecoologBusiness instance;
    private EnderecologDAO dao;
    
    public static EnderecoologBusiness getInstance(){
        if (instance == null) {
            instance = new EnderecoologBusiness();
        }
        return instance;
    }
    
    private EnderecoologBusiness(){
        dao = EnderecologDAO.getInstance();
    }
    
    public Enderecolog getById(int id){
        return dao.getById(id);
    } 
    
    public ArrayList<Enderecolog> getAll(){
        return dao.getAll();
    }
    
}
