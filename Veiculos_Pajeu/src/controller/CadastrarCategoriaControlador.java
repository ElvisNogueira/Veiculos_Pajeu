package controller;

import fachada.Fachada;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javax.swing.JOptionPane;
import model.Categoria;
import util.Mascara;
import util.Util;
import view.AppTelas;

public class CadastrarCategoriaControlador implements Initializable {

    private DecimalFormat df = new DecimalFormat("#####.00");
    private List<String> listaPortes = new ArrayList<String>();
    private List<String> listaCambios = new ArrayList<String>();
    private ObservableList<String> portesObservableList;
    private ObservableList<String> cambiosObservableList;
    private Categoria categoria;
    
    @FXML
    private ImageView homeButton;

    @FXML
    private ImageView voltarButton;

    @FXML
    private ImageView irButton;

    @FXML
    private Button cadastrarButtton;

    @FXML
    private CheckBox arCondCheckBox;

    @FXML
    private CheckBox cameraReCheckBox;

    @FXML
    private CheckBox dirHidraulicaCheckBox;

    @FXML
    private CheckBox dvdCheckBox;

    @FXML
    private CheckBox mp3CheckBox;

    @FXML
    private TextField nomeCategoriaField;

    @FXML
    private TextField horasLimpField;

    @FXML
    private TextField horasRevField;

    @FXML
    private ComboBox<String> porteComboBox;

    @FXML
    private ComboBox<String> cambioComboBox;

    @FXML
    private TextField valorcontroleField;

    @FXML
    private TextField valorLivreField;

    @FXML
    void cadastrarButttonAction(ActionEvent event) {
        categoria = new Categoria();
        categoria.setAr_condicionado(arCondCheckBox.isSelected());
        categoria.setCamara_re(cameraReCheckBox.isSelected());
        categoria.setDvd(dvdCheckBox.isSelected());
        categoria.setMp3(mp3CheckBox.isSelected());
        categoria.setNome(nomeCategoriaField.getText());
        categoria.setNum_horas_limpeza(Integer.parseInt(horasLimpField.getText()));
        categoria.setNum_horas_revisao(Integer.parseInt(horasRevField.getText()));
        categoria.setTamanho(porteComboBox.getSelectionModel().getSelectedItem());
        categoria.setTipo_comboio(cambioComboBox.getSelectionModel().getSelectedItem());
        categoria.setValor_aluguel_controle(Float.parseFloat(valorcontroleField.getText()));
        categoria.setValor_aluguel_livre(Float.parseFloat(valorLivreField.getText()));
        
        Fachada.getInstance().persistCategoria(categoria);
    }

    @FXML
    void cadastrarButttonEntered(MouseEvent event) {
        cadastrarButtton.setCursor(Cursor.HAND);
    }

    @FXML
    void cadastrarButttonExited(MouseEvent event) {
        cadastrarButtton.setCursor(Cursor.DEFAULT);
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
    void valorControleKeyReleased(KeyEvent event) {
        try {
            String valor = valorcontroleField.getText().replace(",", ".");
            df.format(Double.parseDouble(valor));
            valorcontroleField.setText(valorcontroleField.getText().replace(".", ","));
            valorcontroleField.end();
        } catch (Exception e) {
            valorcontroleField.setText("");
        }
    }

    @FXML
    void valorLivreKeyReleased(KeyEvent event) {
        try {
            String valor = valorLivreField.getText().replace(",", ".");
            df.format(Double.parseDouble(valor));
            valorLivreField.setText(valorLivreField.getText().replace(".", ","));
            valorLivreField.end();
        } catch (Exception e) {
            valorLivreField.setText("");
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
        carregarComboBoxes();
    }

    public void carregarComboBoxes() {
        listaPortes.add("Pequeno");
        listaPortes.add("Médio");
        listaPortes.add("Grande");

        listaCambios.add("Automático");
        listaCambios.add("Automatizado de dupla embreagem");
        listaCambios.add("CVT");
        listaCambios.add("Manual");

        portesObservableList = FXCollections.observableArrayList(listaPortes);
        cambiosObservableList = FXCollections.observableArrayList(listaCambios);

        porteComboBox.setItems(portesObservableList);
        cambioComboBox.setItems(cambiosObservableList);

    }

}
