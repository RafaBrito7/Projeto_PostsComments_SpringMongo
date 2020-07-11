package com.rafabrito.workshopMongoSpring.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rafabrito.workshopMongoSpring.domain.Post;
import com.rafabrito.workshopMongoSpring.services.PostServices;

@RestController // Anunciando que a classe vai ser um recurso Rest
@RequestMapping(value = "/posts") // Caminho do endPoint
public class PostResources {

	@Autowired
	private PostServices service;
	
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Post> findById(@PathVariable String id){ // O Path sinalizará que o ID do argumento vai casar com o id da URL
		Post obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
}
