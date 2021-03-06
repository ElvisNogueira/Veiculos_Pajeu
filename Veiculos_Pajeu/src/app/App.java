/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import Threads.Rotinas;
import fachada.Fachada;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import model.Endereco;
import model.Funcionario;
import model.Usuario;
import util.Util;

/**
 *
 * @author Elvis Nogueira
 */
public class App extends Application {

    private static Stage palco;
    Pane login, home, carrosHome, clientesHome, financeiroHome, funcionariosHome, cadCategoria, carrosCad,
            cadFuncionario, cadCarro, reserva, locacao, cadLocacao, cadReserva, cadCliente, cadFinanceiro,
            relatorioFinanceiro, cadLocadora, configuracoes, categoria, cadConta, alertaBackup, cadMotorista,
            relatorios, relatorioClientes, relatorioReserva, relaorioLocacao;
    static Scene loginScene, homeScene, carrosHomeScene, clientesHomeScene, financeiroHomeScene,
            funcionariosHomeScene, cadCategoriaScene, carrosCadScene, cadFuncionarioScene, cadCarroScene,
            reservaScene, locacaoScene, cadLocacaoScene, cadReservaScene, cadClienteScene, cadFinanceiroScene,
            relatorioFinanceiroScene, cadLocadoraScene, configuracoesScene, categoriaScene, cadContaScene,
            alertaBackupScene, cadMotoristaScene, relatoriosScene, relatorioClientesScene, relatorioReservaScene,
            relaorioLocacaoScene;

    private static ArrayList<String> telasAcessadas;
    private static int indice_tela_atual = -1;
    private static Alert alert = new Alert(Alert.AlertType.ERROR);

    public static void main(String[] args) {
        
        launch(args);

    }

    @Override
    public void start(Stage stage) throws Exception {
        telasAcessadas = new ArrayList<String>();

        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent t) {
                t.consume();

                // Coloque aqui o código a ser executado ao fechar o sistema.
                stage.close();
                Platform.exit();
                System.exit(0);
            }
        });

        palco = stage;

        login = FXMLLoader.load(getClass().getResource("/view/login.fxml"));
        home = FXMLLoader.load(getClass().getResource("/view/home.fxml"));
        carrosHome = FXMLLoader.load(getClass().getResource("/view/CarrosHome.fxml"));
        clientesHome = FXMLLoader.load(getClass().getResource("/view/ClientesHome.fxml"));
        financeiroHome = FXMLLoader.load(getClass().getResource("/view/FinanceiroHome.fxml"));
        funcionariosHome = FXMLLoader.load(getClass().getResource("/view/FuncionariosHome.fxml"));
        cadCategoria = FXMLLoader.load(getClass().getResource("/view/CadastrarCategoria.fxml"));
        carrosCad = FXMLLoader.load(getClass().getResource("/view/CarrosCadastrados.fxml"));
        cadFuncionario = FXMLLoader.load(getClass().getResource("/view/CadastroFuncionario.fxml"));
        cadCarro = FXMLLoader.load(getClass().getResource("/view/CadastroVeiculo.fxml"));
        reserva = FXMLLoader.load(getClass().getResource("/view/Reserva.fxml"));
        locacao = FXMLLoader.load(getClass().getResource("/view/Locacao.fxml"));
        cadLocacao = FXMLLoader.load(getClass().getResource("/view/CadastroLocacao.fxml"));
        cadReserva = FXMLLoader.load(getClass().getResource("/view/CadastroReserva.fxml"));
        cadCliente = FXMLLoader.load(getClass().getResource("/view/CadastroCliente.fxml"));
        cadFinanceiro = FXMLLoader.load(getClass().getResource("/view/CadastrarFinanceiro.fxml"));
        relatorioFinanceiro = FXMLLoader.load(getClass().getResource("/view/RelatorioFinanceiro.fxml"));
        cadLocadora = FXMLLoader.load(getClass().getResource("/view/CadastroLocadora.fxml"));
        configuracoes = FXMLLoader.load(getClass().getResource("/view/Configuracoes.fxml"));
        categoria = FXMLLoader.load(getClass().getResource("/view/Categoia.fxml"));
        cadConta = FXMLLoader.load(getClass().getResource("/view/CadastrarConta.fxml"));
