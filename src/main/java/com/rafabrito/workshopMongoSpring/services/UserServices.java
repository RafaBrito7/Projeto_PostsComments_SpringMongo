package com.rafabrito.workshopMongoSpring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rafabrito.workshopMongoSpring.domain.User;
import com.rafabrito.workshopMongoSpring.repository.UserRepository;
import com.rafabrito.workshopMongoSpring.services.exception.ObjectNotFoundException;

@Service
public class UserServices{

	@Autowired // Mecanismo de injenção de dependência automática do Spring... 
	private UserRepository repo; // Chamando a nossa Interface como um Objeto, para utilização dos seus métodos
	
	public List<User> findAll(){
		return repo.findAll();
	}
	
	public User findById(String id) {
		Optional<User> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Object not Found"));
	}
}
