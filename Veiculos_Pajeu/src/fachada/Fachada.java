/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fachada;

import business.Camioneta_cargaBusiness;
import business.Camioneta_cargalogBusiness;
import business.Camioneta_passageiroBusiness;
import business.Camioneta_passageirologBusiness;
import business.CategoriaBusiness;
import business.CategorialogBusiness;
import business.ClienteBusiness;
import business.ClientelogBusiness;
import business.ConfiguracoesBusiness;
import business.ContaBusiness;
import business.ContalogBusiness;
import business.EnderecoBusiness;
import business.EnderecoologBusiness;
import business.FinanceiroBusiness;
import business.FinanceirologBusiness;
import business.FuncionarioBusiness;
import business.FuncionariologBusiness;
import business.LocacaBusiness;
import business.LocacalogBusiness;
import business.LocadoraBusiness;
import business.LocadoralogBusiness;
import business.MotoristaBusiness;
import business.MotoristalogBusiness;
import business.Pessoa_FisicaBusiness;
import business.Pessoa_FisicalogBusiness;
import business.Pessoa_JuridicaBusiness;
import business.Pessoa_JuridicalogBusiness;
import business.Relatorio_financeiroBusiness;
import business.Relatorio_locacaoBusiness;
import business.Relatorio_reservaBusiness;
import business.ReservaBusiness;
import business.ReservalogBusiness;
import business.UsuarioBusiness;
import business.UsuariologBusiness;
import business.VeiculoBusiness;
import business.VeiculologBusiness;
import dao.Camioneta_cargaDAO;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Camioneta_carga;
import model.Camioneta_cargalog;
import model.Camioneta_passageiro;
import model.Camioneta_passageirolog;
import model.Categoria;
import model.Categorialog;
import model.Cliente;
import model.Clientelog;
import model.Configuracoes;
import model.Conta;
import model.Contalog;
import model.Endereco;
import model.Enderecolog;
import model.Financeiro;
import model.Financeirolog;
import model.Funcionario;
import model.Funcionariolog;
import model.Locacao;
import model.Locacaolog;
import model.Locadora;
import model.Locadoralog;
import model.Motorista;
import model.Motoristalog;
import model.Pessoa_Fisica;
import model.Pessoa_Fisicalog;
import model.Pessoa_Juridica;
import model.Pessoa_Juridicalog;
import model.Relatorio_financeiro;
import model.Relatorio_locacao;
import model.Relatorio_reserva;
import model.Reserva;
import model.Reservalog;
import model.Usuario;
import model.Usuariolog;
import model.Veiculo;
import model.Veiculolog;

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
    
    private Camioneta_cargalogBusiness camioneta_cargalogBusiness;
    private Camioneta_passageirologBusiness camioneta_passageirologBusiness;
    private CategorialogBusiness categorialogBusiness;
    private ClientelogBusiness clientelogBusiness;
    private ContalogBusiness contalogBusiness;
    private EnderecoologBusiness enderecologBusiness;
    private FinanceirologBusiness financeirologBusiness;
    private FuncionariologBusiness funcionariologBusiness;
    private LocacalogBusiness locacalogBusiness;
    private LocadoralogBusiness locadoralogBusiness;
    private MotoristalogBusiness motoristalogBusiness;
    private Pessoa_FisicalogBusiness pessoa_FisicalogBusiness;
    private Pessoa_JuridicalogBusiness pessoa_JuridicalogBusiness;
    private ReservalogBusiness reservalogBusiness;
    private UsuariologBusiness usuariologBusiness;
    private VeiculologBusiness veiculologBusiness;
    private Relatorio_financeiroBusiness relatorio_financeiroBusiness;
    private Relatorio_locacaoBusiness relatorio_locacaoBusiness;
    private Relatorio_reservaBusiness relatorio_reservaBusiness;
    
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
        relatorio_financeiroBusiness = relatorio_financeiroBusiness.getInstance();
        relatorio_locacaoBusiness = relatorio_locacaoBusiness.getInstance();
        relatorio_reservaBusiness = relatorio_reservaBusiness.getInstance();
        
        
        camioneta_cargalogBusiness = camioneta_cargalogBusiness.getInstance();
        camioneta_passageirologBusiness = camioneta_passageirologBusiness.getInstance();
        categorialogBusiness = categorialogBusiness.getInstance();
        clientelogBusiness = clientelogBusiness.getInstance();
        contalogBusiness = contalogBusiness.getInstance();
        enderecologBusiness = enderecologBusiness.getInstance();
        financeirologBusiness = financeirologBusiness.getInstance();
        funcionariologBusiness = funcionariologBusiness.getInstance();
        locacalogBusiness = locacalogBusiness.getInstance();
        locadoralogBusiness = locadoralogBusiness.getInstance();
        motoristalogBusiness = motoristalogBusiness.getInstance();
        pessoa_FisicalogBusiness = pessoa_FisicalogBusiness.getInstance();
        pessoa_JuridicalogBusiness = pessoa_JuridicalogBusiness.getInstance();
        reservalogBusiness = reservalogBusiness.getInstance();
        usuariologBusiness = usuariologBusiness.getInstance();
        veiculologBusiness = veiculologBusiness.getInstance();

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
    
    public ArrayList<Categoria> getBuscaCategoria(String busca){
        return categoriaBusiness.getBusca(busca);
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
    
    public ArrayList<Cliente> getBuscaCliente(String busca){
        return clienteBusiness.getBusca(busca);
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
    
    public ArrayList<Conta> getBuscaConta(String busca){
        return contaBusiness.getBusca(busca);
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
    
    public ArrayList<Reserva> getDataReservas(Date d1, Date d2) {
        return reservaBusiness.getData(d1, d2);
    }
    
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
    
    public ArrayList<Veiculo> getBuscaVeiculo(String busca) {
        return veiculoBusiness.getBusca(busca);
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
    
    public Veiculolog getByIdVeiculolog(int id){
        return veiculologBusiness.getById(id);
    } 
    
    public ArrayList<Veiculolog> getAllVeiculolog(){
        return veiculologBusiness.getAll();
    }
    
    public Usuariolog getByIdUsuariolog(int id) {
        return usuariologBusiness.getById(id);
    }

    public ArrayList<Usuariolog> getAllUsuariolog() {
        return usuariologBusiness.getAll();
    }
    
    public Reservalog getByIdReservalog(int id){
        return reservalogBusiness.getById(id);
    } 
    
    public ArrayList<Reservalog> getAllReservalog(){
        return reservalogBusiness.getAll();
    }
    
     public Pessoa_Juridicalog getByIdPessoa_Juridicalog(int id){
        return pessoa_JuridicalogBusiness.getById(id);
    } 
    
    public ArrayList<Pessoa_Juridicalog> getAllPessoa_Juridicalog(){
        return pessoa_JuridicalogBusiness.getAll();
    }
    
    public Pessoa_Fisicalog getByIdPessoa_FisicalogPessoa_Fisicalog(int id){
        return pessoa_FisicalogBusiness.getById(id);
    } 
    
    
    public ArrayList<Pessoa_Fisicalog> getAllPessoa_Fisicalog(){
        return pessoa_FisicalogBusiness.getAll();
    }
    
    
    public Motoristalog getByIdMotoristalog(int id){
        return motoristalogBusiness.getById(id);
    } 
    
    public ArrayList<Motoristalog> getAllMotoristalog(){
        return motoristalogBusiness.getAll();
    }
    
    public Locadoralog getByIdLocadoralog(int id){
        return locadoralogBusiness.getById(id);
    } 
    
    public ArrayList<Locadoralog> getAllLocadoralog(){
        return locadoralogBusiness.getAll();
    }
    
    public Locacaolog getByIdLocacaolog(int id){
        return locacalogBusiness.getById(id);
    } 
    
    public ArrayList<Locacaolog> getAllLocacaolog(){
        return locacalogBusiness.getAll();
    }
    
    public Funcionariolog getByIdFuncionariolog(int id){
        return funcionariologBusiness.getById(id);
    } 
    
    public ArrayList<Funcionariolog> getAllFuncionariolog(){
        return funcionariologBusiness.getAll();
    }
    
    public Financeirolog getByIdFinanceirolog(int id){
        return financeirologBusiness.getById(id);
    } 
    
    public ArrayList<Financeirolog> getAllFinanceirolog(){
        return financeirologBusiness.getAll();
    }
    
    public Enderecolog getByIdEnderecolog(int id){
        return enderecologBusiness.getById(id);
    } 
    
    public ArrayList<Enderecolog> getAllEnderecolog(){
        return enderecologBusiness.getAll();
    }
    
    public Contalog getByIdContalog(int id){
        return contalogBusiness.getById(id);
    } 
    
    
    public ArrayList<Contalog> getAllContalog(){
        return contalogBusiness.getAll();
    }
    
    public Clientelog getByIdClientelog(int id) {
        return clientelogBusiness.getById(id);
    }

    public ArrayList<Clientelog> getAllClientelog() {
        return clientelogBusiness.getAll();
    }
    
    public Categorialog getByIdCategorialog(int id){
        return categorialogBusiness.getById(id);
    } 
    
    public ArrayList<Categorialog> getAllCategorialog(){
        return categorialogBusiness.getAll();
    }
    
    public Camioneta_passageirolog getByIdCamioneta_passageirolog(int id){
        return camioneta_passageirologBusiness.getById(id);
    } 
    
    public ArrayList<Camioneta_passageirolog> getAllCamioneta_passageirolog(){
        return camioneta_passageirologBusiness.getAll();
    }
    
    public Camioneta_cargalog getByIdCamioneta_cargalog(int id){
        return camioneta_cargalogBusiness.getById(id);
    } 
    
    public ArrayList<Camioneta_cargalog> getAllCamioneta_cargalog(){
        return camioneta_cargalogBusiness.getAll();
    }
    
    public Relatorio_locacao getByIdRelatorio_locacao(int id){
        return relatorio_locacaoBusiness.getById(id);
    } 
    
    public ArrayList<Relatorio_locacao> getAllRelatorio_locacao(){
        return relatorio_locacaoBusiness.getAll();
    }
    
    public Relatorio_reserva getByIdRelatorio_reserva(int id){
        return relatorio_reservaBusiness.getById(id);
    } 
    
    public ArrayList<Relatorio_reserva> getAllRelatorio_reserva(){
        return relatorio_reservaBusiness.getAll();
    }
    
    public ArrayList<Relatorio_financeiro> getAllRelatorio_financeiro(){
        return relatorio_financeiroBusiness.getAll();
    }
    
    public ArrayList<Relatorio_financeiro> getBuscaRelatorio_financeiro(String busca) {
        return relatorio_financeiroBusiness.getBusca(busca);
    }
}
