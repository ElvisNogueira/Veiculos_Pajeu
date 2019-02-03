/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import fachada.Fachada;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.NoResultException;
import javax.persistence.ParameterMode;
import javax.persistence.Persistence;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.StoredProcedureQuery;
import model.Conta;
import model.Usuario;
import util.Util;
import app.App;
import connection.ConnectionFactory;

/**
 *
 * @author Elvis Nogueira
 */
public class UsuarioDAO {

    private static UsuarioDAO instance;
    protected EntityManager entityManager;

    public static UsuarioDAO getInstance() {
        if (instance == null) {
            instance = new UsuarioDAO();
        }
        return instance;
    }

    private UsuarioDAO() {
        entityManager = new ConnectionFactory().getConnetion();
    }

    public Usuario getById(final int id) {
        return entityManager.find(Usuario.class, id);
    }

    public ArrayList<Usuario> getAll() {
        return (ArrayList<Usuario>) entityManager.createQuery("FROM " + Usuario.class.getName()+" "
                + "WHERE status = 'true'").getResultList();
    }

    public Usuario getByLogin(String login) {
        try {
            String jpaQuery = "from " + Usuario.class.getSimpleName() + " u where u.login='" + login + "'"
                    +" WHERE status = 'true'";
            return (Usuario) entityManager.createQuery(jpaQuery).getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void persist(Usuario usuario) {
        try {
            StoredProcedureQuery query = entityManager.createNamedStoredProcedureQuery("criptografar_senha");
            query.setParameter("SENHA", usuario.getSenha());
            query.execute();
            
            String senha = (String) query.getOutputParameterValue("SAIDA");
            usuario.setSenha(senha);
            entityManager.getTransaction().begin();
            entityManager.persist(usuario);
            entityManager.getTransaction().commit();
            App.mostrarAlert(Util.SUCESSO_CADASTRO,"Cadastro feito com suucesso");
        } catch (Exception e) {
            App.mostrarAlert(Util.ERRO_CADASTRO, "Erro ao effetuar Cadastro!");
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public void merge(Usuario usuario) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(usuario);
            entityManager.getTransaction().commit();
            App.mostrarAlert(Util.SUCESSO_CADASTRO,"Editção realizada com suucesso!");
        } catch (Exception e) {
            App.mostrarAlert(Util.ERRO_CADASTRO,"Erro ao editar!");
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public void remove(Usuario usuario) {
        try {
            entityManager.getTransaction().begin();
//            entityManager.remove(usuario);
            usuario.setStatus(false);
            entityManager.merge(usuario);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public void removeById(int id) {
        try {
            Usuario usuario = getById(id);
            remove(usuario);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean login(String login, String senha) {
        try {
//            String jpaQuery = "from " + Usuario.class.getSimpleName() + " u where u.login='" + login + "'"
//                    + " and u.senha='" + senha + "'";
//            Usuario usuario = (Usuario) entityManager.createQuery(jpaQuery).getSingleResult();
//            Fachada.setUserLogado(usuario);
//            return true;
            StoredProcedureQuery query = entityManager.createNamedStoredProcedureQuery("login");
            query.setParameter("LOGINPARAM", login);
            query.setParameter("SENHAPARAM", senha);
            query.execute();
            Integer id = (Integer) query.getOutputParameterValue("SAIDA");
            Fachada.setUserLogado(getById(id));
             
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            App.mostrarAlert(Util.ERRO_LOGIN, "Erro ao efetuar login!");
        }

        return false;
    }
    
    private String criptografar(String texto){
        StoredProcedureQuery query = entityManager.createNamedStoredProcedureQuery("criptografar_senha");
            query.setParameter("SENHA", texto);
            query.execute();
            
            return (String) query.getOutputParameterValue("SAIDA");
    }

    public boolean trocarSenha(Usuario user, String novaSenha, String antigaSenha) throws NoSuchAlgorithmException, UnsupportedEncodingException {
            
            antigaSenha = criptografar(antigaSenha);
        if (user.getSenha().equals(antigaSenha)) {
            user.setSenha(criptografar(novaSenha));
            merge(user);
            return true;
        }
        return false;
    }

    public boolean redefinirSenha(String login) {
        try {
            Usuario u = getByLogin(login);
            u.setSenha(criptografar(login));
            merge(u);
            Fachada.setUserLogado(u);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
