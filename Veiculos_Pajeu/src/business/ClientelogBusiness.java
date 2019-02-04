/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;


import dao.ClienteDAO;
import dao.ClientelogDAO;
import fachada.Fachada;
import java.util.ArrayList;
import model.Cliente;
import model.Clientelog;
import model.Endereco;

/**
 *
 * @author Elvis Nogueira
 */
public class ClientelogBusiness {

    private static ClientelogBusiness instance;
    private ClientelogDAO dao;

    public static ClientelogBusiness getInstance() {
        if (instance == null) {
            instance = new ClientelogBusiness();
        }
        return instance;
    }

    private ClientelogBusiness() {
        dao = ClientelogDAO.getInstance();
    }

    public Clientelog getById(int id) {
        return dao.getById(id);
    }

    public ArrayList<Clientelog> getAll() {
        return dao.getAll();
    }
}
