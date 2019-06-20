package com.algaworks.socialbooks.api.domain;

import java.time.LocalDate;
import java.util.List;

import lombok.Data;

@Data
public class Livro {

	private Long id;
	
	private String nome;
	
	private LocalDate publicacao;
	
	private String editora;
	
	private String resumo;
	
	private List<Comentario> comentarios;
	
	private String autor;
	
	public Livro(String nome) {
		this.nome = nome;
	}
}
