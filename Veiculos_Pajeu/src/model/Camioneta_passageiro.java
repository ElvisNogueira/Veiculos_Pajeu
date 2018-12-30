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
public class Camioneta_passageiro extends Veiculo{
    @Column(nullable = false, length = 50)
    private String airbag;
    @Column(nullable = false)
    private boolean cinto_seg_traseiros_ret, controle_poluicao_ar,
            rodas_liga_leve, direcao_assistida;

    public Camioneta_passageiro() {
    }

    public Camioneta_passageiro(String airbag, boolean cinto_seg_traseiros_ret, boolean controle_poluicao_ar, boolean rodas_liga_leve, boolean direcao_assistida, String placa, String fabricante, String numChassi, String num_motor, String modelo, String tipo_combuustivel, String cor, float km_atual, float torqe_motor, int num_portas, int ano_modelo, int ano_fabricacao, int num_passageiros, Categoria categoria, Locadora locadora) {
        super(placa, fabricante, numChassi, num_motor, modelo, tipo_combuustivel, cor, km_atual, torqe_motor, num_portas, ano_modelo, ano_fabricacao, num_passageiros, categoria, locadora);
        this.airbag = airbag;
        this.cinto_seg_traseiros_ret = cinto_seg_traseiros_ret;
        this.controle_poluicao_ar = controle_poluicao_ar;
        this.rodas_liga_leve = rodas_liga_leve;
        this.direcao_assistida = direcao_assistida;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.airbag);
        hash = 67 * hash + (this.cinto_seg_traseiros_ret ? 1 : 0);
        hash = 67 * hash + (this.controle_poluicao_ar ? 1 : 0);
        hash = 67 * hash + (this.rodas_liga_leve ? 1 : 0);
        hash = 67 * hash + (this.direcao_assistida ? 1 : 0);
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
        final Camioneta_passageiro other = (Camioneta_passageiro) obj;
        if (this.cinto_seg_traseiros_ret != other.cinto_seg_traseiros_ret) {
            return false;
        }
        if (this.controle_poluicao_ar != other.controle_poluicao_ar) {
            return false;
        }
        if (this.rodas_liga_leve != other.rodas_liga_leve) {
            return false;
        }
        if (this.direcao_assistida != other.direcao_assistida) {
            return false;
        }
        if (!Objects.equals(this.airbag, other.airbag)) {
            return false;
        }
        return true;
    }
    
    
    

    public String getAirbag() {
        return airbag;
    }

    public void setAirbag(String airbag) {
        this.airbag = airbag;
    }

    public boolean isCinto_seg_traseiros_ret() {
        return cinto_seg_traseiros_ret;
    }

    public void setCinto_seg_traseiros_ret(boolean cinto_seg_traseiros_ret) {
        this.cinto_seg_traseiros_ret = cinto_seg_traseiros_ret;
    }

    public boolean isControle_poluicao_ar() {
        return controle_poluicao_ar;
    }

    public void setControle_poluicao_ar(boolean controle_poluicao_ar) {
        this.controle_poluicao_ar = controle_poluicao_ar;
    }

    public boolean isRodas_liga_leve() {
        return rodas_liga_leve;
    }

    public void setRodas_liga_leve(boolean rodas_liga_leve) {
        this.rodas_liga_leve = rodas_liga_leve;
    }

    public boolean isDirecao_assistida() {
        return direcao_assistida;
    }

    public void setDirecao_assistida(boolean direcao_assistida) {
        this.direcao_assistida = direcao_assistida;
    }

    @Override
    public String toString() {
        return super.toString()+"\nCamioneta_passageiro{" + "airbag=" + airbag + ", cinto_seg_traseiros_ret=" + cinto_seg_traseiros_ret + ",\n"
                + " controle_poluicao_ar=" + controle_poluicao_ar + ", rodas_liga_leve=" + rodas_liga_leve + ", \n"
                + "direcao_assistida=" + direcao_assistida + '}';
    }
    
    
    
}
