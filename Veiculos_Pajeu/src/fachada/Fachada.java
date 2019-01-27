/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fachada;

import business.Camioneta_cargaBusiness;
import business.Camioneta_passageiroBusiness;
import business.CategoriaBusiness;
import business.ClienteBusiness;
import business.ConfiguracoesBusiness;
import business.ContaBusiness;
import business.EnderecoBusiness;
import business.FinanceiroBusiness;
import business.FuncionarioBusiness;
import business.LocacaBusiness;
import business.LocadoraBusiness;
import business.MotoristaBusiness;
import business.Pessoa_FisicaBusiness;
import business.Pessoa_JuridicaBusiness;
import business.ReservaBusiness;
import business.UsuarioBusiness;
import business.VeiculoBusiness;
import dao.Camioneta_cargaDAO;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Camioneta_carga;
import model.Camioneta_passageiro;
import model.Categoria;
import model.Cliente;
import model.Configuracoes;
import model.Conta;
import model.Endereco;
import model.Financeiro;
import model.Funcionario;
import model.Locacao;
import model.Locadora;
import model.Motorista;
import model.Pessoa_Fisica;
import model.Pessoa_Juridica;
import model.Reserva;
import model.Usuario;
import model.Veiculo;

/**
 *
 * @author Elvis Nogueira
 */
public class Fachada {

    private Camioneta_cargaBusiness camioneta_cargaBusiness;
    private Camioneta_passageiroBusiness camioneta_passageiroBusiness;
    private CategoriaBusiness categoriaBusiness;
    private ClienteBusiness clienteBusiness;
    private ContaBusiness contaBusiness;
    private EnderecoBusiness enderecoBusiness;
    private FinanceiroBusiness financeiroBusiness;
    private FuncionarioBusiness funcionarioBusiness;
    private LocacaBusiness locacaBusiness;
    private LocadoraBusiness locadoraBusiness;
    private MotoristaBusiness motoristaBusiness;
    private Pessoa_FisicaBusiness pessoa_FisicaBusiness;
    private Pessoa_JuridicaBusiness pessoa_JuridicaBusiness;
    private ReservaBusiness reservaBusiness;
    private UsuarioBusiness usuarioBusiness;
    private VeiculoBusiness veiculoBusiness;
    private ConfiguracoesBusiness configuracoesBusiness;
    private static Usuario userLogado;

    private static Fachada instance;

    public static Fachada getInstance() {
        if (instance == null) {
            instance = new Fachada();
        }
        return instance;
    }

    private Fachada() {
        camioneta_cargaBusiness = Camioneta_cargaBusiness.getInstance();
        camioneta_passageiroBusiness = camioneta_passageiroBusiness.getInstance();
        categoriaBusiness = categoriaBusiness.getInstance();
        clienteBusiness = clienteBusiness.getInstance();
        contaBusiness = contaBusiness.getInstance();
        enderecoBusiness = enderecoBusiness.getInstance();
        financeiroBusiness = financeiroBusiness.getInstance();
        funcionarioBusiness = funcionarioBusiness.getInstance();
        locacaBusiness = locacaBusiness.getInstance();
        locadoraBusiness = locadoraBusiness.getInstance();
        motoristaBusiness = motoristaBusiness.getInstance();
        pessoa_FisicaBusiness = pessoa_FisicaBusiness.getInstance();
        pessoa_JuridicaBusiness = pessoa_JuridicaBusiness.getInstance();
        reservaBusiness = reservaBusiness.getInstance();
        usuarioBusiness = usuarioBusiness.getInstance();
        veiculoBusiness = veiculoBusiness.getInstance();
        configuracoesBusiness = configuracoesBusiness.getInstance();

    }

    //CAMIONETA_CARGA
    public Camioneta_carga getByIdCamioneta_carga(int id) {
        return camioneta_cargaBusiness.getById(id);
    }

    public ArrayList<Camioneta_carga> getAllCamioneta_carga() {
        return camioneta_cargaBusiness.getAll();
    }

    public void persistCamioneta_carga(Camioneta_carga camioneta_carga) {
        camioneta_cargaBusiness.persist(camioneta_carga);
    }

    public void mergeCamioneta_carga(Camioneta_carga camioneta_carga) {
        camioneta_cargaBusiness.merge(camioneta_carga);
    }

