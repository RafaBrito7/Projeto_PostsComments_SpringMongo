package com.rafabrito.workshopMongoSpring.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rafabrito.workshopMongoSpring.domain.User;

@RestController // Anunciando que a classe vai ser um recurso Rest
@RequestMapping(value = "/users") // Caminho do endPoint
public class UserResources {

	// Pra chamar no endPoint o Get dessa Lista
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<User>> findAll(){ // O response é para manipulação de respostas http, teremos o controle de código de status e etc
		User u1 = new User("Maria Silva", 1L, "mariasilva@gmail.com");
		User u2 = new User("Alex Green", 2L, "alexgreen@gmail.com");
		
		List<User> list = new ArrayList<>();
		
		list.addAll(Arrays.asList(u1,u2));
		return ResponseEntity.ok().body(list);
	}
}
