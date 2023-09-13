package com.equipoA.webapp.Repositorios;

import com.equipoA.webapp.Entidades.Cliente;
import com.equipoA.webapp.Entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Dell
 */

@Repository
public interface ClienteRepositorio extends JpaRepository<Cliente, String> {
    @Query("SELECT c FROM Cliente c WHERE c.email = :email")
    public Cliente buscarPorEmail(@Param("email") String email);
    
    @Query("SELECT c FROM Cliente c WHERE c.phone = :phone")
    public Cliente buscarPorTelefono(@Param("phone") int phone );

}