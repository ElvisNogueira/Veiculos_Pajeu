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

/**
 *
 * @author Elvis Nogueira
 */
public class UsuarioBusiness {

    private static UsuarioBusiness instance;
    private UsuarioDAO dao;

    public static UsuarioBusiness getInstance() {
        if (instance == null) {
            instance = new UsuarioBusiness();
        }
        return instance;
    }

    private UsuarioBusiness() {
        dao = UsuarioDAO.getInstance();
    }

    public Usuario getById(int id) {
        return dao.getById(id);
    }

    public ArrayList<Usuario> getAll() {
        return dao.getAll();
    }

    public void persist(Usuario usuario) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        if (Util.validarSenha(usuario.getSenha())) {
            usuario.setSenha(Util.criptografar(usuario.getSenha()));
            dao.persist(usuario);
        } else {
            System.err.println("Senha inválida!");
        }
    }

    public void merge(Usuario usuario) {
        dao.merge(usuario);
    }

    public void remove(Usuario usuario) {
        dao.remove(usuario);
    }

    public void removeById(int id) {
        dao.removeById(id);
    }

    public boolean login(String login, String senha) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        senha = Util.criptografar(senha);
        
        return dao.login(login, senha);
    }

    public boolean trocarSenha(String novaSenha, String antigaSenha) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        if(Util.validarSenha(novaSenha))
            return dao.trocarSenha(Fachada.getUserLogado(), novaSenha, antigaSenha);
        else
            System.err.println("Senha iinválida!");
        return false;
    }

    public boolean redefinirSenha(String login) {
        if (Fachada.getUserLogado().getTipo().equals("Administrador")) {
            return dao.redefinirSenha(login);
        }
        return false;
    }
}
