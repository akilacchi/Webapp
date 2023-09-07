/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.equipoA.webapp.Entidades;

import com.equipoA.webapp.Enum.Localidad;

/**
 *
 * @author akila
 */
public class Usuario {
    private int ID;
    private String nombre;
    private String apellido;
    private String email;
    private int numero;
    private Localidad ubicacion;

    public Usuario(int ID, String nombre, String apellido, String email, int numero, Localidad ubicacion) {
        this.ID = ID;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.numero = numero;
        this.ubicacion = ubicacion;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Localidad getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(Localidad ubicacion) {
        this.ubicacion = ubicacion;
    }
    
    
}
