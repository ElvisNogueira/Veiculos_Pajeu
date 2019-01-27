/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;
import java.sql.Time;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 *
 * @author Elvis Nogueira
 */
//@Entity
public class Configuracoes {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id; 
    private Time horaBackup;
    @OneToOne
    @JoinColumn(name = "id_locadora")
    private Locadora locadora;

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 11 * hash + this.id;
        hash = 11 * hash + Objects.hashCode(this.horaBackup);
        hash = 11 * hash + Objects.hashCode(this.locadora);
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
        final Configuracoes other = (Configuracoes) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.horaBackup, other.horaBackup)) {
            return false;
        }
        if (!Objects.equals(this.locadora, other.locadora)) {
            return false;
        }
        return true;
    }

    public Time getHoraBackup() {
        return horaBackup;
    }

    public void setHoraBackup(Time horaBackup) {
        this.horaBackup = horaBackup;
    }

    
    
    

    public int getId() {
        return id;
    }

    public Locadora getLocadora() {
        return locadora;
    }

    public void setLocadora(Locadora locadora) {
        this.locadora = locadora;
    }
    
    
}
