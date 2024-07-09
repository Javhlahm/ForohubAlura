package com.alura.forohub.repositories;

import com.alura.forohub.entities.UsuarioSistema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface iUsuarioSistemaRepositorio extends JpaRepository<UsuarioSistema,Integer> {
    UserDetails findByNombreUsuario(String nombreUsuario);
}
