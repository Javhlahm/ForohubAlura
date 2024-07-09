package com.alura.forohub.controllers;

import com.alura.forohub.DTO.TopicoDTOin;
import com.alura.forohub.DTO.TopicoDTOout;
import com.alura.forohub.entities.Topico;
import com.alura.forohub.services.TopicoServicio;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class TopicosControlador {

    @Autowired
    TopicoServicio topicoServicio;

    @PostMapping("/topicos")
    public ResponseEntity crearTopico(@RequestBody @Valid TopicoDTOin topicoDTOin){
        Topico respuesta = topicoServicio.crearTopico(new Topico(topicoDTOin));
        return new ResponseEntity(new TopicoDTOout(respuesta), HttpStatus.CREATED);
    }

    @GetMapping("/topicos")
    public ResponseEntity listarTopicos(){
        List<TopicoDTOout> listaTopicos = topicoServicio.listarTodosTopicos().stream().map(t->new TopicoDTOout(t)).collect(Collectors.toList());
        return new ResponseEntity(listaTopicos,HttpStatus.OK);
    }

    @GetMapping("/topicos/{id}")
    public ResponseEntity buscarTopico(@PathVariable @Valid Integer id){
        Topico respuesta = topicoServicio.buscarTopicoId(id);
        return new ResponseEntity(new TopicoDTOout(respuesta), HttpStatus.OK);
    }

    @PutMapping("/topicos/{id}")
    public ResponseEntity actualizarTopico(@PathVariable @Valid Integer id, @RequestBody @Valid TopicoDTOin topicoDTOin){
        Topico respuesta = topicoServicio.actualizarTopicoId(id, new Topico(topicoDTOin));
        return new ResponseEntity(new TopicoDTOout(respuesta),HttpStatus.OK);
    }

    @DeleteMapping("/topicos/{id}")
    public ResponseEntity eliminarTopico(@PathVariable @Valid Integer id){
        topicoServicio.eliminarTopicoId(id);
        return new ResponseEntity("Topico eliminado", HttpStatus.NOT_FOUND);
    }

}
