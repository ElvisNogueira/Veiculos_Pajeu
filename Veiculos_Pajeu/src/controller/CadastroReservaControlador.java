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
import model.Locacao;
import model.Reserva;
import util.Util;
import view.AppTelas;

public class CadastroReservaControlador implements Initializable{
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

    @FXML
    void cadastrarButtonAction(ActionEvent event) {
        reserva.setCategoria(categoriaComboBox.getSelectionModel().getSelectedItem());
        LocalDate ld = data_retiradaField.getValue();
        reserva.setData_retirada(Util.getDate(ld.toString()));
        reserva.setDuracao_estimada(Integer.parseInt(duracaoEstimada.getText()));
        reserva.setHora_retirada(new Time(horaRetirada_hora.getValue(), horaRetirada_min.getValue(), 0));
        reserva.setTipo_locacao(tipoLocacaoComboBox.getSelectionModel().getSelectedItem());
        reserva.setValor_entrada(Float.parseFloat(valorEntradaField.getText()));
        
        Fachada.getInstance().persistReserva(reserva);
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
        horaRetirada_min.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 59, Util.horaAtual().getMinutes()));
        horaRetirada_hora.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 23, Util.horaAtual().getHours()));
        carregarComboBoxes();
    }

    private void carregarComboBoxes(){
        preencheCategoriaComboBox();
        preencherTipoLocacao();
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