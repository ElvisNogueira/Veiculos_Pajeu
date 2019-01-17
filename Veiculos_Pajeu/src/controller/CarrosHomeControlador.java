package controller;

import javafx.fxml.FXML;
import javafx.scene.Cursor;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import util.Util;
import view.AppTelas;

public class CarrosHomeControlador {

    @FXML
    private ImageView homeButton;

    @FXML
    private Pane locacaoPanel;

    @FXML
    private Pane reservaPanel;

    @FXML
    private Pane cadastrarCarrosPanel;

    @FXML
    private Pane carrosCadastradosPanel;

    @FXML
    private ImageView voltarButton;

    @FXML
    private ImageView irButton;

    @FXML
    void cadastrarCarrosPanelClick(MouseEvent event) {
        AppTelas.trocarTela(Util.TELA_CAD_CARRO, Util.ABRIR);
    }

    @FXML
    void cadastrarCarrosPanelEntered(MouseEvent event) {
        cadastrarCarrosPanel.setStyle(Util.PANE_SELEC);
        cadastrarCarrosPanel.setCursor(Cursor.HAND);
    }

    @FXML
    void cadastrarCarrosPanelExited(MouseEvent event) {
        cadastrarCarrosPanel.setStyle(Util.PANE_DESSELEC);
        cadastrarCarrosPanel.setCursor(Cursor.DEFAULT);
    }

    @FXML
    void carrosCadastradosPanelClicked(MouseEvent event) {
        AppTelas.trocarTela(Util.TELA_CARROS_CADASTRADOS, Util.ABRIR);        
    }

    @FXML
    void carrosCadastradosPanelEntered(MouseEvent event) {
        carrosCadastradosPanel.setStyle(Util.PANE_SELEC);
        carrosCadastradosPanel.setCursor(Cursor.HAND);
    }

    @FXML
    void carrosCadastradosPanelExited(MouseEvent event) {
        carrosCadastradosPanel.setStyle(Util.PANE_SELEC);
        carrosCadastradosPanel.setCursor(Cursor.DEFAULT);
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
    void locacaoPanelClicked(MouseEvent event) {
        AppTelas.trocarTela(Util.TELA_LOCACAO, Util.ABRIR);
    }

    @FXML
    void locacaoPanelEntered(MouseEvent event) {
        locacaoPanel.setStyle(Util.PANE_SELEC);
        locacaoPanel.setCursor(Cursor.HAND);
    }

    @FXML
    void locacaoPanelExited(MouseEvent event) {
        locacaoPanel.setStyle(Util.PANE_DESSELEC);
        locacaoPanel.setCursor(Cursor.DEFAULT);
    }

    @FXML
    void reservaPanelClicked(MouseEvent event) {
        AppTelas.trocarTela(Util.TELA_RESERVA, Util.ABRIR);
    }

    @FXML
    void reservaPanelEntred(MouseEvent event) {
        reservaPanel.setStyle(Util.PANE_SELEC);
        reservaPanel.setCursor(Cursor.HAND);
    }

    @FXML
    void reservaPanelExited(MouseEvent event) {
        reservaPanel.setStyle(Util.PANE_DESSELEC);
        reservaPanel.setCursor(Cursor.DEFAULT);
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

}
