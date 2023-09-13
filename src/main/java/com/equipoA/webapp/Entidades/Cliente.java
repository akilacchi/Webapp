package com.equipoA.webapp.Entidades;

import com.equipoA.webapp.Enum.Provincias;
import java.util.List;
import javax.persistence.Entity;

@Entity
public class Cliente extends Usuario {

//    private List<String> comentarios;
//    private List<String> historialDePedidos;
//    private List<Integer> calificacionesDadas;
    private String direccion;
    private List<Calificacion> calificacion;
    private List<Proveedor> proveedoresCalificados;

    public Cliente(String direccion, List<Calificacion> calificacion, List<Proveedor> proveedoresCalificados, String fullName, String email, String password, int phone, Provincias ubicacion, boolean activo) {
        super(fullName, email, password, phone, ubicacion, activo);
        this.direccion = direccion;
        this.calificacion = calificacion;
        this.proveedoresCalificados = proveedoresCalificados;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public List<Calificacion> getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(List<Calificacion> calificacion) {
        this.calificacion = calificacion;
    }

    public List<Proveedor> getProveedoresCalificados() {
        return proveedoresCalificados;
    }

    public void setProveedoresCalificados(List<Proveedor> proveedoresCalificados) {
        this.proveedoresCalificados = proveedoresCalificados;
    }


}