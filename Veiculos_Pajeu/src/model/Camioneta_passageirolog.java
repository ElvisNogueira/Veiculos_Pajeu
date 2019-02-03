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
public class Camioneta_passageirolog{
    
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private int id;
    
    @Column(nullable = false, length = 50)
    private String airbagAntigo;
    @Column(nullable = false)
    private boolean cinto_seg_traseiros_retAntigo, controle_poluicao_arAntigo,
            rodas_liga_leveAntigo, direcao_assistidaAntigo;
    private String airbagNovo;
    @Column(nullable = false)
    private boolean cinto_seg_traseiros_retNovo, controle_poluicao_arNovo,
            rodas_liga_leveNovo, direcao_assistidaNovo;
    
    
    private Date data_de_modificacao ;
    private String operacao_realizada;
    
    public Camioneta_passageirolog() {
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + this.id;
        hash = 19 * hash + Objects.hashCode(this.airbagAntigo);
        hash = 19 * hash + (this.cinto_seg_traseiros_retAntigo ? 1 : 0);
        hash = 19 * hash + (this.controle_poluicao_arAntigo ? 1 : 0);
        hash = 19 * hash + (this.rodas_liga_leveAntigo ? 1 : 0);
        hash = 19 * hash + (this.direcao_assistidaAntigo ? 1 : 0);
        hash = 19 * hash + Objects.hashCode(this.airbagNovo);
        hash = 19 * hash + (this.cinto_seg_traseiros_retNovo ? 1 : 0);
        hash = 19 * hash + (this.controle_poluicao_arNovo ? 1 : 0);
        hash = 19 * hash + (this.rodas_liga_leveNovo ? 1 : 0);
        hash = 19 * hash + (this.direcao_assistidaNovo ? 1 : 0);
        hash = 19 * hash + Objects.hashCode(this.data_de_modificacao);
        hash = 19 * hash + Objects.hashCode(this.operacao_realizada);
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
        final Camioneta_passageirolog other = (Camioneta_passageirolog) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.cinto_seg_traseiros_retAntigo != other.cinto_seg_traseiros_retAntigo) {
            return false;
        }
        if (this.controle_poluicao_arAntigo != other.controle_poluicao_arAntigo) {
            return false;
        }
        if (this.rodas_liga_leveAntigo != other.rodas_liga_leveAntigo) {
            return false;
        }
        if (this.direcao_assistidaAntigo != other.direcao_assistidaAntigo) {
            return false;
        }
        if (this.cinto_seg_traseiros_retNovo != other.cinto_seg_traseiros_retNovo) {
            return false;
        }
        if (this.controle_poluicao_arNovo != other.controle_poluicao_arNovo) {
            return false;
        }
        if (this.rodas_liga_leveNovo != other.rodas_liga_leveNovo) {
            return false;
        }
        if (this.direcao_assistidaNovo != other.direcao_assistidaNovo) {
            return false;
        }
        if (!Objects.equals(this.airbagAntigo, other.airbagAntigo)) {
            return false;
        }
        if (!Objects.equals(this.airbagNovo, other.airbagNovo)) {
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

    public String getAirbagAntigo() {
        return airbagAntigo;
    }

    public void setAirbagAntigo(String airbagAntigo) {
        this.airbagAntigo = airbagAntigo;
    }

    public boolean isCinto_seg_traseiros_retAntigo() {
        return cinto_seg_traseiros_retAntigo;
    }

    public void setCinto_seg_traseiros_retAntigo(boolean cinto_seg_traseiros_retAntigo) {
        this.cinto_seg_traseiros_retAntigo = cinto_seg_traseiros_retAntigo;
    }

    public boolean isControle_poluicao_arAntigo() {
        return controle_poluicao_arAntigo;
    }

    public void setControle_poluicao_arAntigo(boolean controle_poluicao_arAntigo) {
        this.controle_poluicao_arAntigo = controle_poluicao_arAntigo;
    }

    public boolean isRodas_liga_leveAntigo() {
        return rodas_liga_leveAntigo;
    }

    public void setRodas_liga_leveAntigo(boolean rodas_liga_leveAntigo) {
        this.rodas_liga_leveAntigo = rodas_liga_leveAntigo;
    }

    public boolean isDirecao_assistidaAntigo() {
        return direcao_assistidaAntigo;
    }

    public void setDirecao_assistidaAntigo(boolean direcao_assistidaAntigo) {
        this.direcao_assistidaAntigo = direcao_assistidaAntigo;
    }

    public String getAirbagNovo() {
        return airbagNovo;
    }

    public void setAirbagNovo(String airbagNovo) {
        this.airbagNovo = airbagNovo;
    }

    public boolean isCinto_seg_traseiros_retNovo() {
        return cinto_seg_traseiros_retNovo;
    }

    public void setCinto_seg_traseiros_retNovo(boolean cinto_seg_traseiros_retNovo) {
        this.cinto_seg_traseiros_retNovo = cinto_seg_traseiros_retNovo;
    }

    public boolean isControle_poluicao_arNovo() {
        return controle_poluicao_arNovo;
    }

    public void setControle_poluicao_arNovo(boolean controle_poluicao_arNovo) {
        this.controle_poluicao_arNovo = controle_poluicao_arNovo;
    }

    public boolean isRodas_liga_leveNovo() {
        return rodas_liga_leveNovo;
    }

    public void setRodas_liga_leveNovo(boolean rodas_liga_leveNovo) {
        this.rodas_liga_leveNovo = rodas_liga_leveNovo;
    }

    public boolean isDirecao_assistidaNovo() {
        return direcao_assistidaNovo;
    }

    public void setDirecao_assistidaNovo(boolean direcao_assistidaNovo) {
        this.direcao_assistidaNovo = direcao_assistidaNovo;
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
