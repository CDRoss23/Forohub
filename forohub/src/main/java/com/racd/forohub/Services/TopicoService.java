package com.racd.forohub.Services;

import com.racd.forohub.Models.Curso;
import com.racd.forohub.Models.Topico;
import com.racd.forohub.Models.Usuario;
import com.racd.forohub.repositorios.CursoRepository;
import com.racd.forohub.repositorios.TopicoRepository;
import com.racd.forohub.repositorios.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TopicoService {

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private CursoRepository cursoRepository;

    public List<Topico> findAll() {
        return topicoRepository.findAll();
    }

    public Topico findById(Long id) throws Exception {
        Optional<Topico> topico = topicoRepository.findById(id);
        if (topico.isPresent()) {
            return topico.get();
        } else {
            throw new Exception("Tópico no encontrado");
        }
    }

    public Topico create(DatosRegistroTopico datosRegistroTopico) throws Exception {
        Usuario autor = usuarioRepository.findById(datosRegistroTopico.getAutorId())
                .orElseThrow(() -> new Exception("Autor no encontrado"));
        Curso curso = cursoRepository.findById(datosRegistroTopico.getCursoId())
                .orElseThrow(() -> new Exception("Curso no encontrado"));

        Topico topico = new Topico(datosRegistroTopico, autor, curso);
        return topicoRepository.save(topico);
    }

    public Topico update(Long id, DatosActualizarTopico datosActualizarTopico) throws Exception {
        Topico topico = findById(id);
        topico.actualizarDatos(datosActualizarTopico);
        return topicoRepository.save(topico);
    }

    public void delete(Long id) throws Exception {
        Topico topico = findById(id);
        topicoRepository.delete(topico);
    }
}
