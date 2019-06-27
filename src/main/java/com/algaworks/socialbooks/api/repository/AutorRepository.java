package com.algaworks.socialbooks.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.algaworks.socialbooks.api.domain.Autor;

public interface AutorRepository extends JpaRepository<Autor, Long> {

}
