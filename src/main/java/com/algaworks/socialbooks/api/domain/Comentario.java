package com.algaworks.socialbooks.api.domain;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
public class Comentario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String texto;
	
	private String usuario;
	
	private LocalDate  data;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "livro_id")
	@JsonIgnore
	private  Livro livro;
}
