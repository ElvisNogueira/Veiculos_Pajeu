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

/**
 *
 * @author Elvis Nogueira
 */
@Entity
public class Enderecolog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", insertable = false, updatable = false)
    private int id;
    
   @Column(nullable = true)
    private String rua,bairro, cidade,uf,cep,numero;
   
    @Column(nullable = true)
    private String ruaNovo,bairroNovo, cidadeNovo,ufNovo,cepNovo,numeroNovo;
    
    private Date data_de_modificacao ;
    private String operacao_realizada;

    public Enderecolog() {
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 83 * hash + this.id;
        hash = 83 * hash + Objects.hashCode(this.rua);
        hash = 83 * hash + Objects.hashCode(this.bairro);
        hash = 83 * hash + Objects.hashCode(this.cidade);
        hash = 83 * hash + Objects.hashCode(this.uf);
        hash = 83 * hash + Objects.hashCode(this.cep);
        hash = 83 * hash + Objects.hashCode(this.numero);
        hash = 83 * hash + Objects.hashCode(this.ruaNovo);
        hash = 83 * hash + Objects.hashCode(this.bairroNovo);
        hash = 83 * hash + Objects.hashCode(this.cidadeNovo);
        hash = 83 * hash + Objects.hashCode(this.ufNovo);
        hash = 83 * hash + Objects.hashCode(this.cepNovo);
        hash = 83 * hash + Objects.hashCode(this.numeroNovo);
        hash = 83 * hash + Objects.hashCode(this.data_de_modificacao);
        hash = 83 * hash + Objects.hashCode(this.operacao_realizada);
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
        final Enderecolog other = (Enderecolog) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.rua, other.rua)) {
            return false;
        }
        if (!Objects.equals(this.bairro, other.bairro)) {
            return false;
        }
        if (!Objects.equals(this.cidade, other.cidade)) {
            return false;
        }
        if (!Objects.equals(this.uf, other.uf)) {
            return false;
        }
        if (!Objects.equals(this.cep, other.cep)) {
            return false;
        }
        if (!Objects.equals(this.numero, other.numero)) {
            return false;
        }
        if (!Objects.equals(this.ruaNovo, other.ruaNovo)) {
            return false;
        }
        if (!Objects.equals(this.bairroNovo, other.bairroNovo)) {
            return false;
        }
        if (!Objects.equals(this.cidadeNovo, other.cidadeNovo)) {
            return false;
        }
        if (!Objects.equals(this.ufNovo, other.ufNovo)) {
            return false;
        }
        if (!Objects.equals(this.cepNovo, other.cepNovo)) {
            return false;
        }
        if (!Objects.equals(this.numeroNovo, other.numeroNovo)) {
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

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getRuaNovo() {
        return ruaNovo;
    }

    public void setRuaNovo(String ruaNovo) {
        this.ruaNovo = ruaNovo;
    }

    public String getBairroNovo() {
        return bairroNovo;
    }

    public void setBairroNovo(String bairroNovo) {
        this.bairroNovo = bairroNovo;
    }

    public String getCidadeNovo() {
        return cidadeNovo;
    }

    public void setCidadeNovo(String cidadeNovo) {
        this.cidadeNovo = cidadeNovo;
    }

    public String getUfNovo() {
        return ufNovo;
    }

    public void setUfNovo(String ufNovo) {
        this.ufNovo = ufNovo;
    }

    public String getCepNovo() {
        return cepNovo;
    }

    public void setCepNovo(String cepNovo) {
        this.cepNovo = cepNovo;
    }

    public String getNumeroNovo() {
        return numeroNovo;
    }

    public void setNumeroNovo(String numeroNovo) {
        this.numeroNovo = numeroNovo;
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
