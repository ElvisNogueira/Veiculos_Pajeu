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
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

/**
 *
 * @author Elvis Nogueira
 */
@Entity
public class Camioneta_cargalog{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", insertable = false, updatable = false)
    private int id;
    
    @Column(nullable = false, length = 30)
    private String acionamento_embreagemAntigo;
    
    @Column(nullable = false)
    private int potencia_motorAntigo;
    @Column(nullable = false)
    private float desempenhoAntigo, capacidade_cargaAntigo, 
            distancia_eixosAntigo, capaccidade_tanqueAntigo;
    
    private String acionamento_embreagemNovo;
    
    @Column(nullable = false)
    private int potencia_motorNovo;
    @Column(nullable = false)
    private float desempenhoNovo, capacidade_cargaNovo, 
            distancia_eixosNovo, capaccidade_tanqueNovo;
    
    private Date data_de_modificacao ;
    private String operacao_realizada;

    public Camioneta_cargalog() {
        
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + this.id;
        hash = 83 * hash + Objects.hashCode(this.acionamento_embreagemAntigo);
        hash = 83 * hash + this.potencia_motorAntigo;
        hash = 83 * hash + Float.floatToIntBits(this.desempenhoAntigo);
        hash = 83 * hash + Float.floatToIntBits(this.capacidade_cargaAntigo);
        hash = 83 * hash + Float.floatToIntBits(this.distancia_eixosAntigo);
        hash = 83 * hash + Float.floatToIntBits(this.capaccidade_tanqueAntigo);
        hash = 83 * hash + Objects.hashCode(this.acionamento_embreagemNovo);
        hash = 83 * hash + this.potencia_motorNovo;
        hash = 83 * hash + Float.floatToIntBits(this.desempenhoNovo);
        hash = 83 * hash + Float.floatToIntBits(this.capacidade_cargaNovo);
        hash = 83 * hash + Float.floatToIntBits(this.distancia_eixosNovo);
        hash = 83 * hash + Float.floatToIntBits(this.capaccidade_tanqueNovo);
        hash = 83 * hash + Objects.hashCode(this.data_de_modificacao);
        hash = 83 * hash + Objects.hashCode(this.operacao_realizada);
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
        final Camioneta_cargalog other = (Camioneta_cargalog) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.potencia_motorAntigo != other.potencia_motorAntigo) {
            return false;
        }
        if (Float.floatToIntBits(this.desempenhoAntigo) != Float.floatToIntBits(other.desempenhoAntigo)) {
            return false;
        }
        if (Float.floatToIntBits(this.capacidade_cargaAntigo) != Float.floatToIntBits(other.capacidade_cargaAntigo)) {
            return false;
        }
        if (Float.floatToIntBits(this.distancia_eixosAntigo) != Float.floatToIntBits(other.distancia_eixosAntigo)) {
            return false;
        }
        if (Float.floatToIntBits(this.capaccidade_tanqueAntigo) != Float.floatToIntBits(other.capaccidade_tanqueAntigo)) {
            return false;
        }
        if (this.potencia_motorNovo != other.potencia_motorNovo) {
            return false;
        }
        if (Float.floatToIntBits(this.desempenhoNovo) != Float.floatToIntBits(other.desempenhoNovo)) {
            return false;
        }
        if (Float.floatToIntBits(this.capacidade_cargaNovo) != Float.floatToIntBits(other.capacidade_cargaNovo)) {
            return false;
        }
        if (Float.floatToIntBits(this.distancia_eixosNovo) != Float.floatToIntBits(other.distancia_eixosNovo)) {
            return false;
        }
        if (Float.floatToIntBits(this.capaccidade_tanqueNovo) != Float.floatToIntBits(other.capaccidade_tanqueNovo)) {
            return false;
        }
        if (!Objects.equals(this.acionamento_embreagemAntigo, other.acionamento_embreagemAntigo)) {
            return false;
        }
        if (!Objects.equals(this.acionamento_embreagemNovo, other.acionamento_embreagemNovo)) {
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

    
    public String getAcionamento_embreagemAntigo() {
        return acionamento_embreagemAntigo;
    }

    public void setAcionamento_embreagemAntigo(String acionamento_embreagemAntigo) {
        this.acionamento_embreagemAntigo = acionamento_embreagemAntigo;
    }

    public int getPotencia_motorAntigo() {
        return potencia_motorAntigo;
    }

    public void setPotencia_motorAntigo(int potencia_motorAntigo) {
        this.potencia_motorAntigo = potencia_motorAntigo;
    }

    public float getDesempenhoAntigo() {
        return desempenhoAntigo;
    }

    public void setDesempenhoAntigo(float desempenhoAntigo) {
        this.desempenhoAntigo = desempenhoAntigo;
    }

    public float getCapacidade_cargaAntigo() {
        return capacidade_cargaAntigo;
    }

    public void setCapacidade_cargaAntigo(float capacidade_cargaAntigo) {
        this.capacidade_cargaAntigo = capacidade_cargaAntigo;
    }

    public float getDistancia_eixosAntigo() {
        return distancia_eixosAntigo;
    }

    public void setDistancia_eixosAntigo(float distancia_eixosAntigo) {
        this.distancia_eixosAntigo = distancia_eixosAntigo;
    }

    public float getCapaccidade_tanqueAntigo() {
        return capaccidade_tanqueAntigo;
    }

    public void setCapaccidade_tanqueAntigo(float capaccidade_tanqueAntigo) {
        this.capaccidade_tanqueAntigo = capaccidade_tanqueAntigo;
    }

    public String getAcionamento_embreagemNovo() {
        return acionamento_embreagemNovo;
    }

    public void setAcionamento_embreagemNovo(String acionamento_embreagemNovo) {
        this.acionamento_embreagemNovo = acionamento_embreagemNovo;
    }

    public int getPotencia_motorNovo() {
        return potencia_motorNovo;
    }

    public void setPotencia_motorNovo(int potencia_motorNovo) {
        this.potencia_motorNovo = potencia_motorNovo;
    }

    public float getDesempenhoNovo() {
        return desempenhoNovo;
    }

    public void setDesempenhoNovo(float desempenhoNovo) {
        this.desempenhoNovo = desempenhoNovo;
    }

    public float getCapacidade_cargaNovo() {
        return capacidade_cargaNovo;
    }

    public void setCapacidade_cargaNovo(float capacidade_cargaNovo) {
        this.capacidade_cargaNovo = capacidade_cargaNovo;
    }

    public float getDistancia_eixosNovo() {
        return distancia_eixosNovo;
    }

    public void setDistancia_eixosNovo(float distancia_eixosNovo) {
        this.distancia_eixosNovo = distancia_eixosNovo;
    }

    public float getCapaccidade_tanqueNovo() {
        return capaccidade_tanqueNovo;
    }

    public void setCapaccidade_tanqueNovo(float capaccidade_tanqueNovo) {
        this.capaccidade_tanqueNovo = capaccidade_tanqueNovo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
