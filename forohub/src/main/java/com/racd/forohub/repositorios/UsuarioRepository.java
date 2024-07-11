package com.racd.forohub.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.racd.forohub.Models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {}