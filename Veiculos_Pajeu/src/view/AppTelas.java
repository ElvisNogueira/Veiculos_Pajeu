/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.ArrayList;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import util.Util;

/**
 *
 * @author Elvis Nogueira
 */
public class AppTelas extends Application {
    
    private static Stage palco;
    Pane login, home, carrosHome, clientesHome, financeiroHome, funcionariosHome, cadCategoria;
    static Scene loginScene, homeScene, carrosHomeScene, clientesHomeScene, financeiroHomeScene,
            funcionariosHomeScene, cadCategoriaScene;
    private static ArrayList<String> telasAcessadas;
    private static int indice_tela_atual = -1;
    
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage stage) throws Exception {
        telasAcessadas = new ArrayList<String>();
        palco = stage;
        login = FXMLLoader.load(getClass().getResource("login.fxml"));
        home = FXMLLoader.load(getClass().getResource("home.fxml"));
        carrosHome = FXMLLoader.load(getClass().getResource("CarrosHome.fxml"));
        clientesHome = FXMLLoader.load(getClass().getResource("ClientesHome.fxml"));
        financeiroHome = FXMLLoader.load(getClass().getResource("FinanceiroHome.fxml"));
        funcionariosHome = FXMLLoader.load(getClass().getResource("FuncionariosHome.fxml"));
        cadCategoria = FXMLLoader.load(getClass().getResource("CadastrarCategoria.fxml"));
        
        loginScene = new Scene(login);
        homeScene = new Scene(home);
        carrosHomeScene = new Scene(carrosHome);
        clientesHomeScene = new Scene(clientesHome);
        financeiroHomeScene = new Scene(financeiroHome);
        funcionariosHomeScene = new Scene(funcionariosHome);
        cadCategoriaScene = new Scene(cadCategoria);
        
        stage.setScene(homeScene);
        palco.setTitle("Pajeú Veículos");
        Image e = new Image("imagens/logoIcone.png");
        palco.getIcons().add(e);
        palco.setResizable(false);
        palco.show();
        
        telasAcessadas.add(Util.TELA_HOME);
        indice_tela_atual++;
        
    }
    
    public static void trocarTela(String tela, int tipo) {
        if (!tela.equals(telasAcessadas.get(indice_tela_atual))) {
            if (tela.equals(Util.TELA_HOME))
                palco.setScene(homeScene);
            else if (tela.equals(Util.TELA_CARROS_HOME))
                palco.setScene(carrosHomeScene);
            else if (tela.equals(Util.TELA_LOGIN))
                palco.setScene(loginScene);
            else if (tela.equals(Util.TELA_CLIENTES_HOME))
                palco.setScene(clientesHomeScene);
            else if (tela.equals(Util.TELA_FINANCEIRO_HOME))
                palco.setScene(financeiroHomeScene);
            else if (tela.equals(Util.TELA_FUNCIONARIOS_HOME))
                palco.setScene(funcionariosHomeScene);
            else if (tela.equals(Util.TELA_CADASTRAR_CATEGORIA))
                palco.setScene(cadCategoriaScene);
            if(tipo == Util.ABRIR){
               if(!telasAcessadas.get(telasAcessadas.size()-1).equals(tela)){
                   telasAcessadas.add(tela);
               }               
               indice_tela_atual = telasAcessadas.size() - 1; 
            }else if (tipo == Util.VOLTAR)
                indice_tela_atual--;
            else
                indice_tela_atual++;
            
        }
    }
    
    public static void proximo() {
        if (telasAcessadas.size()-1 > (indice_tela_atual)) {
            trocarTela(telasAcessadas.get(indice_tela_atual + 1),Util.IR);
//            indice_tela_atual++;
        }
    }
    
    public static void voltar() {
        if (indice_tela_atual > 0) {
            trocarTela(telasAcessadas.get(indice_tela_atual - 1),Util.VOLTAR);
        }else
            System.out.println("view.AppTelas.voltar()");
        
    }
    
    public static int getIndice_tela_atual() {
        return indice_tela_atual;
    }
    
    public static void setIndice_tela_atual(int indice_tela_atual) {
        AppTelas.indice_tela_atual = indice_tela_atual;
    }
    
    public static ArrayList<String> getTelasAcessadas() {
        return telasAcessadas;
    }
    
    public static void setTelasAcessadas(ArrayList<String> telasAcessadas) {
        AppTelas.telasAcessadas = telasAcessadas;
    }
    
}
