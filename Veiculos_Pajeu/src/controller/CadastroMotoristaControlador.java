package controller;

import fachada.Fachada;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.time.Month;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import model.Motorista;
import model.Pessoa_Fisica;
import util.Util;
import app.App;

public class CadastroMotoristaControlador implements Initializable{
    private static CadastroMotoristaControlador controlador;
    private Motorista motorista = new Motorista();

    @FXML
    private ImageView homeButton;

    @FXML
    private ImageView voltarButton;

    @FXML
    private ImageView irButton;

    @FXML
    private Button cadCliente;

    @FXML
    private DatePicker dataVenc;

    @FXML
    private TextField numCNHField;

    @FXML
    private ComboBox<Pessoa_Fisica> clienteComboBox;

    @FXML
    private ImageView addCliente;

    @FXML
    private ImageView atualizarButton;
    
    @FXML
    void cadClienteAction(ActionEvent event) {
        
        motorista.setData_venc_habilitacao(Util.getDate(dataVenc.getEditor().getText()));
        motorista.setNum_habilitacao(numCNHField.getText());
        motorista.setPessoa_Fisica(clienteComboBox.getSelectionModel().getSelectedItem());
        
        if(motorista.getId()!=0)
            Fachada.getInstance().mergeMotorista(motorista);
        else 
            Fachada.getInstance().persistMotorista(motorista);
        App.trocarTela(Util.TELA_CAD_CLIENTE, Util.ABRIR);
    }
    
    public void set(Motorista motorista){
        Date d = motorista.getData_venc_habilitacao();
        
        dataVenc.setValue(LocalDate.of(d.getYear(), d.getMonth(), d.getDate()));
        numCNHField.setText(motorista.getNum_habilitacao());
        clienteComboBox.getSelectionModel().select(motorista.getPessoa_Fisica());
    }
    
    public void bloquearCampos(Motorista motorista){
        set(motorista);
        
        dataVenc.setDisable(true);
        numCNHField.setEditable(false);
        clienteComboBox.setEditable(false);
    }

    @FXML
    void atualizarButtonClicked(MouseEvent event) {
        inicializarComboBox();
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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        inicializarComboBox();
    }
    
    @FXML
    void addClicked(MouseEvent event) {
        App.trocarTela(Util.TELA_CAD_CLIENTE, Util.ABRIR);
    }
    
    public void inicializarComboBox(){
        controlador = this;
        clienteComboBox.setItems(FXCollections.observableList(Fachada.getInstance().getAllPessoa_Fisica()));
    }
    
    private static CadastroMotoristaControlador get(){
        return controlador;
    }

}
