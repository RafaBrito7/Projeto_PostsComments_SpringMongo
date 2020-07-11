package com.rafabrito.workshopMongoSpring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rafabrito.workshopMongoSpring.domain.User;
import com.rafabrito.workshopMongoSpring.repository.UserRepository;

@Service
public class UserServices{

	@Autowired // Mecanismo de injenção de dependência automática do Spring... 
	private UserRepository repo; // Chamando a nossa Interface como um Objeto, para utilização dos seus métodos
	
	public List<User> findAll(){
		return repo.findAll();
	}
}
