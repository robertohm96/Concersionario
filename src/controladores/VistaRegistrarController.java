/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controladores;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javax.swing.JOptionPane;
import modelos.Cliente;
import modelos.listas.ListaClientes;
import utiliades.ManejoDatos;
import utiliades.Utilidades;

/**
 * FXML Controller class
 *
 * @author usuario
 */
public class VistaRegistrarController implements Initializable, Utilidades {

    ListaClientes listaClientes = ManejoDatos.getDatos().getListaClientes();
    @FXML
    private TextField txtId;
    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtDireccion;
    @FXML
    private TextField txtTelfono;
    @FXML
    private TextField txtUser;
    @FXML
    private TextField txtPass;
    @FXML
    private Button btnRegistrar;
    @FXML
    private ImageView btnRegresar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

    }

    @FXML
    private void Registar(ActionEvent event) {
        if (cajasVacias()) {
            mostrarAlerta(Alert.AlertType.WARNING, "Debes llenar todos los campos"
                    + "para poder registrarte como cliente", "Advertencia");
        } else {
            if (event.getSource() == btnRegistrar) {
                listaClientes.setAddFin(txtId, txtNombre, txtDireccion, txtTelfono, txtUser, txtPass);
            }
        }
    }

    @FXML
    private void regresar(MouseEvent event) {
        if (event.getSource() == btnRegresar) {
            try {
                Parent root = FXMLLoader.load(getClass().getResource("/vistas/VistaLogin.fxml"));

                Scene scene = new Scene(root);
                Stage stage2 = new Stage();
                stage2.setScene(scene);
                stage2.initStyle(StageStyle.UNDECORATED);
                stage2.show();
                Stage stage = (Stage) this.btnRegresar.getScene().getWindow();
                stage.close();
            } catch (IOException ex) {
                Logger.getLogger(VistaLoginController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void mostrarAlerta(Alert.AlertType tipo, String mensaje, String titulo) {
        Alert alerta = new Alert(tipo);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }

    @Override
    public boolean cajasVacias() {
        if (txtId.getText().isEmpty() || txtNombre.getText().isEmpty()
                || txtTelfono.getText().isEmpty() || txtDireccion.getText().isEmpty()
                || txtUser.getText().isEmpty() || txtPass.getText().isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

}
