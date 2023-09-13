package com.equipoA.webapp.Controladores;

import com.equipoA.webapp.Entidades.Evaluacion;
import com.equipoA.webapp.Entidades.Perfil;
import com.equipoA.webapp.Entidades.Prestacion;
import com.equipoA.webapp.Excepciones.MiException;
import com.equipoA.webapp.Servicios.EvaluacionServicio;
import com.equipoA.webapp.Servicios.PerfilServicio;
import com.equipoA.webapp.Servicios.PrestacionServicio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/prestacion")
public class PrestacionControlador {

    @Autowired
    private PrestacionServicio prestacionServicio;
    @Autowired
    private PerfilServicio perfilServicio;
    @Autowired
    private EvaluacionServicio evaluacionServicio;

    @GetMapping("/registrar") //localhost:8080/prestacion/registrar
    public String registrar(ModelMap modelo) {
        List<Perfil> perfiles = perfilServicio.listarPerfil();
        List<Evaluacion> evaluaciones = evaluacionServicio.listarEvaluaciones();

        modelo.addAttribute("perfiles", perfiles);
        modelo.addAttribute("evaluaciones", evaluaciones);

        return "prestacion_form.html";
    }

    @PostMapping("/registro")
    public String registro(@RequestParam(required = false) String id, @RequestParam String nombreServicio, @RequestParam String idPerfil,
            @RequestParam String idEvaluacion, ModelMap modelo, @RequestParam(required = false) MultipartFile archivo) {
        try {

            prestacionServicio.crearPrestacion(archivo, id, nombreServicio, idPerfil, idEvaluacion);

            modelo.put("exito", "El perfil fue cargado correctamente!");

        } catch (MiException ex) {
            List<Perfil> perfiles = perfilServicio.listarPerfil();
            List<Evaluacion> evaluaciones = evaluacionServicio.listarEvaluaciones();

            modelo.addAttribute("perfiles", perfiles);
            modelo.addAttribute("evaluaciones", evaluaciones);
            modelo.put("error", ex.getMessage());

            return "prestacion_form.html";
        }
        return "index.html";
    }

    @GetMapping("/lista")
    public String listar(ModelMap modelo) {
        List<Prestacion> prestaciones = prestacionServicio.listarPrestacion();
        modelo.addAttribute("prestacion", prestaciones);

        return "prestacion_list";
    }

    @GetMapping("/modificar/{isbn}")
    public String modificar(@PathVariable String id, ModelMap modelo) {

        List<Perfil> perfiles = perfilServicio.listarPerfil();
        List<Evaluacion> evaluaciones = evaluacionServicio.listarEvaluaciones();

        modelo.addAttribute("perfiles", perfiles);
        modelo.addAttribute("evaluaciones", evaluaciones);

        return "Prestacion_modificar.html";
    }

    @PostMapping("/modificar/{id}")
    public String modificar(@PathVariable String id, String nombreServicio, String idPerfil, String idEvaluacion, ModelMap modelo, MultipartFile archivo) {
        try {
            List<Perfil> perfiles = perfilServicio.listarPerfil();
            List<Evaluacion> evaluaciones = evaluacionServicio.listarEvaluaciones();

            modelo.addAttribute("perfiles", perfiles);
            modelo.addAttribute("evaluaciones", evaluaciones);

            prestacionServicio.modificarPrestacion(archivo, id, nombreServicio, idPerfil, idEvaluacion);

            return "redirect:../lista";

        } catch (MiException ex) {
            List<Perfil> perfiles = perfilServicio.listarPerfil();
            List<Evaluacion> evaluaciones = evaluacionServicio.listarEvaluaciones();

            modelo.put("error", ex.getMessage());

            modelo.addAttribute("perfiles", perfiles);
            modelo.addAttribute("evaluaciones", evaluaciones);

            return "prestaciones_modificar.html";
        }

    }

}
