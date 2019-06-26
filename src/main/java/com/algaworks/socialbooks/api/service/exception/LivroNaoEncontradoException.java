package com.algaworks.socialbooks.api.service.exception;

public class LivroNaoEncontradoException extends RuntimeException {

	private static final long serialVersionUID = 5859509763749623247L;


	public LivroNaoEncontradoException(String mensagem) {
		super(mensagem);
	}
	
	
	public LivroNaoEncontradoException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}
	
}
