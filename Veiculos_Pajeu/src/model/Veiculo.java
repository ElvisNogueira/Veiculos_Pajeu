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
public class Veiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(nullable = false, length = 7)
    private String placa;
    @Column(nullable = false, length = 50)
    private String fabricante;
    @Column(nullable = false, length = 17)
    private String numChassi;
    @Column(nullable = false, length = 20)
    private String num_motor, modelo, tipo_combuustivel,cor;
    @Column(nullable = false)
    private float km_atual, torqe_motor;
    @Column(nullable = false)
    private int num_portas, ano_modelo, ano_fabricacao,
            num_passageiros;
    @ManyToOne
    @JoinColumn(name = "id_categoria")
    Categoria categoria;
    @ManyToOne
    @JoinColumn(name = "id_locadora")
    Locadora locadora;
    private boolean status;

    public Veiculo() {
        status = true;
    }

    public Veiculo(String placa, String fabricante, String numChassi, String num_motor, String modelo, String tipo_combuustivel, String cor, float km_atual, float torqe_motor, int num_portas, int ano_modelo, int ano_fabricacao, int num_passageiros, Categoria categoria, Locadora locadora) {
        this.placa = placa;
        this.fabricante = fabricante;
        this.numChassi = numChassi;
        this.num_motor = num_motor;
        this.modelo = modelo;
        this.tipo_combuustivel = tipo_combuustivel;
        this.cor = cor;
        this.km_atual = km_atual;
        this.torqe_motor = torqe_motor;
        this.num_portas = num_portas;
        this.ano_modelo = ano_modelo;
        this.ano_fabricacao = ano_fabricacao;
        this.num_passageiros = num_passageiros;
        this.categoria = categoria;
        this.locadora = locadora;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + this.id;
        hash = 37 * hash + Objects.hashCode(this.placa);
        hash = 37 * hash + Objects.hashCode(this.fabricante);
        hash = 37 * hash + Objects.hashCode(this.numChassi);
        hash = 37 * hash + Objects.hashCode(this.num_motor);
        hash = 37 * hash + Objects.hashCode(this.modelo);
        hash = 37 * hash + Objects.hashCode(this.tipo_combuustivel);
        hash = 37 * hash + Objects.hashCode(this.cor);
        hash = 37 * hash + Float.floatToIntBits(this.km_atual);
        hash = 37 * hash + Float.floatToIntBits(this.torqe_motor);
        hash = 37 * hash + this.num_portas;
        hash = 37 * hash + this.ano_modelo;
        hash = 37 * hash + this.ano_fabricacao;
        hash = 37 * hash + this.num_passageiros;
        hash = 37 * hash + Objects.hashCode(this.categoria);
        hash = 37 * hash + Objects.hashCode(this.locadora);
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
        final Veiculo other = (Veiculo) obj;
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
        if (!Objects.equals(this.categoria, other.categoria)) {
            return false;
        }
        if (!Objects.equals(this.locadora, other.locadora)) {
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

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
    @Override
    public String toString() {
        return "Veiculo{" + "id=" + id + ", placa=" + placa + ", fabricante=" + fabricante + ", \n"
                + "numChassi=" + numChassi + ", num_motor=" + num_motor + ", modelo=" + modelo + ", \n"
                + "tipo_combuustivel=" + tipo_combuustivel + ", cor=" + cor + ", \n"
                + "km_atual=" + km_atual + ", torqe_motor=" + torqe_motor + ", \n"
                + "num_portas=" + num_portas + ", ano_modelo=" + ano_modelo + ", \n"
                + "ano_fabricacao=" + ano_fabricacao + ", num_passageiros=" + num_passageiros + ", \n"
                + "categoria=" + categoria + ", locadora=" + locadora + '}';
    }
    
    
    
}
