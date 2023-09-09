package com.equipoA.webapp.Servicios;

import com.equipoA.webapp.Entidades.Usuario;
import com.equipoA.webapp.Enum.Localidad;
import com.equipoA.webapp.Excepciones.MiException;
import com.equipoA.webapp.Repositorios.UsuarioRepositorio;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServicio {

    @Autowired
    private UsuarioRepositorio userRepo;

    @Transactional
    public void crearUsuario(String fullName, String email, int phone, String password, String pass2, Localidad ubicacion) throws MiException {

        //validacion datos
        validar(fullName, email, phone, password, pass2, ubicacion);
        //búsqueda duplicados
        Usuario respuestaEmail = userRepo.buscarPorEmail(email);
        Usuario respuestaPhone = userRepo.buscarPorTelefono(phone);
        //validacion duplicados
        if (respuestaEmail != null) {
            throw new MiException("Email ya en uso");
        } else if (respuestaPhone != null) {
            throw new MiException("Número de teléfono ya en uso");
        } else {
        //creacion de usuario una vez la validacion haya finalizado    
            Usuario user = new Usuario();

            user.setFullName(fullName);
            user.setEmail(email);
            user.setPhone(phone);
            user.setUbicacion(ubicacion);
            user.setActivo(true);
            user.setPassword(password);

            userRepo.save(user);

        }

    }

    public void modificarUsuario(String Id, String fullName, String email, int phone, String password, String pass2, Localidad ubicacion) throws MiException {
        //verificacion que el id sea correcto
        validarId(Id);
        //búsqueda por id
        Optional<Usuario> respuesta = userRepo.findById(Id);
        
        if (respuesta.isPresent()) {

            validar(fullName, email, phone, password, pass2, ubicacion);

            Usuario usr = respuesta.get();

            usr.setFullName(fullName);
            usr.setEmail(email);
            usr.setPhone(phone);
            usr.setUbicacion(ubicacion);

            userRepo.save(usr);
        }
    }

    public void cambiarContraseñaYEmail(String Id, String email, String password, String pass2) throws MiException {
        validar(Id, email, password, pass2);

        Optional<Usuario> respuesta = userRepo.findById(Id);

        if (respuesta.isPresent()) {
            Usuario usr = respuesta.get();

            usr.setPassword(password);
            usr.setEmail(email);
        }
    }

    public void desactivarUsuario(String Id) {
        Optional<Usuario> respuesta = userRepo.findById(Id);
        if (respuesta.isPresent()) {
            Usuario usr = respuesta.get();

            usr.setActivo(false);

            userRepo.save(usr);
        }
    }

    public void eliminarUsuario(String Id) {
        Optional<Usuario> respuesta = userRepo.findById(Id);
        if (respuesta.isPresent()) {
            Usuario usr = respuesta.get();

            userRepo.delete(usr);
        }
    }

    //metodo unico para validar id
    protected void validarId(String Id) throws MiException {
        if (Id.trim().isEmpty() || Id == null) {
            throw new MiException("ID incorrecto");
        }
    }
    
    //metodo para valorar todo excepto id
    protected void validar(String fullName, String email, int phone, String password, String pass2, Localidad ubicacion) throws MiException {
        if (email == null || email.isEmpty()) {
            throw new MiException("Email no puede estar vacío");
        }
        if (phone == 0) {
            throw new MiException("Número celular no puede estar vacío");
        }
        if (password.trim() == null || password.trim().isEmpty()) {
            throw new MiException("Contraseña no puede estar vacía");
        }
        if (!password.trim().equals(pass2.trim())) {
            throw new MiException("Contraseñas no coinciden");
        }
        if (ubicacion == null) {
            throw new MiException("Seleccione una ubicacion");
        }
        if (fullName.trim().isEmpty() || fullName == null) {
            throw new MiException("Ingrese su nombre");
        }

    }

    //Sobrecarga del metodo validar unico para cambiar contraseña
    protected void validar(String Id, String email, String password, String pass2) throws MiException {
        validarId(Id);
        if (email == null || email.isEmpty()) {
            throw new MiException("Email no puede estar vacío");
        }
        if (password.trim() == null || password.trim().isEmpty()) {
            throw new MiException("Contraseña no puede estar vacía");
        }
        if (!password.trim().equals(pass2.trim())) {
            throw new MiException("Contraseñas no coinciden");
        }
    }
}
