package com.equipoA.webapp.Servicios;

import com.equipoA.webapp.Entidades.Evaluacion;
import com.equipoA.webapp.Entidades.Perfil;
import com.equipoA.webapp.Entidades.Prestacion;
import com.equipoA.webapp.Excepciones.MiException;
import com.equipoA.webapp.Repositorios.EvaluacionRepositorio;
import com.equipoA.webapp.Repositorios.PerfilRepositorio;
import com.equipoA.webapp.Repositorios.PrestacionRepositorio;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class PrestacionServicio {

    @Autowired
    private PrestacionRepositorio prestacionRepositorio;
    @Autowired
    private PerfilRepositorio perfilRepositorio;
    @Autowired
    private EvaluacionRepositorio evaluacionRepositorio;

    @Transactional
    public void crearPrestacion(MultipartFile archivo, String id, String nombreServicio, String idPerfil, String idEvaluacion) throws MiException {

        validar(id, nombreServicio, idPerfil, idEvaluacion);

        Optional<Prestacion> respuesta = prestacionRepositorio.findById(id);
        Optional<Perfil> respuestaPerfil = perfilRepositorio.findById(idPerfil);
        Optional<Evaluacion> respuestaEvaluacion = evaluacionRepositorio.findById(idEvaluacion);

        Perfil perfil = new Perfil();
        Evaluacion evaluacion = new Evaluacion();

        if (respuestaPerfil.isPresent()) {

            perfil = respuestaPerfil.get();
        }

        if (respuestaEvaluacion.isPresent()) {

            evaluacion = respuestaEvaluacion.get();
        }

        Prestacion prestacion = new Prestacion();

        prestacion.setId(id);
        prestacion.setNombreServicio(nombreServicio);
        prestacion.setAlta(new Date());
        prestacion.setPerfil(perfil);
        prestacion.setEvaluacion(evaluacion);

        prestacionRepositorio.save(prestacion);
    }

    public List<Prestacion> listarPrestacion() {
        List<Prestacion> prestacion = new ArrayList();
        prestacion = prestacionRepositorio.findAll();
        return prestacion;
    }

    @Transactional
    public void modificarPrestacion(MultipartFile archivo, String id, String nombreServicio, String idPerfil, String idEvaluacion) throws MiException {

        validar(id, nombreServicio, idPerfil, idEvaluacion);

        Optional<Prestacion> respuesta = prestacionRepositorio.findById(id);
        Optional<Perfil> respuestaPerfil = perfilRepositorio.findById(idPerfil);
        Optional<Evaluacion> respuestaEvaluacion = evaluacionRepositorio.findById(idEvaluacion);

        Perfil perfil = new Perfil();
        Evaluacion evaluacion = new Evaluacion();

        if (respuestaPerfil.isPresent()) {
            perfil = respuestaPerfil.get();
        }
        if (respuestaEvaluacion.isPresent()) {

            evaluacion = respuestaEvaluacion.get();
        }
        if (respuesta.isPresent()) {
            Prestacion prestacion = respuesta.get();

            prestacion.setNombreServicio(nombreServicio);
            prestacion.setPerfil(perfil);
            prestacion.setEvaluacion(evaluacion);

            prestacionRepositorio.save(prestacion);

        }

    }

    private void validar(String id, String nombreServicio, String idPerfil, String idEvaluacion) throws MiException {

        if (id == null) {
            throw new MiException("el id no puede ser nulo");
        }
        if (nombreServicio.isEmpty() || nombreServicio == null) {
            throw new MiException("el nombre del servicio no puede ser nulo o estar vacio");

        }
        if (idPerfil.isEmpty() || idPerfil == null) {
            throw new MiException("el Perfil no puede ser nulo o estar vacio");
        }

        if (idEvaluacion.isEmpty() || idEvaluacion == null) {
            throw new MiException("La Evaluacion no puede ser nula o estar vacia");
        }

    }
}
