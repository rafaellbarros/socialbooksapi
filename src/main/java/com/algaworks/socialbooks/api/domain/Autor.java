package com.algaworks.socialbooks.api.domain;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Entity
@Data
public class Autor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message = "O campo nome não pode ser vazio.")
	private String nome;
	
	@JsonInclude(Include.NON_NULL)
	@JsonFormat(pattern = "dd/MM/yyyy")
	@NotNull(message = "Campo nascimento é de preenchimento obrigatório.")
	private LocalDate nascimento;
	
	@JsonInclude(Include.NON_NULL)
	@NotNull(message = "Campo nacionalidade é de preenchimento obrigatório.")
	private String nacionalidade;
	
	@OneToMany(mappedBy = "autor")
	@JsonIgnore
	private List<Livro> livros;
}
