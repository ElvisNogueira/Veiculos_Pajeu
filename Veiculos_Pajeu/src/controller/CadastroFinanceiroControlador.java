package controller;

import fachada.Fachada;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.time.Month;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import model.Conta;
import model.Financeiro;
import util.Util;
import app.App;


public class CadastroFinanceiroControlador implements Initializable{
    Financeiro f = new Financeiro();
    boolean flag;
    static CadastroFinanceiroControlador controlador;
    @FXML
    private ImageView homeButton;
    
    @FXML
    private ImageView atualizarButton;

    @FXML
    private ImageView voltarButton;

    @FXML
    private ImageView irButton;

    @FXML
    private DatePicker dataPagamento;

    @FXML
    private TextField valorField;

    @FXML
    private ComboBox<Conta> contaComboBox;

    @FXML
    private TextArea observacaoArea;

    @FXML
    private Button cadastrarButton;
    
    @FXML
    private ImageView addConta;

    @FXML
    void addContaClicked(MouseEvent event) {
        App.trocarTela(Util.TELA_CAD_CONTA, Util.ABRIR);
    }
    
    public static CadastroFinanceiroControlador get(){
        return controlador;
    }
    
    @FXML
    void atualizarButtonClicked(MouseEvent event) {
        inicializarCCombobox();
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
    void cadastrarButtonAction(ActionEvent event) {
        Date d  = new Date(dataPagamento.getValue().getYear()-1900, dataPagamento.getValue().getMonthValue()-1,
                dataPagamento.getValue().getDayOfMonth());
        f.setConta(contaComboBox.getSelectionModel().getSelectedItem());
        f.setData(d);
        f.setObservacao(observacaoArea.getText());
        f.setUsuario(Fachada.getUserLogado());
        f.setValor(Float.parseFloat(valorField.getText()));
        System.out.println(f.getValor()+"");
        if(flag)
            Fachada.getInstance().mergeFinanceiro(f);
        else
            Fachada.getInstance().persistFinanceiro(f);
        flag = false;
    }

    
    public void set(Financeiro f){
        flag = true;
        
        contaComboBox.getSelectionModel().select(f.getConta());
        LocalDate ld = LocalDate.of(f.getData().getYear()-1900, f.getData().getMonth()-1, f.getData().getDay());
        dataPagamento.setValue(ld);
        observacaoArea.setText(f.getObservacao());
        
        valorField.setText(f.getValor()+"");
    } 
    public void bloquear(Financeiro f){
        contaComboBox.setEditable(false);
        dataPagamento.setEditable(false);
        observacaoArea.setEditable(false);
        
        valorField.setEditable(false);
    }
    public void limpar(){
        contaComboBox.getSelectionModel().select(0);
        dataPagamento.setValue(LocalDate.now());
        observacaoArea.setText("");
        
        valorField.setText("");
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
    void valorFieldReleased(KeyEvent event) {

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
        controlador = this;
        dataPagamento.setValue(LocalDate.now());
        inicializarCCombobox();
    }
    
    public void inicializarCCombobox(){
        contaComboBox.setItems(carregar());
    }
    
    public ObservableList carregar(){
        return FXCollections.observableList(Fachada.getInstance().getAllConta());
    }

}
