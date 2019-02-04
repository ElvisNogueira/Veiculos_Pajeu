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
import java.util.ArrayList;
import model.Relatorio_reserva;

public class RelatorioReservaControlador implements Initializable {

    @FXML
    private ImageView homeButton;

    @FXML
    private ImageView voltarButton;

    @FXML
    private ImageView irButton;

    @FXML
    private TableView<Relatorio_reserva> reservaTable;

    @FXML
    private TableColumn<Relatorio_reserva, String> nomeCliente;

    @FXML
    private TableColumn<Relatorio_reserva, String> modelo;

    @FXML
    private TableColumn<Relatorio_reserva, Date> dataRetiradaColuna;

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

    private void inicializarTabela() {
        dataRetiradaColuna.setCellValueFactory(new PropertyValueFactory("data_retirada"));
        modelo.setCellValueFactory(new PropertyValueFactory("nome"));
        nomeCliente.setCellValueFactory(new PropertyValueFactory("nome_cliente"));

        reservaTable.setItems(carregarTabela());
    }

    private ObservableList carregarTabela() {
        ArrayList<Relatorio_reserva> aux = Fachada.getInstance().getAllRelatorio_reserva();
        ArrayList<Relatorio_reserva> relatorio_reservas = new ArrayList<>();
        if (dataInicio.getEditor().getText().isEmpty() && dataFim.getEditor().getText().isEmpty()) {
            relatorio_reservas = aux;
            System.err.println("Aqui");
        } else {
            Date d1 = new Date(dataInicio.getValue().getYear() - 1900, dataInicio.getValue().getMonthValue() - 1,
                    dataInicio.getValue().getDayOfMonth());
            Date d2 = new Date(dataFim.getValue().getYear() - 1900, dataFim.getValue().getMonthValue() - 1,
                    dataFim.getValue().getDayOfMonth());

            for (Relatorio_reserva f : aux) {
                if (f.getData_retirada().before(d2) && f.getData_retirada().after(d1)) {
                    relatorio_reservas.add(f);
                }
            }
        }
        return FXCollections.observableArrayList(relatorio_reservas);
    }

}
