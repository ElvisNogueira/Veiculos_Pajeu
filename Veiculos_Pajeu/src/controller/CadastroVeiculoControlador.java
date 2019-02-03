package controller;

import fachada.Fachada;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Observable;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import model.Camioneta_carga;
import model.Camioneta_passageiro;
import model.Categoria;
import model.Locadora;
import model.Veiculo;
import util.Mascara;
import util.Util;
import app.App;

public class CadastroVeiculoControlador implements Initializable {

    boolean flag = false;
    private DecimalFormat df = new DecimalFormat("#####.00");
    Mascara mascara = new Mascara();
    private static CadastroVeiculoControlador controlador;

    Veiculo veiculo = new Veiculo();
    Camioneta_carga camioneta_carga = new Camioneta_carga();
    Camioneta_passageiro camioneta_passageiro = new Camioneta_passageiro();

    ArrayList<Categoria> categorias = new ArrayList<>();
    ArrayList<Locadora> locadoras = new ArrayList<>();

    ObservableList<Categoria> obsCategoria;
    ObservableList<Locadora> obsLocadora;

    @FXML
    private ImageView homeButton;

    @FXML
    private ImageView voltarButton;

    @FXML
    private ImageView irButton;
    
    @FXML
    private ImageView atualizarButton;

    @FXML
    private Button cadastraButton;

    @FXML
    private TextField fabricanteField;

    @FXML
    private RadioButton veiculos_pequenoRadioButton;

    @FXML
    private ToggleGroup tipo_veiculo;

    @FXML
    private RadioButton camionetaCargaRadioButton;

    @FXML
    private RadioButton camionetaPassagRadioButton;

    @FXML
    private TextField modeloField;

    @FXML
    private TextField anoFabricacao;

    @FXML
    private TextField anoModeloField;

    @FXML
    private TextField corField;

    @FXML
    private TextField kmAtualField;

    @FXML
    private TextField numChassiField;

    @FXML
    private TextField numMotor;

    @FXML
    private TextField numPassageirosField;

    @FXML
    private TextField numPortasField;

    @FXML
    private TextField numPlacaField;

    @FXML
    private ComboBox<String> tipoCombustivelComboBox;

    @FXML
    private TextField torqueMotor;

    @FXML
    private ComboBox<Categoria> categoriaComboBox;

    @FXML
    private ComboBox<Locadora> locadoraComboBox;

    @FXML
    private TitledPane camPassageiroTitledPane;

    @FXML
    private ComboBox<String> airbagComboBox;

    @FXML
    private CheckBox cintoSegTraseiroRetCheckBox;

    @FXML
    private CheckBox controlePolicaoArCheckBox;

    @FXML
    private CheckBox direcaoAssistidaCheckBox;

    @FXML
    private CheckBox rodaLigaLeveCheckBox;

    @FXML
    private TitledPane camCargaTitledPane;

    @FXML
    private TextField capTanqueField;

    @FXML
    private TextField capacidadeCargaField;

    @FXML
    private TextField desempenhoField;

    @FXML
    private TextField potenciaMotor;

    @FXML
    private ComboBox<String> acionamentoEmbreagemComboBox;

    
    

    @FXML
    private TextField distEixoField;

    @FXML
    void anoFabricacaoFieldReleased(KeyEvent event) {
        try {
            Integer.parseInt(anoFabricacao.getText());
        } catch (Exception e) {
            anoFabricacao.setText("");
        }
    }

    
    @FXML
    void atualizarButtonClicked(MouseEvent event) {
        carregarCategoriaComboBox();
        carregarLocadora();
    }
    
    @FXML
    void anoModeloFieldReleased(KeyEvent event) {
        try {
            Integer.parseInt(anoModeloField.getText());
        } catch (Exception e) {
            anoModeloField.setText("");
        }
    }

