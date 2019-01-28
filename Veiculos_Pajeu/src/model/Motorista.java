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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 *
 * @author Elvis Nogueira
 */
@Entity
public class Motorista {
    @Id
    private int id;
    @Column(nullable = false)
    private Date data_venc_habilitacao;
    @Column (nullable = false)
    private String num_habilitacao;
    @OneToOne
    @JoinColumn(name = "id_pessoa_Fisica")
    private Pessoa_Fisica pessoa_Fisica;

    public Motorista() {
    }

    public Motorista(Date data_venc_habilitacao, String num_habilitacao, Pessoa_Fisica pessoa_Fisica) {
        this.data_venc_habilitacao = data_venc_habilitacao;
        this.num_habilitacao = num_habilitacao;
        this.pessoa_Fisica = pessoa_Fisica;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + this.id;
        hash = 17 * hash + Objects.hashCode(this.data_venc_habilitacao);
        hash = 17 * hash + Objects.hashCode(this.num_habilitacao);
        hash = 17 * hash + Objects.hashCode(this.pessoa_Fisica);
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
        final Motorista other = (Motorista) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.num_habilitacao, other.num_habilitacao)) {
            return false;
        }
        if (!Objects.equals(this.data_venc_habilitacao, other.data_venc_habilitacao)) {
            return false;
        }
        if (!Objects.equals(this.pessoa_Fisica, other.pessoa_Fisica)) {
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

    @Override
    public String toString() {
        return getPessoa_Fisica().getNome();
    }
    
    
    
}
