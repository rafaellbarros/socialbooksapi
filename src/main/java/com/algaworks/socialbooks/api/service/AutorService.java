package com.algaworks.socialbooks.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.algaworks.socialbooks.api.domain.Autor;
import com.algaworks.socialbooks.api.repository.AutorRepository;

@Service
public class AutorService {

	@Autowired
	private AutorRepository autorRepository;
	
	public List<Autor> listarAutores() {
		return autorRepository.findAll();
	}
}
