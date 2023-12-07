/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utiliades;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javafx.scene.control.Alert;
import javax.swing.JOptionPane;
import modelos.Cliente;
import modelos.colas.ColaHistorialCompra;
import modelos.listas.ListaClientes;
import modelos.listas.ListaVehiculos;
import modelos.pilas.Pilas;

/**
 *
 * @author usuario
 */
public class ManejoDatos implements Utilidades {

    private static ManejoDatos manejoDatos;
    private final ColaHistorialCompra colaHistorialCompra;
    private final ListaClientes listaClientes;
    private final ListaVehiculos listaVehiculos;
    private final Pilas pilas;

    public ManejoDatos() {
        colaHistorialCompra = new ColaHistorialCompra();
        listaClientes = new ListaClientes();
        listaVehiculos = new ListaVehiculos();
        this.pilas = new Pilas();
    }

    public static ManejoDatos getDatos() {
        if (manejoDatos == null) {
            manejoDatos = new ManejoDatos();
        }
        return manejoDatos;
    }

    public Pilas getPilas() {
        return pilas;
    }

    public ColaHistorialCompra getColaHistorialCompra() {
        return colaHistorialCompra;
    }

    public ListaClientes getListaClientes() {
        return listaClientes;
    }

    public ListaVehiculos getListaVehiculos() {
        return listaVehiculos;
    }

    @Override
    public void mostrarAlerta(Alert.AlertType tipo, String mensaje, String titulo) {
        {
            Alert alerta = new Alert(tipo);
            alerta.setTitle(titulo);
            alerta.setHeaderText(null);
            alerta.setContentText(mensaje);
            alerta.showAndWait();
        }

    }

    @Override
    public boolean cajasVacias() {
        return true;
    }

}
