
package com.equipoA.webapp.Repositorios;

import com.equipoA.webapp.Entidades.Prestacion;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PrestacionRepositorio extends JpaRepository<Prestacion, String> {

    @Query("SELECT p FROM Prestacion p WHERE p.nombreServicio = :nombreServicio")
    public Prestacion buscarPornombreServicio(@Param("nombreServicio") String nombreServicio);

    @Query("SELECT p FROM Prestacion p WHERE p.prefil.nombre = :nombre")
    public List<Prestacion> buscarPorPerfil(@Param("nombre") String nombre);

}