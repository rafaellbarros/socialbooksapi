package com.algaworks.socialbooks.api.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.socialbooks.api.domain.Autor;
import com.algaworks.socialbooks.api.service.AutorService;

@RestController
@RequestMapping("/autores")
public class AutorRersouce {
	
	@Autowired
	private AutorService autorService;
	
	@GetMapping
	public ResponseEntity<List<Autor>> listar() {
		List<Autor> autores = autorService.listarAutores();
		return ResponseEntity.status(HttpStatus.OK).body(autores);
	}

}
