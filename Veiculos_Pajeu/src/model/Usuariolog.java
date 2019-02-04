/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;
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

public class Usuariolog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", insertable = false, updatable = false)
    private int id;
    
    @Column(nullable = true)
    private String tipo,login,senha,tipoNovo,loginNovo,senhaNovo;
    
    private Date data_de_modificacao ;
    private String operacao_realizada;

    public Usuariolog() {
    }

    
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + this.id;
        hash = 59 * hash + Objects.hashCode(this.tipo);
        hash = 59 * hash + Objects.hashCode(this.login);
        hash = 59 * hash + Objects.hashCode(this.senha);
        hash = 59 * hash + Objects.hashCode(this.tipoNovo);
        hash = 59 * hash + Objects.hashCode(this.loginNovo);
        hash = 59 * hash + Objects.hashCode(this.senhaNovo);
        hash = 59 * hash + Objects.hashCode(this.data_de_modificacao);
        hash = 59 * hash + Objects.hashCode(this.operacao_realizada);
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
        final Usuariolog other = (Usuariolog) obj;
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
        if (!Objects.equals(this.tipoNovo, other.tipoNovo)) {
            return false;
        }
        if (!Objects.equals(this.loginNovo, other.loginNovo)) {
            return false;
        }
        if (!Objects.equals(this.senhaNovo, other.senhaNovo)) {
            return false;
        }
        if (!Objects.equals(this.operacao_realizada, other.operacao_realizada)) {
            return false;
        }
        if (!Objects.equals(this.data_de_modificacao, other.data_de_modificacao)) {
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

    public String getTipoNovo() {
        return tipoNovo;
    }

    public void setTipoNovo(String tipoNovo) {
        this.tipoNovo = tipoNovo;
    }

    public String getLoginNovo() {
        return loginNovo;
    }

    public void setLoginNovo(String loginNovo) {
        this.loginNovo = loginNovo;
    }

    public String getSenhaNovo() {
        return senhaNovo;
    }

    public void setSenhaNovo(String senhaNovo) {
        this.senhaNovo = senhaNovo;
    }

    public Date getData_de_modificacao() {
        return data_de_modificacao;
    }

    public void setData_de_modificacao(Date data_de_modificacao) {
        this.data_de_modificacao = data_de_modificacao;
    }

    public String getOperacao_realizada() {
        return operacao_realizada;
    }

    public void setOperacao_realizada(String operacao_realizada) {
        this.operacao_realizada = operacao_realizada;
    }
    
    
}
