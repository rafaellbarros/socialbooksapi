package com.algaworks.socialbooks.api.service.exception;

public class AutorExistenteException extends RuntimeException {

	private static final long serialVersionUID = -1093471726911941954L;
	
	public AutorExistenteException(String mensagem) {
		super(mensagem);
	}
	
	
	public AutorExistenteException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}
	

}
