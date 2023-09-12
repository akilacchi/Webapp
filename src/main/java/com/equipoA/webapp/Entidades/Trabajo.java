package com.equipoA.webapp.Entidades;

import com.equipoA.webapp.Enum.EstadoTrabajo;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.EnumType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import org.hibernate.annotations.GenericGenerator;

@Entity
public class Trabajo {
    @Id
    @GeneratedValue(generator="uuid")
    @GenericGenerator(name="uuid" ,strategy="uuid")
    private String Id;
    @Enumerated(EnumType.STRING)
    private Ocupaciones ocupacion;
    private EstadoTrabajo estado;
    
    
}
