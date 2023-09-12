package com.equipoA.webapp.Repositorios;

import com.equipoA.webapp.Entidades.Proveedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author alejandrasuarez
 */

@Repository
public interface ProveedorRepositorio  extends JpaRepository<Proveedor, String>{
    @Repository
public interface ClienteRepositorio extends JpaRepository<Proveedor, String> {
    @Query("SELECT p FROM Proveedor p WHERE p.email = :email")
    public Proveedor buscarPorEmail(@Param("email") String email);
    
    @Query("SELECT p FROM Cliente c WHERE p.phone = :phone")
    public Proveedor buscarPorTelefono(@Param("phone") int phone );

    }
}