
package com.equipoA.webapp.Entidades;

import com.equipoA.webapp.Enum.Provincias;
import java.util.List;
import javax.persistence.Entity;


@Entity
public class Proveedor extends Usuario{
    
    private String id_nacional;
    private List<Trabajo> servicios;
    private boolean certificado;
    private int calificacion;
    private int cantidad_trabajos;
    private boolean nuevo_usuario;

    public Proveedor(String id_nacional, List<Trabajo> servicios, boolean certificado, int calificacion, int cantidad_trabajos, boolean nuevo_usuario, String ID) {
        super(ID);
        this.id_nacional = id_nacional;
        this.servicios = servicios;
        this.certificado = certificado;
        this.calificacion = calificacion;
        this.cantidad_trabajos = cantidad_trabajos;
        this.nuevo_usuario = nuevo_usuario;
    }

    public Proveedor(List<Trabajo> servicios, boolean certificado, int calificacion, int cantidad_trabajos, boolean nuevo_usuario) {
        this.servicios = servicios;
        this.certificado = certificado;
        this.calificacion = calificacion;
        this.cantidad_trabajos = cantidad_trabajos;
        this.nuevo_usuario = nuevo_usuario;
    }

    public Proveedor(List<Trabajo> servicios, boolean certificado, int calificacion, int cantidad_trabajos, boolean nuevo_usuario, String fullName, String email, String password, int phone, Provincias ubicacion, boolean activo) {
        super(fullName, email, password, phone, ubicacion, activo);
        this.servicios = servicios;
        this.certificado = certificado;
        this.calificacion = calificacion;
        this.cantidad_trabajos = cantidad_trabajos;
        this.nuevo_usuario = nuevo_usuario;
    }
    
    public Proveedor() {
    }

    public List<Trabajo> getServicios() {
        return servicios;
    }

    public void setServicios(List<Trabajo> servicios) {
        this.servicios = servicios;
    }

    public String getId_nacional() {
        return id_nacional;
    }

    public void setId_nacional(String id_nacional) {
        this.id_nacional = id_nacional;
    }

    public boolean isCertificado() {
        return certificado;
    }

    public void setCertificado(boolean certificado) {
        this.certificado = certificado;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

    public int getCantidad_trabajos() {
        return cantidad_trabajos;
    }

    public void setCantidad_trabajos(int cantidad_trabajos) {
        this.cantidad_trabajos = cantidad_trabajos;
    }

    public boolean isNuevo_usuario() {
        return nuevo_usuario;
    }

    public void setNuevo_usuario(boolean nuevo_usuario) {
        this.nuevo_usuario = nuevo_usuario;
    }

    @Override
    public void setUbicacion(Provincias ubicacion) {
        super.setUbicacion(ubicacion); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Provincias getUbicacion() {
        return super.getUbicacion(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setPhone(int phone) {
        super.setPhone(phone); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getPhone() {
        return super.getPhone(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setEmail(String email) {
        super.setEmail(email); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getEmail() {
        return super.getEmail(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setFullName(String fullName) {
        super.setFullName(fullName); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getFullName() {
        return super.getFullName(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setID(String ID) {
        super.setID(ID); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getID() {
        return super.getID(); //To change body of generated methods, choose Tools | Templates.
    }
   
    
}