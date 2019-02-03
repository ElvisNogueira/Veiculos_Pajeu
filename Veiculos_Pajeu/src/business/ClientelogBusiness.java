/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;


import dao.ClienteDAO;
import fachada.Fachada;
import java.util.ArrayList;
import model.Cliente;
import model.Endereco;

/**
 *
 * @author Elvis Nogueira
 */
public class ClientelogBusiness {

    private static ClientelogBusiness instance;
    private ClienteDAO dao;

    public static ClientelogBusiness getInstance() {
        if (instance == null) {
            instance = new ClientelogBusiness();
        }
        return instance;
    }

    private ClientelogBusiness() {
        dao = ClienteDAO.getInstance();
    }

    public Cliente getById(int id) {
        return dao.getById(id);
    }

    public ArrayList<Cliente> getAll() {
        return dao.getAll();
    }

    public Cliente getLast() {
        return dao.getLast();
    }
    
    public ArrayList<Cliente> getBusca(String busca){
        return dao.getBusca(busca);
    }

    public void persist(Cliente cliente) {
        EnderecoBusiness.getInstance().persist(cliente.getEndereco());
        Endereco end = Fachada.getInstance().getLastEndereco();
        cliente.setEndereco(end);
        dao.persist(cliente);
    }

    public void merge(Cliente cliente) {
        dao.merge(cliente);
    }

    public void remove(Cliente cliente) {
        dao.remove(cliente);
    }

    public void removeById(int id) {
        dao.removeById(id);
    }
}
