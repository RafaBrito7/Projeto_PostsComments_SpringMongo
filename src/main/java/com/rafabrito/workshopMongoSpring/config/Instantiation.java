package com.rafabrito.workshopMongoSpring.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.rafabrito.workshopMongoSpring.domain.User;
import com.rafabrito.workshopMongoSpring.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner{

	@Autowired
	private UserRepository userRepository; // Para manipularmos o BD
	
	@Override
	public void run(String... args) throws Exception {
		
		userRepository.deleteAll(); // Para apagar todos os dados do BD ao inicializar
		
		User u1 = new User(null, "Maria Brown", "maria@gmail.com");
		User u2 = new User(null, "Alex Green", "alex@gmail.com");
		User u3 = new User(null, "Bob Grey", "bob@gmail.com");
		
		userRepository.saveAll(Arrays.asList(u1,u2,u3));
		
	}

}
