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
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import model.Conta;
import model.Usuario;
import util.Util;
import view.AppTelas;

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
        entityManager = getEntityManager();
    }

    private EntityManager getEntityManager() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("Veiculos_PajeuPU");
        if (entityManager == null) {
            entityManager = factory.createEntityManager();
        }
        return entityManager;
    }

    public Usuario getById(final int id) {
        return entityManager.find(Usuario.class, id);
    }

    public ArrayList<Usuario> getAll() {
        return (ArrayList<Usuario>) entityManager.createQuery("FROM " + Usuario.class.getName()).getResultList();
    }

    public Usuario getByLogin(String login) {
        try {
            String jpaQuery = "from " + Usuario.class.getSimpleName() + " u where u.login='" + login + "'";
            return (Usuario) entityManager.createQuery(jpaQuery).getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void persist(Usuario usuario) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(usuario);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public void merge(Usuario usuario) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(usuario);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public void remove(Usuario usuario) {
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(usuario);
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
            String jpaQuery = "from " + Usuario.class.getSimpleName() + " u where u.login='" + login + "'"
                    + " and u.senha='" + senha + "'";
            Usuario usuario = (Usuario) entityManager.createQuery(jpaQuery).getSingleResult();
            Fachada.setUserLogado(usuario);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            AppTelas.mostrarAlert(Util.ERRO_LOGIN);
        }
        
        return false;
    }

    public boolean trocarSenha(Usuario user, String novaSenha, String antigaSenha) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        if (user.getSenha().equals(Util.criptografar(antigaSenha))) {
            user.setSenha(Util.criptografar(novaSenha));
            merge(user);
            return true;
        }
        return false;
    }

    public boolean redefinirSenha(String login) {
        try {
            Usuario u = getByLogin(login);
            u.setSenha(Util.criptografar(login));
            merge(u);
            Fachada.setUserLogado(u);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
