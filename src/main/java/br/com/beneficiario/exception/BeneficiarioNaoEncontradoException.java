package br.com.beneficiario.exception;

public class BeneficiarioNaoEncontradoException extends RuntimeException{

	
	private static final long serialVersionUID = 1L;
	
	public BeneficiarioNaoEncontradoException (String mensagem){
		super(mensagem);
	}

}
