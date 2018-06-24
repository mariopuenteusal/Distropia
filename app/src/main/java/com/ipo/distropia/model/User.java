package com.ipo.distropia.model;

import java.io.Serializable;

/**
 * Created on 21/06/2018.
 */
public class User implements Serializable {
    private String nombre;
    private String patologia;
    private String tutor;
    private String estado;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPatologia() {
        return patologia;
    }

    public void setPatologia(String patologia) {
        this.patologia = patologia;
    }

    public String getTutor() {
        return tutor;
    }

    public void setTutor(String tutor) {
        this.tutor = tutor;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public User(String nombre) {
        this.nombre = nombre;
    }

    public User(String nombre, String patologia, String tutor, String estado) {
        this.nombre = nombre;
        this.patologia = patologia;
        this.tutor = tutor;
        this.estado = estado;
    }
}