    public void removeCamioneta_carga(Camioneta_carga camioneta_carga) {
        camioneta_cargaBusiness.remove(camioneta_carga);
    }

    public void removeByIdCamioneta_carga(int id) {
        camioneta_cargaBusiness.removeById(id);
    }
    

    //CAMIONETA_PASSAGEIRO
    public Camioneta_passageiro getByIdCamioneta_passageiro(int id) {
        return camioneta_passageiroBusiness.getById(id);
    }

    public ArrayList<Camioneta_passageiro> getAllCamioneta_passageiro() {
        return camioneta_passageiroBusiness.getAll();
    }

    public void persistCamioneta_passageiro(Camioneta_passageiro camioneta_passageiro) {
        camioneta_passageiroBusiness.persist(camioneta_passageiro);
    }

    public void mergeCamioneta_passageiro(Camioneta_passageiro camioneta_passageiro) {
        camioneta_passageiroBusiness.merge(camioneta_passageiro);
    }

    public void removeCamioneta_passageiro(Camioneta_passageiro camioneta_passageiro) {
        camioneta_passageiroBusiness.remove(camioneta_passageiro);
    }

    public void removeByIdCamioneta_passageiro(int id) {
        camioneta_passageiroBusiness.removeById(id);
    }

    //CATEGORIA
    public Categoria getByIdCategoria(int id) {
        return categoriaBusiness.getById(id);
    }

    public ArrayList<Categoria> getAllCategoria() {
        return categoriaBusiness.getAll();
    }

    public void persistCategoria(Categoria categoria) {
        categoriaBusiness.persist(categoria);
    }

    public void mergeCategoria(Categoria categoria) {
        categoriaBusiness.merge(categoria);
    }

    public void removeCategoria(Categoria categoria) {
        categoriaBusiness.remove(categoria);
    }

    public void removeByIdCategoria(int id) {
        categoriaBusiness.removeById(id);
    }

    //Cliente
    public Cliente getByIdCliente(int id) {
        return clienteBusiness.getById(id);
    }
    
    public Cliente getLastCliente(){
        return clienteBusiness.getLast();
    }

    public ArrayList<Cliente> getAllCliente() {
        return clienteBusiness.getAll();
    }

    public void persistCliente(Cliente cliente) {
        clienteBusiness.persist(cliente);
    }

    public void mergeCliente(Cliente cliente) {
        clienteBusiness.merge(cliente);
    }

    public void removeCliente(Cliente cliente) {
        clienteBusiness.remove(cliente);
    }

    public void removeByIdCliente(int id) {
        clienteBusiness.removeById(id);
    }

    //Conta
    public Conta getByIdConta(int id) {
        return contaBusiness.getById(id);
    }

    public ArrayList<Conta> getAllConta() {
        return contaBusiness.getAll();
    }

    public void persistConta(Conta conta) {
        contaBusiness.persist(conta);
    }
    
    public Conta getByNomeConta(String nome){
        return contaBusiness.getByNome(nome);
    }
    
    public void mergeConta(Conta conta) {
        contaBusiness.merge(conta);
    }

    public void removeConta(Conta conta) {
        contaBusiness.remove(conta);
    }

    public void removeByIdConta(int id) {
        contaBusiness.removeById(id);
    }

    //ENDERECO
    public Endereco getByIdEndereco(int id) {
        return enderecoBusiness.getById(id);
    }
    
    public Endereco getLastEndereco(){
        return enderecoBusiness.getLast();
    }

    public ArrayList<Endereco> getAllEndereco() {
        return enderecoBusiness.getAll();
    }

    public void persistEndereco(Endereco endereco) {
        enderecoBusiness.persist(endereco);
    }

    public void mergeEndereco(Endereco endereco) {
        enderecoBusiness.merge(endereco);
    }

    public void removeEndereco(Endereco endereco) {
        enderecoBusiness.remove(endereco);
    }

    public void removeByIdEndereco(int id) {
        enderecoBusiness.removeById(id);
    }

    //FINANCEIRO
    public Financeiro getByIdFinanceiro(int id) {
        return financeiroBusiness.getById(id);
    }

