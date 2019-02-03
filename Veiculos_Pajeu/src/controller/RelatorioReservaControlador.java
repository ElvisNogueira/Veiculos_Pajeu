package controller;

import fachada.Fachada;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import model.Reserva;
import util.Util;
import app.App;

public class RelatorioReservaControlador implements Initializable{

    @FXML
    private ImageView homeButton;

    @FXML
    private ImageView voltarButton;

    @FXML
    private ImageView irButton;

    @FXML
    private TableView<Reserva> reservaTable;
    
    @FXML
    private TableColumn<Reserva, Integer> idColuna;

    @FXML
    private TableColumn<Reserva, String> nomeClienteColuna;

    @FXML
    private TableColumn<Reserva, Date> dataRetiradaColuna;

    
    
    @FXML
    private ImageView pesquisarButton;

    @FXML
    private ImageView atualizarBuutton;

    @FXML
    private DatePicker dataInicio;

    @FXML
    private DatePicker dataFim;

    

    @FXML
    void atualizarBuuttonClicked(MouseEvent event) {
        inicializarTabela();
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

    @FXML
    void pesquisarButtonClicked(MouseEvent event) {
        inicializarTabela();
    }


    @FXML
    void reservaTableClicked(MouseEvent event) {

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
        String d1 = dataInicio.toString();
        String d2 = dataFim.toString();
        if((!d1.isEmpty()) && (!d2.isEmpty())){
            Date inicio = Util.getDate(d1);
            Date fim = Util.getDate(d2);
            return FXCollections.observableArrayList(Fachada.getInstance().getDataReservas(inicio, fim));
        }
        return FXCollections.observableArrayList(Fachada.getInstance().getAllReserva());
    }

}
