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
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author Elvis Nogueira
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Veiculolog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", insertable = false, updatable = false)
    private int id;
    
    private String placa;
    private String fabricante;
    private String numChassi;
    private String num_motor, modelo, tipo_combuustivel,cor;
    private float km_atual, torqe_motor;
    private int num_portas, ano_modelo, ano_fabricacao,
            num_passageiros;
    @ManyToOne
    @JoinColumn(name = "id_categoria")
    Categoria categoria;
    @ManyToOne
    @JoinColumn(name = "id_locadora")
    Locadora locadora;
    
    
    private String placaNovo;
    private String fabricanteNovo;
    private String numChassiNovo;
    private String num_motorNovo, modeloNovo, tipo_combuustivelNovo,corNovo;
    private float km_atualNovo, torqe_motorNovo;
    private int num_portasNovo, ano_modeloNovo, ano_fabricacaoNovo,
            num_passageirosNovo;
    @ManyToOne
    @JoinColumn(name = "id_categoriaNovo")
    Categoria categoriaNovo;
    @ManyToOne
    @JoinColumn(name = "id_locadoraNovo")
    Locadora locadoraNovo;

    public Veiculolog() {
        
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.id;
        hash = 97 * hash + Objects.hashCode(this.placa);
        hash = 97 * hash + Objects.hashCode(this.fabricante);
        hash = 97 * hash + Objects.hashCode(this.numChassi);
        hash = 97 * hash + Objects.hashCode(this.num_motor);
        hash = 97 * hash + Objects.hashCode(this.modelo);
        hash = 97 * hash + Objects.hashCode(this.tipo_combuustivel);
        hash = 97 * hash + Objects.hashCode(this.cor);
        hash = 97 * hash + Float.floatToIntBits(this.km_atual);
        hash = 97 * hash + Float.floatToIntBits(this.torqe_motor);
        hash = 97 * hash + this.num_portas;
        hash = 97 * hash + this.ano_modelo;
        hash = 97 * hash + this.ano_fabricacao;
        hash = 97 * hash + this.num_passageiros;
        hash = 97 * hash + Objects.hashCode(this.categoria);
        hash = 97 * hash + Objects.hashCode(this.locadora);
        hash = 97 * hash + Objects.hashCode(this.placaNovo);
        hash = 97 * hash + Objects.hashCode(this.fabricanteNovo);
        hash = 97 * hash + Objects.hashCode(this.numChassiNovo);
        hash = 97 * hash + Objects.hashCode(this.num_motorNovo);
        hash = 97 * hash + Objects.hashCode(this.modeloNovo);
        hash = 97 * hash + Objects.hashCode(this.tipo_combuustivelNovo);
        hash = 97 * hash + Objects.hashCode(this.corNovo);
        hash = 97 * hash + Float.floatToIntBits(this.km_atualNovo);
        hash = 97 * hash + Float.floatToIntBits(this.torqe_motorNovo);
        hash = 97 * hash + this.num_portasNovo;
        hash = 97 * hash + this.ano_modeloNovo;
        hash = 97 * hash + this.ano_fabricacaoNovo;
        hash = 97 * hash + this.num_passageirosNovo;
        hash = 97 * hash + Objects.hashCode(this.categoriaNovo);
        hash = 97 * hash + Objects.hashCode(this.locadoraNovo);
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
        final Veiculolog other = (Veiculolog) obj;
        if (this.id != other.id) {
            return false;
        }
        if (Float.floatToIntBits(this.km_atual) != Float.floatToIntBits(other.km_atual)) {
            return false;
        }
        if (Float.floatToIntBits(this.torqe_motor) != Float.floatToIntBits(other.torqe_motor)) {
            return false;
        }
        if (this.num_portas != other.num_portas) {
            return false;
        }
        if (this.ano_modelo != other.ano_modelo) {
            return false;
        }
        if (this.ano_fabricacao != other.ano_fabricacao) {
            return false;
        }
        if (this.num_passageiros != other.num_passageiros) {
            return false;
        }
        if (Float.floatToIntBits(this.km_atualNovo) != Float.floatToIntBits(other.km_atualNovo)) {
            return false;
        }
        if (Float.floatToIntBits(this.torqe_motorNovo) != Float.floatToIntBits(other.torqe_motorNovo)) {
            return false;
        }
        if (this.num_portasNovo != other.num_portasNovo) {
            return false;
        }
        if (this.ano_modeloNovo != other.ano_modeloNovo) {
            return false;
        }
        if (this.ano_fabricacaoNovo != other.ano_fabricacaoNovo) {
            return false;
        }
        if (this.num_passageirosNovo != other.num_passageirosNovo) {
            return false;
        }
        if (!Objects.equals(this.placa, other.placa)) {
            return false;
        }
        if (!Objects.equals(this.fabricante, other.fabricante)) {
            return false;
        }
        if (!Objects.equals(this.numChassi, other.numChassi)) {
            return false;
        }
        if (!Objects.equals(this.num_motor, other.num_motor)) {
            return false;
        }
        if (!Objects.equals(this.modelo, other.modelo)) {
            return false;
        }
        if (!Objects.equals(this.tipo_combuustivel, other.tipo_combuustivel)) {
            return false;
        }
        if (!Objects.equals(this.cor, other.cor)) {
            return false;
        }
        if (!Objects.equals(this.placaNovo, other.placaNovo)) {
            return false;
        }
        if (!Objects.equals(this.fabricanteNovo, other.fabricanteNovo)) {
            return false;
        }
        if (!Objects.equals(this.numChassiNovo, other.numChassiNovo)) {
            return false;
        }
        if (!Objects.equals(this.num_motorNovo, other.num_motorNovo)) {
            return false;
        }
        if (!Objects.equals(this.modeloNovo, other.modeloNovo)) {
            return false;
        }
        if (!Objects.equals(this.tipo_combuustivelNovo, other.tipo_combuustivelNovo)) {
            return false;
        }
        if (!Objects.equals(this.corNovo, other.corNovo)) {
            return false;
        }
        if (!Objects.equals(this.categoria, other.categoria)) {
            return false;
        }
        if (!Objects.equals(this.locadora, other.locadora)) {
            return false;
        }
        if (!Objects.equals(this.categoriaNovo, other.categoriaNovo)) {
            return false;
        }
        if (!Objects.equals(this.locadoraNovo, other.locadoraNovo)) {
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

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getNumChassi() {
        return numChassi;
    }

    public void setNumChassi(String numChassi) {
        this.numChassi = numChassi;
    }

    public String getNum_motor() {
        return num_motor;
    }

    public void setNum_motor(String num_motor) {
        this.num_motor = num_motor;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getTipo_combuustivel() {
        return tipo_combuustivel;
    }

    public void setTipo_combuustivel(String tipo_combuustivel) {
        this.tipo_combuustivel = tipo_combuustivel;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public float getKm_atual() {
        return km_atual;
    }

    public void setKm_atual(float km_atual) {
        this.km_atual = km_atual;
    }

    public float getTorqe_motor() {
        return torqe_motor;
    }

    public void setTorqe_motor(float torqe_motor) {
        this.torqe_motor = torqe_motor;
    }

    public int getNum_portas() {
        return num_portas;
    }

    public void setNum_portas(int num_portas) {
        this.num_portas = num_portas;
    }

    public int getAno_modelo() {
        return ano_modelo;
    }

    public void setAno_modelo(int ano_modelo) {
        this.ano_modelo = ano_modelo;
    }

    public int getAno_fabricacao() {
        return ano_fabricacao;
    }

    public void setAno_fabricacao(int ano_fabricacao) {
        this.ano_fabricacao = ano_fabricacao;
    }

    public int getNum_passageiros() {
        return num_passageiros;
    }

    public void setNum_passageiros(int num_passageiros) {
        this.num_passageiros = num_passageiros;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Locadora getLocadora() {
        return locadora;
    }

    public void setLocadora(Locadora locadora) {
        this.locadora = locadora;
    }

    public String getPlacaNovo() {
        return placaNovo;
    }

    public void setPlacaNovo(String placaNovo) {
        this.placaNovo = placaNovo;
    }

    public String getFabricanteNovo() {
        return fabricanteNovo;
    }

    public void setFabricanteNovo(String fabricanteNovo) {
        this.fabricanteNovo = fabricanteNovo;
    }

    public String getNumChassiNovo() {
        return numChassiNovo;
    }

    public void setNumChassiNovo(String numChassiNovo) {
        this.numChassiNovo = numChassiNovo;
    }

    public String getNum_motorNovo() {
        return num_motorNovo;
    }

    public void setNum_motorNovo(String num_motorNovo) {
        this.num_motorNovo = num_motorNovo;
    }

    public String getModeloNovo() {
        return modeloNovo;
    }

    public void setModeloNovo(String modeloNovo) {
        this.modeloNovo = modeloNovo;
    }

    public String getTipo_combuustivelNovo() {
        return tipo_combuustivelNovo;
    }

    public void setTipo_combuustivelNovo(String tipo_combuustivelNovo) {
        this.tipo_combuustivelNovo = tipo_combuustivelNovo;
    }

    public String getCorNovo() {
        return corNovo;
    }

    public void setCorNovo(String corNovo) {
        this.corNovo = corNovo;
    }

    public float getKm_atualNovo() {
        return km_atualNovo;
    }

    public void setKm_atualNovo(float km_atualNovo) {
        this.km_atualNovo = km_atualNovo;
    }

    public float getTorqe_motorNovo() {
        return torqe_motorNovo;
    }

    public void setTorqe_motorNovo(float torqe_motorNovo) {
        this.torqe_motorNovo = torqe_motorNovo;
    }

    public int getNum_portasNovo() {
        return num_portasNovo;
    }

    public void setNum_portasNovo(int num_portasNovo) {
        this.num_portasNovo = num_portasNovo;
    }

    public int getAno_modeloNovo() {
        return ano_modeloNovo;
    }

    public void setAno_modeloNovo(int ano_modeloNovo) {
        this.ano_modeloNovo = ano_modeloNovo;
    }

    public int getAno_fabricacaoNovo() {
        return ano_fabricacaoNovo;
    }

    public void setAno_fabricacaoNovo(int ano_fabricacaoNovo) {
        this.ano_fabricacaoNovo = ano_fabricacaoNovo;
    }

    public int getNum_passageirosNovo() {
        return num_passageirosNovo;
    }

    public void setNum_passageirosNovo(int num_passageirosNovo) {
        this.num_passageirosNovo = num_passageirosNovo;
    }

    public Categoria getCategoriaNovo() {
        return categoriaNovo;
    }

    public void setCategoriaNovo(Categoria categoriaNovo) {
        this.categoriaNovo = categoriaNovo;
    }

    public Locadora getLocadoraNovo() {
        return locadoraNovo;
    }

    public void setLocadoraNovo(Locadora locadoraNovo) {
        this.locadoraNovo = locadoraNovo;
    }
    
    
    
}
