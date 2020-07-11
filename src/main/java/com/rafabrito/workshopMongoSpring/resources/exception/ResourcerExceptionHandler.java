package com.rafabrito.workshopMongoSpring.resources.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.rafabrito.workshopMongoSpring.services.exception.ObjectNotFoundException;

// Classe responsável por gerenciar o erro http da requisição
@ControllerAdvice // Informando que essa classe é responsável por tratar possíveis erros nas requisições
public class ResourcerExceptionHandler {

	@ExceptionHandler(ObjectNotFoundException.class) // Indicando pro framework q vai tratar uma exceção ObjectNotFound. Quando ocorrer ela, ele executará o método abaixo
	public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request){
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError err = new StandardError(System.currentTimeMillis(), status.value(), "Not Found", e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}
}
