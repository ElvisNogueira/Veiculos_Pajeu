/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Elvis Nogueira
 */
public class FinanceiroAux{
        public int id;
        public String nome, obs,tipo;
        
        public FinanceiroAux(int id,String nome, String obs,String tipo){
            this.id = id;
            this.obs = obs;
            this.nome = nome;
            this.tipo = tipo;
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

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
        
        
        
    }
