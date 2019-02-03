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
public class Relatorio_financeiro {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private Date data;
    private String tipo_conta;

    public Relatorio_financeiro() {
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + this.id;
        hash = 79 * hash + Objects.hashCode(this.data);
        hash = 79 * hash + Objects.hashCode(this.tipo_conta);
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
        final Relatorio_financeiro other = (Relatorio_financeiro) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.tipo_conta, other.tipo_conta)) {
            return false;
        }
        if (!Objects.equals(this.data, other.data)) {
            return false;
        }
        return true;
    }

    public int getId() {
        return id;
    }

    public Date getData() {
        return data;
    }

    public String getTipo_conta() {
        return tipo_conta;
    }
    
    
}
