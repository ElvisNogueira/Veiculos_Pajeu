package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import model.Locacao;
import model.Reserva;
import util.Util;
import view.AppTelas;

public class LocacaoControlador implements Initializable{

    @FXML
    private ImageView homeButton;

    @FXML
    private ImageView voltarButton;

    @FXML
    private ImageView irButton;

    @FXML
    private Button novoButton;

    @FXML
    private TableView<Locacao> locacaoTable;
    
    @FXML
    private TableColumn<Locacao, Integer> idColuna;

    @FXML
    private TableColumn<Locacao, String> nomeColuna;

    @FXML
    private TableColumn<Locacao, String> placaColuna;

    @FXML
    private TableColumn<Locacao, String> tipoLocacaoColuna;

    @FXML
    private Button editarButton;

    @FXML
    private Button excluirButton;

    @FXML
    private TextField buscaField;

    @FXML
    private ImageView pesquisarButton;

    @FXML
    private ImageView atualizarBuutton;

    @FXML
    private DatePicker dataInicio;

    @FXML
    private DatePicker dataFim;

    @FXML
    private Button devolverVeiculo;

    @FXML
    void atualizarBuuttonClicked(MouseEvent event) {
        
    }

    @FXML
    void atualizarBuuttonEntered(MouseEvent event) {

    }

    @FXML
    void atualizarBuuttonExited(MouseEvent event) {

    }

    @FXML
    void buscaFielKeyReleased(KeyEvent event) {

    }

    @FXML
    void devolverVeiculoAction(ActionEvent event) {

    }

    @FXML
    void devolverVeiculoEntered(MouseEvent event) {

    }

    @FXML
    void devolverVeiculoExited(MouseEvent event) {

    }

    @FXML
    void editarButtonAction(ActionEvent event) {

    }

    @FXML
    void editarButtonPressed(KeyEvent event) {

    }

    @FXML
    void editarButtonReleased(KeyEvent event) {

    }

    @FXML
    void excluirButtonAction(ActionEvent event) {

    }

    @FXML
    void excluirButtonClicked(MouseEvent event) {

    }

    @FXML
    void excluirButtonEntered(MouseEvent event) {

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

    @FXML
    void novoButtonAction(ActionEvent event) {

    }

    @FXML
    void novoButtonEntered(MouseEvent event) {

    }

    @FXML
    void novoButtonExited(MouseEvent event) {

    }

    @FXML
    void pesquisarButtonClicked(MouseEvent event) {

    }

    @FXML
    void pesquisarButtonEntered(MouseEvent event) {

    }

    @FXML
    void pesquisarButtonExited(MouseEvent event) {

    }

    @FXML
    void reservaTableClicked(MouseEvent event) {

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
    void locacaoTableClicked(MouseEvent event) {
        
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }

    public void inicializarTabela(){
        idColuna.setCellValueFactory(new PropertyValueFactory("id"));
        nomeColuna.setCellValueFactory(new PropertyValueFactory(""));
        placaColuna.setCellValueFactory(new PropertyValueFactory("placa"));
        tipoLocacaoColuna.setCellValueFactory(new PropertyValueFactory("tipo_locacao"));
    }
    
    private ObservableList carregarTabela(){
        
    }
}
