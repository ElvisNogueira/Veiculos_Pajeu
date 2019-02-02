/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.OneToOne;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;

/**
 *
 * @author Elvis Nogueira
 */
@Entity
@NamedStoredProcedureQuery(
	name = "criptografar_senha", 
	procedureName = "criptografar_senha", 
	parameters = { 
		@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "SENHA"),
                @StoredProcedureParameter(mode = ParameterMode.OUT, type = String.class, name = "SAIDA")
	}
)
public class Funcionario {
     @Id
     @GeneratedValue (strategy = GenerationType.AUTO)
     private int id;
     @Column(nullable = false)
     private String nome;
     @Column(nullable = false, length = 14)
     private String telefone;
     @Column(nullable = false, unique = true, length = 14)
     private String cpf;
     @Column(nullable = false)
     private Date data_nasc;
     
     @OneToOne (cascade = CascadeType.ALL)
     @JoinColumn(name = "id_endereco")
     private Endereco end;
     private boolean status;

    public Funcionario(String nome, String telefone, String cpf, Date data_nasc, Endereco end) {
        this.nome = nome;
        this.telefone = telefone;
        this.cpf = cpf;
        this.data_nasc = data_nasc;
        this.end = end;
    }

    public Funcionario() {
        status = true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + this.id;
        hash = 37 * hash + Objects.hashCode(this.nome);
        hash = 37 * hash + Objects.hashCode(this.telefone);
        hash = 37 * hash + Objects.hashCode(this.cpf);
        hash = 37 * hash + Objects.hashCode(this.data_nasc);
        hash = 37 * hash + Objects.hashCode(this.end);
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
        final Funcionario other = (Funcionario) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.telefone, other.telefone)) {
            return false;
        }
        if (!Objects.equals(this.cpf, other.cpf)) {
            return false;
        }
        if (!Objects.equals(this.data_nasc, other.data_nasc)) {
            return false;
        }
        if (!Objects.equals(this.end, other.end)) {
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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Date getData_nasc() {
        return data_nasc;
    }

    public void setData_nasc(Date data_nasc) {
        this.data_nasc = data_nasc;
    }

    public Endereco getEnd() {
        return end;
    }

    public void setEnd(Endereco end) {
        this.end = end;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
    

    @Override
    public String toString() {
        return "Funcionario{" + "id=" + id + ", nome=" + nome + ", telefone=" + telefone + ", \n"
                + "cpf=" + cpf + ", data_nasc=" + data_nasc + ", end=" + end + '}';
    }
     
    
     
     
}
