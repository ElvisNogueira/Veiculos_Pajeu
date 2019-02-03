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
import org.hibernate.annotations.Immutable;

/**
 *
 * @author Elvis Nogueira
 */
@Entity
@Immutable
public class Relatorio_reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private Date data_retirada;
    private String nome;
    private String nome_cliente;

    public Relatorio_reserva() {
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + this.id;
        hash = 17 * hash + Objects.hashCode(this.data_retirada);
        hash = 17 * hash + Objects.hashCode(this.nome);
        hash = 17 * hash + Objects.hashCode(this.nome_cliente);
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
        final Relatorio_reserva other = (Relatorio_reserva) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.nome_cliente, other.nome_cliente)) {
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

    public String getNome() {
        return nome;
    }

    public String getNome_cliente() {
        return nome_cliente;
    }
    
    
}
