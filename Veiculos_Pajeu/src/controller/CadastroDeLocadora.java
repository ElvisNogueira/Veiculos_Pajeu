package controller;

import fachada.Fachada;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import model.Endereco;
import model.Locadora;
import util.Mascara;
import util.Util;
import app.App;

public class CadastroDeLocadora implements Initializable{
    Mascara mascara = new Mascara();
    Locadora locadora = new Locadora();
    Endereco endereco = new Endereco();
    
    @FXML
    private ImageView homeButton;

    @FXML
    private ImageView voltarButton;

    @FXML
    private ImageView irButton;

    @FXML
    private TextField telefoneField;

    @FXML
    private TextField cepField;

    @FXML
    private TextField cidadeField;

    @FXML
    private ComboBox<String> ufComboBox;

    @FXML
    private TextField bairroField;

    @FXML
    private Button cadastrarButon;

    @FXML
    private Label cnpjLabel;

    @FXML
    private TextField cnpjField;
    
    @FXML
    private TextField numeroField;
    
    @FXML
    private TextField ruaField;

    @FXML
    void cadastrarButonAction(ActionEvent event) {
        locadora.setCnpj(cnpjField.getText());
        endereco.setBairro(bairroField.getText());
        endereco.setCep(cepField.getText());
        endereco.setCidade(cidadeField.getText());
        endereco.setNumero(numeroField.getText());
        endereco.setRua(ruaField.getText());
        endereco.setUf(ufComboBox.getSelectionModel().getSelectedItem());
        locadora.setEndereco(endereco);
        
        Fachada.getInstance().persistLocadora(locadora);
        
        App.voltar();
    }

    @FXML
    void cadastrarButonEntered(MouseEvent event) {
        cadastrarButon.setCursor(Cursor.HAND);
    }

    @FXML
    void cadastrarButonExited(MouseEvent event) {
        cadastrarButon.setCursor(Cursor.DEFAULT);
    }

    @FXML
    void cepFieldReleased(KeyEvent event) {
        mascara.setMask("#####-###");
        mascara.setCaracteresValidos("0123456789");
        mascara.setTf(cepField);
        mascara.formatter();
    }

    @FXML
    void cnpjFieldReleased(KeyEvent event) {
        mascara.setMask("##.###.###/####-##");
        mascara.setCaracteresValidos("0123456789");
        mascara.setTf(cnpjField);
        mascara.formatter();
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
    void telefoneFieldReleased(KeyEvent event) {
        mascara.setMask("(##)#####-####");
        mascara.setCaracteresValidos("0123456789");
        mascara.setTf(telefoneField);
        mascara.formatter();
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

    public void carregarUFComboBox(){
        ufComboBox.getItems().addAll("AC","AL","AP","AM","BA","CE","DF","ES","GO",
            "MA","MT","MS","MG","PA","PB","PR","PE","PI","RJ","RN","RS","RO","RR",
            "SC","SP","SE","TO");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        carregarUFComboBox();
    }
}
