/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos.colas;

import javafx.scene.control.Alert;
import modelos.Compra;
import utiliades.Utilidades;

/**
 *
 * @author usuario
 */
public class ColaHistorialCompra implements Utilidades {

    private Compra primero;
    private Compra ultimo;
    private int totalCompras;

    public ColaHistorialCompra() {
    }

    public Compra getPrimero() {
        return primero;
    }

    public void setPrimero(Compra primero) {
        this.primero = primero;
    }

    public Compra getUltimo() {
        return ultimo;
    }

    public void setUltimo(Compra ultimo) {
        this.ultimo = ultimo;
    }

    public int getTotalCompras() {
        return totalCompras;
    }

    public void setTotalCompras(int totalCompras) {
        this.totalCompras = totalCompras;
    }

    public boolean colaVacia() {
        return getTotalCompras() == 0;
    }

    public boolean buscar(String codigo) {
        if (!colaVacia()) {
            Compra aux = getPrimero();
            while (aux != null) {
                if (aux.getCodigoCompra().equalsIgnoreCase(codigo)) {
                    return true;
                }
                aux = aux.getSiguiente();
            }
        }
        return false;
    }

    public void agregar(Compra compra) {
        if (colaVacia()) {
            setPrimero(compra);
            setUltimo(compra);

        } else {
            if (buscar(compra.getCodigoCompra())) {
                mostrarAlerta(Alert.AlertType.INFORMATION,
                        "Ya existe una compra con ese codigo (no puedes ingresar la compra)",
                        "Informacion");
            } else {
                getUltimo().setSiguiente(compra);
                setUltimo(compra);
            }

        }
        totalCompras++;
    }

    public void eliminarPrimero() {
        if (!colaVacia()) {
            setPrimero(getPrimero().getSiguiente());
            totalCompras--;
        }
    }

    public void eliminar(Compra compra) {
        if (!colaVacia()) {
            Compra aux = getPrimero();
            Compra anterior = null;
            while (aux != null) {
                if (aux.getCodigoCompra().equals(compra.getCodigoCompra())) {
                    if (anterior == null) {
                        eliminarPrimero();
                    } else {
                        anterior.setSiguiente(aux.getSiguiente());
                        totalCompras--;
                    }
                    mostrarAlerta(Alert.AlertType.INFORMATION, "Compra: "
                            + compra.getCodigoCompra() + " eliminada", "Informacion");
                }
                anterior = aux;
                aux = aux.getSiguiente();
            }
            mostrarAlerta(Alert.AlertType.WARNING, "Compra no encontrada", "Informacion");
        }
    }

    public void buscarQuitar(String codigo) {
        if (!colaVacia()) {
            Compra aux = getPrimero();
            Compra anterior = null;
            while (aux != null) {
                if (aux.getCodigoCompra().equals(codigo)) {
                    if (anterior == null) {
                        eliminarPrimero();
                    } else {
                        anterior.setSiguiente(aux.getSiguiente());
                        totalCompras--;
                    }
                    System.out.println("Producto eliminado: " + aux);
                    return;
                }
                anterior = aux;
                aux = aux.getSiguiente();
            }
            System.out.println("Producto no encontrado");
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
