/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.equipoA.webapp.Servicios;

import com.equipoA.webapp.Entidades.Cliente;
import com.equipoA.webapp.Enum.Provincias;
import com.equipoA.webapp.Excepciones.MiException;
import com.equipoA.webapp.Repositorios.ClienteRepositorio;
import java.util.ArrayList;
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

    @Transactional
    public void crearCliente(String fullName, String email, int phone, String password, String pass2, Provincias ubicacion) throws MiException {

        Cliente cliente = new Cliente();
        super.crearUsuario(fullName, email, phone, password, pass2, ubicacion);
        cliente.setComentarios(new ArrayList());
        cliente.setHistorialDePedidos(new ArrayList());
        cliente.setCalificacionesDadas(new ArrayList());
        clienteRepo.save(cliente);
    }

    @Transactional
    public void modificarCliente(String Id, String fullName, String email, int phone, String password, String pass2, Provincias ubicacion) throws MiException {
        super.modificarUsuario(Id, fullName, email, phone, password, pass2, ubicacion);
    }

    @Override
    public void desactivarUsuario(String Id) {
        Optional<Cliente> respuesta = clienteRepo.findById(Id);
        if (respuesta.isPresent()) {
            Cliente cliente = respuesta.get();
            super.desactivarUsuario(Id);
        }
    }

    @Override
    public void eliminarUsuario(String Id) {
        Optional<Cliente> respuesta = clienteRepo.findById(Id);
        if (respuesta.isPresent()) {
            Cliente cliente = respuesta.get();
            super.eliminarUsuario(Id);
        }
    }

    //pedirServicio()
    //cancelarServicio()
    //finalizarServicio()
    //calificarProveedor()
    //contactarProveedor()
}
