package com.racd.forohub.controller;

import com.racd.forohub.Models.Topico;
import com.racd.forohub.Services.DatosActualizarTopico;
import com.racd.forohub.Services.DatosRegistroTopico;
import com.racd.forohub.Services.TopicoService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoService topicoService;

    @GetMapping
    public List<Topico> getAllTopicos() {
        return topicoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Topico> getTopicoById(@PathVariable Long id) throws Exception {
        Topico topico = topicoService.findById(id);
        return ResponseEntity.ok(topico);
    }

    @PostMapping
    public ResponseEntity<Topico> createTopico(@Valid @RequestBody DatosRegistroTopico datosRegistroTopico) throws Exception {
        Topico createdTopico = topicoService.create(datosRegistroTopico);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTopico);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Topico> updateTopico(@PathVariable Long id, @Valid @RequestBody DatosActualizarTopico datosActualizarTopico) throws Exception {
        Topico updatedTopico = topicoService.update(id, datosActualizarTopico);
        return ResponseEntity.ok(updatedTopico);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTopico(@PathVariable Long id) throws Exception {
        topicoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
