package controller;

import fachada.Fachada;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import model.Endereco;
import model.Pessoa_Fisica;
import model.Pessoa_Juridica;
import util.Mascara;
import util.Util;
import view.AppTelas;

public class CadastroClienteControlador implements Initializable{
    Mascara mascara = new Mascara();
    Pessoa_Fisica pessoa_Fisica = new Pessoa_Fisica();
    Pessoa_Juridica pessoa_Juridica = new Pessoa_Juridica();
    Endereco endereco = new Endereco();
    
    @FXML
    private ImageView homeButton;

    @FXML
    private ImageView voltarButton;

    @FXML
    private ImageView irButton;

    @FXML
    private TextField codField;

    @FXML
    private TextField nomeField;

    @FXML
    private RadioButton pessoaFisicaRadioButton;

    @FXML
    private ToggleGroup TipoCliente;

    @FXML
    private RadioButton pessoaJuridicaRadioButton;

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
    private DatePicker dataNasc;

    @FXML
    private TextField cnpjField;

    @FXML
    private TextField inscricaoEstadual;

    @FXML
    private Button cadastrarButon;
    
    @FXML
    private Label cpfLabel;
    @FXML
    private Label dataNascLabel;
    @FXML
    private Label cnpjLabel;
    @FXML
    private Label inscricaoEstadualLabel;
    
    @FXML
    void cadastrarButonAction(ActionEvent event) {
        endereco.setBairro(bairroField.getText());
        endereco.setCep(cepField.getText());
        endereco.setCidade(cidadeField.getText());
        endereco.setNumero(numeroField.getText());
        endereco.setRua(ruaField.getText());
        endereco.setUf(ufComboBox.getSelectionModel().getSelectedItem());
        
        if(pessoaFisicaRadioButton.isSelected()){        
            LocalDate ld = dataNasc.getValue();
            Date data = Util.getDate(ld.toString());
            
            pessoa_Fisica.setCpf(cpfField.getText());            
            pessoa_Fisica.setData_nasc(data);
            pessoa_Fisica.setEndereco(endereco);
            pessoa_Fisica.setNome(nomeField.getText());
            pessoa_Fisica.setTelefone(telefoneField.getText());
            
            Fachada.getInstance().persistPessoa_Fisica(pessoa_Fisica);
        }else{
            pessoa_Juridica.setCnpj(cnpjField.getText());
            pessoa_Juridica.setEndereco(endereco);
            pessoa_Juridica.setInscricao_estadual(inscricaoEstadual.getText());
            pessoa_Juridica.setNome(nomeField.getText());
            pessoa_Juridica.setTelefone(telefoneField.getText());
            
            Fachada.getInstance().persistPessoa_Juridica(pessoa_Juridica);
        }
        
        AppTelas.voltar();
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
    void pessoaFisicaRadioButtonAction(ActionEvent event) {
        cnpjField.setVisible(false);
        inscricaoEstadual.setVisible(false);
        
        cnpjLabel.setVisible(false);
        inscricaoEstadualLabel.setVisible(false);
        
        cpfField.setVisible(true);
        dataNasc.setVisible(true);
        
        cpfLabel.setVisible(true);
        dataNascLabel.setVisible(true);
    }

    @FXML
    void pessoaJuridicaRadioButtonAction(ActionEvent event) {
        cnpjField.setVisible(true);
        inscricaoEstadual.setVisible(true);
        
        cnpjLabel.setVisible(true);
        inscricaoEstadualLabel.setVisible(true);
        
        cpfField.setVisible(false);
        dataNasc.setVisible(false);
        
        cpfLabel.setVisible(false);
        dataNascLabel.setVisible(false);
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

    @Override
    public void initialize(URL location, ResourceBundle resources) {      
        cnpjField.setVisible(false);
        inscricaoEstadual.setVisible(false);
        
        cnpjLabel.setVisible(false);
        inscricaoEstadualLabel.setVisible(false);
        carregarUFComboBox();
    }
    
    public void carregarUFComboBox(){
        ufComboBox.getItems().addAll("AC","AL","AP","AM","BA","CE","DF","ES","GO",
            "MA","MT","MS","MG","PA","PB","PR","PE","PI","RJ","RN","RS","RO","RR",
            "SC","SP","SE","TO");
    }

}
