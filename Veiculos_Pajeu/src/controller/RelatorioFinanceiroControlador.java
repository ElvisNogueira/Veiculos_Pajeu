package controller;

import fachada.Fachada;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import model.Financeiro;
import util.Util;
import view.AppTelas;

public class RelatorioFinanceiroControlador implements Initializable{

    @FXML
    private TableView<FinanceiroAux> financeiroTable;

    @FXML
    private TableColumn<FinanceiroAux, Integer> idColumn;

    @FXML
    private TableColumn<FinanceiroAux, String> nomeColumn;

    @FXML
    private TableColumn<FinanceiroAux, String> observacaoColumn;

    @FXML
    private TableColumn<FinanceiroAux, String> tipoColumn;

    @FXML
    private ImageView atualizarButton;

    @FXML
    private ImageView homeButton;

    @FXML
    private ImageView voltarButton;

    @FXML
    private ImageView irButton;

    @FXML
    private DatePicker dataInicio;

    @FXML
    private DatePicker datafFim;

    @FXML
    private ImageView buscar;

    @FXML
    private ComboBox<String> tipoComboBox;

    @FXML
    void atualizarButtonClicked(MouseEvent event) {

    }

    @FXML
    void buscarClicked(MouseEvent event) {

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
        inicializarTabela();
        tipoComboBox.getItems().addAll("Locacao","Reserva");
    }
    
    public void inicializarTabela(){
        idColumn.setCellValueFactory(new PropertyValueFactory("id"));
        observacaoColumn.setCellValueFactory(new PropertyValueFactory("obs"));
        nomeColumn.setCellValueFactory(new PropertyValueFactory("nome"));
        tipoColumn.setCellValueFactory(new PropertyValueFactory("tipo"));
        
        financeiroTable.setItems(carregar());
    }
    
    public ObservableList carregar(){
        ArrayList<FinanceiroAux> financeiroAuxs = new ArrayList<>();
        
        for(Financeiro f : Fachada.getInstance().getAllFinanceiro())
            financeiroAuxs.add(new FinanceiroAux(f.getId(), f.getConta().getNome(), f.getObservacao(), 
                    f.getConta().getTipo()));
        return FXCollections.observableList(financeiroAuxs);
    }
    
    private class FinanceiroAux{
        public int id;
        public String nome, obs,tipo;
        
        public FinanceiroAux(int id,String nome, String obs,String tipo){
            this.id = id;
            this.obs = obs;
            this.nome = nome;
            this.tipo = tipo;
        }
    }

}
