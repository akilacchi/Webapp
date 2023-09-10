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
    private String ID;
    private String fullName;
    private String email;
    private int phone;
    private Localidad ubicacion;
    private String password;
    private boolean activo;

    public Usuario(String ID, String fullName, String email, int phone, Localidad ubicacion, String password, boolean activo) {
        this.ID = ID;
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.ubicacion = ubicacion;
        this.password = password;
        this.activo= activo;
    }

    public Usuario() {
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

    public String getPassword() {
        return password;
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

    public void setPassword(String password) {
        this.password = password;
    }
    

}