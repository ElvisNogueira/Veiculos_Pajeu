package controller;

import fachada.Fachada;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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

public class CarrosCadastradosControlador implements Initializable{

    @FXML
    private ImageView homeButton;

    @FXML
    private ImageView voltarButton;

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
    void excluirButtonAction(ActionEvent event) {
        Fachada.getInstance().removeVeiculo(carrosTable.getSelectionModel().getSelectedItem());
        carregarTabela();
    }
    
    @FXML
    void buscaFieldKeyPressed(KeyEvent event) {

    }

    @FXML
    void buscarButtonClicked(MouseEvent event) {

    }

    @FXML
    void buscarButtonEntered(MouseEvent event) {

    }

    @FXML
    void buscarButtonExited(MouseEvent event) {

    }

    @FXML
    void cancelarButtonAction(ActionEvent event) {

    }

    @FXML
    void cancelarButtonEntered(MouseEvent event) {

    }

    @FXML
    void cancelarButtonExited(MouseEvent event) {

    }

    @FXML
    void carrosTableClicked(MouseEvent event) {

    }
    
    @FXML
    void devolverCarroButtonAction(ActionEvent event) {

    }

    @FXML
    void editarButtonAction(ActionEvent event) {

    }

    @FXML
    void editarButtonEntered(MouseEvent event) {

    }

    @FXML
    void editarButtonExited(MouseEvent event) {
       
    }

    @FXML
    void homeButtonClicked(MouseEvent event) {

    }

    @FXML
    void homeButtonEntered(MouseEvent event) {

    }

    @FXML
    void homeButtonExited(MouseEvent event) {

    }

    @FXML
    void irButtonClicled(MouseEvent event) {

    }

    @FXML
    void irButtonEntered(MouseEvent event) {

    }

    @FXML
    void irButtonExited(MouseEvent event) {

    }

    @FXML
    void novoButtonAction(ActionEvent event) {

    }

    @FXML
    void novoButtonEntered(MouseEvent event) {

    }

    @FXML
    void novoButtonExited(MouseEvent event) {

    }

    @FXML
    void voltarButtonClicked(MouseEvent event) {

    }

    @FXML
    void voltarButtonEntered(MouseEvent event) {

    }

    @FXML
    void voltarButtonExited(MouseEvent event) {

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
        return FXCollections.observableArrayList(Fachada.getInstance().getAllVeiculo());
    }

}
