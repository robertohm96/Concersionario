/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos.listas;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import modelos.Cliente;
import modelos.Vehiculo;
import utiliades.ManejoDatos;
import utiliades.Utilidades;

/**
 *
 * @author usuario
 */
public class ListaVehiculos implements Utilidades {

    Vehiculo cab;
    Vehiculo cab2;

    public ListaVehiculos() {
        cab = null;
        cab2 = null;
    }

    public Vehiculo getCab() {
        return cab;
    }

    public Vehiculo getCab2() {
        return cab2;
    }

    public Vehiculo getBuscarId(int id) {
        Vehiculo q = null;
        if (cab == null) {
            return null;
        } else {
            q = cab;
            do {
                if ((q.getCodigo()) == id) {
                    return q;
                } else {
                    q = q.getSiguiente();
                }
            } while (q != cab);
            return null;
        }
    }

   

    public Vehiculo getUltimo() {
        Vehiculo q;
        if (cab == null) {
            return null;
        } else {
            q = cab;
            while (q.getSiguiente() != cab) {
                q = q.getSiguiente();
            }
            return q;
        }
    }

    public Vehiculo getAnterior(Vehiculo q) {
        if ((cab == null) || (q == null)) {
            return null;
        } else {
            Vehiculo a = cab;
            while (a.getSiguiente() != q) {
                a = a.getSiguiente();
            }
            return a;
        }
    }

    public Vehiculo addVehiculo(int codigo, String marca, String modelo,
            String color, int stock, float precio) {

        Vehiculo info = new Vehiculo(codigo, marca, modelo, color, stock, precio);
        Vehiculo q;
        if (info != null) {
            if (cab == null) {
                cab = info;
                cab.setSiguiente(cab);
            } else {
                q = getUltimo();
                q.setSiguiente(info);
                info.setSiguiente(cab);

            }
        } else {
        }

        return info;
    }

    public void setAddFin(TextField txtId, TextField txtNombre, TextField txtDireccion,
            TextField txtTelfono, TextField txtUser, TextField txtPass) {

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

    public void guardarDatosVehiculo(ListaVehiculos listaV) {

        String direccion = System.getProperty("user.dir") + "\\src\\datos\\ListaVehiculos.txt";

        Path archivo = Paths.get(direccion);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo.toFile(), false))) {
            Vehiculo nuevo = listaV.cab;

            while (nuevo != null) {
                writer.write(nuevo.getCodigo() + " - ");
                writer.write(nuevo.getMarca() + " - ");
                writer.write(nuevo.getModelo() + " - ");
                writer.write(nuevo.getStock() + " - ");
                writer.write(nuevo.getColor() + " - ");
                writer.write((int) nuevo.getPrecio());
                writer.newLine();

                nuevo = nuevo.getSiguiente();
            }

            System.out.println("Datos guardados.");
        } catch (IOException e) {
            System.out.println("Error al guardar los datos: " + e.getMessage());
        }
    }

    public void cargarDatosVehiculo() {

        String direccion = System.getProperty("user.dir") + "\\src\\datos\\ListaVehiculos.txt";

        Path archivo = Paths.get(direccion);

        try (BufferedReader reader = new BufferedReader(new FileReader(archivo.toFile()))) {

            String linea;

            while ((linea = reader.readLine()) != null) {

                String[] atributos = linea.split(" - ");

                int id = Integer.parseInt(atributos[0]);
                String marca = atributos[1];
                String modelo = atributos[2];
                int stock = Integer.parseInt(atributos[3]);
                String color = atributos[4];
                float precio = Float.parseFloat(atributos[5]);

                addVehiculo(id, marca, modelo, color, stock, precio);
            }
            System.out.println("Fino Vehiculos");

        } catch (IOException e) {
            System.out.println("Error al cargar los datos: " + e.getMessage());
        }
    }

    @Override
    public boolean cajasVacias() {
        return true;
    }

}
