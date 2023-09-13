
package com.equipoA.webapp.Controladores;

import com.equipoA.webapp.Entidades.Perfil;
import com.equipoA.webapp.Excepciones.MiException;
import com.equipoA.webapp.Servicios.PerfilServicio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/perfil") 
public class Perfilcontrolador {

    @Autowired
    private PerfilServicio perfilServicio;

    @GetMapping("/registrar") 
    public String registrar() {
        return "perfil_form.html";
    }

    @PostMapping("/registro")
    public String registro(@RequestParam String nombre, ModelMap modelo) {

        try {
            perfilServicio.crearPerfil(nombre);

            modelo.put("exito", "El perfil fue registrado correctamente!");
        } catch (MiException ex) {

            modelo.put("error", ex.getMessage());
            return "perfil_form.html";
        }

        return "index.html";
    }
    
      @GetMapping("/lista")
    public String listar(ModelMap modelo){
        
        List<Perfil> perfiles =perfilServicio.listarPerfil();
        
        modelo.addAttribute("perfiles", perfiles);
        
        return "perfil_list.html";
    }
    
       @GetMapping("/modificar/{id}")
    public String modificar(@PathVariable String id, ModelMap modelo){
        modelo.put("perfiles", perfilServicio.getOne(id));
        
        return "perfil_modificar.html";
    }
    
    @PostMapping("/modificar/{id}")
    public String modificar(@PathVariable String id, String nombre, ModelMap modelo){
        try {
           perfilServicio.modificarPerfil(nombre, id);
            
            return "redirect:../lista";
        } catch (MiException ex) {
            modelo.put("error", ex.getMessage());
            return "perfil_modificar.html";
        }
        
    }

}
