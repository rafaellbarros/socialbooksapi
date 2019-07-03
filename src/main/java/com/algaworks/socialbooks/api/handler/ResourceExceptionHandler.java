package com.algaworks.socialbooks.api.handler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.algaworks.socialbooks.api.service.exception.AutorExistenteException;
import com.algaworks.socialbooks.api.service.exception.AutorNaoEncontradoException;
import com.algaworks.socialbooks.api.service.exception.LivroNaoEncontradoException;

import lombok.AllArgsConstructor;
import lombok.Getter;

@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(LivroNaoEncontradoException.class)
	public ResponseEntity<Erro> handleLivroNaoEncontradoException
			(LivroNaoEncontradoException ex, HttpServletRequest request) {
	
		String mensagemUsuario = ex.getMessage();
		String mensagemDesenvolvedor = ex.toString();

		Erro erro = new Erro(mensagemUsuario, mensagemDesenvolvedor, 404l);
						
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
	}
	
	@ExceptionHandler(AutorExistenteException.class)
	public ResponseEntity<Erro> handleAutorExistenteException
			(AutorExistenteException ex, HttpServletRequest request) {
	
		String mensagemUsuario = ex.getMessage();
		String mensagemDesenvolvedor = ex.toString();

		Erro erro = new Erro(mensagemUsuario, mensagemDesenvolvedor, 409l);
						
		return ResponseEntity.status(HttpStatus.CONFLICT).body(erro);
	}
	
	@ExceptionHandler(AutorNaoEncontradoException.class)
	public ResponseEntity<Erro> handleAutorNaoEncontradoException
			(AutorNaoEncontradoException ex, HttpServletRequest request) {
	
		String mensagemUsuario = ex.getMessage();
		String mensagemDesenvolvedor = ex.toString();

		Erro erro = new Erro(mensagemUsuario, mensagemDesenvolvedor, 404l);
						
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
	}
	
	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<Erro> handleADataIntegrityViolationException
			(DataIntegrityViolationException ex, HttpServletRequest request) {
	
		String mensagemUsuario = String.format("Requisição inválida");
		String mensagemDesenvolvedor = ex.toString();

		Erro erro = new Erro(mensagemUsuario, mensagemDesenvolvedor, 400l);
						
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
	}	
	
	
	@Getter
	@AllArgsConstructor
	public static class Erro {
		
		private String mensagemUsuario;
		private String mensagemDsenvolvedor;
		private Long status;
	}
}
