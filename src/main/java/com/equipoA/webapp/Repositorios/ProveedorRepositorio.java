/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
