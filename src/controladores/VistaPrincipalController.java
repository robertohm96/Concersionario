/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controladores;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void abrirCatalogo(MouseEvent event) {
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
    }
    
}
