package com.algaworks.socialbooks.api.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.socialbooks.api.domain.Livro;
import com.algaworks.socialbooks.api.repository.LivroRepository;

@RestController
public class LivroResource {
	
	@Autowired
	private LivroRepository livroRepository;

	@RequestMapping(value = "/livros", method = RequestMethod.GET)
	public List<Livro> listar() {
		return livroRepository.findAll();
	}
}
