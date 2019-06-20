package com.algaworks.socialbooks.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.algaworks.socialbooks.api.domain.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long> {

}
