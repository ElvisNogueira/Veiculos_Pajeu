package controller;

import fachada.Fachada;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import model.Cliente;
import util.Util;
import app.App;
import java.util.ArrayList;
import javafx.scene.control.ComboBox;
import model.Pessoa_Fisica;
import model.Pessoa_Juridica;

public class RelatorioClienteControlador implements Initializable{
    Cliente cliente = new Cliente();;

    @FXML
    private ImageView voltarButton;

    @FXML
    private ImageView irButton;

    @FXML
    private ImageView homeButton;

    @FXML
    private TableView<Cliente> tabela;

    @FXML
    private ImageView atualizarButton;

    @FXML
    private Button cadastrarButton;

    @FXML
    private Button editarButton;

    @FXML
    private Button excluirButton;

    @FXML
    private ImageView buscarButton;

    @FXML
    private Button sairButton;
    
    @FXML
    private TableColumn<Cliente, Integer > idColumn;

    @FXML
    private TableColumn<Cliente, String> nomeColumn;
    
    @FXML
    private ComboBox<String> comboBox;

    @FXML
    void atualizarButtonClicked(MouseEvent event) {
        comboBox.getSelectionModel().select(0);
        inicializarTabela();
    }

    @FXML
    void atualizarButtonEntered(MouseEvent event) {
        atualizarButton.setCursor(Cursor.HAND);
    }

    @FXML
    void atualizarButtonExited(MouseEvent event) {
        atualizarButton.setCursor(Cursor.DEFAULT);
    }

    @FXML
    void buscaFieldPressed(KeyEvent event) {
        inicializarTabela();
    }

    @FXML
    void buscarButtonClicked(MouseEvent event) {
        inicializarTabela();
    }

    @FXML
    void buscarButtonEntered(MouseEvent event) {
        buscarButton.setCursor(Cursor.HAND);
    }

    @FXML
    void buscarButtonExited(MouseEvent event) {
        buscarButton.setCursor(Cursor.DEFAULT);
    }

    @FXML
    void cadastrarButtonAction(ActionEvent event) {
        App.trocarTela(Util.TELA_CAD_CLIENTE, Util.ABRIR);
    }

    @FXML
    void editarButtonAction(ActionEvent event) {
        cliente = tabela.getSelectionModel().getSelectedItem();
        CadastroClienteControlador.get().setCliente(cliente);
        App.trocarTela(Util.TELA_CAD_CLIENTE, Util.ABRIR);
    }
    
    @FXML
    void excluirButtonAction(ActionEvent event) {
        Fachada.getInstance().removeCliente(tabela.getSelectionModel().getSelectedItem());
        inicializarTabela();
    }

    @FXML
    void sairButtonAction(ActionEvent event) {
        App.voltar();
    }

    @FXML
    void tabelaClicked(MouseEvent event) {
        if(event.getClickCount()==2){
            
            CadastroClienteControlador.get().bloquearCampos(tabela.getSelectionModel().getSelectedItem());
            App.trocarTela(Util.TELA_CAD_CLIENTE, Util.ABRIR);
        }
    }

    @FXML
    void voltarButtonClicked(MouseEvent event) {
        App.voltar();
    }

    @FXML
    void voltarButtonEntered(MouseEvent event) {
        voltarButton.setCursor(Cursor.HAND);
    }

    @FXML
    void voltarButtonExited(MouseEvent event) {
        voltarButton.setCursor(Cursor.DEFAULT);
    }

    @FXML
    void homeButtonClicked(MouseEvent event) {
        App.trocarTela(Util.TELA_HOME, Util.ABRIR);
    }

    @FXML
    void homeButtonEntered(MouseEvent event) {
        homeButton.setCursor(Cursor.HAND);
    }

    @FXML
    void homeButtonExited(MouseEvent event) {
        homeButton.setCursor(Cursor.DEFAULT);
    }

    @FXML
    void irButtonClicled(MouseEvent event) {
        App.proximo();
    }

    @FXML
    void irButtonEntered(MouseEvent event) {
        irButton.setCursor(Cursor.HAND);
    }

    @FXML
    void irButtonExited(MouseEvent event) {
        irButton.setCursor(Cursor.DEFAULT);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        comboBox.getItems().addAll("Pessoa Física","Pessoa Jurídica");
        inicializarTabela();        
    }
    
    public void inicializarTabela(){
        idColumn.setCellValueFactory(new PropertyValueFactory("id"));
        nomeColumn.setCellValueFactory(new PropertyValueFactory("nome"));
        
        tabela.setItems(carregarTabela());
    }
    
    public ObservableList carregarTabela(){
//        ArrayList<Pessoa_Fisica> pf = new ArrayList<>();
//        ArrayList<Pessoa_Juridica> pj = new ArrayList<>();
        ArrayList<Cliente> c = new ArrayList<>();
        
        if(comboBox.getSelectionModel().getSelectedIndex()==0){
            for(Pessoa_Fisica pf : Fachada.getInstance().getAllPessoa_Fisica())
                c.add(pf);
        }else if(comboBox.getSelectionModel().getSelectedIndex()==1){
            for(Pessoa_Juridica pj : Fachada.getInstance().getAllPessoa_Juridica())
                c.add(pj);
        }else{
            c = Fachada.getInstance().getAllCliente();
        }
        
        return FXCollections.observableList(c);
    }
    
    
    
    

}
