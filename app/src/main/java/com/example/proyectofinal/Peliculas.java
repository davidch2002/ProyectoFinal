package com.example.proyectofinal;

import java.io.Serializable;

public class Peliculas implements Serializable {
    int idpelicula, precio_pelicula;
    String nombre_pelicula;
    String duracion_pelicula;
    String descripcion_pelicula;
    String fechaEstreno;
    String nombre_genero;
    String urlImg;

    public Peliculas(int idpelicula, int precio_pelicula, String nombre_pelicula, String duracion_pelicula, String descripcion_pelicula, String fechaEstreno, String nombre_genero, String urlImg) {
        this.idpelicula = idpelicula;
        this.precio_pelicula = precio_pelicula;
        this.nombre_pelicula = nombre_pelicula;
        this.duracion_pelicula = duracion_pelicula;
        this.descripcion_pelicula = descripcion_pelicula;
        this.fechaEstreno = fechaEstreno;
        this.nombre_genero = nombre_genero;
        this.urlImg = urlImg;
    }

    public int getIdpelicula() {
        return idpelicula;
    }

    public void setIdpelicula(int idpelicula) {
        this.idpelicula = idpelicula;
    }

    public int getPrecio_pelicula() {
        return precio_pelicula;
    }

    public void setPrecio_pelicula(int precio_pelicula) {
        this.precio_pelicula = precio_pelicula;
    }

    public String getNombre_pelicula() {
        return nombre_pelicula;
    }

    public void setNombre_pelicula(String nombre_pelicula) {
        this.nombre_pelicula = nombre_pelicula;
    }

    public String getDuracion_pelicula() {
        return duracion_pelicula;
    }

    public void setDuracion_pelicula(String duracion_pelicula) {
        this.duracion_pelicula = duracion_pelicula;
    }

    public String getDescripcion_pelicula() {
        return descripcion_pelicula;
    }

    public void setDescripcion_pelicula(String descripcion_pelicula) {
        this.descripcion_pelicula = descripcion_pelicula;
    }

    public String getFechaEstreno() {
        return fechaEstreno;
    }

    public void setFechaEstreno(String fechaEstreno) {
        this.fechaEstreno = fechaEstreno;
    }

    public String getUrlImg() {
        return urlImg;
    }

    public void setUrlImg(String urlImg) {
        this.urlImg = urlImg;
    }

    public String getNombre_genero() {
        return nombre_genero;
    }

    public void setNombre_genero(String nombre_genero) {
        this.nombre_genero = nombre_genero;
    }
}
