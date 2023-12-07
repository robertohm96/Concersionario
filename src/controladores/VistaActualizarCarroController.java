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
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author usuario
 */
public class VistaActualizarCarroController implements Initializable {

    @FXML
    private ComboBox<String> comboAuto;
    @FXML
    private TextField txtCantidad;
    @FXML
    private TextField txtPrecio;
    @FXML
    private Button btnActulizarCarro;
    @FXML
    private Button btnCancelar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        String[] idCarros = {"1", "2", "3", "4"};
        comboAuto.setItems(FXCollections.observableArrayList(idCarros));
    }

    @FXML
    private void Actualizar(ActionEvent event) {
        
    }

    @FXML
    private void salir(ActionEvent event) {
        if (event.getSource() == btnCancelar) {
            try {
                Parent root = FXMLLoader.load(getClass().getResource("/vistas/VistaLogin.fxml"));
                Scene scene = new Scene(root);
                Stage stage2 = new Stage();
                stage2.setScene(scene);
                stage2.initStyle(StageStyle.UNDECORATED);
                stage2.show();
                Stage stage = (Stage) this.btnCancelar.getScene().getWindow();
                stage.close();
            } catch (IOException ex) {
                Logger.getLogger(VistaLoginController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
