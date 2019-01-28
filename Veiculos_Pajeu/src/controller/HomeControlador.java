package controller;

import app.App;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.Pane;
import util.Util;
import view.AppTelas;

public class HomeControlador implements Initializable{

    @FXML
    private Pane carrosPanel;

    @FXML
    private Pane clientesPanel;

    @FXML
    private Pane funcionariosPanel;

    @FXML
    private Pane financeiroPanel;

    @FXML
    private Pane relatoriosPanel;

    @FXML
    private Pane configuracoesPanel;
    
    
    @FXML
    private ImageView voltarButton;

    @FXML
    private ImageView irButton;

    
    @FXML
    private ImageView homeButton;

    @FXML
    void carrosPanelClicked(MouseEvent event) {
        AppTelas.trocarTela(Util.TELA_CARROS_HOME, Util.ABRIR);
    }

    @FXML
    void carrosPanelEntered(MouseEvent event) {
        carrosPanel.setCursor(Cursor.HAND);
        carrosPanel.setStyle(Util.PANE_SELEC);
    }

    @FXML
    void carrosPanelExited(MouseEvent event) {
        carrosPanel.setCursor(Cursor.DEFAULT);
        carrosPanel.setStyle(Util.PANE_DESSELEC);
    }

    @FXML
    void clientesPanelClicked(MouseEvent event) {
        AppTelas.trocarTela(Util.TELA_CLIENTES_HOME, Util.ABRIR);
    }

    @FXML
    void clientesPanelEntred(MouseEvent event) {
        clientesPanel.setCursor(Cursor.HAND);
        clientesPanel.setStyle(Util.PANE_SELEC);
    }

    @FXML
    void clientesPanelExited(MouseEvent event) {
        clientesPanel.setCursor(Cursor.DEFAULT);
        clientesPanel.setStyle(Util.PANE_DESSELEC);
    }

    @FXML
    void configuracoesPanelClicked(MouseEvent event) {
        AppTelas.trocarTela(Util.TELA_CONFIGURACOES, Util.ABRIR);
    }

    @FXML
    void configuracoesPanelEntered(MouseEvent event) {
        configuracoesPanel.setCursor(Cursor.HAND);
        configuracoesPanel.setStyle(Util.PANE_SELEC);
    }

    @FXML
    void configuracoesPanelExited(MouseEvent event) {
        configuracoesPanel.setCursor(Cursor.DEFAULT);
        configuracoesPanel.setStyle(Util.PANE_DESSELEC);
    }

    @FXML
    void financeiroPanelClick(MouseEvent event) {
        AppTelas.trocarTela(Util.TELA_FINANCEIRO_HOME, Util.ABRIR);
    }

    @FXML
    void financeiroPanelEntered(MouseEvent event) {
        financeiroPanel.setCursor(Cursor.HAND);
        financeiroPanel.setStyle(Util.PANE_SELEC);
    }

    @FXML
    void financeiroPanelExited(MouseEvent event) {
        financeiroPanel.setCursor(Cursor.DEFAULT);
        financeiroPanel.setStyle(Util.PANE_DESSELEC);
    }

    @FXML
    void funcionariosPanelClicked(MouseEvent event) {
        AppTelas.trocarTela(Util.TELA_FUNCIONARIOS_HOME, Util.ABRIR);
    }

    @FXML
    void funcionariosPanelEntered(MouseEvent event) {
        funcionariosPanel.setCursor(Cursor.HAND);
        funcionariosPanel.setStyle(Util.PANE_SELEC);
    }

    @FXML
    void funcionariosPanelExited(MouseEvent event) {
        funcionariosPanel.setCursor(Cursor.DEFAULT);
        funcionariosPanel.setStyle(Util.PANE_DESSELEC);
    }

    @FXML
    void relatoriosPanelClicked(MouseEvent event) {

    }

    @FXML
    void relatoriosPanelEntered(MouseEvent event) {
        relatoriosPanel.setCursor(Cursor.HAND);
        relatoriosPanel.setStyle(Util.PANE_SELEC);
    }

    @FXML
    void relatoriosPanelExited(MouseEvent event) {
        relatoriosPanel.setCursor(Cursor.DEFAULT);
        relatoriosPanel.setStyle(Util.PANE_DESSELEC);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
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
        
    }

    @FXML
    void homeButtonEntered(MouseEvent event) {
        homeButton.setCursor(Cursor.HAND);
    }

    @FXML
    void homeButtonExited(MouseEvent event) {
        voltarButton.setCursor(Cursor.DEFAULT);
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

}
