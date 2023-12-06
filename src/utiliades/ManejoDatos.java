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

/**
 *
 * @author usuario
 */
public class ManejoDatos implements Utilidades {

    private static ManejoDatos manejoDatos;
    private final ColaHistorialCompra colaHistorialCompra;
    private final ListaClientes listaClientes;

    public ManejoDatos() {
        colaHistorialCompra = new ColaHistorialCompra();
        listaClientes = new ListaClientes();
    }

    public static ManejoDatos getDatos() {
        if (manejoDatos == null) {
            manejoDatos = new ManejoDatos();
        }
        return manejoDatos;
    }

    public ColaHistorialCompra getColaHistorialCompra() {
        return colaHistorialCompra;
    }

    public ListaClientes getListaClientes() {
        return listaClientes;
    }

    public void leerClientes() {
        String linea = ""; // Variable para guardar la línea leída.
        try {
            File directorio = new File(ManejoDatos.getDatos()
                    .getListaClientes()
                    .getRuta().replace("\\ListaClientes.txt", ""));/*
            se crear una variable guardar la ruta para  la carpeta que guardara los archivos 
            utilizados en el programa u tilizamos el metodo replace(cadena a cambiar,cadena nueva), para
            dejar la ruta hasta la carpeta que almacenara los archivos.txt
             */
            if (!directorio.exists()) {/*Verificamos si no existe el directorio que se creara
                en la ruta especificada, si no exite entra en la ruta especificada*/
                if (directorio.mkdirs()) {/*Creamos el directorio o carpeta con el metodo mkdirs()
                    y validamos si se creo correctamente metiendo el comando
                    en un if, si devuelve true mandara un mensaje de confirmacion*/
                    mostrarAlerta(Alert.AlertType.CONFIRMATION, "Directorio creado", "Felicitacions");
                } else {
                    //Si no mandara un mensaje de error
                    mostrarAlerta(Alert.AlertType.CONFIRMATION,
                            "la carpeta donde se\n guardaran los archivos.txt no existe",
                            "Error al crear directorio");
                }
            }
            FileReader archivo = new FileReader(listaClientes.getRuta());
            BufferedReader leer = new BufferedReader(archivo);
            while ((linea = leer.readLine()) != null) {
                String[] datos = linea.split(" - "); // Separa los datos leídos por guiones y los guarda en un arreglo.
                Cliente cliente = new Cliente(Long.parseLong(datos[0]),
                        Long.parseLong(datos[1]), datos[2], datos[3],
                        datos[4], datos[5]);
                listaClientes.setAddFin(cliente);
//                listaCircularClientes.cargarInfo(getVistaVerClientes().getTbClientes());
            }
            leer.close();
        } catch (FileNotFoundException e) {
            try {
                File archivo = new File(listaClientes.getRuta());
                archivo.createNewFile();
            } catch (IOException ex) {
                mostrarAlerta(Alert.AlertType.ERROR,
                        "Error al crear el archivo.",
                        "Error");
            }
        } catch (IOException e) {
            mostrarAlerta(Alert.AlertType.ERROR,
                    "Error al leer el archivo.",
                    "Error");

        }
    }

    public void guardarCliente(Cliente cliente) {
        BufferedWriter escribir;
        try {
            File archivo = new File(listaClientes.getRuta());
            if (archivo.exists()) {
                escribir = new BufferedWriter(new FileWriter(archivo, true));
            } else {
                escribir = new BufferedWriter(new FileWriter(archivo));
            }
            if (cliente != null) {
                escribir.write(cliente.getIdentificacion() + " - " + cliente.getNombre() + " - "
                        + cliente.getDireccion() + " - " + cliente.getTelefono() + " - "
                        + cliente.getUser() + " - " + cliente.getPasword());
                escribir.newLine();
            }
            escribir.close();
        } catch (IOException e) {
            mostrarAlerta(Alert.AlertType.ERROR, "Error al guardar el archivo.", "Error");
            System.out.println("" + e);
        }
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
