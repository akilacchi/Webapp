package com.equipoA.webapp.Servicios;

import com.equipoA.webapp.Entidades.Usuario;
import com.equipoA.webapp.Enum.Localidad;

import com.equipoA.webapp.Enum.Rol;
import com.equipoA.webapp.Excepciones.MiException;
import com.equipoA.webapp.Repositorios.UsuarioRepositorio;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Service;


import org.springframework.web.multipart.MultipartFile;

@Service
public class UsuarioServicio {

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    @org.springframework.transaction.annotation.Transactional
    public void registrar(MultipartFile archivo, String nombre, String email, String password, String password2, Localidad  ubicacion) throws MiException {

        validar(nombre, email, password, password2);

        Usuario usuario = new Usuario();

        usuario.setFullName(nombre);
        usuario.setEmail(email);

        usuario.setUbicacion(ubicacion);
        usuario.setRol(Rol.USER);

        usuarioRepositorio.save(usuario);
    }

    @Transactional
    public void actualizar(MultipartFile archivo, String idUsuario, String nombre, String email, String password, String password2, Localidad ubicacion) throws MiException {

        validar(nombre, email, password, password2);
        Optional<Usuario> respuesta = usuarioRepositorio.findById(idUsuario);
        if (respuesta.isPresent()) {

            Usuario usuario = respuesta.get();
            usuario.setFullName(nombre);
            usuario.setEmail(email);

            usuario.setUbicacion(ubicacion);
            usuario.setRol(Rol.USER);

            usuarioRepositorio.save(usuario);
        }
    }

    public Usuario getOne(String id) {
        return usuarioRepositorio.getOne(id);
    }

    @org.springframework.transaction.annotation.Transactional(readOnly = true)
    public List<Usuario> listarUsuarios() {

        List<Usuario> usuarios = new ArrayList();

        usuarios = usuarioRepositorio.findAll();

        return usuarios;
    }

    @org.springframework.transaction.annotation.Transactional
    public void cambiarRol(String id) {
        Optional<Usuario> respuesta = usuarioRepositorio.findById(id);

        if (respuesta.isPresent()) {

            Usuario usuario = respuesta.get();

            if (usuario.getRol().equals(Rol.USER)) {

                usuario.setRol(Rol.ADMIN);

            } else if (usuario.getRol().equals(Rol.ADMIN)) {
                usuario.setRol(Rol.USER);
            }
        }
    }

    private void validar(String nombre, String email, String password, String password2) throws MiException {

        if (nombre.isEmpty() || nombre == null) {
            throw new MiException("el nombre no puede ser nulo o estar vacío");
        }
        if (email.isEmpty() || email == null) {
            throw new MiException("el email no puede ser nulo o estar vacio");
        }
        if (password.isEmpty() || password == null || password.length() <= 5) {
            throw new MiException("La contraseña no puede estar vacía, y debe tener más de 5 dígitos");
        }

        if (!password.equals(password2)) {
            throw new MiException("Las contraseñas ingresadas deben ser iguales");
        }

    }

    

    
}
