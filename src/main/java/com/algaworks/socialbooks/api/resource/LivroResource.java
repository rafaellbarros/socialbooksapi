package com.algaworks.socialbooks.api.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.socialbooks.api.domain.Livro;
import com.algaworks.socialbooks.api.repository.LivroRepository;

@RestController
@RequestMapping("/livros")
public class LivroResource {
	
	@Autowired
	private LivroRepository livroRepository;

	@GetMapping
	public List<Livro> listar() {
		return livroRepository.findAll();
	}
	
	@PostMapping
	public void salvar(@RequestBody Livro livro) {
		livroRepository.save(livro);
	}
}