//        alertaBackup = FXMLLoader.load(getClass().getResource("AlertaBackup.fxml"));
        cadMotorista = FXMLLoader.load(getClass().getResource("/view/CadastroMotorista.fxml"));
        relatorios = FXMLLoader.load(getClass().getResource("/view/Relatorios.fxml"));
        relatorioClientes = FXMLLoader.load(getClass().getResource("/view/RelatorioClientes.fxml"));
        relatorioReserva = FXMLLoader.load(getClass().getResource("/view/RelatorioReserva.fxml"));
        relaorioLocacao = FXMLLoader.load(getClass().getResource("/view/RelatorioLocacoes.fxml"));

        loginScene = new Scene(login);
        homeScene = new Scene(home);
        carrosHomeScene = new Scene(carrosHome);
        clientesHomeScene = new Scene(clientesHome);
        financeiroHomeScene = new Scene(financeiroHome);
        funcionariosHomeScene = new Scene(funcionariosHome);
        cadCategoriaScene = new Scene(cadCategoria);
        carrosCadScene = new Scene(carrosCad);
        cadFuncionarioScene = new Scene(cadFuncionario);
        cadCarroScene = new Scene(cadCarro);
        reservaScene = new Scene(reserva);
        locacaoScene = new Scene(locacao);
        cadLocacaoScene = new Scene(cadLocacao);
        cadReservaScene = new Scene(cadReserva);
        cadClienteScene = new Scene(cadCliente);
        cadFinanceiroScene = new Scene(cadFinanceiro);
        relatorioFinanceiroScene = new Scene(relatorioFinanceiro);
        cadLocadoraScene = new Scene(cadLocadora);
        configuracoesScene = new Scene(configuracoes);
        categoriaScene = new Scene(categoria);
        cadContaScene = new Scene(cadConta);
        cadMotoristaScene = new Scene(cadMotorista);
//        alertaBackupScene = new Scene(alertaBackup);
        relatoriosScene = new Scene(relatorios);
        relatorioClientesScene = new Scene(relatorioClientes);
        relatorioReservaScene = new Scene(relatorioReserva);
        relaorioLocacaoScene = new Scene(relaorioLocacao);

        stage.setScene(loginScene);
        palco.setTitle("Pajeú Veículos");
        Image e = new Image("imagens/logoIcone.png");
        palco.getIcons().add(e);
        palco.setResizable(false);
        palco.show();
        
//        if (Fachada.getInstance().getAllUsuario().size() == 0) {
//            Endereco endereco = new Endereco("Rua Manoel Ferraz", "DNER", "Floresta", "PE", "56400-000", "70");
//            Funcionario funcionario = new Funcionario("Elvis", "(87)99612-2609", "113.000.434-74", Util.getDate("1997/12/02"),
//                    endereco);
//            Usuario usuario = new Usuario("Administrador", "admin1", "admin1", funcionario);
//            Fachada.getInstance().persistUsuario(usuario);
//        }else{
//            System.err.println("Não entrou");
//        }

        telasAcessadas.add(Util.TELA_LOGIN);
        indice_tela_atual++;
