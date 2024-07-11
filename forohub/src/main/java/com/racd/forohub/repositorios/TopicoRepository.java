package com.racd.forohub.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.racd.forohub.Models.Topico;

@Repository
public interface TopicoRepository extends JpaRepository<Topico, Long> {
}
