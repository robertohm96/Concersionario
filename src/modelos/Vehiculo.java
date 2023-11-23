/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

import javafx.scene.image.Image;

/**
 *
 * @author usuario
 */
public class Vehiculo {

    private int codigo;
    private Image foto;
    private String marca, modelo, color;
    private int stock;
    private float precio;
    private Vehiculo siguiente, anterior;

    public Vehiculo(int codigo, Image foto, String marca, String modelo,
            String color, int stock, float precio, Vehiculo siguiente,
            Vehiculo anterior) {
        this.codigo = codigo;
        this.foto = foto;
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.stock = stock;
        this.precio = precio;
        this.siguiente = siguiente;
        this.anterior = anterior;
    }

    public Image getFoto() {
        return foto;
    }

    public void setFoto(Image foto) {
        this.foto = foto;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Vehiculo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Vehiculo siguiente) {
        this.siguiente = siguiente;
    }

    public Vehiculo getAnterior() {
        return anterior;
    }

    public void setAnterior(Vehiculo anterior) {
        this.anterior = anterior;
    }

}
