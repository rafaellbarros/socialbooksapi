package com.algaworks.socialbooks.api.domain;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Data
@Entity
public class Livro {

	
	@JsonInclude(Include.NON_NULL)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	
	@JsonInclude(Include.NON_NULL)
	private LocalDate publicacao;
	
	@JsonInclude(Include.NON_NULL)
	private String editora;
	
	@JsonInclude(Include.NON_NULL)
	private String resumo;
	
	@JsonInclude(Include.NON_NULL)
	@Transient
	private List<Comentario> comentarios;
	
	@JsonInclude(Include.NON_NULL)
	private String autor;
	
	public Livro(String nome) {
		this.nome = nome;
	}
}