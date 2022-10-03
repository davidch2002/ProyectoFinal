package com.example.proyectofinal;

import java.io.Serializable;

public class Locales implements Serializable {
    int idlocal;
    String nombre_local;
    String nombre_estado;

    public Locales(int idlocal, String nombre_local, String nombre_estado) {
        this.idlocal = idlocal;
        this.nombre_local = nombre_local;
        this.nombre_estado = nombre_estado;
    }

    public int getIdlocal() {
        return idlocal;
    }

    public void setIdlocal(int idlocal) {
        this.idlocal = idlocal;
    }

    public String getNombre_local() {
        return nombre_local;
    }

    public void setNombre_local(String nombre_local) {
        this.nombre_local = nombre_local;
    }

    public String getNombre_estado() {
        return nombre_estado;
    }

    public void setNombre_estado(String nombre_estado) {
        this.nombre_estado = nombre_estado;
    }
}
