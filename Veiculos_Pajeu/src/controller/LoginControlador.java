package controller;

import app.App;
import fachada.Fachada;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import util.Util;
import view.AppTelas;

public class LoginControlador implements Initializable {

    @FXML
    private TextField loginField;

    @FXML
    private PasswordField senhaField;

    @FXML
    private Button entrarButton;

    @FXML
    private Button sairButton;

    @FXML
    void entrarButtonAction(ActionEvent event) {
        boolean flag = Fachada.getInstance().loginUsuario(loginField.getText(), senhaField.getText());
        if (flag) {
            AppTelas.trocarTela(Util.TELA_HOME);
        }
    }

    @FXML
    void entrarButtonEntered(MouseEvent event) {
         entrarButton.setCursor(Cursor.HAND);
    }

    @FXML
    void entrarButtonExited(MouseEvent event) {
         entrarButton.setCursor(Cursor.DEFAULT);
    }

    @FXML
    void sairButtonAction(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    void sairButtonEntered(MouseEvent event) {
        sairButton.setCursor(Cursor.HAND);
    }

    @FXML
    void sairButtonExited(MouseEvent event) {
         sairButton.setCursor(Cursor.DEFAULT);
    }

    @FXML
    void senhaField_key_pressed(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            boolean flag = Fachada.getInstance().loginUsuario(loginField.getText(), senhaField.getText());
            if (flag) {
                AppTelas.trocarTela(Util.TELA_HOME);
            }
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

}
