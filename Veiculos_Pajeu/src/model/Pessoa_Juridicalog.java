/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

/**
 *
 * @author Elvis Nogueira
 */
@Entity
public class Pessoa_Juridicalog{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", insertable = false, updatable = false)
    private int id;
    
    @Column(nullable = false, length = 18, unique = true)
    private String cnpj;
    @Column(nullable = false, length = 10, unique = true)
    private String inscricao_estadual;
    
    @Column(nullable = false, length = 18, unique = true)
    private String cnpjNovo;
    @Column(nullable = false, length = 10, unique = true)
    private String inscricao_estadualNovo;
    
    private Date data_de_modificacao ;
    private String operacao_realizada;

    public Pessoa_Juridicalog() {
        
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 61 * hash + this.id;
        hash = 61 * hash + Objects.hashCode(this.cnpj);
        hash = 61 * hash + Objects.hashCode(this.inscricao_estadual);
        hash = 61 * hash + Objects.hashCode(this.cnpjNovo);
        hash = 61 * hash + Objects.hashCode(this.inscricao_estadualNovo);
        hash = 61 * hash + Objects.hashCode(this.data_de_modificacao);
        hash = 61 * hash + Objects.hashCode(this.operacao_realizada);
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
        final Pessoa_Juridicalog other = (Pessoa_Juridicalog) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.cnpj, other.cnpj)) {
            return false;
        }
        if (!Objects.equals(this.inscricao_estadual, other.inscricao_estadual)) {
            return false;
        }
        if (!Objects.equals(this.cnpjNovo, other.cnpjNovo)) {
            return false;
        }
        if (!Objects.equals(this.inscricao_estadualNovo, other.inscricao_estadualNovo)) {
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

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getInscricao_estadual() {
        return inscricao_estadual;
    }

    public void setInscricao_estadual(String inscricao_estadual) {
        this.inscricao_estadual = inscricao_estadual;
    }

    public String getCnpjNovo() {
        return cnpjNovo;
    }

    public void setCnpjNovo(String cnpjNovo) {
        this.cnpjNovo = cnpjNovo;
    }

    public String getInscricao_estadualNovo() {
        return inscricao_estadualNovo;
    }

    public void setInscricao_estadualNovo(String inscricao_estadualNovo) {
        this.inscricao_estadualNovo = inscricao_estadualNovo;
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
