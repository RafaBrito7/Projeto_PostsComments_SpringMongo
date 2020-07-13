package com.rafabrito.workshopMongoSpring.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rafabrito.workshopMongoSpring.domain.Post;
import com.rafabrito.workshopMongoSpring.resources.util.URL;
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
	
	@RequestMapping(value = "/titlesearch", method = RequestMethod.GET)
	public ResponseEntity<List<Post>> findByTitle(@RequestParam(value = "text", defaultValue = "") String text){ // O request formatará a url no padrão http titlesearch?text=parametromsg
		text = URL.decodeParam(text); // Para encontrar a formatação http do text, inpencionar elemento no chrome e pesquisar no console o encodeURIComponent("bom dia")
		List<Post> list = service.findByTitle(text);
		return ResponseEntity.ok().body(list);
	}
	
}
