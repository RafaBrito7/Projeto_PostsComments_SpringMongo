package com.rafabrito.workshopMongoSpring.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rafabrito.workshopMongoSpring.domain.User;
import com.rafabrito.workshopMongoSpring.services.UserServices;

@RestController // Anunciando que a classe vai ser um recurso Rest
@RequestMapping(value = "/users") // Caminho do endPoint
public class UserResources {

	@Autowired
	private UserServices service;
	
	// Pra chamar no endPoint o Get dessa Lista
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<User>> findAll(){ // O response é para manipulação de respostas http, teremos o controle de código de status e etc
		List<User> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
}
