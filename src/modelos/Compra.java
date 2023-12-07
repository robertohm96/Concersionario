/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

import java.time.LocalDate;

/**
 *
 * @author usuario
 */
public class Compra {

    private int codigoCompra;
    private long idCliente;
    private int vehiculo;
    private int cantidad;
    private double precio;
    private String marca;
    private int modelo;
    private String color;
    private Compra siguiente;
    private double subTotal;
    private LocalDate fecha;

    public Compra() {
        cantidad = 0;
        precio = 0;
        marca = "";
        modelo = 0;
        color = "";
        subTotal = 0;
        fecha = null;
    }

    public Compra(int cantidad, double precio, String marca, int modelo, String color, double subTotal) {
        this.cantidad = cantidad;
        this.precio = precio;
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.subTotal = subTotal;
    }

    public Compra(int codigoCompra, long idCliente, int vehiculo, int cantidad, double precio) {
        this.codigoCompra = codigoCompra;
        this.idCliente = idCliente;
        this.vehiculo = vehiculo;
        this.cantidad = cantidad;
        this.precio = precio;
        this.subTotal = cantidad * precio;
    }

    public int getCodigoCompra() {
        return codigoCompra;
    }

    public void setCodigoCompra(int codigoCompra) {
        this.codigoCompra = codigoCompra;
    }

    public long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(long idCliente) {
        this.idCliente = idCliente;
    }

    public int getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(int vehiculo) {
        this.vehiculo = vehiculo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double valorCompra() {
        return precio * cantidad;
    }

    public Compra getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Compra siguiente) {
        this.siguiente = siguiente;
    }

    public double subTotal() {
        return getCantidad() * getPrecio();
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getModelo() {
        return modelo;
    }

    public void setModelo(int modelo) {
        this.modelo = modelo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

}
