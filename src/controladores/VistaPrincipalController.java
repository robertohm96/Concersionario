/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controladores;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.paint.Color;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;

/**
 * FXML Controller class
 *
 * @author usuario
 */
public class VistaPrincipalController implements Initializable {

    @FXML
    private Label btnInicio;
    @FXML
    private Label txtNombreCliente;
    @FXML
    private Pane panelA1;
    @FXML
    private Label txtMarca;
    @FXML
    private Label txtModelo;
    @FXML
    private TextField txtPrecioA;
    @FXML
    private Pane panelA2;
    @FXML
    private Label txtMarca1;
    @FXML
    private Label txtModelo1;
    @FXML
    private TextField txtPrecioA1;
    @FXML
    private Pane panelA3;
    @FXML
    private Label txtMarca2;
    @FXML
    private Label txtModelo2;
    @FXML
    private TextField txtPrecioA2;
    @FXML
    private Pane panelA4;
    @FXML
    private Label txtMarca3;
    @FXML
    private Label txtModelo3;
    @FXML
    private TextField txtPrecioA3;
    @FXML
    private GridPane vistaInicio;
    @FXML
    private Pane panelDescripcion;
    @FXML
    private ImageView imgContenedor;
    @FXML
    private Label txtMarcaGeneral;
    @FXML
    private Label txtModeloGneral;
    @FXML
    private Label txtColorGeneral;
    @FXML
    private Label txtStockGeneral;
    @FXML
    private TextField txtPrecioGenral;
    @FXML
    private Spinner<?> spinnerCantidadGenral;
    @FXML
    private Button btnAddCarrito;
    @FXML
    private ImageView btnAddDeseos;
    @FXML
    private Label btnCarrito;
    @FXML
    private Label btnDeseos;
    @FXML
    private Label btnCompras;
    @FXML
    private Label btnSalir;
    @FXML
    private Pane VistaCarrito;
    @FXML
    private Button btnAddCarrito1;
    @FXML
    private Button btnAddCarrito11;
    @FXML
    private Button btnAddCarrito12;
    @FXML
    private Pane vistaDeseos;
    @FXML
    private Button btnAddCarrito111;
    @FXML
    private Button btnAddCarrito121;
    @FXML
    private Pane vistaCompras;
    @FXML
    private Pane PanelHistorial;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void abrirCatalogo(MouseEvent event) {
        reseterarVistas();
        vistaInicio.setVisible(true);
    }

    @FXML
    private void VerCarrito(MouseEvent event) {
    }

    @FXML
    private void verListaDeseos(MouseEvent event) {
    }

    @FXML
    private void verCompras(MouseEvent event) {
    }

    @FXML
    private void regresar(MouseEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/vistas/VistaLogin.fxml"));
            Scene scene = new Scene(root);
            Stage stage2 = new Stage();
            stage2.setScene(scene);
            stage2.initStyle(StageStyle.UNDECORATED);
            stage2.show();
            Stage stage = (Stage) this.btnSalir.getScene().getWindow();
            stage.close();
        } catch (IOException ex) {
            Logger.getLogger(VistaLoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void reseterarVistas() {
        vistaInicio.setVisible(false);
    }

    @FXML
    private void agregarCarrito(ActionEvent event) {
    }

    @FXML
    private void agregarDeseos(MouseEvent event) {
    }

    @FXML
    private void hoverEntro(MouseDragEvent event) {
    }

    @FXML
    private void hoverSalio(MouseDragEvent event) {
    }

  

   
}
