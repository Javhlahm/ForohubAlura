package com.alura.forohub.services;

import com.alura.forohub.entities.Topico;
import com.alura.forohub.exceptions.TopicoNoEncontradoException;
import com.alura.forohub.repositories.iTopicoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TopicoServicio {

    @Autowired
    iTopicoRepositorio topicoRepositorio;

    public Topico crearTopico(Topico topico){
        return topicoRepositorio.save(topico);
    }

    public List<Topico> listarTodosTopicos() {
        return topicoRepositorio.findAll();
    }

    public Topico buscarTopicoId(Integer id) throws RuntimeException {
        Optional<Topico> resultadobusqueda = topicoRepositorio.findById(id);
        if (resultadobusqueda.isEmpty()){
            throw new TopicoNoEncontradoException("Topico no encontrado");
        }
        return resultadobusqueda.get();
    }

    public Topico actualizarTopicoId(Integer id, Topico topicoActualizado) {
        Optional<Topico> resultadobusqueda = topicoRepositorio.findById(id);
        if (resultadobusqueda.isEmpty()) {
            throw new TopicoNoEncontradoException("Topico no encontrado");
        }
        Topico topicoActual = resultadobusqueda.get();
        topicoActual.setTitulo(topicoActualizado.getTitulo());
        topicoActual.setMensaje(topicoActualizado.getMensaje());
        topicoActual.setAutor(topicoActualizado.getAutor());
        topicoActual.setCurso(topicoActualizado.getCurso());
        return topicoRepositorio.save(topicoActual);
    }

    public void eliminarTopicoId(Integer id) {
        Optional<Topico> resultadobusqueda = topicoRepositorio.findById(id);
        if (resultadobusqueda.isEmpty()) {
            throw new TopicoNoEncontradoException("Topico no encontrado");
        }
         topicoRepositorio.deleteById(id);
    }
}
