package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import view.AppTelas;

public class AlertaBackupControlador implements Initializable {

    private static AlertaBackupControlador controlador;

    public static AlertaBackupControlador get() {
        return controlador;
    }

    public void fimBackup() {
        AppTelas.voltar();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        controlador = this;
    }

}
