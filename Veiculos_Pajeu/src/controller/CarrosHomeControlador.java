package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import view.AppTelas;

public class CarrosHomeControlador implements Initializable{

    @FXML
    private ImageView voltarButton;

    @FXML
    private ImageView irButton;

    @FXML
    private ImageView homeButton;

    @FXML
    private Pane carrosPanel;

    @FXML
    private Pane clientesPanel;

    @FXML
    private Pane financeiroPanel;

    @FXML
    private Pane relatoriosPanel;

    @FXML
    void carrosPanelClicked(MouseEvent event) {

    }

    @FXML
    void carrosPanelEntered(MouseEvent event) {

    }

    @FXML
    void carrosPanelExited(MouseEvent event) {

    }

    @FXML
    void clientesPanelClicked(MouseEvent event) {

    }

    @FXML
    void clientesPanelEntred(MouseEvent event) {

    }

    @FXML
    void clientesPanelExited(MouseEvent event) {

    }

    @FXML
    void financeiroPanelClick(MouseEvent event) {

    }

    @FXML
    void financeiroPanelEntered(MouseEvent event) {

    }

    @FXML
    void financeiroPanelExited(MouseEvent event) {

    }

    @FXML
    void relatoriosPanelClicked(MouseEvent event) {

    }

    @FXML
    void relatoriosPanelEntered(MouseEvent event) {

    }

    @FXML
    void relatoriosPanelExited(MouseEvent event) {

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
        homeButton.setCursor(Cursor.DEFAULT);
    }

    @FXML
    void irButtonClicled(MouseEvent event) {

    }

    @FXML
    void irButtonEntered(MouseEvent event) {

    }

    @FXML
    void irButtonExited(MouseEvent event) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }

}
