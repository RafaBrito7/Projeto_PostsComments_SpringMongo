package com.rafabrito.workshopMongoSpring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rafabrito.workshopMongoSpring.domain.User;
import com.rafabrito.workshopMongoSpring.dto.UserDTO;
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
	
	public User insert(User obj) {
		return repo.insert(obj);
	}
	
	public void delete(String id) {
		findById(id);
		repo.deleteById(id);
	}
	
	public User update(User obj) {
		User newObj = findById(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}
	
	private void updateData(User newObj, User obj) {
		newObj.setName(obj.getName());
		newObj.setEmail(obj.getEmail());
	}

	// Foi implementado na classe Service, por conta de uma possível manipulação no Banco futuramente, a class Service é a unica que mantem uma dpendência com o banco
	public User fromDTO(UserDTO objDTO) { // Instanciando um User a partir do DTO
		return new User(objDTO.getId(), objDTO.getName(), objDTO.getEmail());
	}
}
