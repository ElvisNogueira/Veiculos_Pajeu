package controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

public class CadastroFuncionarioControlador implements Initializable{
    
    @FXML
    private ImageView homeButton;

    @FXML
    private ImageView voltarButton;

    @FXML
    private ImageView irButton;

    @FXML
    private TextField nomeField;

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
    private TextField ruaField;

    @FXML
    private TextField numeroField;

    @FXML
    private TextField cpfField;

    @FXML
    private DatePicker dataNascField;

    @FXML
    private Button cadastrarButon;

    @FXML
    private TextField loginField;

    @FXML
    private PasswordField senhaField;

    @FXML
    private PasswordField confSenhaField;

    @FXML
    private ComboBox<String> tipoUsuariosComboBox;

    @FXML
    void cadastrarButonAcion(ActionEvent event) {
         
    }

    @FXML
    void cadastrarButonEntered(MouseEvent event) {

    }

    @FXML
    void cadastrarButonExited(MouseEvent event) {

    }

    @FXML
    void cadastrarButonReleased(KeyEvent event) {

    }

    @FXML
    void cepFieldReleased(KeyEvent event) {

    }

    @FXML
    void cpfFieldReleased(KeyEvent event) {

    }

    @FXML
    void homeButtonClicked(MouseEvent event) {

    }

    @FXML
    void homeButtonEntered(MouseEvent event) {

    }

    @FXML
    void homeButtonExited(MouseEvent event) {

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

    @FXML
    void telefoneFieldReleased(KeyEvent event) {

    }

    @FXML
    void voltarButtonClicked(MouseEvent event) {

    }

    @FXML
    void voltarButtonEntered(MouseEvent event) {

    }

    @FXML
    void voltarButtonExited(MouseEvent event) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        carregarComboBoxes();
    }
    
    public void carregarComboBoxes(){
        ufComboBox.getItems().addAll("AC","AL","AP","AM","BA","CE","DF","ES","GO",
            "MA","MT","MS","MG","PA","PB","PR","PE","PI","RJ","RN","RS","RO","RR",
            "SC","SP","SE","TO");
        tipoUsuariosComboBox.getItems().addAll("Administrador","Atendente");
        
    }

}
