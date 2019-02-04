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
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 *
 * @author Elvis Nogueira
 */
@Entity
public class Motoristalog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", insertable = false, updatable = false)
    private int id;
    
    @Column(nullable = true)
    private Date data_venc_habilitacao;
    @Column(nullable = true)
    private String num_habilitacao;
    @OneToOne
    @JoinColumn(name = "id_pessoa_Fisica")
    private Pessoa_Fisica pessoa_Fisica;
    
    @Column(nullable = true)
    private Date data_venc_habilitacaoNovo;
    @Column(nullable = true)
    private String num_habilitacaoNovo;
    @OneToOne
    @JoinColumn(name = "id_pessoa_FisicaNovo")
    private Pessoa_Fisica pessoa_FisicaNovo;
    
    private Date data_de_modificacao ;
    private String operacao_realizada;

    public Motoristalog() {
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + this.id;
        hash = 79 * hash + Objects.hashCode(this.data_venc_habilitacao);
        hash = 79 * hash + Objects.hashCode(this.num_habilitacao);
        hash = 79 * hash + Objects.hashCode(this.pessoa_Fisica);
        hash = 79 * hash + Objects.hashCode(this.data_venc_habilitacaoNovo);
        hash = 79 * hash + Objects.hashCode(this.num_habilitacaoNovo);
        hash = 79 * hash + Objects.hashCode(this.pessoa_FisicaNovo);
        hash = 79 * hash + Objects.hashCode(this.data_de_modificacao);
        hash = 79 * hash + Objects.hashCode(this.operacao_realizada);
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
        final Motoristalog other = (Motoristalog) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.num_habilitacao, other.num_habilitacao)) {
            return false;
        }
        if (!Objects.equals(this.num_habilitacaoNovo, other.num_habilitacaoNovo)) {
            return false;
        }
        if (!Objects.equals(this.operacao_realizada, other.operacao_realizada)) {
            return false;
        }
        if (!Objects.equals(this.data_venc_habilitacao, other.data_venc_habilitacao)) {
            return false;
        }
        if (!Objects.equals(this.pessoa_Fisica, other.pessoa_Fisica)) {
            return false;
        }
        if (!Objects.equals(this.data_venc_habilitacaoNovo, other.data_venc_habilitacaoNovo)) {
            return false;
        }
        if (!Objects.equals(this.pessoa_FisicaNovo, other.pessoa_FisicaNovo)) {
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

    public Date getData_venc_habilitacao() {
        return data_venc_habilitacao;
    }

    public void setData_venc_habilitacao(Date data_venc_habilitacao) {
        this.data_venc_habilitacao = data_venc_habilitacao;
    }

    public String getNum_habilitacao() {
        return num_habilitacao;
    }

    public void setNum_habilitacao(String num_habilitacao) {
        this.num_habilitacao = num_habilitacao;
    }

    public Pessoa_Fisica getPessoa_Fisica() {
        return pessoa_Fisica;
    }

    public void setPessoa_Fisica(Pessoa_Fisica pessoa_Fisica) {
        this.pessoa_Fisica = pessoa_Fisica;
    }

    public Date getData_venc_habilitacaoNovo() {
        return data_venc_habilitacaoNovo;
    }

    public void setData_venc_habilitacaoNovo(Date data_venc_habilitacaoNovo) {
        this.data_venc_habilitacaoNovo = data_venc_habilitacaoNovo;
    }

    public String getNum_habilitacaoNovo() {
        return num_habilitacaoNovo;
    }

    public void setNum_habilitacaoNovo(String num_habilitacaoNovo) {
        this.num_habilitacaoNovo = num_habilitacaoNovo;
    }

    public Pessoa_Fisica getPessoa_FisicaNovo() {
        return pessoa_FisicaNovo;
    }

    public void setPessoa_FisicaNovo(Pessoa_Fisica pessoa_FisicaNovo) {
        this.pessoa_FisicaNovo = pessoa_FisicaNovo;
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
