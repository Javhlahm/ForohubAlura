package com.alura.forohub.repositories;

import com.alura.forohub.entities.Topico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface iTopicoRepositorio extends JpaRepository<Topico, Integer> {
}
