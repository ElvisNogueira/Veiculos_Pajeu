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
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(nullable = false, length = 25)
    private String tipo_locacao;
    @Column(nullable = false)
    private int duracao_estimada;//Em dias
    @Column(nullable = false)
    private Date data_retirada;
    private Time hora_retirada;
    @Column(nullable = false)
    private float valor_entrada;
    @ManyToOne
    @JoinColumn(name = "id_categoria")
    private Categoria categoria;

    public Reserva() {
    }

    public Reserva(String tipo_locacao, int duracao_estimada, Date data_retirada, Time hora_retirada, float valor_entrada, 
            Categoria categoria) {
        this.tipo_locacao = tipo_locacao;
        this.duracao_estimada = duracao_estimada;
        this.data_retirada = data_retirada;
        this.hora_retirada = hora_retirada;
        this.valor_entrada = valor_entrada;
        this.categoria = categoria;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + this.id;
        hash = 67 * hash + Objects.hashCode(this.tipo_locacao);
        hash = 67 * hash + this.duracao_estimada;
        hash = 67 * hash + Objects.hashCode(this.data_retirada);
        hash = 67 * hash + Objects.hashCode(this.hora_retirada);
        hash = 67 * hash + Float.floatToIntBits(this.valor_entrada);
        hash = 67 * hash + Objects.hashCode(this.categoria);
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
        final Reserva other = (Reserva) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.duracao_estimada != other.duracao_estimada) {
            return false;
        }
        if (Float.floatToIntBits(this.valor_entrada) != Float.floatToIntBits(other.valor_entrada)) {
            return false;
        }
        if (!Objects.equals(this.tipo_locacao, other.tipo_locacao)) {
            return false;
        }
        if (!Objects.equals(this.data_retirada, other.data_retirada)) {
            return false;
        }
        if (!Objects.equals(this.hora_retirada, other.hora_retirada)) {
            return false;
        }
        if (!Objects.equals(this.categoria, other.categoria)) {
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

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "Reserva{" + "id=" + id + ", tipo_locacao=" + tipo_locacao + ", duracao_estimada=" + duracao_estimada + ",\n "
                + "data_retirada=" + data_retirada + ", hora_retirada=" + hora_retirada + ", "
                + "valor_entrada=" + valor_entrada + ",\n categoria=" + categoria + '}';
    }
    
    
    
}
