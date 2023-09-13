package com.equipoA.webapp.Servicios;

import com.equipoA.webapp.Entidades.Evaluacion;
import com.equipoA.webapp.Excepciones.MiException;
import com.equipoA.webapp.Repositorios.EvaluacionRepositorio;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EvaluacionServicio {
    
    @Autowired
    EvaluacionRepositorio evaluacionRepositorio;

    @Transactional
    public void crearEvaluacion(String nombre) throws MiException {

        validar(nombre);

        Evaluacion evaluacion = new Evaluacion();

        evaluacion.setNombre(nombre);

        evaluacionRepositorio.save(evaluacion);
    }

    public List<Evaluacion> listarEvaluaciones() {

        List<Evaluacion> evaluaciones = new ArrayList();

        evaluaciones = evaluacionRepositorio.findAll();

        return evaluaciones;
    }

    @Transactional
    public void modificarEvaluacion(String id, String nombre) throws MiException {
        validar(nombre);

        Optional<Evaluacion> respuesta = evaluacionRepositorio.findById(id);

        if (respuesta.isPresent()) {

            Evaluacion evaluacion = respuesta.get();

            evaluacion.setNombre(nombre);

            evaluacionRepositorio.save(evaluacion);
        }
    }

    private void validar(String nombre) throws MiException {

        if (nombre.isEmpty() || nombre == null) {
            throw new MiException("el nombre de la editorial no puede ser nulo o estar vacio");
        }
    }

}
