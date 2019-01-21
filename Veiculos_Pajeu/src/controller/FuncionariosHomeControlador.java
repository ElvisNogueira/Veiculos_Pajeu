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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import model.Funcionario;
import util.Util;
import view.AppTelas;

public class FuncionariosHomeControlador implements Initializable{

    @FXML
    private TableView<Funcionario> funcionariosTable;

    @FXML
    private TableColumn<Funcionario, Integer> idColumn;

    @FXML
    private TableColumn<Funcionario, String> nomeColumn;

    @FXML
    private TableColumn<Funcionario, String> tipoContaColumn;

    @FXML
    private TextField buscaField;

    @FXML
    private ImageView atualizarButton;

    @FXML
    private Button cadastrarButton;

    @FXML
    private Button editarButton;

    @FXML
    private Button excluirButton;

    @FXML
    private ImageView buscarButton;

    @FXML
    private Button sairButton;

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

    }

    @FXML
    void atualizarButtonExited(MouseEvent event) {

    }

    @FXML
    void buscaFieldReleased(KeyEvent event) {

    }

    @FXML
    void buscarButtonClicked(MouseEvent event) {

    }

    @FXML
    void buscarButtonEntered(MouseEvent event) {

    }

    @FXML
    void buscarButtonExited(MouseEvent event) {

    }

    @FXML
    void cadastrarButtonAction(ActionEvent event) {
        AppTelas.trocarTela(Util.TELA_CAD_FUNCIONARIO, Util.ABRIR);
    }

    @FXML
    void editarButtonAction(ActionEvent event) {

    }

    @FXML
    void excluirButtonAction(ActionEvent event) {
        Fachada.getInstance().removeFuncionario(funcionariosTable.getSelectionModel().getSelectedItem());
        inicializarTabela();
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
    
    public void inicializarTabela(){
        idColumn.setCellValueFactory(new PropertyValueFactory("id"));
        nomeColumn.setCellValueFactory(new PropertyValueFactory("nome"));
        tipoContaColumn.setCellValueFactory(new PropertyValueFactory(""));
        
        funcionariosTable.setItems(carregarTabela());
    }
    
    public ObservableList carregarTabela(){
        return FXCollections.observableList(Fachada.getInstance().getAllFuncionario());
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        inicializarTabela();
    }

}
