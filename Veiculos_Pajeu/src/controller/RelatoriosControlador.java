package controller;

import app.App;
import fachada.Fachada;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import util.Util;

public class RelatoriosControlador {

    @FXML
    private ImageView homeButton;

    @FXML
    private ImageView voltarButton;

    @FXML
    private ImageView irButton;

    @FXML
    private Button clientes;

    @FXML
    private Button reservas;

    @FXML
    private Button locacao;

    @FXML
    private Button ffinanceiro;

    @FXML
    private Button logs;

    @FXML
    void clientes(ActionEvent event) {
        App.trocarTela(Util.TELA_RELATTORIO_CLIENTES, Util.ABRIR);
    }

    @FXML
    void ffinanceiroAciton(ActionEvent event) {
        if(Fachada.getUserLogado().getTipo().equals("Administrador"))
            App.trocarTela(Util.TELA_RELATORIO_FINANCEIRO, Util.ABRIR);
        else
            App.mostrarAlert(Util.ERRO_LOGIN, "Acesso negado!");
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
    void locacaoAction(ActionEvent event) {
        App.trocarTela(Util.TELA_RELATORIO_LOCACAO, Util.ABRIR);
    }

    @FXML
    void logsAction(ActionEvent event) {

    }

    @FXML
    void reservasAction(ActionEvent event) {
        App.trocarTela(Util.TELA_RELATORIO_RESERVA, Util.ABRIR);
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

}
