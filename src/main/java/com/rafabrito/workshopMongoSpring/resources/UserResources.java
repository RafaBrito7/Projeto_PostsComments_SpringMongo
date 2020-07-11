package com.rafabrito.workshopMongoSpring.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.rafabrito.workshopMongoSpring.domain.User;
import com.rafabrito.workshopMongoSpring.dto.UserDTO;
import com.rafabrito.workshopMongoSpring.services.UserServices;

@RestController // Anunciando que a classe vai ser um recurso Rest
@RequestMapping(value = "/users") // Caminho do endPoint
public class UserResources {

	@Autowired
	private UserServices service;
	
	// Pra chamar no endPoint o Get dessa Lista
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<UserDTO>> findAll(){ // O response é para manipulação de respostas http, teremos o controle de código de status e etc
		List<User> list = service.findAll();
		List<UserDTO> listDTO = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList()); // Convertendo cada obj da Lista para um DTO
		return ResponseEntity.ok().body(listDTO);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<UserDTO> findById(@PathVariable String id){ // O Path sinalizará que o ID do argumento vai casar com o id da URL
		User obj = service.findById(id);
		return ResponseEntity.ok().body(new UserDTO(obj));
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody UserDTO objDTO){ // O Request é para q o endpoint aceite o objDTO
		User obj = service.fromDTO(objDTO);
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri(); // vai capturar o endereço do novo objeto que inseriu através do ID dele
		return ResponseEntity.created(uri).build(); // o Created retornará o código 201 http para confirmação de execução
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable String id){ // O Request é para q o endpoint aceite o objDTO
		service.delete(id);
		return ResponseEntity.noContent().build(); // o NoContent retornará o código 204 para confirmar que foi deletado daquela requisição (do id)
	}
}
