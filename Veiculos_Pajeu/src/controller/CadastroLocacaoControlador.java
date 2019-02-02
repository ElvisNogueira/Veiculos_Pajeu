package controller;

import fachada.Fachada;
import java.net.URL;
import java.sql.Date;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
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
import model.Financeiro;
import model.Locacao;
import model.Motorista;
import model.Veiculo;
import util.Util;
import view.AppTelas;

public class CadastroLocacaoControlador implements Initializable {

    static CadastroLocacaoControlador controlador;
    boolean flag = true;
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
        AppTelas.trocarTela(Util.TELA_CAD_MOTORISTA, Util.ABRIR);
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
        AppTelas.trocarTela(Util.TELA_CAD_CLIENTE, Util.ABRIR);
    }

    @FXML
    void addClienteButtonEntered(MouseEvent event) {
        addClienteButton.setCursor(Cursor.HAND);
    }

    @FXML
    void addClienteButtonExited(MouseEvent event) {
        addClienteButton.setCursor(Cursor.DEFAULT);
    }

    public static CadastroLocacaoControlador get() {
        return controlador;
    }

    @FXML
    void cadastrarButtonAction(ActionEvent event) {
        locacao = new Locacao();

        locacao.setDuracao_estiimada(Integer.parseInt(DuracaoEstimadaField.getText()));
        locacao.setKm_final(Float.parseFloat(km_finalField.getText()));
        locacao.setKm_inicial(Float.parseFloat(km_inicialField.getText()));
        locacao.setMotorista(motoristaComboBox.getSelectionModel().getSelectedItem());
        if (!idReservaField.getText().isEmpty()) {
            locacao.setReserva(Fachada.getInstance().getByIdReserva(Integer.parseInt(idReservaField.getText())));
        }
        locacao.setStatus(statusComboBox.getSelectionModel().getSelectedItem());
        locacao.setTaxa_combuustivel(Float.parseFloat(taxaCombField.getText()));
        locacao.setTaxa_higienizacao(Float.parseFloat(taxaHigienizacaoField.getText()));
        locacao.setTipo_locacao(tipoComboBox.getSelectionModel().getSelectedItem());
        locacao.setValor_locacao(Float.parseFloat(valorLocacaoField.getText()));
        locacao.setVeiculo(veiculoComboBox.getSelectionModel().getSelectedItem());

        if (flag) {
            if (!statusComboBox.getSelectionModel().getSelectedItem().equals("Em andamento")) {
                locacao.setHora_devolucao(Util.horaAtual());
                locacao.setData_devolucao(Util.dataAtual());
                Calendar dRet = Calendar.getInstance();
                Calendar dDev = Calendar.getInstance();
                dRet.set(locacao.getData_retirada().getYear(), locacao.getData_retirada().getMonth(),
                        locacao.getData_retirada().getDate(), locacao.getHora_retirada().getHours(),
                        locacao.getHora_retirada().getMinutes());
                dDev.set(locacao.getData_devolucao().getYear(), locacao.getData_devolucao().getMonth(),
                        locacao.getData_devolucao().getDate(), locacao.getHora_retirada().getHours(),
                        locacao.getHora_devolucao().getMinutes());
                dRet.add(Calendar.DAY_OF_MONTH, locacao.getDuracao_estiimada());
                dRet.add(Calendar.HOUR, 1);
                float valorLocacao;
                float taxas;
                if (dRet.after(dDev)) {
                    Long dif = (dRet.getTime().getTime()) - (dDev.getTime().getTime());
                    float difHoras = Math.round(dif / (60 * 60 * 1000));
                    if (difHoras < 3) {
                        taxas = (float) (0.25 * locacao.getVeiculo().getCategoria().getValor_aluguel_controle());
                    } else {
                        taxas=0;
                    }
                    if (locacao.getTipo_locacao().equals("Plano controle")) {
                        valorLocacao = (locacao.getDuracao_estiimada() * locacao.getVeiculo().getCategoria().
                                getValor_aluguel_controle())+taxas;
                    }else{
                       valorLocacao = ((locacao.getKm_final()-locacao.getKm_inicial()) * locacao.getVeiculo().
                               getCategoria().getValor_aluguel_controle())+taxas; 
                    }
                    Financeiro f = new Financeiro(locacao.getData_devolucao(), valorLocacao, 
                            "", Fachada.getInstance().getBuscaConta("Loc").get(0), Fachada.getUserLogado());
                    CadastroFinanceiroControlador.get().set(f);
                    AppTelas.trocarTela(Util.TELA_CAD_FINANCEIRO, Util.ABRIR);
                }
            } else {
                Fachada.getInstance().mergeLocacao(locacao);
            }
        } else {
            locacao.setHora_retirada(Util.horaAtual());
            locacao.setData_retirada(Util.dataAtual());
            locacao.setStatus("Em andamento");
            Fachada.getInstance().persistLocacao(locacao);
        }

        AppTelas.voltar();
    }

    @FXML
    private ImageView atualizarButton;

    @FXML
    void atualizarButtonClicked(MouseEvent event) {

    }

    public void set(Locacao locacao) {
        statusComboBox.setDisable(false);
        DuracaoEstimadaField.setText(locacao.getDuracao_estiimada() + "");
        km_finalField.setText(locacao.getKm_final() + "");
        km_inicialField.setText(locacao.getKm_inicial() + "");
        motoristaComboBox.getSelectionModel().select(locacao.getMotorista());
        if (locacao.getId() == 0) {
            idReservaField.setText(locacao.getReserva().getId() + "");
        }
        statusComboBox.getSelectionModel().select(locacao.getStatus());
        taxaCombField.setText(locacao.getTaxa_combuustivel() + "");
        taxaHigienizacaoField.setText(locacao.getTaxa_higienizacao() + "");
        tipoComboBox.getSelectionModel().select(locacao.getTipo_locacao());
        valorLocacaoField.setText(locacao.getValor_locacao() + "");
        veiculoComboBox.getSelectionModel().select(locacao.getVeiculo());
    }

    public void limpar() {
        DuracaoEstimadaField.setText("");
        km_finalField.setText("");
        km_inicialField.setText("");
        motoristaComboBox.getSelectionModel().select(0);

        idReservaField.setText("");
        statusComboBox.getSelectionModel().select(0);
        taxaCombField.setText("");
        taxaHigienizacaoField.setText("");
        tipoComboBox.getSelectionModel().select(0);
        valorLocacaoField.setText("");
        veiculoComboBox.getSelectionModel().select(0);
    }

    public void bloquear(Locacao locacao) {
        set(locacao);
        DuracaoEstimadaField.setEditable(false);
        km_finalField.setEditable(false);
        km_inicialField.setEditable(false);
        motoristaComboBox.setEditable(false);;

        idReservaField.setEditable(false);;
        statusComboBox.setEditable(false);;
        taxaCombField.setEditable(false);;
        taxaHigienizacaoField.setEditable(false);;
        tipoComboBox.setEditable(false);
        valorLocacaoField.setEditable(false);;
        veiculoComboBox.setEditable(false);;
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
        controlador = this;
        carregarTipoStatusComboBox();
        carregarClienteComboBox();
        carregarMotorista();
        carregarVeiculoComboBox();
    }

    private void carregarTipoStatusComboBox() {
        tipoComboBox.getItems().addAll("Plano controle", "Plano Livre");
        statusComboBox.getItems().addAll("Em andamento", "Encerrada");
    }

    private void carregarClienteComboBox() {
        clientes = Fachada.getInstance().getAllCliente();
        obsClientes = FXCollections.observableArrayList(clientes);

        clienteComboBox.setItems(obsClientes);
    }

    private void carregarVeiculoComboBox() {
        veiculos = Fachada.getInstance().getAllVeiculo();
        obsVeiculo = FXCollections.observableArrayList(veiculos);

        veiculoComboBox.setItems(obsVeiculo);
    }

    private void carregarMotorista() {
        motoristas = Fachada.getInstance().getAllMotorista();
        obsMotorista = FXCollections.observableArrayList(motoristas);

        motoristaComboBox.setItems(obsMotorista);
    }
}
