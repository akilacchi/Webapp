package com.equipoA.webapp.Entidades;

import com.equipoA.webapp.Enum.EstadoTrabajo;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.EnumType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import org.hibernate.annotations.GenericGenerator;

@Entity
public class Trabajo {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    private String Id;

    @ManyToOne
    @JoinColumn(name = "ocupacion")
    private Ocupaciones ocupacion;

    @ManyToOne
    @JoinColumn(name = "proveedor_id")
    private Proveedor proveedor;

    @Enumerated(EnumType.STRING)
    private EstadoTrabajo estado;

    public Trabajo(String Id, Ocupaciones ocupacion, Proveedor proveedor, EstadoTrabajo estado) {
        this.Id = Id;
        this.ocupacion = ocupacion;
        this.proveedor = proveedor;
        this.estado = estado;
    }

    public Trabajo() {
    }

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public Ocupaciones getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(Ocupaciones ocupacion) {
        this.ocupacion = ocupacion;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public EstadoTrabajo getEstado() {
        return estado;
    }

    public void setEstado(EstadoTrabajo estado) {
        this.estado = estado;
    }

}
