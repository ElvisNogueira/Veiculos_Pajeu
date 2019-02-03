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

public class Funcionariolog {
     @Id
     @GeneratedValue (strategy = GenerationType.AUTO)
     private int id;
     @Column(nullable = false)
     private String nome;
     @Column(nullable = false, length = 14)
     private String telefone;
     @Column(nullable = false, unique = true, length = 14)
     private String cpf;
     @Column(nullable = false)
     private Date data_nasc;
     
      @Column(nullable = false)
     private String nomeNovo;
     @Column(nullable = false, length = 14)
     private String telefoneNovo;
     @Column(nullable = false, unique = true, length = 14)
     private String cpfNovo;
     @Column(nullable = false)
     private Date data_nascNovo;
     
    private Date data_de_modificacao ;
    private String operacao_realizada;

    public Funcionariolog() {
        
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + this.id;
        hash = 41 * hash + Objects.hashCode(this.nome);
        hash = 41 * hash + Objects.hashCode(this.telefone);
        hash = 41 * hash + Objects.hashCode(this.cpf);
        hash = 41 * hash + Objects.hashCode(this.data_nasc);
        hash = 41 * hash + Objects.hashCode(this.nomeNovo);
        hash = 41 * hash + Objects.hashCode(this.telefoneNovo);
        hash = 41 * hash + Objects.hashCode(this.cpfNovo);
        hash = 41 * hash + Objects.hashCode(this.data_nascNovo);
        hash = 41 * hash + Objects.hashCode(this.data_de_modificacao);
        hash = 41 * hash + Objects.hashCode(this.operacao_realizada);
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
        final Funcionariolog other = (Funcionariolog) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.telefone, other.telefone)) {
            return false;
        }
        if (!Objects.equals(this.cpf, other.cpf)) {
            return false;
        }
        if (!Objects.equals(this.nomeNovo, other.nomeNovo)) {
            return false;
        }
        if (!Objects.equals(this.telefoneNovo, other.telefoneNovo)) {
            return false;
        }
        if (!Objects.equals(this.cpfNovo, other.cpfNovo)) {
            return false;
        }
        if (!Objects.equals(this.operacao_realizada, other.operacao_realizada)) {
            return false;
        }
        if (!Objects.equals(this.data_nasc, other.data_nasc)) {
            return false;
        }
        if (!Objects.equals(this.data_nascNovo, other.data_nascNovo)) {
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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getData_nasc() {
        return data_nasc;
    }

    public void setData_nasc(Date data_nasc) {
        this.data_nasc = data_nasc;
    }

    public String getNomeNovo() {
        return nomeNovo;
    }

    public void setNomeNovo(String nomeNovo) {
        this.nomeNovo = nomeNovo;
    }

    public String getTelefoneNovo() {
        return telefoneNovo;
    }

    public void setTelefoneNovo(String telefoneNovo) {
        this.telefoneNovo = telefoneNovo;
    }

    public String getCpfNovo() {
        return cpfNovo;
    }

    public void setCpfNovo(String cpfNovo) {
        this.cpfNovo = cpfNovo;
    }

    public Date getData_nascNovo() {
        return data_nascNovo;
    }

    public void setData_nascNovo(Date data_nascNovo) {
        this.data_nascNovo = data_nascNovo;
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
