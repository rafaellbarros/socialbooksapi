package com.algaworks.socialbooks.api.domain;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Entity
@Data
public class Comentario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
		
	@NotEmpty(message = "O comentário deve ser preenchido.")
	@Size(max = 1500, message = "O comentário não pode conter mais de 1500 caracteres.")
	@JsonProperty("comentario")
	private String texto;
	
	@JsonInclude(Include.NON_NULL)
	private String usuario;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate  data;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "livro_id")
	@JsonIgnore
	private  Livro livro;
}
