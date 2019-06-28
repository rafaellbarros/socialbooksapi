package com.algaworks.socialbooks.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.algaworks.socialbooks.api.domain.Autor;
import com.algaworks.socialbooks.api.repository.AutorRepository;
import com.algaworks.socialbooks.api.service.exception.AutorExistenteException;
import com.algaworks.socialbooks.api.service.exception.AutorNaoEncontradoException;

@Service
public class AutorService {

	@Autowired
	private AutorRepository autorRepository;
	
	public List<Autor> listarAutores() {
		return autorRepository.findAll();
	}
	
	public Autor salvar(Autor autor) {
		if (autor.getId() != null) {
			Autor a = autorRepository.findOne(autor.getId());
			
			if (a != null) {
				throw new AutorExistenteException("O autor já existe.");
			}
		}
		
		return autorRepository.save(autor);
	}
	
	public Autor buscar(Long id) {
		Autor autor = autorRepository.findOne(id);
		if (autor == null) {
			throw new AutorNaoEncontradoException("O autor não foi encontrado.");
		}
		return autor;
	}
}
