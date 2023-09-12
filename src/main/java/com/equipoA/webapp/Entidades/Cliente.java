package com.equipoA.webapp.Entidades;

import com.equipoA.webapp.Enum.Provincias;
import java.util.List;
import javax.persistence.Entity;

@Entity
public class Cliente extends Usuario {

    private List<String> comentarios;
    private List<String> historialDePedidos;
    private List<Integer> calificacionesDadas;

    public Cliente() {
    }

    public Cliente(List<String> comentarios, List<String> historialDePedidos, List<Integer> calificacionesDadas, String ID) {
        super(ID);
        this.comentarios = comentarios;
        this.historialDePedidos = historialDePedidos;
        this.calificacionesDadas = calificacionesDadas;
    }

    public Cliente(List<String> comentarios, List<String> historialDePedidos, List<Integer> calificacionesDadas, String ID, String fullName, String email, String password, int phone, Provincias ubicacion, boolean activo) {
        super(fullName, email, password, phone, ubicacion, activo);
        this.comentarios = comentarios;
        this.historialDePedidos = historialDePedidos;
        this.calificacionesDadas = calificacionesDadas;
    }

    public List<String> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<String> comentarios) {
        this.comentarios = comentarios;
    }

    public List<String> getHistorialDePedidos() {
        return historialDePedidos;
    }

    public void setHistorialDePedidos(List<String> historialDePedidos) {
        this.historialDePedidos = historialDePedidos;
    }

    public List<Integer> getCalificacionesDadas() {
        return calificacionesDadas;
    }

    public void setCalificacionesDadas(List<Integer> calificacionesDadas) {
        this.calificacionesDadas = calificacionesDadas;
    }


    
}