/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

/**
 *
 * @author Elvis Nogueira
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Pessoa_Juridica extends Cliente{
    @Column(nullable = false, length = 18, unique = true)
    private String cnpj;
    @Column(nullable = false, length = 10, unique = true)
    private String inscricao_estadual;

    public Pessoa_Juridica() {
    }

    public Pessoa_Juridica(String cnpj, String inscricao_estadual, String codigo, String nome, String telefone, Endereco endereco) {
        super(codigo, nome, telefone, endereco);
        this.cnpj = cnpj;
        this.inscricao_estadual = inscricao_estadual;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.cnpj);
        hash = 89 * hash + Objects.hashCode(this.inscricao_estadual);
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
        final Pessoa_Juridica other = (Pessoa_Juridica) obj;
        if (!Objects.equals(this.cnpj, other.cnpj)) {
            return false;
        }
        if (!Objects.equals(this.inscricao_estadual, other.inscricao_estadual)) {
            return false;
        }
        return true;
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

    @Override
    public String toString() {
        return super.toString()+"\nPessoa_Juridica{" + "cnpj=" + cnpj + ", inscricao_estadual=" + inscricao_estadual + '}';
    }
    
    
    
}