//        Rotinas rotinas = new Rotinas();
//        rotinas.start();

    }

    public static void trocarTela(String tela, int tipo) {

        if (!tela.equals(telasAcessadas.get(indice_tela_atual))) {
            System.err.println(tela);
            if (tela.equals(Util.TELA_HOME)) {
                palco.setScene(homeScene);
            } else if (tela.equals(Util.TELA_CARROS_HOME)) {
                palco.setScene(carrosHomeScene);
            } else if (tela.equals(Util.TELA_LOGIN)) {
                palco.setScene(loginScene);
            } else if (tela.equals(Util.TELA_CLIENTES_HOME)) {
                palco.setScene(clientesHomeScene);
            } else if (tela.equals(Util.TELA_FINANCEIRO_HOME)) {
                palco.setScene(financeiroHomeScene);
            } else if (tela.equals(Util.TELA_FUNCIONARIOS_HOME)) {
                palco.setScene(funcionariosHomeScene);
            } else if (tela.equals(Util.TELA_CADASTRAR_CATEGORIA)) {
                palco.setScene(cadCategoriaScene);
            } else if (tela.equals(Util.TELA_CARROS_CADASTRADOS)) {
                palco.setScene(carrosCadScene);
            } else if (tela.equals(Util.TELA_CAD_FUNCIONARIO)) {
                palco.setScene(cadFuncionarioScene);
            } else if (tela.equals(Util.TELA_CAD_CARRO)) {
                palco.setScene(cadCarroScene);
            } else if (tela.equals(Util.TELA_RESERVA)) {
                palco.setScene(reservaScene);
            } else if (tela.equals(Util.TELA_LOCACAO)) {
                palco.setScene(locacaoScene);
            } else if (tela.equals(Util.TELA_CAD_LOCACAO)) {
                palco.setScene(cadLocacaoScene);
            } else if (tela.equals(Util.TELA_CAD_RESERVA)) {
                palco.setScene(cadReservaScene);
            } else if (tela.equals(Util.TELA_CAD_CLIENTE)) {
                palco.setScene(cadClienteScene);
            } else if (tela.equals(Util.TELA_CAD_FINANCEIRO)) {
                palco.setScene(cadFinanceiroScene);
            } else if (tela.equals(Util.TELA_RELATORIO_FINANCEIRO)) {
                palco.setScene(relatorioFinanceiroScene);
            } else if (Util.TELA_CONFIGURACOES.equals(tela)) {
                palco.setScene(configuracoesScene);
            } else if (tela.equals(Util.TELA_CADASTRAR_CATEGORIA)) {
                palco.setScene(cadLocadoraScene);
            } else if (tela.equals(Util.TELA_CADASTRAR_CATEGORIA)) {
                palco.setScene(categoriaScene);
            } else if (tela.equals(Util.TELA_CAD_CONTA)) {
                palco.setScene(cadContaScene);
            } else if (tela.equals(Util.TELA_CATEGORIA)) {
                palco.setScene(categoriaScene);
            } else if (tela.equals(Util.TELA_CAD_LOCADORA)) {
                palco.setScene(cadLocadoraScene);
            } //            else if(tela.equals(Util.TELA_ALERTA_BACKUP))
            //                palco.setScene(alertaBackupScene);
            else if (tela.equals(Util.TELA_CAD_MOTORISTA)) {
                palco.setScene(cadMotoristaScene);
            } else if (Util.TELA_RELATORIOS.equals(tela)) {
                palco.setScene(relatoriosScene);
            } else if (Util.TELA_RELATTORIO_CLIENTES.equals(tela)) {
                palco.setScene(relatorioClientesScene);
            } else if (Util.TELA_RELATORIO_RESERVA.equals(tela)) {
                palco.setScene(relatorioReservaScene);
            } else if (Util.TELA_RELATORIO_LOCACAO.equals(tela)) {
                palco.setScene(relaorioLocacaoScene);
            }

            if (tipo == Util.ABRIR) {
                if (!telasAcessadas.get(telasAcessadas.size() - 1).equals(tela)) {
                    telasAcessadas.add(tela);
                }
                indice_tela_atual = telasAcessadas.size() - 1;
            } else if (tipo == Util.VOLTAR) {
                indice_tela_atual--;
            } else {
                indice_tela_atual++;
            }

        }
    }

    public static void proximo() {
        if (telasAcessadas.size() - 1 > (indice_tela_atual)) {
            trocarTela(telasAcessadas.get(indice_tela_atual + 1), Util.IR);
//            indice_tela_atual++;
        }
    }

    public static void voltar() {
        if (indice_tela_atual > 0) {
            trocarTela(telasAcessadas.get(indice_tela_atual - 1), Util.VOLTAR);
        } else {
            System.out.println("view.AppTelas.voltar()");
        }

    }

    public static void mostrarAlert(int tipo, String texto) {
        switch (tipo) {
            case 0:
                alert.setAlertType(Alert.AlertType.ERROR);
                alert.setTitle("ERRO");
                alert.setContentText(texto);
                alert.show();
                break;
            case 1:
                alert.setAlertType(Alert.AlertType.ERROR);
                alert.setTitle("ERRO");
                alert.setContentText(texto);
                alert.show();
                break;
            case 2:
                alert.setAlertType(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Sucesso");
                alert.setContentText(texto);
                alert.show();
                break;

        }

    }

    public static int getIndice_tela_atual() {
        return indice_tela_atual;
    }

    public static void setIndice_tela_atual(int indice_tela_atual) {
        App.indice_tela_atual = indice_tela_atual;
    }

    public static ArrayList<String> getTelasAcessadas() {
        return telasAcessadas;
    }

    public static void setTelasAcessadas(ArrayList<String> telasAcessadas) {
        App.telasAcessadas = telasAcessadas;
    }

}
