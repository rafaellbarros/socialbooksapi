package com.algaworks.socialbooks.api.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.algaworks.socialbooks.api.domain.Comentario;
import com.algaworks.socialbooks.api.domain.Livro;
import com.algaworks.socialbooks.api.repository.ComentarioRepository;
import com.algaworks.socialbooks.api.repository.LivroRepository;
import com.algaworks.socialbooks.api.service.exception.LivroNaoEncontradoException;

@Service
public class LivroService {
	
	@Autowired
	private LivroRepository livroRepository;
	
	@Autowired
	private ComentarioRepository comentarioRepository;
	
	public List<Livro> listar() {
		return livroRepository.findAll();
	}
	
	public Livro buscar(Long id) {
		Livro livro = livroRepository.findOne(id);
		
		if (livro == null) {
			throw new LivroNaoEncontradoException("O livro não pôde ser encontrado.");
		}
		
		return livro;
	}
	
	public Livro salvar(Livro livro) {
		livro.setId(null);
		return livroRepository.save(livro);
	}
	
	public void deletar(Long id) {
		try {
			livroRepository.delete(id);			
		} catch (EmptyResultDataAccessException e) {
			throw new LivroNaoEncontradoException("O livro não pôde ser encontrado.");
		}
	}
	
	public void atualizar(Livro livro) {
		verificarExistencia(livro);
		livroRepository.save(livro);
	}
	
	public Comentario salvarComentario(Long livroId, Comentario comentario) {
		Livro livro = buscar(livroId);
		comentario.setLivro(livro);
		comentario.setData(LocalDate.now());
		return comentarioRepository.save(comentario);
	}
	
	private void verificarExistencia(Livro livro) {
		buscar(livro.getId());
	}

	public List<Comentario> listarComentarios(Long livroId) {
		Livro livro = buscar(livroId);
		return livro.getComentarios();
	}

}
