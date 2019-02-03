/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;
import java.sql.Time;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author Elvis Nogueira
 */
@Entity
public class Reservalog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", insertable = false, updatable = false)
    private int id;
    
    private String tipo_locacao;
    private int duracao_estimada;//Em dias
    private Date data_retirada;
    private Time hora_retirada;
    private float valor_entrada;
    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;
    @ManyToOne
    @JoinColumn(name = "id_categoria")
    private Categoria categoria;
    
    
    private String tipo_locacaoNovo;
    private int duracao_estimadaNovo;//Em dias
    private Date data_retiradaNovo;
    private Time hora_retiradaNovo;
    private float valor_entradaNovo;
    @ManyToOne
    @JoinColumn(name = "id_clienteNovo")
    private Cliente clienteNovo;
    @ManyToOne
    @JoinColumn(name = "id_categoriaNovo")
    private Categoria categoriaNovo;
    
    private Date data_de_modificacao ;
    private String operacao_realizada;

    public Reservalog() {
        
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 11 * hash + this.id;
        hash = 11 * hash + Objects.hashCode(this.tipo_locacao);
        hash = 11 * hash + this.duracao_estimada;
        hash = 11 * hash + Objects.hashCode(this.data_retirada);
        hash = 11 * hash + Objects.hashCode(this.hora_retirada);
        hash = 11 * hash + Float.floatToIntBits(this.valor_entrada);
        hash = 11 * hash + Objects.hashCode(this.cliente);
        hash = 11 * hash + Objects.hashCode(this.categoria);
        hash = 11 * hash + Objects.hashCode(this.tipo_locacaoNovo);
        hash = 11 * hash + this.duracao_estimadaNovo;
        hash = 11 * hash + Objects.hashCode(this.data_retiradaNovo);
        hash = 11 * hash + Objects.hashCode(this.hora_retiradaNovo);
        hash = 11 * hash + Float.floatToIntBits(this.valor_entradaNovo);
        hash = 11 * hash + Objects.hashCode(this.clienteNovo);
        hash = 11 * hash + Objects.hashCode(this.categoriaNovo);
        hash = 11 * hash + Objects.hashCode(this.data_de_modificacao);
        hash = 11 * hash + Objects.hashCode(this.operacao_realizada);
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
        final Reservalog other = (Reservalog) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.duracao_estimada != other.duracao_estimada) {
            return false;
        }
        if (Float.floatToIntBits(this.valor_entrada) != Float.floatToIntBits(other.valor_entrada)) {
            return false;
        }
        if (this.duracao_estimadaNovo != other.duracao_estimadaNovo) {
            return false;
        }
        if (Float.floatToIntBits(this.valor_entradaNovo) != Float.floatToIntBits(other.valor_entradaNovo)) {
            return false;
        }
        if (!Objects.equals(this.tipo_locacao, other.tipo_locacao)) {
            return false;
        }
        if (!Objects.equals(this.tipo_locacaoNovo, other.tipo_locacaoNovo)) {
            return false;
        }
        if (!Objects.equals(this.operacao_realizada, other.operacao_realizada)) {
            return false;
        }
        if (!Objects.equals(this.data_retirada, other.data_retirada)) {
            return false;
        }
        if (!Objects.equals(this.hora_retirada, other.hora_retirada)) {
            return false;
        }
        if (!Objects.equals(this.cliente, other.cliente)) {
            return false;
        }
        if (!Objects.equals(this.categoria, other.categoria)) {
            return false;
        }
        if (!Objects.equals(this.data_retiradaNovo, other.data_retiradaNovo)) {
            return false;
        }
        if (!Objects.equals(this.hora_retiradaNovo, other.hora_retiradaNovo)) {
            return false;
        }
        if (!Objects.equals(this.clienteNovo, other.clienteNovo)) {
            return false;
        }
        if (!Objects.equals(this.categoriaNovo, other.categoriaNovo)) {
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

    public String getTipo_locacao() {
        return tipo_locacao;
    }

    public void setTipo_locacao(String tipo_locacao) {
        this.tipo_locacao = tipo_locacao;
    }

    public int getDuracao_estimada() {
        return duracao_estimada;
    }

    public void setDuracao_estimada(int duracao_estimada) {
        this.duracao_estimada = duracao_estimada;
    }

    public Date getData_retirada() {
        return data_retirada;
    }

    public void setData_retirada(Date data_retirada) {
        this.data_retirada = data_retirada;
    }

    public Time getHora_retirada() {
        return hora_retirada;
    }

    public void setHora_retirada(Time hora_retirada) {
        this.hora_retirada = hora_retirada;
    }

    public float getValor_entrada() {
        return valor_entrada;
    }

    public void setValor_entrada(float valor_entrada) {
        this.valor_entrada = valor_entrada;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public String getTipo_locacaoNovo() {
        return tipo_locacaoNovo;
    }

    public void setTipo_locacaoNovo(String tipo_locacaoNovo) {
        this.tipo_locacaoNovo = tipo_locacaoNovo;
    }

    public int getDuracao_estimadaNovo() {
        return duracao_estimadaNovo;
    }

    public void setDuracao_estimadaNovo(int duracao_estimadaNovo) {
        this.duracao_estimadaNovo = duracao_estimadaNovo;
    }

    public Date getData_retiradaNovo() {
        return data_retiradaNovo;
    }

    public void setData_retiradaNovo(Date data_retiradaNovo) {
        this.data_retiradaNovo = data_retiradaNovo;
    }

    public Time getHora_retiradaNovo() {
        return hora_retiradaNovo;
    }

    public void setHora_retiradaNovo(Time hora_retiradaNovo) {
        this.hora_retiradaNovo = hora_retiradaNovo;
    }

    public float getValor_entradaNovo() {
        return valor_entradaNovo;
    }

    public void setValor_entradaNovo(float valor_entradaNovo) {
        this.valor_entradaNovo = valor_entradaNovo;
    }

    public Cliente getClienteNovo() {
        return clienteNovo;
    }

    public void setClienteNovo(Cliente clienteNovo) {
        this.clienteNovo = clienteNovo;
    }

    public Categoria getCategoriaNovo() {
        return categoriaNovo;
    }

    public void setCategoriaNovo(Categoria categoriaNovo) {
        this.categoriaNovo = categoriaNovo;
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
