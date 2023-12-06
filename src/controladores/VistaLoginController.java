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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import utiliades.Utilidades;

/**
 * FXML Controller class
 *
 * @author usuario
 */
public class VistaLoginController implements Initializable,Utilidades {

    @FXML
    private Button btnIngresar;
    @FXML
    private Label labelUs;
    @FXML
    private Label labelContra;
    @FXML
    private ImageView btnRegistro;
    @FXML
    private TextField txtCorreo;
    @FXML
    private TextField txtClave;
    @FXML
    private ImageView btnSalir;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void registrar(MouseEvent event) {
        if (event.getSource() == btnRegistro) {
            try {
                Parent root = FXMLLoader.load(getClass().getResource("/vistas/VistaRegistrar.fxml"));

                Scene scene = new Scene(root);
                Stage stage2 = new Stage();
                stage2.setScene(scene);
                stage2.initStyle(StageStyle.UNDECORATED);
                stage2.show();
                Stage stage = (Stage) this.btnRegistro.getScene().getWindow();
                stage.close();
            } catch (IOException ex) {
                Logger.getLogger(VistaLoginController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }


    @FXML
    private void salir(MouseEvent event) {
        if (event.getSource() == btnSalir) {
            System.exit(0);
        }
    }

    @FXML
    private void Ingresar(ActionEvent event) {
        
    }

    @Override
    public void mostrarAlerta(Alert.AlertType tipo, String mensaje, String titulo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean cajasVacias() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
   
}
