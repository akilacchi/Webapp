
package com.equipoA.webapp.Repositorios;

import com.equipoA.webapp.Entidades.Perfil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PerfilRepositorio  extends JpaRepository<Perfil, String>{
    
}

    

