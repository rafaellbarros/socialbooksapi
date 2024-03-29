package com.algaworks.socialbooks.api.domain;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonFormat;
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
	
	
	@NotEmpty(message = "O campo nome não pode ser vazio.")
	private String nome;
	
	@JsonInclude(Include.NON_NULL)
	@JsonFormat(pattern = "dd/MM/yyyy")
	@NotNull(message = "Campo publicação é de preenchimento obrigatório.")
	private LocalDate publicacao;
	
	@JsonInclude(Include.NON_NULL)
	@NotNull(message = "Campo editora é de preenchimento obrigatório.")
	private String editora;
	
	@JsonInclude(Include.NON_NULL)
	@NotEmpty(message = "Campo editora é de preenchimento obrigatório.")
	@Size(max = 1500, message = "O resumo não pode conter mais de 1500 caracteres.")
	private String resumo;
	
	@JsonInclude(Include.NON_EMPTY)
	@OneToMany(mappedBy = "livro")
	private List<Comentario> comentarios;
	
	@JsonInclude(Include.NON_NULL)
	@ManyToOne
	@JoinColumn(name = "autor_id")
	private Autor autor;
	
}