    @FXML
    void cadastraButtonAction(ActionEvent event) {
        if (veiculos_pequenoRadioButton.isSelected()) {
            veiculo.setAno_fabricacao(Integer.parseInt(anoFabricacao.getText()));
            veiculo.setAno_modelo(Integer.parseInt(anoModeloField.getText()));
            veiculo.setCategoria(categoriaComboBox.getSelectionModel().getSelectedItem());
            veiculo.setCor(corField.getText());
            veiculo.setFabricante(fabricanteField.getText());
            veiculo.setKm_atual(Float.parseFloat(kmAtualField.getText()));
            veiculo.setLocadora(locadoraComboBox.getSelectionModel().getSelectedItem());
            veiculo.setModelo(modeloField.getText());
            veiculo.setNumChassi(numChassiField.getText());
            veiculo.setNum_motor(numMotor.getText());
            veiculo.setNum_passageiros(Integer.parseInt(numPassageirosField.getText()));
            veiculo.setNum_portas(Integer.parseInt(numPortasField.getText()));
            veiculo.setPlaca(numPlacaField.getText());
            veiculo.setTipo_combuustivel(tipoCombustivelComboBox.getSelectionModel().getSelectedItem());
            veiculo.setTorqe_motor(Float.parseFloat(torqueMotor.getText()));
            if (flag) {
                Fachada.getInstance().mergeVeiculo(veiculo);
            } else {
                Fachada.getInstance().persistVeiculo(veiculo);
            }

        } else if (camionetaCargaRadioButton.isSelected()) {
            camioneta_carga.setAcionamento_embreagem(acionamentoEmbreagemComboBox.
                    getSelectionModel().getSelectedItem());
            camioneta_carga.setAno_fabricacao(Integer.parseInt(anoFabricacao.getText()));
            camioneta_carga.setAno_modelo(Integer.parseInt(anoModeloField.getText()));
            camioneta_carga.setCapaccidade_tanque(Float.parseFloat(capTanqueField.
                    getText().replace(",", ".")));
            camioneta_carga.setCapacidade_carga(Float.parseFloat(capacidadeCargaField.
                    getText().replace(",", ".")));
            camioneta_carga.setCategoria(categoriaComboBox.getSelectionModel().getSelectedItem());
            camioneta_carga.setCor(corField.getText());
            camioneta_carga.setFabricante(fabricanteField.getText());
            camioneta_carga.setKm_atual(Float.parseFloat(kmAtualField.getText()));
            camioneta_carga.setLocadora(locadoraComboBox.getSelectionModel().getSelectedItem());
            camioneta_carga.setModelo(modeloField.getText());
            camioneta_carga.setNumChassi(numChassiField.getText());
            camioneta_carga.setNum_motor(numMotor.getText());
            camioneta_carga.setNum_passageiros(Integer.parseInt(numPassageirosField.getText()));
            camioneta_carga.setNum_portas(Integer.parseInt(numPortasField.getText()));
            camioneta_carga.setPlaca(numPlacaField.getText());
            camioneta_carga.setTipo_combuustivel(tipoCombustivelComboBox.getSelectionModel().getSelectedItem());
            camioneta_carga.setTorqe_motor(Float.parseFloat(torqueMotor.getText().replace(",", ".")));
            camioneta_carga.setDesempenho(Float.parseFloat(desempenhoField.getText().replace(",", ".")));
            camioneta_carga.setDistancia_eixos(Float.parseFloat(distEixoField.getText().replace(",", ".")));
            camioneta_carga.setPotencia_motor(Integer.parseInt(potenciaMotor.getText()));

            if (flag) {
                Fachada.getInstance().mergeCamioneta_carga(camioneta_carga);
            } else {
                Fachada.getInstance().persistCamioneta_carga(camioneta_carga);
            }

        } else if (camionetaPassagRadioButton.isSelected()) {
            camioneta_passageiro.setAno_fabricacao(Integer.parseInt(anoFabricacao.getText()));
            camioneta_passageiro.setAno_modelo(Integer.parseInt(anoModeloField.getText()));
            camioneta_passageiro.setCategoria(categoriaComboBox.getSelectionModel().getSelectedItem());
            camioneta_passageiro.setCor(corField.getText());
            camioneta_passageiro.setFabricante(fabricanteField.getText());
            camioneta_passageiro.setKm_atual(Float.parseFloat(kmAtualField.getText()));
            camioneta_passageiro.setLocadora(locadoraComboBox.getSelectionModel().getSelectedItem());
            camioneta_passageiro.setModelo(modeloField.getText());
            camioneta_passageiro.setNumChassi(numChassiField.getText());
            camioneta_passageiro.setNum_motor(numMotor.getText());
            camioneta_passageiro.setNum_passageiros(Integer.parseInt(numPassageirosField.getText()));
            camioneta_passageiro.setNum_portas(Integer.parseInt(numPortasField.getText()));
            camioneta_passageiro.setPlaca(numPlacaField.getText());
            camioneta_passageiro.setTipo_combuustivel(tipoCombustivelComboBox.getSelectionModel().getSelectedItem());
            camioneta_passageiro.setTorqe_motor(Float.parseFloat(torqueMotor.getText()));
            camioneta_passageiro.setAirbag(airbagComboBox.getSelectionModel().getSelectedItem());
            camioneta_passageiro.setCinto_seg_traseiros_ret(true);
            camioneta_passageiro.setControle_poluicao_ar(controlePolicaoArCheckBox.isSelected());
            camioneta_passageiro.setDirecao_assistida(direcaoAssistidaCheckBox.isSelected());
            camioneta_passageiro.setRodas_liga_leve(rodaLigaLeveCheckBox.isSelected());

            if (flag) {
                Fachada.getInstance().mergeCamioneta_passageiro(camioneta_passageiro);
            } else {
                Fachada.getInstance().persistCamioneta_passageiro(camioneta_passageiro);
            }
            
        }
        
        flag = false;
            limparCampos(veiculo);
            App.voltar();
    }

