package com.equipoA.webapp.Servicios;

import com.equipoA.webapp.Entidades.Perfil;
import com.equipoA.webapp.Excepciones.MiException;
import com.equipoA.webapp.Repositorios.PerfilRepositorio;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PerfilServicio {

    @Autowired
    PerfilRepositorio perfilRepositorio;

    @Transactional
    public void crearPerfil(String nombre) throws MiException {

//        validar(nombre);
        Perfil perfil = new Perfil();

        perfil.setNombre(nombre);

        perfilRepositorio.save(perfil);

    }

    public List<Perfil> listarPerfil() {

        List<Perfil> perfiles = new ArrayList();

        perfiles = perfilRepositorio.findAll();

        return perfiles;
    }

    @Transactional
    public void modificarPerfil(String nombre, String id) throws MiException {

        validar(nombre);
        Optional<Perfil> respuesta = perfilRepositorio.findById(id);

        if (respuesta.isPresent()) {
            Perfil perfil = respuesta.get();

            perfil.setNombre(nombre);

            perfilRepositorio.save(perfil);

        }
    }

    public Perfil getOne(String id) {
        return perfilRepositorio.getOne(id);
    }

    private void validar(String nombre) throws MiException {

        if (nombre.isEmpty() || nombre == null) {
            throw new MiException("el nombre no puede ser nulo o estar vacio");
        }
    }

}
