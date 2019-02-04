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
import javax.persistence.PrimaryKeyJoinColumn;

/**
 *
 * @author Elvis Nogueira
 */
@Entity
public class Pessoa_Fisicalog{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", insertable = false, updatable = false)
    private int id;

    
    private String cpf;
    private Date data_nasc;
    private String sexo;

    
    private String cpfNovo;
    private Date data_nascNovo;
    private String sexoNovo;
    
    private Date data_de_modificacao ;
    private String operacao_realizada;
    
    public Pessoa_Fisicalog() {
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + this.id;
        hash = 97 * hash + Objects.hashCode(this.cpf);
        hash = 97 * hash + Objects.hashCode(this.data_nasc);
        hash = 97 * hash + Objects.hashCode(this.sexo);
        hash = 97 * hash + Objects.hashCode(this.cpfNovo);
        hash = 97 * hash + Objects.hashCode(this.data_nascNovo);
        hash = 97 * hash + Objects.hashCode(this.sexoNovo);
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
        final Pessoa_Fisicalog other = (Pessoa_Fisicalog) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.cpf, other.cpf)) {
            return false;
        }
        if (!Objects.equals(this.sexo, other.sexo)) {
            return false;
        }
        if (!Objects.equals(this.cpfNovo, other.cpfNovo)) {
            return false;
        }
        if (!Objects.equals(this.sexoNovo, other.sexoNovo)) {
            return false;
        }
        if (!Objects.equals(this.data_nasc, other.data_nasc)) {
            return false;
        }
        if (!Objects.equals(this.data_nascNovo, other.data_nascNovo)) {
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

    public String getCpfNovo() {
        return cpfNovo;
    }

    public void setCpfNovo(String cpfNovo) {
        this.cpfNovo = cpfNovo;
    }

    public Date getData_nascNovo() {
        return data_nascNovo;
    }

    public void setData_nascNovo(Date data_nascNovo) {
        this.data_nascNovo = data_nascNovo;
    }

    public String getSexoNovo() {
        return sexoNovo;
    }

    public void setSexoNovo(String sexoNovo) {
        this.sexoNovo = sexoNovo;
    }

    
    
}