    public ArrayList<Financeiro> getAllFinanceiro() {
        return financeiroBusiness.getAll();
    }

    public void persistFinanceiro(Financeiro financeiro) {
        financeiroBusiness.persist(financeiro);
    }

    public void mergeFinanceiro(Financeiro financeiro) {
        financeiroBusiness.merge(financeiro);
    }

    public void removeFinanceiro(Financeiro financeiro) {
        financeiroBusiness.remove(financeiro);
    }

    public void removeByIdFinanceiro(int id) {
        financeiroBusiness.removeById(id);
    }

    //FUNCIONARIO
    public Funcionario getByIdFuncionario(int id) {
        return funcionarioBusiness.getById(id);
    }

    public ArrayList<Funcionario> getAllFuncionario() {
        return funcionarioBusiness.getAll();
    }
    
    public ArrayList<Funcionario> getBuscaFuncionario(String busca){
         return funcionarioBusiness.getBusca(busca);
    }

    public void persistFuncionario(Funcionario funcionario) {
        funcionarioBusiness.persist(funcionario);
    }

    public void mergeFuncionario(Funcionario funcionario) {
        funcionarioBusiness.merge(funcionario);
    }

    public void removeFuncionario(Funcionario funcionario) {
        funcionarioBusiness.remove(funcionario);
    }

    public void removeByIdFuncionario(int id) {
        funcionarioBusiness.removeById(id);
    }

    //LOCACAO
    public Locacao getByIdLocacao(int id) {
        return locacaBusiness.getById(id);
    }

    public ArrayList<Locacao> getAllLocacao() {
        return locacaBusiness.getAll();
    }

    public void persistLocacao(Locacao locacao) {
        locacaBusiness.persist(locacao);
    }

    public void mergeLocacao(Locacao locacao) {
        locacaBusiness.merge(locacao);
    }

    public void removeLocacao(Locacao locacao) {
        locacaBusiness.remove(locacao);
    }

    public void removeByIdLocacao(int id) {
        locacaBusiness.removeById(id);
    }

    //LOCADORA
    public Locadora getByIdLocadora(int id) {
        return locadoraBusiness.getById(id);
    }

    public ArrayList<Locadora> getAllLocadora() {
        return locadoraBusiness.getAll();
    }
    
    public Locadora getLastIdLocadora(){
        return locadoraBusiness.getLastId();
    }

    public void persistLocadora(Locadora locadora) {
        locadoraBusiness.persist(locadora);
    }

    public void mergeLocadora(Locadora locadora) {
        locadoraBusiness.merge(locadora);
    }

    public void removeLocadora(Locadora locadora) {
        locadoraBusiness.remove(locadora);
    }

    public void removeByIdLocadora(int id) {
        locadoraBusiness.removeById(id);
    }

    //MOTORISTA
    public Motorista getByIdMotorista(int id) {
        return motoristaBusiness.getById(id);
    }

    public ArrayList<Motorista> getAllMotorista() {
        return motoristaBusiness.getAll();
    }

    public void persistMotorista(Motorista motorista) {
        motoristaBusiness.persist(motorista);
    }

    public void mergeMotorista(Motorista motorista) {
        motoristaBusiness.merge(motorista);
    }

    public void removeMotorista(Motorista motorista) {
        motoristaBusiness.remove(motorista);
    }

    public void removeByIdMotorista(int id) {
        motoristaBusiness.removeById(id);
    }

    //PESSOA_FISICA
    public Pessoa_Fisica getByIdPessoa_Fisica(int id) {
        return pessoa_FisicaBusiness.getById(id);
    }
    
    public Pessoa_Fisica getLastPessoa_Fisica() {
        return pessoa_FisicaBusiness.getLast();
    }

    public ArrayList<Pessoa_Fisica> getAllPessoa_Fisica() {
        return pessoa_FisicaBusiness.getAll();
    }

    public void persistPessoa_Fisica(Pessoa_Fisica pessoa_Fisica) {
        pessoa_FisicaBusiness.persist(pessoa_Fisica);
    }

    public void mergePessoa_Fisica(Pessoa_Fisica pessoa_Fisica) {
        pessoa_FisicaBusiness.merge(pessoa_Fisica);
    }

