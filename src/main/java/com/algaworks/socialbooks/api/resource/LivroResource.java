package com.algaworks.socialbooks.api.resource;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.socialbooks.api.domain.Livro;

@RestController
public class LivroResource {

	@RequestMapping(value = "/livros", method = RequestMethod.GET)
	public List<Livro> listar() {
		Livro livro1 = new Livro("Rest Aplicado");
		Livro livro2 = new Livro("Git passo-a-passo");
		return Arrays.asList(livro1, livro2);
	}
}
