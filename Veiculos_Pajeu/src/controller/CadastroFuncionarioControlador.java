package controller;

import fachada.Fachada;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import model.Endereco;
import model.Funcionario;
import model.Usuario;
import util.Mascara;
import util.Util;
import view.AppTelas;

public class CadastroFuncionarioControlador implements Initializable{
    private Usuario usuario;
    private Funcionario funcionario;
    private Endereco endereco;
    
    Mascara mascara = new Mascara();
    
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
    void cadastrarButonAction(ActionEvent event) {
         usuario.setLogin(loginField.getText());
         if(senhaField.getText().equals(confSenhaField.getText()))
             usuario.setSenha(senhaField.getText());
         usuario.setTipo(tipoUsuariosComboBox.getSelectionModel().getSelectedItem());
         
         
        LocalDate ld = dataNascField.getValue();
        Date data = Util.getDate(ld.toString());
        funcionario.setCpf(cpfField.getText());
        funcionario.setData_nasc(data);
        funcionario.setTelefone(telefoneField.getText());
        funcionario.setNome(nomeField.getText());
        
        endereco.setBairro(bairroField.getText());
        endereco.setCep(cepField.getText());
        endereco.setCidade(cidadeField.getText());
        endereco.setNumero(numeroField.getText());
        endereco.setRua(ruaField.getText());
        endereco.setUf(ufComboBox.getSelectionModel().getSelectedItem());
        
        funcionario.setEnd(endereco);
        usuario.setFuncionario(funcionario);
        
        Fachada.getInstance().persistUsuario(usuario);
        
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
    void cadastrarButonReleased(KeyEvent event) {
        
    }

    @FXML
    void cepFieldReleased(KeyEvent event) {
        mascara.setMask("#####-###");
        mascara.setCaracteresValidos("0123456789");
        mascara.setTf(cepField);
        mascara.formatter();
    }

    @FXML
    void cpfFieldReleased(KeyEvent event) {
        mascara.setMask("###.###.###-##");
        mascara.setCaracteresValidos("0123456789");
        mascara.setTf(cpfField);
        mascara.formatter();
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
    void telefoneFieldReleased(KeyEvent event) {
        mascara.setMask("(##)#####-####");
        mascara.setCaracteresValidos("0123456789");
        mascara.setTf(telefoneField);
        mascara.formatter();
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
    void senhaFieldKeyReleased(KeyEvent event) {

    }
    
    @FXML
    void confSenhaFieldKeyReleased(KeyEvent event) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        usuario = new Usuario();
        funcionario = new Funcionario();
//        carregarComboBoxes();
    }
    
    public void carregarComboBoxes(){
        ufComboBox.getItems().addAll("AC","AL","AP","AM","BA","CE","DF","ES","GO",
            "MA","MT","MS","MG","PA","PB","PR","PE","PI","RJ","RN","RS","RO","RR",
            "SC","SP","SE","TO");
        tipoUsuariosComboBox.getItems().addAll("Administrador","Atendente");
        
    }

}
