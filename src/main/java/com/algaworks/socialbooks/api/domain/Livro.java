package com.algaworks.socialbooks.api.domain;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Data
public class Livro {

	@JsonInclude(Include.NON_NULL)
	private Long id;
	
	private String nome;
	
	@JsonInclude(Include.NON_NULL)
	private LocalDate publicacao;
	
	@JsonInclude(Include.NON_NULL)
	private String editora;
	
	@JsonInclude(Include.NON_NULL)
	private String resumo;
	
	@JsonInclude(Include.NON_NULL)
	private List<Comentario> comentarios;
	
	@JsonInclude(Include.NON_NULL)
	private String autor;
	
	public Livro(String nome) {
		this.nome = nome;
	}
}
