package com.racd.forohub.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.racd.forohub.Services.DatosActualizarTopico;
import com.racd.forohub.Services.DatosRegistroTopico;

@Entity
@Table(name = "topicos")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String mensaje;
    private LocalDateTime fechaCreacion;
    private String status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "autor_id")
    private Usuario autor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "curso_id")
    private Curso curso;

    @OneToMany(mappedBy = "topico", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Respuesta> respuestas = new ArrayList<>();

    public Topico(DatosRegistroTopico datosRegistroTopico, Usuario autor, Curso curso) {
        this.titulo = datosRegistroTopico.getTitulo();
        this.mensaje = datosRegistroTopico.getMensaje();
        this.fechaCreacion = LocalDateTime.now();
        this.status = "ABIERTO"; // o cualquier valor por defecto que desees
        this.autor = autor;
        this.curso = curso;
    }

    public void actualizarDatos(DatosActualizarTopico datosActualizarTopico) {
        if (datosActualizarTopico.getTitulo() != null) {
            this.titulo = datosActualizarTopico.getTitulo();
        }
        if (datosActualizarTopico.getMensaje() != null) {
            this.mensaje = datosActualizarTopico.getMensaje();
        }
        if (datosActualizarTopico.getStatus() != null) {
            this.status = datosActualizarTopico.getStatus();
        }
    }
}
