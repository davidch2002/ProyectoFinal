package com.example.proyectofinal;

import java.io.Serializable;

public class Compras implements Serializable {
    int idventa, cantidad;
    String nombrecompleto, nombre_combo, nombre_pelicula;
    double precio_combo,  preciounidad, descuento, total;

    public Compras(int idventa, int cantidad, String nombrecompleto, String nombre_combo, String nombre_pelicula, double precio_combo, double preciounidad, double descuento, double total) {
        this.idventa = idventa;
        this.cantidad = cantidad;
        this.nombrecompleto = nombrecompleto;
        this.nombre_combo = nombre_combo;
        this.nombre_pelicula = nombre_pelicula;
        this.precio_combo = precio_combo;
        this.preciounidad = preciounidad;
        this.descuento = descuento;
        this.total = total;
    }

    public int getIdventa() {
        return idventa;
    }

    public void setIdventa(int idventa) {
        this.idventa = idventa;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getNombrecompleto() {
        return nombrecompleto;
    }

    public void setNombrecompleto(String nombrecompleto) {
        this.nombrecompleto = nombrecompleto;
    }

    public String getNombre_combo() {
        return nombre_combo;
    }

    public void setNombre_combo(String nombre_combo) {
        this.nombre_combo = nombre_combo;
    }

    public String getNombre_pelicula() {
        return nombre_pelicula;
    }

    public void setNombre_pelicula(String nombre_pelicula) {
        this.nombre_pelicula = nombre_pelicula;
    }

    public double getPrecio_combo() {
        return precio_combo;
    }

    public void setPrecio_combo(double precio_combo) {
        this.precio_combo = precio_combo;
    }

    public double getPreciounidad() {
        return preciounidad;
    }

    public void setPreciounidad(double preciounidad) {
        this.preciounidad = preciounidad;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
