package controller;

import fachada.Fachada;
import java.net.URL;
import java.sql.Date;
import java.util.Observable;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
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
import model.Reserva;
import util.Util;
import view.AppTelas;

public class ReservaControlador implements Initializable{

    @FXML
    private ImageView homeButton;

    @FXML
    private ImageView voltarButton;

    @FXML
    private ImageView irButton;

    @FXML
    private Button novoButton;

    @FXML
    private TableView<Reserva> reservaTable;
    
    @FXML
    private TableColumn<Reserva, Integer> idColuna;

    @FXML
    private TableColumn<Reserva, String> nomeClienteColuna;

    @FXML
    private TableColumn<Reserva, Date> dataRetiradaColuna;


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
    private Button realizarReserva;

    @FXML
    void atualizarBuuttonClicked(MouseEvent event) {
        
    }

    @FXML
    void atualizarBuuttonEntered(MouseEvent event) {
        atualizarBuutton.setCursor(Cursor.HAND);
    }

    @FXML
    void atualizarBuuttonExited(MouseEvent event) {
        atualizarBuutton.setCursor(Cursor.DEFAULT);
    }

    @FXML
    void buscaFielKeyReleased(KeyEvent event) {

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
        novoButton.setCursor(Cursor.HAND);
    }

    @FXML
    void novoButtonExited(MouseEvent event) {
        novoButton.setCursor(Cursor.DEFAULT);
    }

    @FXML
    void pesquisarButtonClicked(MouseEvent event) {

    }

    @FXML
    void pesquisarButtonEntered(MouseEvent event) {
        pesquisarButton.setCursor(Cursor.HAND);
    }

    @FXML
    void pesquisarButtonExited(MouseEvent event) {
        pesquisarButton.setCursor(Cursor.DEFAULT);
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
    void realizarReservaAction(ActionEvent event) {

    }

    @FXML
    void realizarReservaEntered(MouseEvent event) {
        realizarReserva.setCursor(Cursor.HAND);
    }

    @FXML
    void realizarReservaExited(MouseEvent event) {
        realizarReserva.setCursor(Cursor.DEFAULT);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        inicializarTabela();
    }
    
    private void inicializarTabela(){
        dataRetiradaColuna.setCellValueFactory(new PropertyValueFactory("data_retirada"));
        nomeClienteColuna.setCellValueFactory(new PropertyValueFactory("nome"));
        idColuna.setCellValueFactory(new PropertyValueFactory("id"));
        
        reservaTable.setItems(carregarTabela());
    }
    
    private ObservableList carregarTabela(){
        return FXCollections.observableArrayList(Fachada.getInstance().getAllReserva());
    }

}
