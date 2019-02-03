/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import static model.Relatorio_reserva_.nome_cliente;
import org.hibernate.annotations.Immutable;

/**
 *
 * @author Elvis Nogueira
 */
@Entity
@Immutable
public class Relatorio_locacao {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private Date data_retirada;
    private String modelo;
    private String nome;

    public Relatorio_locacao() {
    }

    
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + this.id;
        hash = 37 * hash + Objects.hashCode(this.data_retirada);
        hash = 37 * hash + Objects.hashCode(this.modelo);
        hash = 37 * hash + Objects.hashCode(this.nome);
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
        final Relatorio_locacao other = (Relatorio_locacao) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.modelo, other.modelo)) {
            return false;
        }
        if (!Objects.equals(this.data_retirada, other.data_retirada)) {
            return false;
        }
        return true;
    }

    public int getId() {
        return id;
    }

    public Date getData_retirada() {
        return data_retirada;
    }

    public String getModelo() {
        return modelo;
    }

    public String getNome() {
        return nome;
    }
    
    
}
