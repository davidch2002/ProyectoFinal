package com.example.proyectofinal;

import java.io.Serializable;

public class Combos implements Serializable {
    int idcombo;
    String nombre_combo;
    double precio_combo;
    String descripcion_combo;
    String urlImg;

    public Combos(int idcombo, String nombre_combo, double precio_combo, String descripcion_combo, String urlImg) {
        this.idcombo = idcombo;
        this.nombre_combo = nombre_combo;
        this.precio_combo = precio_combo;
        this.descripcion_combo = descripcion_combo;
        this.urlImg = urlImg;
    }

    public int getIdcombo() {
        return idcombo;
    }

    public void setIdcombo(int idcombo) {
        this.idcombo = idcombo;
    }

    public String getNombre_combo() {
        return nombre_combo;
    }

    public void setNombre_combo(String nombre_combo) {
        this.nombre_combo = nombre_combo;
    }

    public double getPrecio_combo() {
        return precio_combo;
    }

    public void setPrecio_combo(double precio_combo) {
        this.precio_combo = precio_combo;
    }

    public String getDescripcion_combo() {
        return descripcion_combo;
    }

    public void setDescripcion_combo(String descripcion_combo) {
        this.descripcion_combo = descripcion_combo;
    }

    public String getUrlImg() {
        return urlImg;
    }

    public void setUrlImg(String urlImg) {
        this.urlImg = urlImg;
    }
}
