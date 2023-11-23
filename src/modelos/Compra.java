/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

/**
 *
 * @author usuario
 */
public class Compra {

    private String codigoCompra;
    private Cliente cliente;
    private Vehiculo vehiculo;
    private Compra siguiente;

    public Compra(String codigoCompra, Cliente cliente, Vehiculo vehiculo) {
        this.codigoCompra = codigoCompra;
        this.cliente = cliente;
        this.vehiculo = vehiculo;
    }

    public String getCodigoCompra() {
        return codigoCompra;
    }

    public void setCodigoCompra(String codigoCompra) {
        this.codigoCompra = codigoCompra;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public float valorCompra() {
        return getVehiculo().getPrecio() * getVehiculo().getStock();
    }

    public Compra getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Compra siguiente) {
        this.siguiente = siguiente;
    }

}
