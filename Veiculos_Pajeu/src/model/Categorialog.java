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
public class Categorialog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", insertable = false, updatable = false)
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
    private String nomeNovo;
    @Column(nullable = false)
    private float valor_aluguel_controleNovo, valor_aluguel_livreNovo;
    private int num_horas_limpezaNovo, num_horas_revisaoNovo;
    @Column(nullable = false)
    private boolean ar_condicionadoNovo, dvdNovo, camara_reNovo,mp3Novo,
            direcao_hidraulicaNovo;
    @Column(nullable = false)
    private String tipo_comboioNovo, tamanhoNovo;
    
    private Date data_de_modificacao ;
    private String operacao_realizada;
    
    public Categorialog() {
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + this.id;
        hash = 23 * hash + Objects.hashCode(this.nome);
        hash = 23 * hash + Float.floatToIntBits(this.valor_aluguel_controle);
        hash = 23 * hash + Float.floatToIntBits(this.valor_aluguel_livre);
        hash = 23 * hash + this.num_horas_limpeza;
        hash = 23 * hash + this.num_horas_revisao;
        hash = 23 * hash + (this.ar_condicionado ? 1 : 0);
        hash = 23 * hash + (this.dvd ? 1 : 0);
        hash = 23 * hash + (this.camara_re ? 1 : 0);
        hash = 23 * hash + (this.mp3 ? 1 : 0);
        hash = 23 * hash + (this.direcao_hidraulica ? 1 : 0);
        hash = 23 * hash + Objects.hashCode(this.tipo_comboio);
        hash = 23 * hash + Objects.hashCode(this.tamanho);
        hash = 23 * hash + Objects.hashCode(this.nomeNovo);
        hash = 23 * hash + Float.floatToIntBits(this.valor_aluguel_controleNovo);
        hash = 23 * hash + Float.floatToIntBits(this.valor_aluguel_livreNovo);
        hash = 23 * hash + this.num_horas_limpezaNovo;
        hash = 23 * hash + this.num_horas_revisaoNovo;
        hash = 23 * hash + (this.ar_condicionadoNovo ? 1 : 0);
        hash = 23 * hash + (this.dvdNovo ? 1 : 0);
        hash = 23 * hash + (this.camara_reNovo ? 1 : 0);
        hash = 23 * hash + (this.mp3Novo ? 1 : 0);
        hash = 23 * hash + (this.direcao_hidraulicaNovo ? 1 : 0);
        hash = 23 * hash + Objects.hashCode(this.tipo_comboioNovo);
        hash = 23 * hash + Objects.hashCode(this.tamanhoNovo);
        hash = 23 * hash + Objects.hashCode(this.data_de_modificacao);
        hash = 23 * hash + Objects.hashCode(this.operacao_realizada);
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
        final Categorialog other = (Categorialog) obj;
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
        if (Float.floatToIntBits(this.valor_aluguel_controleNovo) != Float.floatToIntBits(other.valor_aluguel_controleNovo)) {
            return false;
        }
        if (Float.floatToIntBits(this.valor_aluguel_livreNovo) != Float.floatToIntBits(other.valor_aluguel_livreNovo)) {
            return false;
        }
        if (this.num_horas_limpezaNovo != other.num_horas_limpezaNovo) {
            return false;
        }
        if (this.num_horas_revisaoNovo != other.num_horas_revisaoNovo) {
            return false;
        }
        if (this.ar_condicionadoNovo != other.ar_condicionadoNovo) {
            return false;
        }
        if (this.dvdNovo != other.dvdNovo) {
            return false;
        }
        if (this.camara_reNovo != other.camara_reNovo) {
            return false;
        }
        if (this.mp3Novo != other.mp3Novo) {
            return false;
        }
        if (this.direcao_hidraulicaNovo != other.direcao_hidraulicaNovo) {
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
        if (!Objects.equals(this.nomeNovo, other.nomeNovo)) {
            return false;
        }
        if (!Objects.equals(this.tipo_comboioNovo, other.tipo_comboioNovo)) {
            return false;
        }
        if (!Objects.equals(this.tamanhoNovo, other.tamanhoNovo)) {
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

    public String getNomeNovo() {
        return nomeNovo;
    }

    public void setNomeNovo(String nomeNovo) {
        this.nomeNovo = nomeNovo;
    }

    public float getValor_aluguel_controleNovo() {
        return valor_aluguel_controleNovo;
    }

    public void setValor_aluguel_controleNovo(float valor_aluguel_controleNovo) {
        this.valor_aluguel_controleNovo = valor_aluguel_controleNovo;
    }

    public float getValor_aluguel_livreNovo() {
        return valor_aluguel_livreNovo;
    }

    public void setValor_aluguel_livreNovo(float valor_aluguel_livreNovo) {
        this.valor_aluguel_livreNovo = valor_aluguel_livreNovo;
    }

    public int getNum_horas_limpezaNovo() {
        return num_horas_limpezaNovo;
    }

    public void setNum_horas_limpezaNovo(int num_horas_limpezaNovo) {
        this.num_horas_limpezaNovo = num_horas_limpezaNovo;
    }

    public int getNum_horas_revisaoNovo() {
        return num_horas_revisaoNovo;
    }

    public void setNum_horas_revisaoNovo(int num_horas_revisaoNovo) {
        this.num_horas_revisaoNovo = num_horas_revisaoNovo;
    }

    public boolean isAr_condicionadoNovo() {
        return ar_condicionadoNovo;
    }

    public void setAr_condicionadoNovo(boolean ar_condicionadoNovo) {
        this.ar_condicionadoNovo = ar_condicionadoNovo;
    }

    public boolean isDvdNovo() {
        return dvdNovo;
    }

    public void setDvdNovo(boolean dvdNovo) {
        this.dvdNovo = dvdNovo;
    }

    public boolean isCamara_reNovo() {
        return camara_reNovo;
    }

    public void setCamara_reNovo(boolean camara_reNovo) {
        this.camara_reNovo = camara_reNovo;
    }

    public boolean isMp3Novo() {
        return mp3Novo;
    }

    public void setMp3Novo(boolean mp3Novo) {
        this.mp3Novo = mp3Novo;
    }

    public boolean isDirecao_hidraulicaNovo() {
        return direcao_hidraulicaNovo;
    }

    public void setDirecao_hidraulicaNovo(boolean direcao_hidraulicaNovo) {
        this.direcao_hidraulicaNovo = direcao_hidraulicaNovo;
    }

    public String getTipo_comboioNovo() {
        return tipo_comboioNovo;
    }

    public void setTipo_comboioNovo(String tipo_comboioNovo) {
        this.tipo_comboioNovo = tipo_comboioNovo;
    }

    public String getTamanhoNovo() {
        return tamanhoNovo;
    }

    public void setTamanhoNovo(String tamanhoNovo) {
        this.tamanhoNovo = tamanhoNovo;
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
