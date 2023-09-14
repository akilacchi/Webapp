/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.equipoA.webapp.Servicios;

import com.equipoA.webapp.Entidades.Calificacion;
import com.equipoA.webapp.Entidades.Cliente;
import com.equipoA.webapp.Entidades.Proveedor;
import com.equipoA.webapp.Entidades.Trabajo;
import com.equipoA.webapp.Enum.Provincias;
import com.equipoA.webapp.Excepciones.MiException;
import com.equipoA.webapp.Repositorios.CalificacionRepositorio;
import com.equipoA.webapp.Repositorios.ClienteRepositorio;
import com.equipoA.webapp.Repositorios.ProveedorRepositorio;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Dell
 */
@Service
public class ClienteServicio extends UsuarioServicio {

    @Autowired
    private ClienteRepositorio clienteRepo;
    private ProveedorRepositorio proveedorRepo;
    private CalificacionRepositorio calificacionRepo;

    @Transactional
    public void crearCliente(String direccion, List<Trabajo> trabajos, List<Calificacion> calificaciones,
            String fullName, String email, int phone, String password, Provincias ubicacion) throws MiException {

        super.crearUsuario(fullName, email, phone, password, password, ubicacion);

        Cliente cliente = new Cliente();
        cliente.setDireccion(direccion);
        cliente.setTrabajos(trabajos);
        cliente.setCalificacion(calificaciones);

        clienteRepo.save(cliente);
    }

    @Transactional
    public void modificarCliente(String id, String direccion, String fullName, String email, int phone, String password, Provincias ubicacion) throws MiException {

        super.modificarUsuario(id, fullName, email, phone, password, password, ubicacion);

        Optional<Cliente> respuesta = clienteRepo.findById(id);
        if (respuesta.isPresent()) {
            Cliente cliente = respuesta.get();
            cliente.setDireccion(direccion);
            clienteRepo.save(cliente);
        } else {
            throw new MiException("Cliente no encontrado");
        }
    }

    @Transactional
    public void eliminarCliente(String id) throws MiException {
        Optional<Cliente> cliente = clienteRepo.findById(id);
        if (cliente.isPresent()) {
            clienteRepo.delete(cliente.get());
        } else {
            throw new MiException("Cliente no encontrado");
        }
    }

    //pedirServicio()
    //cancelarServicio()
    //finalizarServicio()
    //calificarProveedor()
    //contactarProveedor()
    @Transactional
    public void calificarProveedor(String proveedorId, int puntuacion, String comentarios) throws MiException {
        Optional<Proveedor> proveedorOpt = proveedorRepo.findById(proveedorId);

        if (proveedorOpt.isPresent()) {
            Proveedor proveedor = proveedorOpt.get();

            Calificacion calificacion = new Calificacion();
            calificacion.setPuntuacion(puntuacion);
            calificacion.setComentario(comentarios);

            proveedor.getCalificaciones().add(calificacion);
            calificacionRepo.save(calificacion);

        } else {
            throw new MiException("Proveedor no encontrado");
        }
    }
}
