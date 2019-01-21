package controller;

import fachada.Fachada;
import java.net.URL;
import java.sql.Date;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import model.Categoria;
import model.Cliente;
import model.Locacao;
import model.Motorista;
import model.Veiculo;
import util.Util;
import view.AppTelas;

public class CadastroLocacaoControlador implements Initializable {
    private DecimalFormat df = new DecimalFormat("#####.00");
    
    Locacao locacao;
    
    ArrayList<Cliente> clientes = new ArrayList<>();
    ArrayList<Motorista> motoristas = new ArrayList<>();
    ArrayList<Veiculo> veiculos = new ArrayList<>();
    
    private ObservableList<Cliente> obsClientes;
    private ObservableList<Motorista> obsMotorista;
    private ObservableList<Veiculo> obsVeiculo;

    public CadastroLocacaoControlador() {
    }

    @FXML
    private ImageView homeButton;

    @FXML
    private ImageView voltarButton;

    @FXML
    private ImageView irButton;

    @FXML
    private Button cadastrarButton;

    @FXML
    private TextField km_inicialField;

    @FXML
    private TextField km_finalField;

    @FXML
    private ComboBox<String> statusComboBox;

    @FXML
    private TextField taxaCombField;

    @FXML
    private TextField taxaHigienizacaoField;

    @FXML
    private ComboBox<String> tipoComboBox;

    @FXML
    private TextField valorLocacaoField;

    @FXML
    private ComboBox<Motorista> motoristaComboBox;

    @FXML
    private ImageView addMotoristaButton;

    @FXML
    private TextField idReservaField;

    @FXML
    private ComboBox<Veiculo> veiculoComboBox;

    @FXML
    private TextField DuracaoEstimadaField;
    
    @FXML
    private ComboBox<Cliente> clienteComboBox;

    @FXML
    private ImageView addClienteButton;

    @FXML
    void DuracaoEstimadaFieldReleased(KeyEvent event) {
        try {
            Integer.parseInt(DuracaoEstimadaField.getText());
        } catch (Exception e) {
            DuracaoEstimadaField.setText("");
        }
    }

    @FXML
    void addMotoristaButtonClicked(MouseEvent event) {
        
    }

    @FXML
    void addMotoristaButtonEntered(MouseEvent event) {
        addMotoristaButton.setCursor(Cursor.HAND);
    }

    @FXML
    void addMotoristaButtonExited(MouseEvent event) {
        addMotoristaButton.setCursor(Cursor.DEFAULT);
    }

    @FXML
    void addClienteButtonClicked(MouseEvent event) {
        
    }

    @FXML
    void addClienteButtonEntered(MouseEvent event) {
        addClienteButton.setCursor(Cursor.HAND);
    }

    @FXML
    void addClienteButtonExited(MouseEvent event) {
        addClienteButton.setCursor(Cursor.DEFAULT);
    }
    
    @FXML
    void cadastrarButtonAction(ActionEvent event) {
        locacao = new Locacao();
        
        locacao.setDuracao_estiimada(Integer.parseInt(DuracaoEstimadaField.getText()));
        locacao.setKm_final(Float.parseFloat(km_finalField.getText()));
        locacao.setKm_inicial(Float.parseFloat(km_inicialField.getText()));
        locacao.setMotorista(motoristaComboBox.getSelectionModel().getSelectedItem());
        if(!idReservaField.getText().isEmpty())
            locacao.setReserva(Fachada.getInstance().getByIdReserva(Integer.parseInt(idReservaField.getText())));
        locacao.setStatus(statusComboBox.getSelectionModel().getSelectedItem());
        locacao.setTaxa_combuustivel(Float.parseFloat(taxaCombField.getText()));
        locacao.setTaxa_higienizacao(Float.parseFloat(taxaHigienizacaoField.getText()));
        locacao.setTipo_locacao(tipoComboBox.getSelectionModel().getSelectedItem());
        locacao.setValor_locacao(Float.parseFloat(valorLocacaoField.getText()));
        locacao.setVeiculo(veiculoComboBox.getSelectionModel().getSelectedItem());
        
        Fachada.getInstance().persistLocacao(locacao);
        
        AppTelas.voltar();
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
    void km_finalFieldReleased(KeyEvent event) {
        try {
            String valor = km_finalField.getText().replace(",", ".");
            df.format(Double.parseDouble(valor));
            km_finalField.setText(km_finalField.getText().replace(".", ","));
            km_finalField.end();
        } catch (Exception e) {
            km_finalField.setText("");
        }
    }

    @FXML
    void km_inicialFieldReleased(KeyEvent event) {
        try {
            String valor = km_inicialField.getText().replace(",", ".");
            df.format(Double.parseDouble(valor));
            km_inicialField.setText(km_inicialField.getText().replace(".", ","));
            km_inicialField.end();
        } catch (Exception e) {
            km_inicialField.setText("");
        }
    }

    @FXML
    void taxaCombFieldReleased(KeyEvent event) {
        try {
            String valor = taxaCombField.getText().replace(",", ".");
            df.format(Double.parseDouble(valor));
            taxaCombField.setText(taxaCombField.getText().replace(".", ","));
            taxaCombField.end();
        } catch (Exception e) {
            taxaCombField.setText("");
        }
    }

    @FXML
    void taxaHigienizacaoFieldReleased(KeyEvent event) {
        try {
            String valor = taxaHigienizacaoField.getText().replace(",", ".");
            df.format(Double.parseDouble(valor));
            taxaHigienizacaoField.setText(taxaHigienizacaoField.getText().replace(".", ","));
            taxaHigienizacaoField.end();
        } catch (Exception e) {
            taxaHigienizacaoField.setText("");
        }
    }

    @FXML
    void valorLocacaoFieldReleased(KeyEvent event) {
        try {
            String valor = valorLocacaoField.getText().replace(",", ".");
            df.format(Double.parseDouble(valor));
            valorLocacaoField.setText(valorLocacaoField.getText().replace(".", ","));
            valorLocacaoField.end();
        } catch (Exception e) {
            valorLocacaoField.setText("");
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
        carregarTipoStatusComboBox();
        carregarClienteComboBox();
        carregarMotorista();
        carregarVeiculoComboBox();  
    }

    private void carregarTipoStatusComboBox(){
        tipoComboBox.getItems().addAll("Plano controle","Plano Livre");    
        statusComboBox.getItems().addAll("Em andamento","Encerrada");
    }
    
    private void carregarClienteComboBox(){
        clientes = Fachada.getInstance().getAllCliente();
        obsClientes = FXCollections.observableArrayList(clientes);
        
        clienteComboBox.setItems(obsClientes);
    }
    
    private void carregarVeiculoComboBox(){
        veiculos = Fachada.getInstance().getAllVeiculo();
        obsVeiculo = FXCollections.observableArrayList(veiculos);
        
        veiculoComboBox.setItems(obsVeiculo);
    }
    
    private void carregarMotorista(){
        motoristas = Fachada.getInstance().getAllMotorista();
        obsMotorista = FXCollections.observableArrayList(motoristas);
        
        motoristaComboBox.setItems(obsMotorista);
    }
}
