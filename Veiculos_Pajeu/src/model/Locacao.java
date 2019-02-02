/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;
import java.sql.Time;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 *
 * @author Elvis Nogueira
 */
@Entity
public class Locacao {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(nullable = false, length = 25)
    private String tipo_locacao;
    @Column(nullable = false, length = 15)
    private String status;
    @Column(nullable = false)
    private int duracao_estiimada;
    @Column(nullable = false)
    private Date data_retirada, data_devolucao;
    
    @Column(nullable = true)
    private Time hora_retirada, hora_devolucao;
    @Column(nullable = false)
    private float taxa_higienizacao, taxa_combuustivel,
            valor_locacao, km_inicial, km_final;
    @ManyToOne
    @JoinColumn(name = "id_veiculo")
    private Veiculo veiculo;
    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;
    @ManyToOne
    @JoinColumn(name = "id_motorista")
    private Motorista motorista;
    @OneToOne
    @JoinColumn (name = "id_reserva")
    private Reserva reserva;
    private boolean ativo;

    public Locacao() {
        ativo = true;
    }

    public Locacao(String tipo_locacao, String status, int duracao_estiimada, Date data_retirada, Time hora_retirada, 
            Date data_devolucao, Time hora_devolucao, float taxa_higienizacao, float taxa_combuustivel, float valor_locacao, 
            float km_inicial, float km_final, Veiculo veiculo, Motorista motorista, Reserva reserva) {
        this.tipo_locacao = tipo_locacao;
        this.status = status;
        this.duracao_estiimada = duracao_estiimada;
        this.data_retirada = data_retirada;
        this.hora_retirada = hora_retirada;
        this.data_devolucao = data_devolucao;
        this.hora_devolucao = hora_devolucao;
        this.taxa_higienizacao = taxa_higienizacao;
        this.taxa_combuustivel = taxa_combuustivel;
        this.valor_locacao = valor_locacao;
        this.km_inicial = km_inicial;
        this.km_final = km_final;
        this.veiculo = veiculo;
        this.motorista = motorista;
        this.reserva = reserva;
    }

