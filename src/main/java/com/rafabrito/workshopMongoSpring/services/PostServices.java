package com.rafabrito.workshopMongoSpring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rafabrito.workshopMongoSpring.domain.Post;
import com.rafabrito.workshopMongoSpring.repository.PostRepository;
import com.rafabrito.workshopMongoSpring.services.exception.ObjectNotFoundException;

@Service
public class PostServices{

	@Autowired // Mecanismo de injenção de dependência automática do Spring... 
	private PostRepository repo; // Chamando a nossa Interface como um Objeto, para utilização dos seus métodos
	
	public Post findById(String id) {
		Optional<Post> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Object not Found"));
	}
	
	public List<Post> findByTitle(String text){
		return repo.searchTitle(text);
	}
	
}
