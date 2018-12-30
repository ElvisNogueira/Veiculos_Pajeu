/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import dao.Camioneta_cargaDAO;
import dao.MotoristaDAO;
import java.util.ArrayList;
import model.Camioneta_carga;
import model.Motorista;
import util.Util;

/**
 *
 * @author Elvis Nogueira
 */
public class MotoristaBusiness {
    private static MotoristaBusiness instance;
    private MotoristaDAO dao;
    
    public static MotoristaBusiness getInstance(){
        if (instance == null) {
            instance = new MotoristaBusiness();
        }
        return instance;
    }
    
    private MotoristaBusiness(){
        dao = MotoristaDAO.getInstance();
    }
    
    public Motorista getById(int id){
        return dao.getById(id);
    } 
    
    public ArrayList<Motorista> getAll(){
        return dao.getAll();
    }
    
    public void persist(Motorista motorista){
        if(Util.calcularIdade(motorista.getPessoa_Fisica().getData_nasc())>=21)
            dao.persist(motorista);
        else
            System.err.println("O motorista deve ter 21 anos ou mais!");
        
        
    }
    
    public void merge(Motorista motorista) {
        dao.merge(motorista);
    }
    public void remove(Motorista motorista) {
        dao.remove(motorista);
    }
    public void removeById(int id) {
        dao.removeById(id);
    }
}
