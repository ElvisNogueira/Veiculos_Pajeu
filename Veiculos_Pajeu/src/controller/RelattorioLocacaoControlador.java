/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import app.App;
import java.sql.Date;
import java.util.ArrayList;
import model.Relatorio_locacao;

/**
 *
 * @author Elvis Nogueira
 */
public class RelattorioLocacaoControlador implements Initializable {

    @FXML
    private ImageView homeButton;

    @FXML
    private ImageView voltarButton;

    @FXML
    private ImageView irButton;

    @FXML
    private TableView<Relatorio_locacao> locacaoTable;

    @FXML
    private TableColumn<Relatorio_locacao, String> nomeColuna;

    @FXML
    private TableColumn<Relatorio_locacao, Date> dataRetiradaColuna;

    @FXML
    private TableColumn<Relatorio_locacao, String> modeloColuna;

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
    void locacaoTableClicked(MouseEvent event) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        inicializarTabela();
    }

    public void inicializarTabela() {
        dataRetiradaColuna.setCellValueFactory(new PropertyValueFactory("data_retirada"));
        modeloColuna.setCellValueFactory(new PropertyValueFactory("modelo"));
        nomeColuna.setCellValueFactory(new PropertyValueFactory("nome"));
        carregarTabela();
    }

    private ObservableList carregarTabela() {
        ArrayList<Relatorio_locacao> aux = Fachada.getInstance().getAllRelatorio_locacao();
        ArrayList<Relatorio_locacao> relatorio_locacaos = new ArrayList<>();

        if (buscaField.getText().toLowerCase().isEmpty()) {
            if (dataInicio.getEditor().getText().isEmpty() && dataFim.getEditor().getText().isEmpty()) {
                relatorio_locacaos = aux;
            } else {
                Date d1 = new Date(dataInicio.getValue().getYear() - 1900, dataInicio.getValue().getMonthValue() - 1,
                        dataInicio.getValue().getDayOfMonth());
                Date d2 = new Date(dataFim.getValue().getYear() - 1900, dataFim.getValue().getMonthValue() - 1,
                        dataFim.getValue().getDayOfMonth());

                for (Relatorio_locacao f : Fachada.getInstance().getAllRelatorio_locacao()) {
                    if (f.getData_retirada().before(d2) && f.getData_retirada().after(d1)) {
                        relatorio_locacaos.add(f);
                    }
                }
            }
        } else {
            if (dataInicio.getEditor().getText().isEmpty() && dataFim.getEditor().getText().isEmpty()) {
                for (Relatorio_locacao f : aux) {
                    if (f.getNome().toLowerCase().contains(buscaField.getText().toLowerCase())) {
                        relatorio_locacaos.add(f);
                    }
                }
                relatorio_locacaos = aux;
            } else {
                Date d1 = new Date(dataInicio.getValue().getYear() - 1900, dataInicio.getValue().getMonthValue() - 1,
                        dataInicio.getValue().getDayOfMonth());
                Date d2 = new Date(dataFim.getValue().getYear() - 1900, dataFim.getValue().getMonthValue() - 1,
                        dataFim.getValue().getDayOfMonth());

                for (Relatorio_locacao f : aux) {
                    if ((f.getData_retirada().before(d2) && f.getData_retirada().after(d1))
                            && (f.getNome().toLowerCase().contains(buscaField.getText().toLowerCase()))) {
                        relatorio_locacaos.add(f);
                    }
                }
            }

            return FXCollections.observableArrayList(relatorio_locacaos);
        }
        return null;
    }
}
