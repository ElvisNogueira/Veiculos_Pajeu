package controller;

import fachada.Fachada;
import java.net.URL;
import java.sql.Date;
import java.sql.Time;
import java.text.DecimalFormat;
import java.time.Clock;
import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
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
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import model.Categoria;
import model.Financeiro;
import model.Locacao;
import model.Reserva;
import util.Util;
import app.App;

public class CadastroReservaControlador implements Initializable{
    boolean flag;
    static CadastroReservaControlador controlador;
    private DecimalFormat df = new DecimalFormat("#####.00");
    Reserva reserva = new Reserva();
    ArrayList<Categoria> categorias = new ArrayList<>();
    ObservableList<Categoria> obsCategorias;

    @FXML
    private ImageView homeButton;

    @FXML
    private ImageView voltarButton;

    @FXML
    private ImageView irButton;

    @FXML
    private Button cadastrarButton;

    @FXML
    private DatePicker data_retiradaField;
    
    @FXML
    private ImageView atualizarBuutton;

    @FXML
    private TextField duracaoEstimada;

    @FXML
    private ComboBox<String> tipoLocacaoComboBox;

    @FXML
    private ComboBox<Categoria> categoriaComboBox;

    @FXML
    private TextField valorEntradaField;

    @FXML
    private Spinner<Integer> horaRetirada_hora;

    @FXML
    private Spinner<Integer> horaRetirada_min;
    
    public static CadastroReservaControlador get(){
        return controlador;
    }

    @FXML
    void cadastrarButtonAction(ActionEvent event) {
        reserva.setCategoria(categoriaComboBox.getSelectionModel().getSelectedItem());
        LocalDate ld = data_retiradaField.getValue();
        Date d  = new Date(ld.getYear()-1900, ld.getMonthValue()-1,
                ld.getDayOfMonth());
        reserva.setData_retirada(d);
        reserva.setDuracao_estimada(Integer.parseInt(duracaoEstimada.getText()));
        reserva.setHora_retirada(new Time(horaRetirada_hora.getValue(), horaRetirada_min.getValue(), 0));
        reserva.setTipo_locacao(tipoLocacaoComboBox.getSelectionModel().getSelectedItem());
        reserva.setValor_entrada(Float.parseFloat(valorEntradaField.getText()));
        if(flag)
            Fachada.getInstance().mergeReserva(reserva);
        else{
            Fachada.getInstance().persistReserva(reserva);
            
            CadastroFinanceiroControlador.controlador.set(new Financeiro(Util.dataAtual(), reserva.getValor_entrada(), 
                    "", Fachada.getInstance().getByNomeConta("Reserva"), Fachada.getUserLogado()));
            App.trocarTela(Util.TELA_CAD_FINANCEIRO,Util.ABRIR);
        }        
            flag = false;
    }
    
    public void set(Reserva reserva){
        flag = true;
        categoriaComboBox.getSelectionModel().select(reserva.getCategoria());
        data_retiradaField.setValue(LocalDate.of(reserva.getData_retirada().getYear(), 
                reserva.getData_retirada().getMonth(), reserva.getData_retirada().getDay()));
        duracaoEstimada.setText(reserva.getDuracao_estimada()+"");
         horaRetirada_min.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 59, 
                 reserva.getHora_retirada().getMinutes()));
        horaRetirada_hora.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 23, 
                reserva.getHora_retirada().getHours()));
        tipoLocacaoComboBox.getSelectionModel().select(reserva.getTipo_locacao());
        
        
       valorEntradaField.setText(reserva.getValor_entrada()+"");
    }
    
    public void limpar(){
        categoriaComboBox.getSelectionModel().select(0);
        data_retiradaField.setValue(null);
        duracaoEstimada.setText("");
        horaRetirada_min.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 59, Util.horaAtual().getMinutes()));
        horaRetirada_hora.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 23, Util.horaAtual().getHours()));
      
       valorEntradaField.setText("");
    }
    
    public void bloquear(Reserva reserva){
        set(reserva);
        categoriaComboBox.setEditable(false);
        data_retiradaField.setEditable(false);
        duracaoEstimada.setEditable(false);
        horaRetirada_min.setEditable(false);
        horaRetirada_hora.setEditable(false);
       valorEntradaField.setEditable(false);
    }
    
    public void initCadastro(){
        limpar();
        data_retiradaField.setEditable(true);
        duracaoEstimada.setEditable(true);
        horaRetirada_min.setEditable(true);
        horaRetirada_hora.setEditable(true);
        valorEntradaField.setEditable(true);
    }
    
    
    @FXML
    void atualizarBuuttonClicked(MouseEvent event) {
        carregarComboBoxes();
    }
    
    @FXML
    void entradaClicked(MouseEvent event) {
        valorEntradaField.setText(categoriaComboBox.getSelectionModel().getSelectedItem().getValor_aluguel_controle()*0.5+"");

    }
    
    
    @FXML
    void duracaoEstimadaReleased(KeyEvent event) {
        try {
            Integer.parseInt(duracaoEstimada.getText());
        } catch (Exception e) {
            duracaoEstimada.setText("");
        }
    }

    @FXML
    void homeButtonClicked(MouseEvent event) {
        App.trocarTela(Util.TELA_HOME, Util.ABRIR);
    }

    @FXML
    void valorEntradaFieldAction(ActionEvent event) {
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
    void valorEntradaFieldReleased(KeyEvent event) {
        try {
            String valor = valorEntradaField.getText().replace(",", ".");
            df.format(Double.parseDouble(valor));
            valorEntradaField.setText(valorEntradaField.getText().replace(".", ","));
            valorEntradaField.end();
        } catch (Exception e) {
            valorEntradaField.setText("");
        }
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
        valorEntradaField.setEditable(false);
        horaRetirada_min.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 59, Util.horaAtual().getMinutes()));
        horaRetirada_hora.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 23, Util.horaAtual().getHours()));
        carregarComboBoxes();
    }

    private void carregarComboBoxes(){
        preencheCategoriaComboBox();
        preencherTipoLocacao();
    }
    
    @FXML
    void atualizarBuuttonEntered(MouseEvent event) {

    }

    @FXML
    void atualizarBuuttonExited(MouseEvent event) {

    }
    
    private void preencherTipoLocacao(){
        tipoLocacaoComboBox.getItems().addAll("Plano controle","Plano Livre");
    }
    
    private void preencheCategoriaComboBox(){
        categorias = Fachada.getInstance().getAllCategoria();
        obsCategorias = FXCollections.observableList(categorias);
        
        categoriaComboBox.setItems(obsCategorias);
    }
}