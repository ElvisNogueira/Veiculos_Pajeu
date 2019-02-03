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
public class Locacaolog {
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
    
    
    @Column(nullable = false, length = 25)
    private String tipo_locacaoNovo;
    @Column(nullable = false, length = 15)
    private String statusNovo;
    @Column(nullable = false)
    private int duracao_estiimadaNovo;
    @Column(nullable = false)
    private Date data_retiradaNovo, data_devolucaoNovo;
    
    @Column(nullable = true)
    private Time hora_retiradaNovo, hora_devolucaoNovo;
    @Column(nullable = false)
    private float taxa_higienizacaoNovo, taxa_combuustivelNovo,
            valor_locacaoNovo, km_inicialNovo, km_finalNovo;
    @ManyToOne
    @JoinColumn(name = "id_veiculoNovo")
    private Veiculo veiculoNovo;
    @ManyToOne
    @JoinColumn(name = "id_clienteNovo")
    private Cliente clienteNovo;
    @ManyToOne
    @JoinColumn(name = "id_motoristaNovo")
    private Motorista motoristaNovo;
    @OneToOne
    @JoinColumn (name = "id_reservaNovo")
    private Reserva reservaNovo;
    
    private Date data_de_modificacao ;
    private String operacao_realizada;

    public Locacaolog() {
        
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + this.id;
        hash = 67 * hash + Objects.hashCode(this.tipo_locacao);
        hash = 67 * hash + Objects.hashCode(this.status);
        hash = 67 * hash + this.duracao_estiimada;
        hash = 67 * hash + Objects.hashCode(this.data_retirada);
        hash = 67 * hash + Objects.hashCode(this.data_devolucao);
        hash = 67 * hash + Objects.hashCode(this.hora_retirada);
        hash = 67 * hash + Objects.hashCode(this.hora_devolucao);
        hash = 67 * hash + Float.floatToIntBits(this.taxa_higienizacao);
        hash = 67 * hash + Float.floatToIntBits(this.taxa_combuustivel);
        hash = 67 * hash + Float.floatToIntBits(this.valor_locacao);
        hash = 67 * hash + Float.floatToIntBits(this.km_inicial);
        hash = 67 * hash + Float.floatToIntBits(this.km_final);
        hash = 67 * hash + Objects.hashCode(this.veiculo);
        hash = 67 * hash + Objects.hashCode(this.cliente);
        hash = 67 * hash + Objects.hashCode(this.motorista);
        hash = 67 * hash + Objects.hashCode(this.reserva);
        hash = 67 * hash + Objects.hashCode(this.tipo_locacaoNovo);
        hash = 67 * hash + Objects.hashCode(this.statusNovo);
        hash = 67 * hash + this.duracao_estiimadaNovo;
        hash = 67 * hash + Objects.hashCode(this.data_retiradaNovo);
        hash = 67 * hash + Objects.hashCode(this.data_devolucaoNovo);
        hash = 67 * hash + Objects.hashCode(this.hora_retiradaNovo);
        hash = 67 * hash + Objects.hashCode(this.hora_devolucaoNovo);
        hash = 67 * hash + Float.floatToIntBits(this.taxa_higienizacaoNovo);
        hash = 67 * hash + Float.floatToIntBits(this.taxa_combuustivelNovo);
        hash = 67 * hash + Float.floatToIntBits(this.valor_locacaoNovo);
        hash = 67 * hash + Float.floatToIntBits(this.km_inicialNovo);
        hash = 67 * hash + Float.floatToIntBits(this.km_finalNovo);
        hash = 67 * hash + Objects.hashCode(this.veiculoNovo);
        hash = 67 * hash + Objects.hashCode(this.clienteNovo);
        hash = 67 * hash + Objects.hashCode(this.motoristaNovo);
        hash = 67 * hash + Objects.hashCode(this.reservaNovo);
        hash = 67 * hash + Objects.hashCode(this.data_de_modificacao);
        hash = 67 * hash + Objects.hashCode(this.operacao_realizada);
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
        final Locacaolog other = (Locacaolog) obj;
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
        if (this.duracao_estiimadaNovo != other.duracao_estiimadaNovo) {
            return false;
        }
        if (Float.floatToIntBits(this.taxa_higienizacaoNovo) != Float.floatToIntBits(other.taxa_higienizacaoNovo)) {
            return false;
        }
        if (Float.floatToIntBits(this.taxa_combuustivelNovo) != Float.floatToIntBits(other.taxa_combuustivelNovo)) {
            return false;
        }
        if (Float.floatToIntBits(this.valor_locacaoNovo) != Float.floatToIntBits(other.valor_locacaoNovo)) {
            return false;
        }
        if (Float.floatToIntBits(this.km_inicialNovo) != Float.floatToIntBits(other.km_inicialNovo)) {
            return false;
        }
        if (Float.floatToIntBits(this.km_finalNovo) != Float.floatToIntBits(other.km_finalNovo)) {
            return false;
        }
        if (!Objects.equals(this.tipo_locacao, other.tipo_locacao)) {
            return false;
        }
        if (!Objects.equals(this.status, other.status)) {
            return false;
        }
        if (!Objects.equals(this.tipo_locacaoNovo, other.tipo_locacaoNovo)) {
            return false;
        }
        if (!Objects.equals(this.statusNovo, other.statusNovo)) {
            return false;
        }
        if (!Objects.equals(this.operacao_realizada, other.operacao_realizada)) {
            return false;
        }
        if (!Objects.equals(this.data_retirada, other.data_retirada)) {
            return false;
        }
        if (!Objects.equals(this.data_devolucao, other.data_devolucao)) {
            return false;
        }
        if (!Objects.equals(this.hora_retirada, other.hora_retirada)) {
            return false;
        }
        if (!Objects.equals(this.hora_devolucao, other.hora_devolucao)) {
            return false;
        }
        if (!Objects.equals(this.veiculo, other.veiculo)) {
            return false;
        }
        if (!Objects.equals(this.cliente, other.cliente)) {
            return false;
        }
        if (!Objects.equals(this.motorista, other.motorista)) {
            return false;
        }
        if (!Objects.equals(this.reserva, other.reserva)) {
            return false;
        }
        if (!Objects.equals(this.data_retiradaNovo, other.data_retiradaNovo)) {
            return false;
        }
        if (!Objects.equals(this.data_devolucaoNovo, other.data_devolucaoNovo)) {
            return false;
        }
        if (!Objects.equals(this.hora_retiradaNovo, other.hora_retiradaNovo)) {
            return false;
        }
        if (!Objects.equals(this.hora_devolucaoNovo, other.hora_devolucaoNovo)) {
            return false;
        }
        if (!Objects.equals(this.veiculoNovo, other.veiculoNovo)) {
            return false;
        }
        if (!Objects.equals(this.clienteNovo, other.clienteNovo)) {
            return false;
        }
        if (!Objects.equals(this.motoristaNovo, other.motoristaNovo)) {
            return false;
        }
        if (!Objects.equals(this.reservaNovo, other.reservaNovo)) {
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

    public Date getData_devolucao() {
        return data_devolucao;
    }

    public void setData_devolucao(Date data_devolucao) {
        this.data_devolucao = data_devolucao;
    }

    public Time getHora_retirada() {
        return hora_retirada;
    }

    public void setHora_retirada(Time hora_retirada) {
        this.hora_retirada = hora_retirada;
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

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
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

    public String getTipo_locacaoNovo() {
        return tipo_locacaoNovo;
    }

    public void setTipo_locacaoNovo(String tipo_locacaoNovo) {
        this.tipo_locacaoNovo = tipo_locacaoNovo;
    }

    public String getStatusNovo() {
        return statusNovo;
    }

    public void setStatusNovo(String statusNovo) {
        this.statusNovo = statusNovo;
    }

    public int getDuracao_estiimadaNovo() {
        return duracao_estiimadaNovo;
    }

    public void setDuracao_estiimadaNovo(int duracao_estiimadaNovo) {
        this.duracao_estiimadaNovo = duracao_estiimadaNovo;
    }

    public Date getData_retiradaNovo() {
        return data_retiradaNovo;
    }

    public void setData_retiradaNovo(Date data_retiradaNovo) {
        this.data_retiradaNovo = data_retiradaNovo;
    }

    public Date getData_devolucaoNovo() {
        return data_devolucaoNovo;
    }

    public void setData_devolucaoNovo(Date data_devolucaoNovo) {
        this.data_devolucaoNovo = data_devolucaoNovo;
    }

    public Time getHora_retiradaNovo() {
        return hora_retiradaNovo;
    }

    public void setHora_retiradaNovo(Time hora_retiradaNovo) {
        this.hora_retiradaNovo = hora_retiradaNovo;
    }

    public Time getHora_devolucaoNovo() {
        return hora_devolucaoNovo;
    }

    public void setHora_devolucaoNovo(Time hora_devolucaoNovo) {
        this.hora_devolucaoNovo = hora_devolucaoNovo;
    }

    public float getTaxa_higienizacaoNovo() {
        return taxa_higienizacaoNovo;
    }

    public void setTaxa_higienizacaoNovo(float taxa_higienizacaoNovo) {
        this.taxa_higienizacaoNovo = taxa_higienizacaoNovo;
    }

    public float getTaxa_combuustivelNovo() {
        return taxa_combuustivelNovo;
    }

    public void setTaxa_combuustivelNovo(float taxa_combuustivelNovo) {
        this.taxa_combuustivelNovo = taxa_combuustivelNovo;
    }

    public float getValor_locacaoNovo() {
        return valor_locacaoNovo;
    }

    public void setValor_locacaoNovo(float valor_locacaoNovo) {
        this.valor_locacaoNovo = valor_locacaoNovo;
    }

    public float getKm_inicialNovo() {
        return km_inicialNovo;
    }

    public void setKm_inicialNovo(float km_inicialNovo) {
        this.km_inicialNovo = km_inicialNovo;
    }

    public float getKm_finalNovo() {
        return km_finalNovo;
    }

    public void setKm_finalNovo(float km_finalNovo) {
        this.km_finalNovo = km_finalNovo;
    }

    public Veiculo getVeiculoNovo() {
        return veiculoNovo;
    }

    public void setVeiculoNovo(Veiculo veiculoNovo) {
        this.veiculoNovo = veiculoNovo;
    }

    public Cliente getClienteNovo() {
        return clienteNovo;
    }

    public void setClienteNovo(Cliente clienteNovo) {
        this.clienteNovo = clienteNovo;
    }

    public Motorista getMotoristaNovo() {
        return motoristaNovo;
    }

    public void setMotoristaNovo(Motorista motoristaNovo) {
        this.motoristaNovo = motoristaNovo;
    }

    public Reserva getReservaNovo() {
        return reservaNovo;
    }

    public void setReservaNovo(Reserva reservaNovo) {
        this.reservaNovo = reservaNovo;
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
