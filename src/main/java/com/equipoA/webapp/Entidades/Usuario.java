/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.equipoA.webapp.Entidades;

import com.equipoA.webapp.Enum.Provincias;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import org.hibernate.annotations.GenericGenerator;

@Entity
public class Usuario {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")

    private String ID;
    private String fullName;
    private String email;
    protected String password;
    private int phone;
    @Enumerated(EnumType.STRING)
    private Provincias ubicacion;
    private boolean activo;

    public Usuario(String ID, String fullName, String email, int phone, Provincias ubicacion, String password, boolean activo) {

        this.ID = ID;
    }

    public Usuario() {
    }

    public Usuario(String fullName, String email, String password, int phone, Provincias ubicacion, boolean activo) {
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.ubicacion = ubicacion;

        this.password = password;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public Provincias getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(Provincias ubicacion) {
        this.ubicacion = ubicacion;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    
    

}
