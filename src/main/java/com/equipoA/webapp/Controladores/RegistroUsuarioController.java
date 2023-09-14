package com.equipoA.webapp.Controladores;

import com.equipoA.webapp.Enum.Provincias;
import com.equipoA.webapp.Excepciones.MiException;
import com.equipoA.webapp.Servicios.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/RegistroUser")
public class RegistroUsuarioController {

    @ModelAttribute
    public Provincias[] getLocalidad() {
        Provincias[] localidades = Provincias.values();
        System.out.println("numero de localidades: " + localidades.length);
        return Provincias.values();
    }

    @Autowired
    UsuarioServicio usuarioServicio;

    @GetMapping("/")
    public String registrar(Model model) {
        model.addAttribute("localidad", getLocalidad());
        return "registro.html";
    }

    @PostMapping("/registro")
    public String registro(@RequestParam String fullName, @RequestParam String email, @RequestParam int phone,
            @RequestParam String password, @RequestParam String pass2, @RequestParam Provincias ubicacion) {

        try {
            usuarioServicio.crearUsuario(fullName, email, phone, password, pass2, ubicacion);
        } catch (MiException ex) {
            System.err.println(ex.getMessage());
        }

        return "redirect:/";
    }
}
