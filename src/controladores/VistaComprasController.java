/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controladores;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import modelos.colas.ColaHistorialCompra;
import utiliades.ManejoDatos;

/**
 * FXML Controller class
 *
 * @author usuario
 */
public class VistaComprasController implements Initializable {

    private ColaHistorialCompra aux = ManejoDatos.getDatos().getColaHistorialCompra();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
