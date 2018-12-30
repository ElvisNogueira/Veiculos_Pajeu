/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import util.Util;
import view.AppTelas;

/**
 *
 * @author Elvis Nogueira
 */
public class App{

    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
//        new AppTelas();
//        Fachada.getInstance().loginUsuario("elvis150", "Elvis1574!");
//        Fachada.getInstance().trocarSenha("Elvis1574!", "Elvis150!");

//        Fachada.getInstance().redefinirSenhaUsuario("elvis150");

        /*  Conta conta = new Conta("débito", "Conta de luz");
        Conta conta2 = new Conta("débito", "Aluguel");
//        
//        System.out.println("app.App.main()");
        Categoria categoria = new Categoria("A1", 100, 20, 4, 4, true, true, true, true, true,
                "Cambio automático", "Grande");
        Categoria categoria2 = new Categoria("B1", 100, 20, 4, 4, true, true, true, true, true,
                "Cambio manual", "Grande");
        Endereco endereco = new Endereco("Rua Manoel Ferraz", "DNER", "Floresta", "PE", "56400-000", "70");
        Endereco endereco2 = new Endereco("Rua Manoel Ferraz", "ST", "Floresta", "PE", "56400-000", "70");
        Endereco endereco3 = new Endereco("Rua Manoel Ferraz", "ST", "Floresta", "PE", "56400-000", "70");
        Locadora locadora = new Locadora("111111111", endereco2);
        Locadora locadora2 = new Locadora("222222222", endereco2);
        Camioneta_carga camioneta_carga = new Camioneta_carga("Manual", 1, 4, 550, 1, 300, "MOB8080",
                "Toyota", "aaaaaaaa", "AAQE##@$", "Hilux", "Gasolina", "Prata", 1, 1, 2, 2017, 2018, 3,
                categoria, locadora);
        Camioneta_carga camioneta_carga2 = new Camioneta_carga("Manual", 1, 4, 550, 1, 300, "MOB8080",
                "Toyota", "aaaaaaaa", "AAQE##@$", "Hilux", "Gasolina", "Prata", 1, 1, 2, 2017, 2018, 3,
                categoria, locadora);
        Camioneta_passageiro camioneta_passageiro = new Camioneta_passageiro("Completo", true, true, true, true, "CNK80Q3",
                "Chevrolet", "AAANCNKDK3", "ALCK#", "Ranger", "Gasolina", "Vermelho", 0, 0, 0, 0, 0, 0, categoria, locadora);
        
        Pessoa_Fisica pessoa_Fisica = new Pessoa_Fisica("113.755.434-74", Util.getDate("12/02/1997"), "Masculino",
                "AA123", "Elvis", "(87)99612-2609", endereco);
        Pessoa_Juridica pessoa_Juridica = new Pessoa_Juridica("121212", "12121211", "PJ001", "Microsoft",
                "(87)3877-1111", endereco);
        Motorista motorista = new Motorista(Util.getDate("12/02/2020"), "11111", pessoa_Fisica);
        Reserva reserva = new Reserva("Livre", 0, Util.getDate("09/12/2018"), new Time(16, 10, 0), 0, categoria);

        Locacao locacao = new Locacao("Livre", "Em andamento", 2, Util.dataAtual(), Util.getDate("09/12/2018"), 
                Util.horaAtual(), new Time(16, 18, 0), 0, 0, 0, 0, 0, camioneta_carga, motorista);
        Usuario usuario = new Usuario("Administrador", "elvis", "Elvis150!", funcionario);

        Financeiro financeiro = new Financeiro(Util.dataAtual(), 900, "Aluguel do prédio", conta2, usuario);

        //Conta
        Fachada.getInstance().persistConta(conta);
        conta = Fachada.getInstance().getByNomeConta("Conta de luz");
        System.out.println("\n"+conta.toString()+"\n");
        conta.setNome("Água");
        Fachada.getInstance().mergeConta(conta);
        conta = Fachada.getInstance().getByNomeConta("Água");
        System.out.println("\n"+"Conta editada " + conta.toString()+"\n");
        System.out.println("\n\n\n");

        //Categoria
        Fachada.getInstance().persistCategoria(categoria);
        Fachada.getInstance().persistCategoria(categoria2);
        categoria = Fachada.getInstance().getAllCategoria().get(0);
        categoria2 = Fachada.getInstance().getAllCategoria().get(1);
        System.out.println("\n"+categoria.toString()+"\n");
        System.out.println("\n"+categoria2.toString()+"\n");
        categoria.setNome("Edit");
        Fachada.getInstance().mergeCategoria(categoria);
        categoria = Fachada.getInstance().getAllCategoria().get(0);
        categoria2 = Fachada.getInstance().getAllCategoria().get(1);
        System.out.println("\n"+"Categoria editada " + categoria.toString() + "\n");
        System.out.println("\n"+categoria2.toString() + "\n");

        System.out.println("\n\n\n");

        //Endereço
        Fachada.getInstance().persistEndereco(endereco);
        endereco = Fachada.getInstance().getLastEndereco();
        System.out.println("\n"+endereco.toString()+"\n");
        endereco.setBairro("Centro");
        Fachada.getInstance().mergeEndereco(endereco);
        System.out.println("\n"+endereco.toString()+"\n");
        System.out.println("\n\n\n");

        //Locadora
        Fachada.getInstance().persistLocadora(locadora);
        locadora = Fachada.getInstance().getLastIdLocadora();
        Fachada.getInstance().persistLocadora(locadora2);
        locadora2 = Fachada.getInstance().getLastIdLocadora();
        System.out.println("\n"+locadora.toString()+"\n");
        locadora.setCnpj("aaaa");
        Fachada.getInstance().mergeLocadora(locadora);
        locadora = Fachada.getInstance().getByIdLocadora(locadora.getId());
        System.out.println("\n"+locadora.toString()+"\n");
        System.out.println("\n\n\n");

        //CAmioneta de carga
        camioneta_carga.setCategoria(categoria2);
        camioneta_carga2.setCategoria(categoria2);
        camioneta_carga.setLocadora(locadora2);
        camioneta_carga2.setLocadora(locadora2);
        Fachada.getInstance().persistCamioneta_carga(camioneta_carga);
        camioneta_carga = Fachada.getInstance().getAllCamioneta_carga().get(0);
        System.out.println("\n"+camioneta_carga.toString()+"\n");
        Fachada.getInstance().persistCamioneta_carga(camioneta_carga2);
        camioneta_carga2 = Fachada.getInstance().getAllCamioneta_carga().get(1);
        camioneta_carga.setTipo_combuustivel("Diesel");
        camioneta_carga.setNum_portas(4);
        Fachada.getInstance().mergeCamioneta_carga(camioneta_carga);
        camioneta_carga = Fachada.getInstance().getAllCamioneta_carga().get(0);
        System.out.println("\n"+camioneta_carga2.toString()+"\n");
        System.out.println("\n\n\n");

        //Camioneta de passageiro
        Fachada.getInstance().persistCamioneta_passageiro(camioneta_passageiro);
        camioneta_passageiro = Fachada.getInstance().getAllCamioneta_passageiro().get(0);
        System.out.println("\n"+camioneta_passageiro.toString()+"\n");
        camioneta_passageiro.setDirecao_assistida(false);
        Fachada.getInstance().mergeCamioneta_passageiro(camioneta_passageiro);
        camioneta_passageiro = Fachada.getInstance().getAllCamioneta_passageiro().get(0);
        System.out.println("\n"+camioneta_passageiro.toString()+"\n");
        System.out.println("\n\n\n");

        //Pessoa_Fisica
        Fachada.getInstance().persistPessoa_Fisica(pessoa_Fisica);
        pessoa_Fisica = Fachada.getInstance().getAllPessoa_Fisica().get(0);
        System.out.println("\n"+pessoa_Fisica.toString()+"\n");
        pessoa_Fisica.setNome("Elvis Nogueira");
        Fachada.getInstance().mergePessoa_Fisica(pessoa_Fisica);
        pessoa_Fisica = Fachada.getInstance().getAllPessoa_Fisica().get(0);
        System.out.println("\n"+pessoa_Fisica.toString()+"\n");

        System.out.println("\n\n\n");

        //Pessoa_Juridica
        Fachada.getInstance().persistPessoa_Juridica(pessoa_Juridica);
        pessoa_Juridica = Fachada.getInstance().getAllPessoa_Juridica().get(0);
        System.out.println("\n"+pessoa_Juridica.toString()+"\n");
        pessoa_Juridica.setCnpj("YYYYY");
        Fachada.getInstance().mergePessoa_Juridica(pessoa_Juridica);
        pessoa_Juridica = Fachada.getInstance().getAllPessoa_Juridica().get(0);
        System.out.println("\n"+pessoa_Juridica.toString()+"\n");
        System.out.println("\n\n\n");

        //Motorista
        Fachada.getInstance().persistPessoa_Fisica(pessoa_Fisica);
        pessoa_Fisica = Fachada.getInstance().getAllPessoa_Fisica().get(0);
        motorista.setPessoa_Fisica(pessoa_Fisica);
        Fachada.getInstance().persistMotorista(motorista);
        motorista = Fachada.getInstance().getAllMotorista().get(0);
        System.out.println("\n"+motorista.toString()+"\n");
        motorista.setNum_habilitacao("12345678");
        Fachada.getInstance().mergeMotorista(motorista);
        motorista = Fachada.getInstance().getAllMotorista().get(0);
        System.out.println("\n"+motorista.toString()+"\n");
        System.out.println("\n\n\n");

        //Reserva
        reserva.setCategoria(categoria2);
        Fachada.getInstance().persistReserva(reserva);
        reserva = Fachada.getInstance().getAllReserva().get(0);
        System.out.println("\n"+reserva.toString()+"\n");
        reserva.setTipo_locacao("Controle");
        Fachada.getInstance().mergeReserva(reserva);
        reserva = Fachada.getInstance().getAllReserva().get(0);
        System.out.println("\n"+reserva.toString()+"\n");
        System.out.println("\n\n\n");

        //Locacao
        locacao.setVeiculo(camioneta_carga2);
        Fachada.getInstance().persistLocacao(locacao);
        locacao = Fachada.getInstance().getAllLocacao().get(0);
        System.out.println("\n"+locacao.toString()+"\n");
        locacao.setTipo_locacao("Controle");
        Fachada.getInstance().mergeLocacao(locacao);
        locacao = Fachada.getInstance().getAllLocacao().get(0);
        System.out.println("\n"+locacao.toString()+"\n");
        System.out.println("\n\n\n");

        //Usuario
        Fachada.getInstance().persistUsuario(usuario);
        usuario = Fachada.getInstance().getAllUsuario().get(0);
        System.out.println("\n"+usuario.toString()+"\n");
        usuario.setLogin("elvis150");
        Fachada.getInstance().mergeUsuario(usuario);
        System.out.println("\n"+usuario.toString()+"\n");
        usuario = Fachada.getInstance().getAllUsuario().get(0);
        System.out.println("\n"+usuario.toString()+"\n");
        Fachada.getInstance().loginUsuario("elvis150", "Elvis150!");
        System.out.println("\nUsuario Logado: "+Fachada.getUserLogado().getLogin()+"\nSenha:"
                +Fachada.getUserLogado().getSenha()+"\n");
        Fachada.getInstance().trocarSenha("Elvis1574!", "Elvis150!");
        System.out.println("\nNova senha: "+Fachada.getUserLogado().getSenha()+"\n");
        Fachada.getInstance().redefinirSenhaUsuario("elvis150");
        System.out.println("\nNova senha: "+Fachada.getUserLogado().getSenha()+"\n");
        System.out.println("\n\n\n");
        
        
        //Financeiro
        financeiro.setConta(conta);
        financeiro.setUsuario(Fachada.getUserLogado());
        Fachada.getInstance().persistFinanceiro(financeiro);
        financeiro = Fachada.getInstance().getAllFinanceiro().get(0);
        System.out.println("\n"+financeiro.toString()+"\n");
        financeiro.setObservacao("Editado");
        Fachada.getInstance().getAllFinanceiro().get(0);
        System.out.println("\n"+financeiro.toString()+"\n");
        System.out.println("\n\n\n");
        
        
        
        
        
//        Fachada.getInstance().removeReserva(reserva);  
//        Fachada.getInstance().removeLocacao(locacao);
//        Fachada.getInstance().removeCamioneta_carga(camioneta_carga);
//        Fachada.getInstance().removeByIdCamioneta_passageiro(camioneta_passageiro.getId());
//        Fachada.getInstance().removeFinanceiro(financeiro);
//        Fachada.getInstance().removeUsuario(usuario);
//        Fachada.getInstance().removeConta(conta);
//        Fachada.getInstance().removeMotorista(motorista);
//        Fachada.getInstance().removePessoa_Fisica(pessoa_Fisica);
//        Fachada.getInstance().removePessoa_Juridica(pessoa_Juridica);
//        
//        Fachada.getInstance().removeCategoria(categoria);
//        Fachada.getInstance().removeLocadora(locadora);
//        Fachada.getInstance().removeEndereco(endereco);
         */
//        Endereco endereco = new Endereco("Rua Manoel Ferraz", "DNER", "Floresta", "PE", "56400-000", "70");
//        Funcionario funcionario = new Funcionario("Berg", "(87)99612-2609", "113.000.434-74", Util.getDate("12/02/1997"),
//                endereco);
//        Usuario usuario = new Usuario("Administrador", "berg", "@Berg123", funcionario);
//        Fachada.getInstance().persistUsuario(usuario);
//        System.out.println("\n" + usuario.toString() + "\n");
//        usuario = Fachada.getInstance().getAllUsuario().get(0);
//        System.out.println("\n" + usuario.toString() + "\n");
//        usuario.setLogin("elvis150");
//        Fachada.getInstance().mergeUsuario(usuario);
//        System.out.println("\n" + usuario.toString() + "\n");
//        usuario = Fachada.getInstance().getAllUsuario().get(0);
//        System.out.println("\n" + usuario.toString() + "\n")berg
//        Fachada.getInstance().loginUsuario("berg", "Berg123@");
//        Fachada.getInstance().redefinirSenhaUsuario("berg");
//        System.out.println("\nUsuario Logado: " + Fachada.getUserLogado().getLogin() + "\nSenha:"
//                + Fachada.getUserLogado().getSenha() + "\n");
//        Fachada.getInstance().loginUsuario("berg", "berg");
//        System.out.println("\n------Usuario Logado: " + Fachada.getUserLogado().getLogin() + "\nSenha:"
//                + Fachada.getUserLogado().getSenha() + "\n");
//        Fachada.getInstance().trocarSenha("Berg123@", "@Berg123");
//        System.out.println("\n------Usuario Logado: " + Fachada.getUserLogado().getLogin() + "\nSenha:"
//                + Fachada.getUserLogado().getSenha() + "\n");
        
//        System.out.println("\nNova senha: " + Fachada.getUserLogado().getSenha() + "\n");
//        Fachada.getInstance().redefinirSenhaUsuario("elvis150");
//        System.out.println("\nNova senha: " + Fachada.getUserLogado().getSenha() + "\n");
//        System.out.println("\n\n\n");
        
    
    }
    
    
    

}
