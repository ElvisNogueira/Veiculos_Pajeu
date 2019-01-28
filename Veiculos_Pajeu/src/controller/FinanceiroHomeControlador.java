package controller;

import fachada.Fachada;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import model.Financeiro;
import util.Util;
import view.AppTelas;

public class FinanceiroHomeControlador implements Initializable{

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
    private Button novoButton;

    @FXML
    private Button editarButton;

    @FXML
    private Button excluirButton;

    @FXML
    private Button sairButton;

    @FXML
    private ImageView homeButton;

    @FXML
    private ImageView voltarButton;

    @FXML
    private ImageView irButton;

    @FXML
    void atualizarButtonClicked(MouseEvent event) {
        inicializarTabela();
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
    void editarButtonAction(ActionEvent event) {
        CadastroFinanceiroControlador.get().set(Fachada.getInstance().getByIdFinanceiro
        (financeiroTable.getSelectionModel().getSelectedItem().id));
        AppTelas.trocarTela(Util.TELA_CAD_FINANCEIRO, Util.ABRIR);
        
    }

    @FXML
    void excluirButtonAction(ActionEvent event) {
        Fachada.getInstance().removeFinanceiro(Fachada.getInstance().getByIdFinanceiro
        (financeiroTable.getSelectionModel().getSelectedItem().id));
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
    void novoButtonAction(ActionEvent event) {
        AppTelas.trocarTela(Util.TELA_CAD_FINANCEIRO, Util.ABRIR);
    }

    @FXML
    void sairButtonAction(ActionEvent event) {
        AppTelas.voltar();
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