    public Locacao(String tipo_locacao, String status, int duracao_estiimada, Date data_retirada, Date data_devolucao, 
            Time hora_retirada, Time hora_devolucao, float taxa_higienizacao, float taxa_combuustivel, 
            float valor_locacao, float km_inicial, float km_final, Veiculo veiculo, Motorista motorista) {
        this.tipo_locacao = tipo_locacao;
        this.status = status;
        this.duracao_estiimada = duracao_estiimada;
        this.data_retirada = data_retirada;
        this.data_devolucao = data_devolucao;
        this.hora_retirada = hora_retirada;
        this.hora_devolucao = hora_devolucao;
        this.taxa_higienizacao = taxa_higienizacao;
        this.taxa_combuustivel = taxa_combuustivel;
        this.valor_locacao = valor_locacao;
        this.km_inicial = km_inicial;
        this.km_final = km_final;
        this.veiculo = veiculo;
        this.motorista = motorista;
    }

    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + this.id;
        hash = 71 * hash + Objects.hashCode(this.tipo_locacao);
        hash = 71 * hash + Objects.hashCode(this.status);
        hash = 71 * hash + this.duracao_estiimada;
        hash = 71 * hash + Objects.hashCode(this.data_retirada);
        hash = 71 * hash + Objects.hashCode(this.hora_retirada);
        hash = 71 * hash + Objects.hashCode(this.data_devolucao);
        hash = 71 * hash + Objects.hashCode(this.hora_devolucao);
        hash = 71 * hash + Float.floatToIntBits(this.taxa_higienizacao);
        hash = 71 * hash + Float.floatToIntBits(this.taxa_combuustivel);
        hash = 71 * hash + Float.floatToIntBits(this.valor_locacao);
        hash = 71 * hash + Float.floatToIntBits(this.km_inicial);
        hash = 71 * hash + Float.floatToIntBits(this.km_final);
        hash = 71 * hash + Objects.hashCode(this.veiculo);
        hash = 71 * hash + Objects.hashCode(this.motorista);
        hash = 71 * hash + Objects.hashCode(this.reserva);
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
        final Locacao other = (Locacao) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.duracao_estiimada != other.duracao_estiimada) {
            return false;
        }
        if (Float.floatToIntBits(this.taxa_higienizacao) != Float.floatToIntBits(other.taxa_higienizacao)) {
            return false;
        }
        if (Float.floatToIntBits(this.taxa_combuustivel) != Float.floatToIntBits(other.taxa_combuustivel)) {
            return false;
        }
        if (Float.floatToIntBits(this.valor_locacao) != Float.floatToIntBits(other.valor_locacao)) {
            return false;
        }
        if (Float.floatToIntBits(this.km_inicial) != Float.floatToIntBits(other.km_inicial)) {
            return false;
        }
        if (Float.floatToIntBits(this.km_final) != Float.floatToIntBits(other.km_final)) {
            return false;
        }
        if (!Objects.equals(this.tipo_locacao, other.tipo_locacao)) {
            return false;
        }
        if (!Objects.equals(this.status, other.status)) {
            return false;
        }
        if (!Objects.equals(this.data_retirada, other.data_retirada)) {
            return false;
        }
        if (!Objects.equals(this.hora_retirada, other.hora_retirada)) {
            return false;
        }
        if (!Objects.equals(this.data_devolucao, other.data_devolucao)) {
            return false;
        }
        if (!Objects.equals(this.hora_devolucao, other.hora_devolucao)) {
            return false;
        }
        if (!Objects.equals(this.veiculo, other.veiculo)) {
            return false;
        }
        if (!Objects.equals(this.motorista, other.motorista)) {
            return false;
        }
        if (!Objects.equals(this.reserva, other.reserva)) {
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

    public String getTipo_locacao() {
        return tipo_locacao;
    }

    public void setTipo_locacao(String tipo_locacao) {
        this.tipo_locacao = tipo_locacao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getDuracao_estiimada() {
        return duracao_estiimada;
    }

    public void setDuracao_estiimada(int duracao_estiimada) {
        this.duracao_estiimada = duracao_estiimada;
    }

    public Date getData_retirada() {
        return data_retirada;
    }

    public void setData_retirada(Date data_retirada) {
        this.data_retirada = data_retirada;
    }

    public Time getHora_retirada() {
        return hora_retirada;
    }

    public void setHora_retirada(Time hora_retirada) {
        this.hora_retirada = hora_retirada;
    }

    public Date getData_devolucao() {
        return data_devolucao;
    }

    public void setData_devolucao(Date data_devolucao) {
        this.data_devolucao = data_devolucao;
    }

    public Time getHora_devolucao() {
        return hora_devolucao;
    }

    public void setHora_devolucao(Time hora_devolucao) {
        this.hora_devolucao = hora_devolucao;
    }

    public float getTaxa_higienizacao() {
        return taxa_higienizacao;
    }

    public void setTaxa_higienizacao(float taxa_higienizacao) {
        this.taxa_higienizacao = taxa_higienizacao;
    }

    public float getTaxa_combuustivel() {
        return taxa_combuustivel;
    }

    public void setTaxa_combuustivel(float taxa_combuustivel) {
        this.taxa_combuustivel = taxa_combuustivel;
    }

    public float getValor_locacao() {
        return valor_locacao;
    }

    public void setValor_locacao(float valor_locacao) {
        this.valor_locacao = valor_locacao;
    }

    public float getKm_inicial() {
        return km_inicial;
    }

    public void setKm_inicial(float km_inicial) {
        this.km_inicial = km_inicial;
    }

    public float getKm_final() {
        return km_final;
    }

    public void setKm_final(float km_final) {
        this.km_final = km_final;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public Motorista getMotorista() {
        return motorista;
    }

    public void setMotorista(Motorista motorista) {
        this.motorista = motorista;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public Cliente getCliente() {
        return cliente;
    }
    
    

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
    
    

    @Override
    public String toString() {
        return "Locacao{" + "id=" + id + ", tipo_locacao=" + tipo_locacao + ", status=" + status + ", \n"
                + "duracao_estiimada=" + duracao_estiimada + ", data_retirada=" + data_retirada + ", "
                + "data_devolucao=" + data_devolucao + ",\n hora_retirada=" + hora_retirada + ", "
                + "hora_devolucao=" + hora_devolucao + ", taxa_higienizacao=" + taxa_higienizacao + ",\n"
                + " taxa_combuustivel=" + taxa_combuustivel + ", valor_locacao=" + valor_locacao + ", "
                + "km_inicial=" + km_inicial + ", km_final=" + km_final + ",\n veiculo=" + veiculo + ", "
                + "motorista=" + motorista + ", reserva=" + reserva + '}';
    }
    
    
}
