
package com.equipoA.webapp.Repositorios;

import com.equipoA.webapp.Entidades.Proveedor;
import org.springframework.data.jpa.repository.JpaRepository;


import org.springframework.stereotype.Repository;

/**
 *
 * @author alejandrasuarez
 */

@Repository
public interface ProveedorRepositorio  extends JpaRepository<Proveedor, String>{

    
}

