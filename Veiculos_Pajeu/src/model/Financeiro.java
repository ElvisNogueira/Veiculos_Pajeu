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
public class Financeiro {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(nullable = false)
    private Date data;
    @Column(nullable = false)
    private float valor;
    @Column(nullable = false)
    private String observacao;
    @OneToOne
    @JoinColumn(name = "id_conta")
    private Conta conta;
    @OneToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    public Financeiro() {
    }

    public Financeiro(Date data, float valor, String observacao, Conta conta, Usuario usuario) {
        this.data = data;
        this.valor = valor;
        this.observacao = observacao;
        this.conta = conta;
        this.usuario = usuario;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + this.id;
        hash = 13 * hash + Objects.hashCode(this.data);
        hash = 13 * hash + Float.floatToIntBits(this.valor);
        hash = 13 * hash + Objects.hashCode(this.observacao);
        hash = 13 * hash + Objects.hashCode(this.conta);
        hash = 13 * hash + Objects.hashCode(this.usuario);
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
        final Financeiro other = (Financeiro) obj;
        if (this.id != other.id) {
            return false;
        }
        if (Float.floatToIntBits(this.valor) != Float.floatToIntBits(other.valor)) {
            return false;
        }
        if (!Objects.equals(this.observacao, other.observacao)) {
            return false;
        }
        if (!Objects.equals(this.data, other.data)) {
            return false;
        }
        if (!Objects.equals(this.conta, other.conta)) {
            return false;
        }
        if (!Objects.equals(this.usuario, other.usuario)) {
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

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "Financeiro{" + "id=" + id + ", data=" + data + ", valor=" + valor + ", observacao=" + observacao + ", conta=" + conta + ", usuario=" + usuario + '}';
    }
    
    
    
            
}
