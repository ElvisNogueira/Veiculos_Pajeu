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
public class Contalog {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(nullable = false, length = 25)
    String tipoAntigo,tipoNovo;
    @Column(nullable = false)
    private String nomeAntigo,nomeNovo;
    
    private Date data_de_modificacao ;
    private String operacao_realizada;

    public Contalog() {
    }

    public String getTipoAntigo() {
        return tipoAntigo;
    }

    public void setTipoAntigo(String tipoAntigo) {
        this.tipoAntigo = tipoAntigo;
    }

    public String getTipoNovo() {
        return tipoNovo;
    }

    public void setTipoNovo(String tipoNovo) {
        this.tipoNovo = tipoNovo;
    }

    public String getNomeAntigo() {
        return nomeAntigo;
    }

    public void setNomeAntigo(String nomeAntigo) {
        this.nomeAntigo = nomeAntigo;
    }

    public String getNomeNovo() {
        return nomeNovo;
    }

    public void setNomeNovo(String nomeNovo) {
        this.nomeNovo = nomeNovo;
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


    public int getId() {
        return id;
    }

    @Override
    public int hashCode() {
        int hash = 5;
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
        final Contalog other = (Contalog) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.tipoAntigo, other.tipoAntigo)) {
            return false;
        }
        if (!Objects.equals(this.tipoNovo, other.tipoNovo)) {
            return false;
        }
        if (!Objects.equals(this.nomeAntigo, other.nomeAntigo)) {
            return false;
        }
        if (!Objects.equals(this.nomeNovo, other.nomeNovo)) {
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

    public void setId(int id) {
        this.id = id;
    }    
    
}
