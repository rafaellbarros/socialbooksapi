package com.algaworks.socialbooks.api.service.exception;

public class AutorNaoEncontradoException extends RuntimeException {

	private static final long serialVersionUID = -1093471726911941954L;
	
	public AutorNaoEncontradoException(String mensagem) {
		super(mensagem);
	}
	
	public AutorNaoEncontradoException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}

}
