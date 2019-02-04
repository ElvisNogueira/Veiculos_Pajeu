package controller;

import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import model.Camioneta_cargalog;

public class CamionetaCargalogControlador implements Initializable{

    @FXML
    private TableView<Camioneta_cargalog> tabelaNovo;

    @FXML
    private TableColumn<Camioneta_cargalog, Date> dataColumn;

    @FXML
    private TableColumn<Camioneta_cargalog, String> opColumn;

    @FXML
    private TableColumn<Camioneta_cargalog, Float> embreagemNovo;

    @FXML
    private TableColumn<Camioneta_cargalog, Float> capTanqueNovo;

    @FXML
    private TableColumn<Camioneta_cargalog, Float> capCargaNovo;

    @FXML
    private TableColumn<Camioneta_cargalog, Float> desempNovo;

    @FXML
    private TableColumn<Camioneta_cargalog, Float> distEixosNovo;

    @FXML
    private TableColumn<Camioneta_cargalog, Integer> potMotorNovvo;

    @FXML
    private ImageView atualizarButton;

    @FXML
    private ImageView homeButton;

    @FXML
    private ImageView voltarButton;

    @FXML
    private ImageView irButton;

    @FXML
    private TableView<Camioneta_cargalog> tabelaAnt;

    @FXML
    private TableColumn<Camioneta_cargalog, String> acionEmbAnt;

    @FXML
    private TableColumn<Camioneta_cargalog, Float> capTanqueAnt;

    @FXML
    private TableColumn<Camioneta_cargalog, Float> capCargaAntt;

    @FXML
    private TableColumn<Camioneta_cargalog, Float> desempAnt;

    @FXML
    private TableColumn<Camioneta_cargalog, Float> disEixAnt;

    @FXML
    private TableColumn<Camioneta_cargalog, Float> potMotorAnt;

    @FXML
    void atualizarButtonClicked(MouseEvent event) {

    }

    @FXML
    void atualizarButtonEntered(MouseEvent event) {

    }

    @FXML
    void atualizarButtonExited(MouseEvent event) {

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
    void tabelaClicked(MouseEvent event) {

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
        
    }

}
