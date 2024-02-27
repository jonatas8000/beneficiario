package br.com.beneficiario.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.beneficiario.dto.ErroDTO;
import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler extends ResponseEntityExceptionHandler {
	
	
	@ExceptionHandler(BeneficiarioNaoEncontradoException.class)
	public ResponseEntity<ErroDTO> handlePautaNaoEncontradaException(BeneficiarioNaoEncontradoException e,
			HttpServletRequest request, HandlerMethod handlerMethod) {	
		
		ErroDTO erroDTO = new ErroDTO(404,HttpStatus.NOT_FOUND.name(), e.getMessage());
		return new  ResponseEntity<ErroDTO>(erroDTO, HttpStatus.NOT_FOUND);
	}
	
	
	

}
