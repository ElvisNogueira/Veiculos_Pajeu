package controller;

import fachada.Fachada;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import model.Categoria;
import util.Util;
import view.AppTelas;

public class CategoriaControlador implements Initializable{

    @FXML
    private ImageView homeButton;

    @FXML
    private ImageView voltarButton;

    @FXML
    private ImageView irButton;

    @FXML
    private Button salvarButton;

    @FXML
    private TableView<Categoria> tabelaCategoria;

    @FXML
    private TableColumn<Categoria, Integer> idColumn;

    @FXML
    private TableColumn<Categoria, String> nomeColumn;

    @FXML
    private TableColumn<Categoria, Double> livreColumn;

    @FXML
    private TableColumn<Categoria, Double> planoControleColumn;

    @FXML
    private Button editarButton;

    @FXML
    private Button excluirButton;
    
    @FXML
    private ImageView atualizarButton;
    
    @FXML
    private ImageView buscarButton;
    
     @FXML
    private TextField buscaField;

    @FXML
    void editarButtonAction(ActionEvent event) {

    }

    @FXML
    void excluirButton(ActionEvent event) {

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
    void salvarButtonAction(ActionEvent event) {
        AppTelas.trocarTela(Util.TELA_CADASTRAR_CATEGORIA, Util.ABRIR);
    }

    @FXML
    void tabelaCategoriaClicked(MouseEvent event) {
        if(event.getClickCount()==2){
            
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
    
    @FXML
    void buscarButtonClicked(MouseEvent event) {
        if(buscaField.getText().isEmpty())
            carregarTabela();
    }
    
    @FXML
    void buscaFieldReleased(KeyEvent event) {
        if(buscaField.getText().isEmpty())
            carregarTabela();
    }
    
    @FXML
    void atualizarButtonClicked(MouseEvent event) {        
        if(buscaField.getText().isEmpty())
            carregarTabela();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        inicializarTabela();
    }
    
    public void inicializarTabela(){        
        idColumn.setCellValueFactory(new PropertyValueFactory("id"));
        nomeColumn.setCellValueFactory(new PropertyValueFactory("nome"));
        livreColumn.setCellValueFactory(new PropertyValueFactory("valor_aluguel_livre"));
        planoControleColumn.setCellValueFactory(new PropertyValueFactory("valor_aluguel_controle"));
        
        tabelaCategoria.setItems(carregarTabela());
    }
    
    public ObservableList carregarTabela(){
        return FXCollections.observableList(Fachada.getInstance().getAllCategoria());
    }

}