    public void setVeiculo(Veiculo veiculo) {
        flag = true;
        camioneta_carga = Fachada.getInstance().getByIdCamioneta_carga(veiculo.getId());
        camioneta_passageiro = Fachada.getInstance().getByIdCamioneta_passageiro(veiculo.getId());

        if (camioneta_carga != null) {
            camionetaCargaRadioButton.setSelected(true);
            acionamentoEmbreagemComboBox.getSelectionModel().select(camioneta_carga.getAcionamento_embreagem());
            anoFabricacao.setText(camioneta_carga.getAno_fabricacao() + "");
            anoModeloField.setText(camioneta_carga.getAno_modelo() + "");
            capTanqueField.setText(camioneta_carga.getCapaccidade_tanque() + "");
            capacidadeCargaField.setText(camioneta_carga.getCapacidade_carga() + "");
            categoriaComboBox.getSelectionModel().select(camioneta_carga.getCategoria());
            corField.setText(camioneta_carga.getCor());
            fabricanteField.setText(camioneta_carga.getFabricante());
            kmAtualField.setText(camioneta_carga.getKm_atual() + "");
            locadoraComboBox.getSelectionModel().select(camioneta_carga.getLocadora());
            modeloField.setText(camioneta_carga.getModelo());
            numChassiField.setText(camioneta_carga.getNumChassi());
            numMotor.setText(camioneta_carga.getNum_motor());
            numPassageirosField.setText(camioneta_carga.getNum_passageiros() + "");
            numPortasField.setText(camioneta_carga.getNum_portas() + "");
            numPlacaField.setText(camioneta_carga.getPlaca());
            tipoCombustivelComboBox.getSelectionModel().select(camioneta_carga.getTipo_combuustivel());
            torqueMotor.setText(camioneta_carga.getTorqe_motor() + "");
            desempenhoField.setText(camioneta_carga.getDesempenho() + "");
            distEixoField.setText(camioneta_carga.getDistancia_eixos() + "");
            potenciaMotor.setText(camioneta_carga.getPotencia_motor() + "");
            camCargaTitledPane.setExpanded(true);
            camCargaTitledPane.setDisable(false);

            camPassageiroTitledPane.setExpanded(false);
            camPassageiroTitledPane.setDisable(true);
        } else if (camioneta_passageiro != null) {
            camionetaPassagRadioButton.setSelected(true);

            camCargaTitledPane.setExpanded(false);
            camCargaTitledPane.setDisable(true);

            camPassageiroTitledPane.setExpanded(true);
            camPassageiroTitledPane.setDisable(false);

            anoFabricacao.setText(camioneta_passageiro.getAno_fabricacao() + "");
            anoModeloField.setText(camioneta_passageiro.getAno_modelo() + "");
            categoriaComboBox.getSelectionModel().select(camioneta_passageiro.getCategoria());
            corField.setText(camioneta_passageiro.getCor());
            fabricanteField.setText(camioneta_passageiro.getFabricante());
            kmAtualField.setText(camioneta_passageiro.getKm_atual() + "");
            locadoraComboBox.getSelectionModel().select(camioneta_passageiro.getLocadora());
            modeloField.setText(camioneta_passageiro.getModelo());
            numChassiField.setText(camioneta_passageiro.getNumChassi());
            numMotor.setText(camioneta_passageiro.getNum_motor());
            numPassageirosField.setText(camioneta_passageiro.getNum_passageiros() + "");
            numPortasField.setText(camioneta_passageiro.getNum_portas() + "");
            numPlacaField.setText(camioneta_passageiro.getPlaca());
            tipoCombustivelComboBox.getSelectionModel().select(camioneta_passageiro.getTipo_combuustivel());
            torqueMotor.setText(camioneta_passageiro.getTorqe_motor() + "");
            airbagComboBox.getSelectionModel().select(camioneta_passageiro.getAirbag());
            cintoSegTraseiroRetCheckBox.setSelected(camioneta_passageiro.isCinto_seg_traseiros_ret());
            controlePolicaoArCheckBox.setSelected(camioneta_passageiro.isControle_poluicao_ar());
            direcaoAssistidaCheckBox.setSelected(camioneta_passageiro.isDirecao_assistida());
            rodaLigaLeveCheckBox.setSelected(camioneta_passageiro.isRodas_liga_leve());
        } else {
            veiculos_pequenoRadioButton.setSelected(true);
            camCargaTitledPane.setExpanded(false);
            camCargaTitledPane.setDisable(true);

            camPassageiroTitledPane.setExpanded(false);
            camPassageiroTitledPane.setDisable(true);

            anoFabricacao.setText(veiculo.getAno_fabricacao() + "");
            anoModeloField.setText(veiculo.getAno_modelo() + "");
            categoriaComboBox.getSelectionModel().select(veiculo.getCategoria());
            corField.setText(veiculo.getCor());
            fabricanteField.setText(veiculo.getFabricante());
            kmAtualField.setText(veiculo.getKm_atual() + "");
            locadoraComboBox.getSelectionModel().select(veiculo.getLocadora());
            modeloField.setText(veiculo.getModelo());
            numChassiField.setText(veiculo.getNumChassi());
            numMotor.setText(veiculo.getNum_motor());
            numPassageirosField.setText(veiculo.getNum_passageiros() + "");
            numPortasField.setText(veiculo.getNum_portas() + "");
            numPlacaField.setText(veiculo.getPlaca());
            tipoCombustivelComboBox.getSelectionModel().select(veiculo.getTipo_combuustivel());
            torqueMotor.setText(veiculo.getTorqe_motor() + "");

        }
    }

