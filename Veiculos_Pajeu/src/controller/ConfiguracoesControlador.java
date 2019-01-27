package controller;

import fachada.Fachada;
import java.net.URL;
import java.sql.Time;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import model.Configuracoes;
import model.Locadora;
import util.Util;
import view.AppTelas;

public class ConfiguracoesControlador implements Initializable{
    Configuracoes configuracoes = new Configuracoes();
    
    @FXML
    private ImageView homeButton;

    @FXML
    private ImageView voltarButton;

    @FXML
    private ImageView irButton;

    @FXML
    private ComboBox<Locadora> filialComboBox;

    @FXML
    private ImageView addFilialButton;

    @FXML
    private Spinner<Integer> horaBackup_hora;

    @FXML
    private Spinner<Integer> horaBackup_min;

    @FXML
    private Pane cadastrarCategoriaPanel;

    @FXML
    private Pane backupPanel;

    @FXML
    private Pane restaurarPanel;

    @FXML
    private Button salvarButton;

    @FXML
    void addFilialButtonClicked(MouseEvent event) {
        AppTelas.trocarTela(Util.TELA_CATEGORIA, Util.ABRIR);
    }

    @FXML
    void backupPanelClicked(MouseEvent event) {
        
    }

    @FXML
    void backupPanelEntred(MouseEvent event) {
        backupPanel.setStyle(Util.PANE_SELEC);
    }

    @FXML
    void backupPanelExited(MouseEvent event) {
        backupPanel.setStyle(Util.PANE_DESSELEC);
    }

    @FXML
    void cadastrarCategoriaPanelClicked(MouseEvent event) {
        
    }

    @FXML
    void cadastrarCategoriaPanelEntered(MouseEvent event) {
        
    }

    @FXML
    void cadastrarCategoriaPanelExited(MouseEvent event) {

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
    void restaurarPanelClicked(MouseEvent event) {

    }

    @FXML
    void restaurarPanelEntred(MouseEvent event) {

    }

    @FXML
    void restaurarPanelExited(MouseEvent event) {

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
    void salvarButtonAction(ActionEvent event) {
        configuracoes.setLocadora(filialComboBox.getSelectionModel().getSelectedItem());
        configuracoes.setHoraBackup(new Time(horaBackup_hora.getValue(), horaBackup_min.getValue(), 0));
        
       if(Fachada.getInstance().getAllConfiguracoes().isEmpty())
            Fachada.getInstance().persistConfiguracoes(configuracoes);
       else
           Fachada.getInstance().mergeConfiguracoes(configuracoes);
    }       

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if(Fachada.getInstance().getAllConfiguracoes().isEmpty()){
            horaBackup_min.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 59, 
                Util.horaAtual().getMinutes()));
            horaBackup_hora.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 23, 
                Util.horaAtual().getHours()));
        }
    }

}
