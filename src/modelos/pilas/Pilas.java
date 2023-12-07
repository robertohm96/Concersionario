/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos.pilas;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Stack;
import javafx.scene.control.Alert;
import javax.swing.JOptionPane;
import modelos.Admin;
import modelos.Compra;
import modelos.Vehiculo;
import utiliades.Utilidades;

/**
 *
 * @author usuario
 */
public class Pilas implements Utilidades {

    private final Stack<Admin> admins;
    private final Stack<Vehiculo> deseos;
    private final Stack<Compra> compras;
    private final Stack<Compra> carrito;

    public Pilas() {
        admins = new Stack<>();
        deseos = new Stack<>();
        compras = new Stack<>();
        carrito = new Stack<>();
    }

    public Stack<Compra> getCarrito() {
        return carrito;
    }

    public Stack<Compra> getCompras() {
        return compras;
    }

    public Stack<Admin> getAdmins() {
        return admins;
    }

    public Stack<Vehiculo> getDeseos() {
        return deseos;
    }

    public void eliminar(Stack<Compra> pila, int id) {
        Stack<Compra> temp = new Stack<>();

        while (!pila.isEmpty()) {
            Compra producto = pila.pop();
            if (producto.getIdCliente() != id) {
                temp.push(producto);
            }
        }
        while (!temp.isEmpty()) {
            pila.push(temp.pop());
        }
    }

    //Metodos Pila de administradores
    public void setPushAdmin(Admin nuevo) {
        int pos = admins.indexOf(nuevo);
        if (pos == -1) {
            admins.push(nuevo);
        } else {
            System.out.println("Ya se encontraba admin registrado");
        }
    }

    public Admin getAdminUsuario(String user) {
        Admin aux = new Admin();
        int i = 0;
        while (i < admins.size()) {
            aux = admins.get(i);
            if (aux.getUser().equals(user)) {
                return aux;
            }
            i++;
        }
        aux = null;
        return aux;
    }

    public void cargarDatosDesdeArchivoAdmin() {

        String direccion = System.getProperty("user.dir") + "\\src\\datos\\ListaAdmins.txt";

        Path archivo = Paths.get(direccion);

        try (BufferedReader reader = new BufferedReader(new FileReader(archivo.toFile()))) {

            String linea;
            if (!admins.isEmpty()) {
                admins.clear();
            }
            while ((linea = reader.readLine()) != null) {

                String[] atributos = linea.split(" - ");
                String user = atributos[0];
                String pass = atributos[1];

                Admin nuevo = new Admin(user, pass);

                setPushAdmin(nuevo);
            }

            System.out.println("Datos cargados correctamente desde archivo de compras.");
        } catch (IOException e) {
            System.out.println("Error al cargar los datos desde el archivo de compras: " + e.getMessage());
        }
    }

    //Metodos Pila de compras
    public void setPushCompra(Compra nuevo) {
        int pos = compras.indexOf(nuevo);
        if (pos == -1) {
            compras.push(nuevo);
        } else {
            System.out.println("Ya se encontraba admin registrado");
        }
    }

    public Compra getCompra(int codigo) {
        Compra aux = new Compra();
        int i = 0;
        while (i < compras.size()) {
            aux = compras.get(i);
            if (aux.getCodigoCompra() == (codigo)) {
                return aux;
            }
            i++;
        }
        aux = null;
        return aux;
    }

    public void cargarDatosDesdeArchivoCompra() {

        String direccion = System.getProperty("user.dir") + "\\src\\datos\\ListaCompra.txt";

        Path archivo = Paths.get(direccion);

        try (BufferedReader reader = new BufferedReader(new FileReader(archivo.toFile()))) {

            String linea;
            if (!compras.isEmpty()) {
                compras.clear();
            }

            while ((linea = reader.readLine()) != null) {

                String[] atributos = linea.split(" - ");
                int codigoCompra = Integer.parseInt(atributos[0]);
                int idCliente = Integer.parseInt(atributos[1]);
                int vehiculo = Integer.parseInt(atributos[2]);
                int cantidad = Integer.parseInt(atributos[3]);
                double precio = Double.parseDouble(atributos[4]);
                Compra nueva = new Compra(codigoCompra, idCliente, vehiculo, cantidad, precio);

                setPushCompra(nueva);
            }

            System.out.println("Datos cargados correctamente desde archivo de compras.");
        } catch (IOException e) {
            System.out.println("Error al cargar los datos desde el archivo de compras: " + e.getMessage());
        }
    }

