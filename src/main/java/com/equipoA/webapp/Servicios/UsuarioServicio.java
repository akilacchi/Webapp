package com.equipoA.webapp.Servicios;

import com.equipoA.webapp.Entidades.Usuario;
import com.equipoA.webapp.Enum.Localidad;
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
    public void crearUsuario(String fullName, String email, int phone, Localidad ubicacion){
        Usuario user = new Usuario();
        
        user.setFullName(fullName);
        user.setEmail(email);
        user.setPhone(phone);
        user.setUbicacion(ubicacion);
        user.setActivo(true);
        
        userRepo.save(user);
    }
    
    public void modificarUsuario(String Id, String fullName, String email, int phone,Localidad ubicacion){
        Optional<Usuario> respuesta = userRepo.findById(Id);
        if(respuesta.isPresent()){
            Usuario usr = respuesta.get();
            
            usr.setFullName(fullName);
            usr.setEmail(email);
            usr.setPhone(phone);
            usr.setUbicacion(ubicacion);
            
            userRepo.save(usr);
        }
    }
    
    public void desactivarUsuario(String Id){
    Optional<Usuario> respuesta = userRepo.findById(Id);
        if(respuesta.isPresent()){
            Usuario usr = respuesta.get();
            
            usr.setActivo(false);
            
            userRepo.save(usr);
        }
    }
    
    public void eliminarUsuario(String Id){
        Optional<Usuario> respuesta = userRepo.findById(Id);
        if(respuesta.isPresent()){
            Usuario usr = respuesta.get();
            
            userRepo.delete(usr);
        }
    }
    
}
