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
import view.AppTelas;

public class ClientesHomeControlador implements Initializable{
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
    private TextField buscaField;

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
    void atualizarButtonClicked(MouseEvent event) {
        buscaField.setText("");
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
        AppTelas.trocarTela(Util.TELA_CAD_CLIENTE, Util.ABRIR);
    }

    @FXML
    void editarButtonAction(ActionEvent event) {
        cliente = tabela.getSelectionModel().getSelectedItem();
        CadastroClienteControlador.get().setCliente(cliente);
        AppTelas.trocarTela(Util.TELA_CAD_CLIENTE, Util.ABRIR);
    }
    
    @FXML
    void excluirButtonAction(ActionEvent event) {
        Fachada.getInstance().removeCliente(tabela.getSelectionModel().getSelectedItem());
        inicializarTabela();
    }

    @FXML
    void sairButtonAction(ActionEvent event) {
        AppTelas.voltar();
    }

    @FXML
    void tabelaClicked(MouseEvent event) {
        if(event.getClickCount()==2){
            
            CadastroClienteControlador.get().bloquearCampos(tabela.getSelectionModel().getSelectedItem());
            AppTelas.trocarTela(Util.TELA_CAD_CLIENTE, Util.ABRIR);
        }
    }

    @FXML
    void voltarButtonClicked(MouseEvent event) {
        AppTelas.voltar();
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
        AppTelas.trocarTela(Util.TELA_HOME, Util.ABRIR);
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
        AppTelas.proximo();
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
        
        inicializarTabela();
        
    }
    
    public void inicializarTabela(){
        idColumn.setCellValueFactory(new PropertyValueFactory("id"));
        nomeColumn.setCellValueFactory(new PropertyValueFactory("nome"));
        
        tabela.setItems(carregarTabela());
    }
    
    public ObservableList carregarTabela(){
        return FXCollections.observableList(Fachada.getInstance().getBuscaCliente(buscaField.getText()));
    }
    
    
    
    

}