    public void guardarDatosEnArchivoCompras(Stack<Compra> compras) {

        String direccion = System.getProperty("user.dir") + "\\src\\datos\\ListaCompra.txt";

        Path archivo = Paths.get(direccion);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo.toFile(), false))) {
            Stack<Compra> nuevo = compras;

            for (Compra compra : nuevo) {
                writer.write(compra.getCodigoCompra() + " - ");
                writer.write(compra.getIdCliente() + " - ");
                writer.write(compra.getVehiculo() + " - ");
                writer.write(compra.getCantidad() + " - ");
                writer.write(compra.getPrecio() + " - ");

                writer.newLine();
            }

            System.out.println("Datos guardados correctamente en el archivo de compras.");
        } catch (IOException e) {
            System.out.println("Error al guardar los datos en el archivo de compras: " + e.getMessage());
        }
    }

    //Metodos Pila de carrito
    public void setPushCarrito(Compra nuevo) {
        int pos = carrito.indexOf(nuevo);
        if (pos == -1) {
            carrito.push(nuevo);
        } else {
            System.out.println("Ya se encontraba admin registrado");
        }
    }

    public Compra getCompraCod(int id) {
        Compra aux = new Compra();
        int i = 0;
        while (i < carrito.size()) {
            aux = carrito.get(i);
            if (aux.getCodigoCompra() == (id)) {
                return aux;
            }
            i++;
        }
        return null;
    }

    public Compra getCarrito(int codigo) {
        Compra aux = new Compra();
        int i = 0;
        while (i < carrito.size()) {
            aux = carrito.get(i);
            if (aux.getCodigoCompra() == (codigo)) {
                return aux;
            }
            i++;
        }
        aux = null;
        return aux;
    }

    public void setCarrito(int codigo, int cantidad) {
        Compra aux = new Compra();
        int i = 0;
        int cant = 0;
        while (i < carrito.size()) {
            aux = carrito.get(i);
            if (aux.getCodigoCompra() == (codigo)) {

                cant = aux.getCantidad() - cantidad;
                carrito.get(i).setCantidad(cant);
                mostrarAlerta(Alert.AlertType.INFORMATION, "el stock contara con " + cant, "Stock actulizado");
            }
            i++;
        }
    }

    public void eliminarUnPilaCarrito() {
        carrito.pop();
    }
    
    public void eliminarPilaCarrito() {
        carrito.clear();
    }

    public void cargarDatosDesdeArchivoCarrito() {

        String direccion = System.getProperty("user.dir") + "\\src\\datos\\ListaCarrito.txt";

        Path archivo = Paths.get(direccion);

        try (BufferedReader reader = new BufferedReader(new FileReader(archivo.toFile()))) {

            String linea;
            if (!carrito.isEmpty()) {
                carrito.clear();
            }

            while ((linea = reader.readLine()) != null) {

                String[] atributos = linea.split(" - ");
                int codigoCompra = Integer.parseInt(atributos[0]);
                int idCliente = Integer.parseInt(atributos[1]);
                int vehiculo = Integer.parseInt(atributos[2]);
                int cantidad = Integer.parseInt(atributos[3]);
                double precio = Double.parseDouble(atributos[4]);
                Compra nueva = new Compra(codigoCompra, idCliente, vehiculo, cantidad, precio);
                setPushCompra(nueva);
            }

            System.out.println("Datos cargados correctamente desde archivo de compras.");
        } catch (IOException e) {
            System.out.println("Error al cargar los datos desde el archivo de compras: " + e.getMessage());
        }
    }

    public void guardarDatosEnArchivoCarrito(Stack<Compra> carrito) {

        String direccion = System.getProperty("user.dir") + "\\src\\datos\\ListaCarrito.txt";

        Path archivo = Paths.get(direccion);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo.toFile(), false))) {
            Stack<Compra> nuevo = carrito;

            for (Compra compra : nuevo) {
                writer.write(compra.getCodigoCompra() + " - ");
                writer.write(compra.getIdCliente() + " - ");
                writer.write(compra.getVehiculo() + " - ");
                writer.write(compra.getCantidad() + " - ");
                writer.write(compra.getPrecio() + " - ");

                writer.newLine();
            }

            System.out.println("Datos guardados correctamente en el archivo de compras.");
        } catch (IOException e) {
            System.out.println("Error al guardar los datos en el archivo de compras: " + e.getMessage());
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
        return true;
    }
}
