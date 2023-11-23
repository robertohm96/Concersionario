/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos.listas;

import javafx.scene.control.Alert;
import modelos.Cliente;
import utiliades.Utilidades;

/**
 *
 * @author usuario
 */
public class ListaClientes implements Utilidades {

    Cliente cab;

    public ListaClientes() {
    }

    public Cliente Buscar(Long id) {
        if (cab == null) {
            return null;
        } else {
            Cliente p = cab;
            while (p != null) {
                if ((p.getIdentificacion() == id)) {
                    return p;
                } else {
                    p = p.getSiguiente();  //Avanza un posición en la lista
                }
            }
            return null;
        }
    }

    public boolean getEsVacia() {
        return cab == null ? true : false;
    }

    public int tamanioLista() {
        int cont = 0;
        Cliente p = null;
        if (cab == null) {
            return 0;
        } else {
            p = cab;
            while (p != null) {
                cont++;
                p = p.getSiguiente();
            }
            return cont;
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

}