    public void removePessoa_Fisica(Pessoa_Fisica pessoa_Fisica) {
        pessoa_FisicaBusiness.remove(pessoa_Fisica);
    }

    public void removeByIdPessoa_Fisica(int id) {
        pessoa_FisicaBusiness.removeById(id);
    }

    //PESSOA_JURIDICA
    public Pessoa_Juridica getByIdPessoa_Juridica(int id) {
        return pessoa_JuridicaBusiness.getById(id);
    }

    public ArrayList<Pessoa_Juridica> getAllPessoa_Juridica() {
        return pessoa_JuridicaBusiness.getAll();
    }

    public void persistPessoa_Juridica(Pessoa_Juridica pessoa_Juridica) {
        pessoa_JuridicaBusiness.persist(pessoa_Juridica);
    }

    public void mergePessoa_Juridica(Pessoa_Juridica pessoa_Juridica) {
        pessoa_JuridicaBusiness.merge(pessoa_Juridica);
    }

    public void removePessoa_Juridica(Pessoa_Juridica pessoa_Juridica) {
        pessoa_JuridicaBusiness.remove(pessoa_Juridica);
    }

    public void removeByIdPessoa_Juridica(int id) {
        pessoa_JuridicaBusiness.removeById(id);
    }
    

    //RESERVA
    public Reserva getByIdReserva(int id) {
        return reservaBusiness.getById(id);
    }

    public ArrayList<Reserva> getAllReserva() {
        return reservaBusiness.getAll();
    }

    public void persistReserva(Reserva reserva) {
        reservaBusiness.persist(reserva);
    }

    public void mergeReserva(Reserva reserva) {
        reservaBusiness.merge(reserva);
    }

    public void removeReserva(Reserva reserva) {
        reservaBusiness.remove(reserva);
    }

    public void removeByIdReserva(int id) {
        reservaBusiness.removeById(id);
    }

    //USUARIO
    public Usuario getByIdUsuario(int id) {
        return usuarioBusiness.getById(id);
    }

    public ArrayList<Usuario> getAllUsuario() {
        return usuarioBusiness.getAll();
    }

    public void persistUsuario(Usuario usuario) {
        try {
            usuarioBusiness.persist(usuario);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Fachada.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(Fachada.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void mergeUsuario(Usuario usuario) {
        usuarioBusiness.merge(usuario);
    }

    public void removeUsuario(Usuario usuario) {
        usuarioBusiness.remove(usuario);
    }

    public void removeByIdUsuario(int id) {
        usuarioBusiness.removeById(id);
    }
    
    public boolean loginUsuario(String login, String senha){
        try {
            return usuarioBusiness.login(login, senha);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Fachada.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(Fachada.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public boolean trocarSenha(String novaSenha, String antigaSenha){
        try {
            return usuarioBusiness.trocarSenha(novaSenha, antigaSenha);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Fachada.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {        
            Logger.getLogger(Fachada.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public boolean redefinirSenhaUsuario(String login){
        return usuarioBusiness.redefinirSenha(login);
    }

    //VEICULO
    public Veiculo getByIdVeiculo(int id) {
        return veiculoBusiness.getById(id);
    }

    public ArrayList<Veiculo> getAllVeiculo() {
        return veiculoBusiness.getAll();
    }

    public void persistVeiculo(Veiculo veiculo) {
        veiculoBusiness.persist(veiculo);
    }

    public void mergeVeiculo(Veiculo veiculo) {
        veiculoBusiness.merge(veiculo);
    }

    public void removeVeiculo(Veiculo veiculo) {
        veiculoBusiness.remove(veiculo);
    }

    public void removeByIdVeiculo(int id) {
        veiculoBusiness.removeById(id);
    }
    
    public ArrayList<Configuracoes> getAllConfiguracoes() {
        return configuracoesBusiness.getAll();
    }

    public void persistConfiguracoes(Configuracoes configuracoes) {
        configuracoesBusiness.persist(configuracoes);
    }

    public void mergeConfiguracoes(Configuracoes configuracoes) {
        configuracoesBusiness.merge(configuracoes);
    }
    
    

    public static Usuario getUserLogado() {
        return userLogado;
    }

    public static void setUserLogado(Usuario userLogado) {
        Fachada.userLogado = userLogado;
    }
    
    
}
