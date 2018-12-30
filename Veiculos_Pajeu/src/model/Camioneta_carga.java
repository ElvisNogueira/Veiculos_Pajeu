/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

/**
 *
 * @author Elvis Nogueira
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Camioneta_carga extends Veiculo{
    @Column(nullable = false, length = 30)
    private String acionamento_embreagem;
    @Column(nullable = false)
    private int potencia_motor;
    @Column(nullable = false)
    private float desempenho, capacidade_carga, 
            distancia_eixos, capaccidade_tanque;

    public Camioneta_carga() {
    }

    public Camioneta_carga(String acionamento_embreagem, int potencia_motor, float desempenho, float capacidade_carga, 
            float distancia_eixos, float capaccidade_tanque, String placa, String fabricante, String numChassi, 
            String num_motor, String modelo, String tipo_combuustivel, String cor, float km_atual, float torqe_motor, 
            int num_portas, int ano_modelo, int ano_fabricacao, int num_passageiros, Categoria categoria, Locadora locadora) {
        super(placa, fabricante, numChassi, num_motor, modelo, tipo_combuustivel, cor, km_atual, torqe_motor, num_portas, 
                ano_modelo, ano_fabricacao, num_passageiros, categoria, locadora);
        this.acionamento_embreagem = acionamento_embreagem;
        this.potencia_motor = potencia_motor;
        this.desempenho = desempenho;
        this.capacidade_carga = capacidade_carga;
        this.distancia_eixos = distancia_eixos;
        this.capaccidade_tanque = capaccidade_tanque;
    } 

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.acionamento_embreagem);
        hash = 37 * hash + this.potencia_motor;
        hash = 37 * hash + Float.floatToIntBits(this.desempenho);
        hash = 37 * hash + Float.floatToIntBits(this.capacidade_carga);
        hash = 37 * hash + Float.floatToIntBits(this.distancia_eixos);
        hash = 37 * hash + Float.floatToIntBits(this.capaccidade_tanque);
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
        final Camioneta_carga other = (Camioneta_carga) obj;
        if (this.potencia_motor != other.potencia_motor) {
            return false;
        }
        if (Float.floatToIntBits(this.desempenho) != Float.floatToIntBits(other.desempenho)) {
            return false;
        }
        if (Float.floatToIntBits(this.capacidade_carga) != Float.floatToIntBits(other.capacidade_carga)) {
            return false;
        }
        if (Float.floatToIntBits(this.distancia_eixos) != Float.floatToIntBits(other.distancia_eixos)) {
            return false;
        }
        if (Float.floatToIntBits(this.capaccidade_tanque) != Float.floatToIntBits(other.capaccidade_tanque)) {
            return false;
        }
        if (!Objects.equals(this.acionamento_embreagem, other.acionamento_embreagem)) {
            return false;
        }
        return true;
    }
    
    
    

    public String getAcionamento_embreagem() {
        return acionamento_embreagem;
    }

    public void setAcionamento_embreagem(String acionamento_embreagem) {
        this.acionamento_embreagem = acionamento_embreagem;
    }

    public int getPotencia_motor() {
        return potencia_motor;
    }

    public void setPotencia_motor(int potencia_motor) {
        this.potencia_motor = potencia_motor;
    }

    public float getDesempenho() {
        return desempenho;
    }

    public void setDesempenho(float desempenho) {
        this.desempenho = desempenho;
    }

    public float getCapacidade_carga() {
        return capacidade_carga;
    }

    public void setCapacidade_carga(float capacidade_carga) {
        this.capacidade_carga = capacidade_carga;
    }

    public float getDistancia_eixos() {
        return distancia_eixos;
    }

    public void setDistancia_eixos(float distancia_eixos) {
        this.distancia_eixos = distancia_eixos;
    }

    public float getCapaccidade_tanque() {
        return capaccidade_tanque;
    }

    public void setCapaccidade_tanque(float capaccidade_tanque) {
        this.capaccidade_tanque = capaccidade_tanque;
    }

    @Override
    public String toString() {
        return super.toString()+"\nCamioneta_carga{" + "acionamento_embreagem=" + acionamento_embreagem + ", \n"
                + "potencia_motor=" + potencia_motor + ", desempenho=" + desempenho + ", \n"
                + "capacidade_carga=" + capacidade_carga + ", distancia_eixos=" + distancia_eixos + ", \n"
                + "capaccidade_tanque=" + capaccidade_tanque + '}';
    }

    
    

   
    
    
    
}
