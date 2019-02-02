/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

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
public class Categoria {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private int id;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private float valor_aluguel_controle, valor_aluguel_livre;
    private int num_horas_limpeza, num_horas_revisao;
    @Column(nullable = false)
    private boolean ar_condicionado, dvd, camara_re,mp3,
            direcao_hidraulica;
    @Column(nullable = false)
    private String tipo_comboio, tamanho;
    @Column(nullable = false)
    private boolean status;

    public Categoria() {
        status = true;
    }

    public Categoria(String nome, float valor_aluguel_controle, float valor_aluguel_livre, int num_horas_limpeza, int num_horas_revisao, boolean ar_condicionado, boolean dvd, boolean camara_re, boolean mp3, boolean direcao_hidraulica, String tipo_comboio, String tamanho) {
        this.nome = nome;
        this.valor_aluguel_controle = valor_aluguel_controle;
        this.valor_aluguel_livre = valor_aluguel_livre;
        this.num_horas_limpeza = num_horas_limpeza;
        this.num_horas_revisao = num_horas_revisao;
        this.ar_condicionado = ar_condicionado;
        this.dvd = dvd;
        this.camara_re = camara_re;
        this.mp3 = mp3;
        this.direcao_hidraulica = direcao_hidraulica;
        this.tipo_comboio = tipo_comboio;
        this.tamanho = tamanho;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + this.id;
        hash = 37 * hash + Objects.hashCode(this.nome);
        hash = 37 * hash + Float.floatToIntBits(this.valor_aluguel_controle);
        hash = 37 * hash + Float.floatToIntBits(this.valor_aluguel_livre);
        hash = 37 * hash + this.num_horas_limpeza;
        hash = 37 * hash + this.num_horas_revisao;
        hash = 37 * hash + (this.ar_condicionado ? 1 : 0);
        hash = 37 * hash + (this.dvd ? 1 : 0);
        hash = 37 * hash + (this.camara_re ? 1 : 0);
        hash = 37 * hash + (this.mp3 ? 1 : 0);
        hash = 37 * hash + (this.direcao_hidraulica ? 1 : 0);
        hash = 37 * hash + Objects.hashCode(this.tipo_comboio);
        hash = 37 * hash + Objects.hashCode(this.tamanho);
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
        final Categoria other = (Categoria) obj;
        if (this.id != other.id) {
            return false;
        }
        if (Float.floatToIntBits(this.valor_aluguel_controle) != Float.floatToIntBits(other.valor_aluguel_controle)) {
            return false;
        }
        if (Float.floatToIntBits(this.valor_aluguel_livre) != Float.floatToIntBits(other.valor_aluguel_livre)) {
            return false;
        }
        if (this.num_horas_limpeza != other.num_horas_limpeza) {
            return false;
        }
        if (this.num_horas_revisao != other.num_horas_revisao) {
            return false;
        }
        if (this.ar_condicionado != other.ar_condicionado) {
            return false;
        }
        if (this.dvd != other.dvd) {
            return false;
        }
        if (this.camara_re != other.camara_re) {
            return false;
        }
        if (this.mp3 != other.mp3) {
            return false;
        }
        if (this.direcao_hidraulica != other.direcao_hidraulica) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.tipo_comboio, other.tipo_comboio)) {
            return false;
        }
        if (!Objects.equals(this.tamanho, other.tamanho)) {
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

    public boolean isAr_condicionado() {
        return ar_condicionado;
    }

    public void setAr_condicionado(boolean ar_condicionado) {
        this.ar_condicionado = ar_condicionado;
    }

    public boolean isDvd() {
        return dvd;
    }

    public void setDvd(boolean dvd) {
        this.dvd = dvd;
    }

    public boolean isCamara_re() {
        return camara_re;
    }

    public void setCamara_re(boolean camara_re) {
        this.camara_re = camara_re;
    }

    public boolean isMp3() {
        return mp3;
    }

    public void setMp3(boolean mp3) {
        this.mp3 = mp3;
    }

    public boolean isDirecao_hidraulica() {
        return direcao_hidraulica;
    }

    public void setDirecao_hidraulica(boolean direcao_hidraulica) {
        this.direcao_hidraulica = direcao_hidraulica;
    }

    public String getTipo_comboio() {
        return tipo_comboio;
    }

    public void setTipo_comboio(String tipo_comboio) {
        this.tipo_comboio = tipo_comboio;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getValor_aluguel_controle() {
        return valor_aluguel_controle;
    }

    public void setValor_aluguel_controle(float valor_aluguel_controle) {
        this.valor_aluguel_controle = valor_aluguel_controle;
    }

    public float getValor_aluguel_livre() {
        return valor_aluguel_livre;
    }

    public void setValor_aluguel_livre(float valor_aluguel_livre) {
        this.valor_aluguel_livre = valor_aluguel_livre;
    }

    public int getNum_horas_limpeza() {
        return num_horas_limpeza;
    }

    public void setNum_horas_limpeza(int num_horas_limpeza) {
        this.num_horas_limpeza = num_horas_limpeza;
    }

    public int getNum_horas_revisao() {
        return num_horas_revisao;
    }

    public void setNum_horas_revisao(int num_horas_revisao) {
        this.num_horas_revisao = num_horas_revisao;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
    

    @Override
    public String toString() {
        return getNome();
    }
    
    
    
}
