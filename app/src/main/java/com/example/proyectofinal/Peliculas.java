package com.example.proyectofinal;

import java.util.Date;

public class Peliculas {
    int idpelicula;
    String nombre_pelicula;
    String duracion_pelicula;
    String descripcion_pelicula;
    String fechaEstreno;
    String urlImg;

    public Peliculas(int idpelicula, String nombre_pelicula, String duracion_pelicula, String descripcion_pelicula, String fechaEstreno, String urlImg) {
        this.idpelicula = idpelicula;
        this.nombre_pelicula = nombre_pelicula;
        this.duracion_pelicula = duracion_pelicula;
        this.descripcion_pelicula = descripcion_pelicula;
        this.fechaEstreno = fechaEstreno;
        this.urlImg = urlImg;
    }

    public int getIdpelicula() {
        return idpelicula;
    }

    public void setIdpelicula(int idpelicula) {
        this.idpelicula = idpelicula;
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
}
