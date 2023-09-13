/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.

/*private String id_nacional;
    private boolean certificado;
    private int calificacion;
    private int cantidad_trabajos;
    private boolean nuevo_usuario;
package com.equipoA.webapp.Servicios;
 */
package com.equipoA.webapp.Servicios;

import com.equipoA.webapp.Entidades.Proveedor;

import com.equipoA.webapp.Entidades.Trabajo;
import com.equipoA.webapp.Enum.Provincias;
import com.equipoA.webapp.Excepciones.MiException;
import com.equipoA.webapp.Repositorios.ProveedorRepositorio;
import java.util.ArrayList;

import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author alejandrasuarez
 */

@Service
public class ProveedorServicio extends UsuarioServicio {

    @Autowired

    ProveedorRepositorio proveedorRepositorio;

    @Transactional

    // hereda el método de creación de usuario y le añade los atributos propios de proveedor
    public void crearProveedor(String fullName, String email, int phone, Provincias ubicacion,
            String password, String pass2, String idNacional, boolean certificado, boolean nuevoUsuario)
            throws MiException {

        Proveedor proveedor = new Proveedor();

        super.crearUsuario(fullName, email, phone, password, pass2, ubicacion);
        proveedor.setId_nacional(idNacional);
        proveedor.setServicios(new ArrayList());
        proveedor.setCertificado(certificado);
        proveedor.setCantidad_trabajos(0);
        proveedor.setNuevo_usuario(nuevoUsuario);

        proveedorRepositorio.save(proveedor);

    }

    public void editarPerfil(String id, String fullName, String email, int phone, Provincias ubicacion,
            String password, boolean activo, String idNacional, List<Trabajo> servicios, boolean certificado, int cantidadTrabajos, boolean nuevoUsuario)
            throws MiException {

        super.validarId(id);
        super.modificarUsuario(id, fullName, email, phone, password, password, ubicacion);

        Optional<Proveedor> respuesta = proveedorRepositorio.findById(id);

        if (respuesta.isPresent()) {

            Proveedor proveedor = respuesta.get();

            proveedor.setId_nacional(idNacional);
            proveedor.setServicios(servicios);
            proveedor.setCertificado(certificado);
            proveedor.setCantidad_trabajos(cantidadTrabajos);
            proveedor.setNuevo_usuario(nuevoUsuario);

            
            proveedorRepositorio.save(proveedor);
        }
        
        
        
        
    }
    

}