    public void limparCampos(Veiculo veiculo) {
        camionetaCargaRadioButton.setSelected(true);
        acionamentoEmbreagemComboBox.getSelectionModel().select(0);
        anoFabricacao.setText("");
        anoModeloField.setText("");
        capTanqueField.setText("");
        capacidadeCargaField.setText("");
        categoriaComboBox.getSelectionModel().select(0);
        corField.setText("");
        fabricanteField.setText("");
        kmAtualField.setText("");
        locadoraComboBox.getSelectionModel().select(0);
        modeloField.setText("");
        numChassiField.setText("");
        numMotor.setText("");
        numPassageirosField.setText("");
        numPortasField.setText("");
        numPlacaField.setText("");
        tipoCombustivelComboBox.getSelectionModel().select(0);
        torqueMotor.setText("");
        desempenhoField.setText("");
        distEixoField.setText("");
        potenciaMotor.setText("");
        camCargaTitledPane.setExpanded(true);
        camCargaTitledPane.setDisable(false);

        camPassageiroTitledPane.setExpanded(false);
        camPassageiroTitledPane.setDisable(true);

        camionetaPassagRadioButton.setSelected(true);

        camCargaTitledPane.setExpanded(false);
        camCargaTitledPane.setDisable(true);
        airbagComboBox.getSelectionModel().select(0);
        cintoSegTraseiroRetCheckBox.setSelected(false);
        controlePolicaoArCheckBox.setSelected(false);
        direcaoAssistidaCheckBox.setSelected(false);
        rodaLigaLeveCheckBox.setSelected(false);
    }

    public void bloquear(Veiculo veiculo) {
        setVeiculo(veiculo);
        camionetaCargaRadioButton.setSelected(true);
        acionamentoEmbreagemComboBox.setEditable(false);
        anoFabricacao.setEditable(false);
        anoModeloField.setEditable(false);
        capTanqueField.setEditable(false);
        capacidadeCargaField.setEditable(false);
        categoriaComboBox.setEditable(false);
        corField.setEditable(false);
        fabricanteField.setEditable(false);
        kmAtualField.setEditable(false);
        locadoraComboBox.setEditable(false);
        modeloField.setEditable(false);
        numChassiField.setEditable(false);
        numMotor.setEditable(false);
        numPassageirosField.setEditable(false);
        numPortasField.setEditable(false);
        numPlacaField.setEditable(false);
        tipoCombustivelComboBox.setEditable(false);
        torqueMotor.setEditable(false);
        desempenhoField.setEditable(false);
        distEixoField.setEditable(false);
        potenciaMotor.setEditable(false);
        camCargaTitledPane.setExpanded(false);
        camCargaTitledPane.setDisable(true);

        camPassageiroTitledPane.setExpanded(false);
        camPassageiroTitledPane.setDisable(true);

        camionetaPassagRadioButton.setDisable(true);

        camCargaTitledPane.setExpanded(false);
        camCargaTitledPane.setDisable(true);
        airbagComboBox.setDisable(true);
        cintoSegTraseiroRetCheckBox.setDisable(true);
        controlePolicaoArCheckBox.setDisable(true);
        direcaoAssistidaCheckBox.setDisable(true);
        rodaLigaLeveCheckBox.setDisable(true);
    }

