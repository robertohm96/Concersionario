/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos.listas;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;
import modelos.Cliente;
import utiliades.ManejoDatos;
import utiliades.Utilidades;

/**
 *
 * @author usuario
 */
public class ListaClientes implements Utilidades {

    Cliente cab;
    String ruta;

    public ListaClientes() {
        cab = null;
        ruta = "C:\\Base de datos\\ListaClientes.txt";
    }

    public String getRuta() {
        return ruta;
    }

    public Cliente getBuscarId(long id) {
        Cliente q = null;
        if (cab == null) {
            return null;
        } else {
            q = cab;
            do {
                if ((q.getIdentificacion()) == id) {
                    return q;
                } else {
                    q = q.getSiguiente();
                }
            } while (q != cab);
            return null;
        }
    }

    public Cliente getUltimo() {
        Cliente q;
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

    public Cliente getAnterior(Cliente q) {
        if ((cab == null) || (q == null)) {
            return null;
        } else {
            Cliente a = cab;
            while (a.getSiguiente() != q) {
                a = a.getSiguiente();
            }
            return a;
        }
    }

    public Cliente getCrearNodo(TextField txtId, TextField txtNombre, TextField txtDireccion,
            TextField txtTelfono, TextField txtUser, TextField txtPass) {
        Cliente info = null, b = null;
        long id = Long.parseLong(txtId.getText()), telefono = Long.parseLong(txtTelfono.getText());
        String nombre = txtNombre.getText(),
                direccion = txtDireccion.getText(),
                user = txtUser.getText(), pass = txtPass.getText();
        b = getBuscarId(id);
        if (b != null) {
            mostrarAlerta(Alert.AlertType.INFORMATION, "Error! Esta identificion ya existe!",
                    "Intente nuevamente.");
            txtId.setText("");
            txtNombre.setText("");
            txtDireccion.setText("");
            txtTelfono.setText("");
            txtUser.setText("");
            txtPass.setText("");
        } else {
            info = new Cliente(id, telefono, nombre, direccion, user, pass);
            mostrarAlerta(Alert.AlertType.INFORMATION, "Nodo creado", "Informacion");
            ManejoDatos.getDatos().guardarCliente(info);
        }
        return info;
    }

    public void setAddFin(TextField txtId, TextField txtNombre, TextField txtDireccion,
            TextField txtTelfono, TextField txtUser, TextField txtPass) {
        Cliente info = getCrearNodo(txtId, txtNombre, txtDireccion, txtTelfono, txtUser, txtPass);
        Cliente q;
        if (info != null) {
            if (cab == null) {
                cab = info;
                cab.setSiguiente(cab);
                mostrarAlerta(Alert.AlertType.INFORMATION,
                        " Un elemento en la lista!",
                        "Nodo registrado. ");
            } else {
                q = getUltimo();
                q.setSiguiente(info);
                info.setSiguiente(cab);
                mostrarAlerta(Alert.AlertType.INFORMATION,
                        "Elemento agregado al final de la lista!",
                        "Nodo registrado. ");
            }
        } else {
            mostrarAlerta(Alert.AlertType.WARNING,
                    "Vuelve a llenar los campos!",
                    "");
        }
    }

    public void setAddFin(Cliente info) {
        Cliente q;
        if (info != null) {
            if (cab == null) {
                cab = info;
                cab.setSiguiente(cab);
                mostrarAlerta(Alert.AlertType.INFORMATION,
                        " Un elemento en la lista!",
                        "Nodo registrado. ");
            } else {
                q = getUltimo();
                q.setSiguiente(info);
                info.setSiguiente(cab);
                mostrarAlerta(Alert.AlertType.INFORMATION,
                        "Elemento agregado al final de la lista!",
                        "Nodo registrado. ");
            }
        } else {
            mostrarAlerta(Alert.AlertType.WARNING,
                    "Vuelve a llenar los campos!",
                    "");
        }
    }

    public void setEliminarCod(long id) {
        if (cab == null) {
            mostrarAlerta(Alert.AlertType.INFORMATION, "Lista vacía!!!", "");
        } else {
            Cliente q = getBuscarId(id);
            Cliente u, a;
            if (q == null) {
                mostrarAlerta(Alert.AlertType.WARNING, "El código tiquete no existe!!!", "Espera");
            } else {
                if ((cab.getSiguiente() == cab) && (q == cab)) {
                    cab = null;
                    mostrarAlerta(Alert.AlertType.CONFIRMATION, "Eliminado. Lista vacía!!!", "");
                } else if ((cab.getSiguiente() != cab) && (q == cab)) {
                    u = getUltimo();
                    cab = cab.getSiguiente();
                    u.setSiguiente(cab);
                    q.setSiguiente(null);
                    q = null;
                    mostrarAlerta(Alert.AlertType.CONFIRMATION, "Eliminado al inicio!!!", "");
                } else if (q.getSiguiente() == cab) {
                    a = getAnterior(q);
                    a.setSiguiente(cab);
                    q = null;
                    mostrarAlerta(Alert.AlertType.CONFIRMATION, "Eliminado al final!!!", "");
                } else {
                    a = getAnterior(q);
                    a.setSiguiente(q.getSiguiente());
                    q.setSiguiente(null);
                    q = null;
                    mostrarAlerta(Alert.AlertType.CONFIRMATION, "Eliminado entre nodos!!!", "");
                }
            }
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
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
