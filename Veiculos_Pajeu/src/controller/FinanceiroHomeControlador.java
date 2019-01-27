package controller;

import fachada.Fachada;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import model.Financeiro;
import util.Util;
import view.AppTelas;

public class FinanceiroHomeControlador implements Initializable{

    @FXML
    private TableView<Financeiro> financeiroTable;

    @FXML
    private TableColumn<Financeiro, Integer> idColumn;

    @FXML
    private TableColumn<Financeiro, String> nomeColumn;

    @FXML
    private TableColumn<Financeiro, String> observacaoColumn;

    @FXML
    private TableColumn<Financeiro, String> tipoColumn;

    @FXML
    private TextField buscaField;

    @FXML
    private ImageView atualizarButton;

    @FXML
    private Button novoButton;

    @FXML
    private Button editarButton;

    @FXML
    private Button excluirButton;

    @FXML
    private ImageView buscarButton;

    @FXML
    private Button sairButton;

    @FXML
    private ChoiceBox<String> tipoComboBox;

    @FXML
    private ImageView homeButton;

    @FXML
    private ImageView voltarButton;

    @FXML
    private ImageView irButton;

    @FXML
    void atualizarButtonClicked(MouseEvent event) {

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
    void buscaFieldReleased(KeyEvent event) {

    }

    @FXML
    void buscarButtonClicked(MouseEvent event) {

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
    void editarButtonAction(ActionEvent event) {
        
    }

    @FXML
    void excluirButtonAction(ActionEvent event) {
        Fachada.getInstance().removeFinanceiro(financeiroTable.getSelectionModel().getSelectedItem());
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
        AppTelas.trocarTela(Util.TELA_CAD_FINANCEIRO, Util.ABRIR);
    }

    @FXML
    void sairButtonAction(ActionEvent event) {
        AppTelas.voltar();
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

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
    

}
