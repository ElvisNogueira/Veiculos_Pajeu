/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.OneToOne;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;

/**
 *
 * @author Elvis Nogueira
 */
@Entity
@NamedStoredProcedureQuery(
	name = "login", 
	procedureName = "login", 
	parameters = { 
		@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "LOGINPARAM"), 
		@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "SENHAPARAM"),
                @StoredProcedureParameter(mode = ParameterMode.OUT, type = Integer.class, name = "SAIDA")
	}
)


public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(nullable = false, length = 20)
    private String tipo;
    @Column(nullable = false)
    private String login,senha;
    @OneToOne (cascade = CascadeType.ALL)
    @JoinColumn(name = "id_funcionario")
    private Funcionario funcionario;
    private boolean status;

    public Usuario(String tipo, String login, String senha, Funcionario funcionario) {
        this.tipo = tipo;
        this.login = login;
        this.senha = senha;
        this.funcionario = funcionario;
    }

    public Usuario() {
        status = true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + this.id;
        hash = 67 * hash + Objects.hashCode(this.tipo);
        hash = 67 * hash + Objects.hashCode(this.login);
        hash = 67 * hash + Objects.hashCode(this.senha);
        hash = 67 * hash + Objects.hashCode(this.funcionario);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Usuario other = (Usuario) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.tipo, other.tipo)) {
            return false;
        }
        if (!Objects.equals(this.login, other.login)) {
            return false;
        }
        if (!Objects.equals(this.senha, other.senha)) {
            return false;
        }
        if (!Objects.equals(this.funcionario, other.funcionario)) {
            return false;
        }
        return true;
    }

    
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
    

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", tipo=" + tipo + ", login=" + login + ", senha=" + senha + ", funcionario=" + funcionario + '}';
    }
    
    
}
