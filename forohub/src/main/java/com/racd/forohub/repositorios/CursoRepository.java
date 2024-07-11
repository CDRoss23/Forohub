package com.racd.forohub.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.racd.forohub.Models.Curso;

public interface CursoRepository extends JpaRepository<Curso, Long> {}