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
import app.App;
import java.sql.Date;
import model.Relatorio_financeiro;

public class RelatorioFinanceiroControlador implements Initializable{

    @FXML
    private TableView<Relatorio_financeiro> financeiroTable;

    @FXML
    private TableColumn<Relatorio_financeiro, ?> idColumn;

    @FXML
    private TableColumn<Relatorio_financeiro, Date> dataColumn;

    @FXML
    private TableColumn<Relatorio_financeiro, String> tipoColumn;

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
        tipoComboBox.getSelectionModel().select(-1);
        dataInicio.getEditor().setText("");
        datafFim.getEditor().setText("");
        
        inicializarTabela();
    }

    @FXML
    void buscarClicked(MouseEvent event) {
        inicializarTabela();
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
        inicializarTabela();
        tipoComboBox.getItems().addAll("Locação","Reserva");
    }
    
    public void inicializarTabela(){
        idColumn.setCellValueFactory(new PropertyValueFactory("id"));
        dataColumn.setCellValueFactory(new PropertyValueFactory("data"));
        tipoColumn.setCellValueFactory(new PropertyValueFactory("tipo_conta"));
        
        financeiroTable.setItems(carregar());
    }
    
    public ObservableList carregar(){
        ArrayList<Relatorio_financeiro> aux = Fachada.getInstance().getAllRelatorio_financeiro();
        ArrayList<Relatorio_financeiro> relatorio_financeiros = new ArrayList<>();
        System.out.println(tipoComboBox.getSelectionModel().getSelectedIndex());
        if(tipoComboBox.getSelectionModel().getSelectedIndex()==-1){
            if(dataInicio.getEditor().getText().isEmpty() && datafFim.getEditor().getText().isEmpty()){
                relatorio_financeiros = aux;
                System.err.println("aqi");
            }else{
                Date d1  = new Date(dataInicio.getValue().getYear()-1900, dataInicio.getValue().getMonthValue()-1,
                dataInicio.getValue().getDayOfMonth());
                Date d2  = new Date(datafFim.getValue().getYear()-1900, datafFim.getValue().getMonthValue()-1,
                datafFim.getValue().getDayOfMonth());
                
                for(Relatorio_financeiro f : Fachada.getInstance().getAllRelatorio_financeiro()){
                    if(f.getData().before(d2) && f.getData().after(d1)){
                        relatorio_financeiros.add(f);
                    }
                }
            }                
        }else{
            if(dataInicio.getEditor().getText().isEmpty() && datafFim.getEditor().getText().isEmpty()){
                for(Relatorio_financeiro f : Fachada.getInstance().getAllRelatorio_financeiro()){
                    if(f.equals(tipoComboBox.getSelectionModel().getSelectedItem())){
                        relatorio_financeiros.add(f);
                    }
                }
//                relatorio_financeiros = aux;
            }else{
                Date d1  = new Date(dataInicio.getValue().getYear()-1900, dataInicio.getValue().getMonthValue()-1,
                dataInicio.getValue().getDayOfMonth());
                Date d2  = new Date(datafFim.getValue().getYear()-1900, datafFim.getValue().getMonthValue()-1,
                datafFim.getValue().getDayOfMonth());
                
                for(Relatorio_financeiro f : Fachada.getInstance().getAllRelatorio_financeiro()){
                    if((f.getData().before(d2) && f.getData().after(d1)) &&
                        (f.getTipo_conta().equals(tipoComboBox.getSelectionModel().getSelectedItem()))){
                            relatorio_financeiros.add(f);
                    }
                }
            }
        }
        
        
        return FXCollections.observableList(relatorio_financeiros);
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
