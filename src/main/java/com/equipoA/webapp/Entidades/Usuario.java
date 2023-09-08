/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.equipoA.webapp.Entidades;

import com.equipoA.webapp.Enum.Localidad;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import org.hibernate.annotations.GenericGenerator;

@Entity
public class Usuario {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name="uuid", strategy = "uuid2")
    protected String ID;
    protected String fullName;
    protected String email;
    protected int phone;
    protected Localidad ubicacion;
    protected boolean activo;

    public Usuario() {
    }
    
    public Usuario(String ID, String fullName, String email, int phone, Localidad ubicacion, boolean activo) {
        this.ID = ID;
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.ubicacion = ubicacion;
        this.activo = activo;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public Localidad getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(Localidad ubicacion) {
        this.ubicacion = ubicacion;
    }
    

}