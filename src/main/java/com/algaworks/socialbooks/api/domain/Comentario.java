package com.algaworks.socialbooks.api.domain;

import java.time.LocalDate;

import lombok.Data;

@Data
public class Comentario {

	private Long id;
	
	private String texto;
	
	private String usuario;
	
	private LocalDate  data;
}
