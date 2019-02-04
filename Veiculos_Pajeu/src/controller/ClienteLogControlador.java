package controller;

import java.sql.Date;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import model.Clientelog;

public class ClienteLogControlador {

    @FXML
    private TableView<Clientelog> tabelaNovo;

    @FXML
    private TableColumn<Clientelog, Date> dataColumn;

    @FXML
    private TableColumn<Clientelog, String> opColumn;

    @FXML
    private TableColumn<Clientelog, String> nomeNNovo;

    @FXML
    private TableColumn<Clientelog, String> telefoneNovo;

    @FXML
    private ImageView atualizarButton;

    @FXML
    private ImageView homeButton;

    @FXML
    private ImageView voltarButton;

    @FXML
    private ImageView irButton;

    @FXML
    private TableView<Clientelog> tabelaNovo1;

    @FXML
    private TableColumn<Clientelog, String> nomeAnt;

    @FXML
    private TableColumn<Clientelog, String> telefoneAnt;

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

}
