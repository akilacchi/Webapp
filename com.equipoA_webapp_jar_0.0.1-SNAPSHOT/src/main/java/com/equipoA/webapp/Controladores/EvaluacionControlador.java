
package com.equipoA.webapp.Controladores;

import com.equipoA.webapp.Excepciones.MiException;
import com.equipoA.webapp.Servicios.EvaluacionServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/Evaluacion")
public class EvaluacionControlador {

    @Autowired
    private EvaluacionServicio evaluacionServicio;

    @GetMapping("/registrar") 
    public String registrar() {
        return "evaluacion_form.html";
    }

    @PostMapping("/registro")
    public String registro(@RequestParam String nombre, ModelMap modelo) {

        try {
            evaluacionServicio.crearEvaluacion(nombre);

            modelo.put("exito", "La evaluacion fue registrada correctamente!");
        } catch (MiException ex) {

            modelo.put("error", ex.getMessage());
            return "evaluacion_form.html";
        }

        return "index.html";
    }
}
