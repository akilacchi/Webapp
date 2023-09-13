
package com.equipoA.webapp.Repositorios;

import com.equipoA.webapp.Entidades.Evaluacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EvaluacionRepositorio extends JpaRepository<Evaluacion, String> {

}
