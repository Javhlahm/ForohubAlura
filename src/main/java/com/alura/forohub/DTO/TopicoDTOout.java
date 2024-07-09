package com.alura.forohub.DTO;

import com.alura.forohub.entities.Topico;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record TopicoDTOout(
        @NotNull
        String titulo,
        @NotNull
        String mensaje,
        @NotNull
        LocalDateTime fechaCreacion,
        @NotNull
        String status,
        @NotNull
        String autor,
        @NotNull
        String curso
) {

    public TopicoDTOout(Topico topico) {
        this(topico.getTitulo(), topico.getMensaje(), topico.getFechaCreacion(), topico.isStatus(), topico.getAutor(), topico.getCurso());
    }
}
