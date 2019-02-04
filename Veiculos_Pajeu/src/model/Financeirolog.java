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
public class Financeirolog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", insertable = false, updatable = false)
    private int id;
    
    private Date data;
    @Column(nullable = true)
    private float valor;
    private String observacao;
    @OneToOne
    @JoinColumn(name = "id_conta")
    private Conta conta;
    @OneToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;
    
    
    private Date dataNovo;
    private float valorNovo;
    private String observacaoNovo;
    @OneToOne
    @JoinColumn(name = "id_contaNovo")
    private Conta contaNovo;
    @OneToOne
    @JoinColumn(name = "id_usuarioNovo")
    private Usuario usuarioNovo;
    
    private Date data_de_modificacao ;
    private String operacao_realizada;
    
    public Financeirolog() {
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + this.id;
        hash = 31 * hash + Objects.hashCode(this.data);
        hash = 31 * hash + Float.floatToIntBits(this.valor);
        hash = 31 * hash + Objects.hashCode(this.observacao);
        hash = 31 * hash + Objects.hashCode(this.conta);
        hash = 31 * hash + Objects.hashCode(this.usuario);
        hash = 31 * hash + Objects.hashCode(this.dataNovo);
        hash = 31 * hash + Float.floatToIntBits(this.valorNovo);
        hash = 31 * hash + Objects.hashCode(this.observacaoNovo);
        hash = 31 * hash + Objects.hashCode(this.contaNovo);
        hash = 31 * hash + Objects.hashCode(this.usuarioNovo);
        hash = 31 * hash + Objects.hashCode(this.data_de_modificacao);
        hash = 31 * hash + Objects.hashCode(this.operacao_realizada);
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
        final Financeirolog other = (Financeirolog) obj;
        if (this.id != other.id) {
            return false;
        }
        if (Float.floatToIntBits(this.valor) != Float.floatToIntBits(other.valor)) {
            return false;
        }
        if (Float.floatToIntBits(this.valorNovo) != Float.floatToIntBits(other.valorNovo)) {
            return false;
        }
        if (!Objects.equals(this.observacao, other.observacao)) {
            return false;
        }
        if (!Objects.equals(this.observacaoNovo, other.observacaoNovo)) {
            return false;
        }
        if (!Objects.equals(this.operacao_realizada, other.operacao_realizada)) {
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
        if (!Objects.equals(this.dataNovo, other.dataNovo)) {
            return false;
        }
        if (!Objects.equals(this.contaNovo, other.contaNovo)) {
            return false;
        }
        if (!Objects.equals(this.usuarioNovo, other.usuarioNovo)) {
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

    public Date getDataNovo() {
        return dataNovo;
    }

    public void setDataNovo(Date dataNovo) {
        this.dataNovo = dataNovo;
    }

    public float getValorNovo() {
        return valorNovo;
    }

    public void setValorNovo(float valorNovo) {
        this.valorNovo = valorNovo;
    }

    public String getObservacaoNovo() {
        return observacaoNovo;
    }

    public void setObservacaoNovo(String observacaoNovo) {
        this.observacaoNovo = observacaoNovo;
    }

    public Conta getContaNovo() {
        return contaNovo;
    }

    public void setContaNovo(Conta contaNovo) {
        this.contaNovo = contaNovo;
    }

    public Usuario getUsuarioNovo() {
        return usuarioNovo;
    }

    public void setUsuarioNovo(Usuario usuarioNovo) {
        this.usuarioNovo = usuarioNovo;
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
