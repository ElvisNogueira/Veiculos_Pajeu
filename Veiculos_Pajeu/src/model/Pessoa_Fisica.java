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
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.PrimaryKeyJoinColumn;

/**
 *
 * @author Elvis Nogueira
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Pessoa_Fisica extends Cliente {

    @Column(nullable = false, unique = true, length = 14)
    private String cpf;
    @Column(nullable = false)
    private Date data_nasc;
    @Column(length = 14)
    private String sexo;

    public Pessoa_Fisica() {
    }

    public Pessoa_Fisica(String cpf, Date data_nasc, String sexo, String codigo, String nome, String telefone, Endereco endereco) {
        super(codigo, nome, telefone, endereco);
        this.cpf = cpf;
        this.data_nasc = data_nasc;
        this.sexo = sexo;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + Objects.hashCode(this.cpf);
        hash = 59 * hash + Objects.hashCode(this.data_nasc);
        hash = 59 * hash + Objects.hashCode(this.sexo);
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
        final Pessoa_Fisica other = (Pessoa_Fisica) obj;
        if (!Objects.equals(this.cpf, other.cpf)) {
            return false;
        }
        if (!Objects.equals(this.sexo, other.sexo)) {
            return false;
        }
        if (!Objects.equals(this.data_nasc, other.data_nasc)) {
            return false;
        }
        return true;
    }
    
    

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getData_nasc() {
        return data_nasc;
    }

    public void setData_nasc(Date data_nasc) {
        this.data_nasc = data_nasc;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    @Override
    public String toString() {
        return super.toString()+", "+getCpf();
    }
    
    
    
}
