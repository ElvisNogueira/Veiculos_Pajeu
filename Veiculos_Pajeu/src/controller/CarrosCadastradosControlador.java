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
import model.Veiculo;
import org.hibernate.PropertyValueException;
import util.Util;
import view.AppTelas;

public class CarrosCadastradosControlador implements Initializable{

    @FXML
    private ImageView homeButton;

    @FXML
    private ImageView voltarButton;

    @FXML
    private ImageView atualizarButton;
    
    @FXML
    private ImageView irButton;

    @FXML
    private TableView<Veiculo> carrosTable;
    
     @FXML
    private TableColumn<Veiculo,Long> idColuna;

    @FXML
    private TableColumn<Veiculo, String> placaColuna;

    @FXML
    private TableColumn<Veiculo, String> modeloColuna;

    @FXML
    private TableColumn<Veiculo, String> marcaColuna;

    @FXML
    private TableColumn<Veiculo, Integer> categoriaColuna;

    @FXML
    private TextField buscarField;

    @FXML
    private ImageView buscarButton;

    @FXML
    private Button novoButton;

    @FXML
    private Button editarButton;

    @FXML
    private Button cancelarButton;
    
    @FXML
    private Button devolverCarroButton;
    
    private Button excluirButton;
    
    @FXML
    void atualizarButtonClicked(MouseEvent event) {
        buscarField.setText("");
        iniciarTabela();
    }
    
    @FXML
    void excluirButtonAction(ActionEvent event) {
        Fachada.getInstance().removeVeiculo(carrosTable.getSelectionModel().getSelectedItem());
        carregarTabela();
    }
    
    @FXML
    void buscaFieldKeyPressed(KeyEvent event) {
        iniciarTabela();
    }

    @FXML
    void buscarButtonClicked(MouseEvent event) {
        iniciarTabela();
    }

    @FXML
    void buscarButtonEntered(MouseEvent event) {
        buscarButton.setCursor(Cursor.HAND);
    }

    @FXML
    void buscarButtonExited(MouseEvent event) {
        buscarButton.setCursor(Cursor.DEFAULT);
    }

    @FXML
    void cancelarButtonAction(ActionEvent event) {
        AppTelas.voltar();
    }

    @FXML
    void cancelarButtonEntered(MouseEvent event) {
        cancelarButton.setCursor(Cursor.HAND);
    }

    @FXML
    void cancelarButtonExited(MouseEvent event) {
        cancelarButton.setCursor(Cursor.DEFAULT);
    }

    @FXML
    void carrosTableClicked(MouseEvent event) {
        if(event.getClickCount()==2){
            CadastroVeiculoControlador.get().bloquear(carrosTable.getSelectionModel().getSelectedItem());
            AppTelas.trocarTela(Util.TELA_CAD_CARRO, Util.ABRIR);
        }
            
    }
    
    @FXML
    void devolverCarroButtonAction(ActionEvent event) {

    }

    @FXML
    void editarButtonAction(ActionEvent event) {
        CadastroVeiculoControlador.get().setVeiculo(carrosTable.getSelectionModel().getSelectedItem());
        AppTelas.trocarTela(Util.TELA_CAD_CARRO, Util.ABRIR);
    }

    @FXML
    void editarButtonEntered(MouseEvent event) {
        editarButton.setCursor(Cursor.HAND);
    }

    @FXML
    void editarButtonExited(MouseEvent event) {
       editarButton.setCursor(Cursor.DEFAULT);
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
        AppTelas.trocarTela(Util.TELA_CAD_CARRO, Util.ABRIR);
    }

    @FXML
    void novoButtonEntered(MouseEvent event) {
        novoButton.setCursor(Cursor.HAND);
    }

    @FXML
    void novoButtonExited(MouseEvent event) {
        novoButton.setCursor(Cursor.DEFAULT);
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
        iniciarTabela();
    }
    
    public void iniciarTabela(){
        idColuna.setCellValueFactory(new PropertyValueFactory("id"));
        categoriaColuna.setCellValueFactory(new PropertyValueFactory("num_passageiros"));
        marcaColuna.setCellValueFactory(new PropertyValueFactory("fabricante"));
        modeloColuna.setCellValueFactory(new PropertyValueFactory("modelo"));
        placaColuna.setCellValueFactory(new PropertyValueFactory("placa"));
        
        carrosTable.setItems(carregarTabela());
    }
    
    public ObservableList carregarTabela(){
        return FXCollections.observableArrayList(Fachada.getInstance().getBuscaVeiculo(buscarField.getText()));
    }

}
