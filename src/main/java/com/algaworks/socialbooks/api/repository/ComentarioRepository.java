package com.algaworks.socialbooks.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.algaworks.socialbooks.api.domain.Comentario;

public interface ComentarioRepository extends JpaRepository<Comentario, Long> {

}