    @FXML
    void desempenhoFieldReleased(KeyEvent event) {
        try {
            String valor = desempenhoField.getText().replace(",", ".");
            df.format(Double.parseDouble(valor));
            desempenhoField.setText(desempenhoField.getText().replace(".", ","));
            desempenhoField.end();
        } catch (Exception e) {
            kmAtualField.setText("");
        }
    }

    public static CadastroVeiculoControlador get() {
        return controlador;
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
    void kmAtualFieldReleased(KeyEvent event) {
        try {
            String valor = kmAtualField.getText().replace(",", ".");
            df.format(Double.parseDouble(valor));
            kmAtualField.setText(kmAtualField.getText().replace(".", ","));
            kmAtualField.end();
        } catch (Exception e) {
            kmAtualField.setText("");
        }
    }

    @FXML
    void numChassiFieldReleased(KeyEvent event) {
        String texto;
        texto = numChassiField.getText();
        numChassiField.setText(texto.toUpperCase());
        numChassiField.end();
    }

    @FXML
    void numPassageirosFieldReleased(KeyEvent event) {
        try {
            Integer.parseInt(numPassageirosField.getText());
        } catch (Exception e) {
            numPassageirosField.setText("");
        }

    }

    @FXML
    void numPlacaFieldReleased(KeyEvent event) {
        mascara.setMask("AAA####");
        mascara.setCaracteresValidos("0123456789AaBbCcDdEeFfGgHhIiJjKkLlMm"
                + "NnOoPpQqRrSsTtUuVvXxWwYyZz");
        mascara.setTf(numPlacaField);
        mascara.formatter();
    }

    @FXML
    void numPortasFieldReleased(KeyEvent event) {
        try {
            Integer.parseInt(numPortasField.getText());
        } catch (Exception e) {
            numPortasField.setText("");
        }
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

    @FXML
    void camionetaCargaRadioButtonAction(ActionEvent event) {
        camPassageiroTitledPane.setDisable(true);
        camCargaTitledPane.setDisable(false);
    }

    @FXML
    void camionetaPassagRadioButtonAction(ActionEvent event) {
        camPassageiroTitledPane.setDisable(false);
        camCargaTitledPane.setDisable(true);
    }

    @FXML
    void veiculos_pequenoRadioButtonAction(ActionEvent event) {
        camPassageiroTitledPane.setDisable(true);
        camCargaTitledPane.setDisable(true);
    }

    @FXML
    void potenciaMotorReleased(KeyEvent event) {
        try {
            String valor = potenciaMotor.getText().replace(",", ".");
            df.format(Double.parseDouble(valor));
            potenciaMotor.setText(potenciaMotor.getText().replace(".", ","));
            potenciaMotor.end();
        } catch (Exception e) {
            potenciaMotor.setText("");
        }

    }

    @FXML
    void distEixoFieldReleased(KeyEvent event) {
        try {
            String valor = potenciaMotor.getText().replace(",", ".");
            df.format(Double.parseDouble(valor));
            potenciaMotor.setText(potenciaMotor.getText().replace(".", ","));
            potenciaMotor.end();
        } catch (Exception e) {
            potenciaMotor.setText("");
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        controlador = this;
        camPassageiroTitledPane.setDisable(true);
        camCargaTitledPane.setDisable(true);
        carregarComboBoxesString();
        carregarCategoriaComboBox();
        carregarLocadora();
    }

    public void carregarComboBoxesString() {
        acionamentoEmbreagemComboBox.getItems().setAll("Multidisco", "Centrífuga", "Hidraúlica");
        airbagComboBox.getItems().setAll("Simples-dianteira", "Duplo-dianteira", "Total");
        tipoCombustivelComboBox.getItems().setAll("Alcool", "Diesel", "Gasolina");
    }

    public void carregarCategoriaComboBox() {
        categorias = Fachada.getInstance().getAllCategoria();
        obsCategoria = FXCollections.observableArrayList(categorias);

        categoriaComboBox.setItems(obsCategoria);
    }

    public void carregarLocadora() {
        locadoras = Fachada.getInstance().getAllLocadora();
        obsLocadora = FXCollections.observableArrayList(locadoras);
        
        

        locadoraComboBox.setItems(obsLocadora);
    }

}
