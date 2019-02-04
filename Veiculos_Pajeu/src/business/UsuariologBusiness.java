/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import dao.UsuarioDAO;
import fachada.Fachada;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import model.Usuario;
import util.Util;
import app.App;
import dao.UsuariologDAO;
import model.Usuariolog;

/**
 *
 * @author Elvis Nogueira
 */
public class UsuariologBusiness {

    private static UsuariologBusiness instance;
    private UsuariologDAO dao;

    public static UsuariologBusiness getInstance() {
        if (instance == null) {
            instance = new UsuariologBusiness();
        }
        return instance;
    }

    private UsuariologBusiness() {
        dao = UsuariologDAO.getInstance();
    }

    public Usuariolog getById(int id) {
        return dao.getById(id);
    }

    public ArrayList<Usuariolog> getAll() {
        return dao.getAll();
    }
}
