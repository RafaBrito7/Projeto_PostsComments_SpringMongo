package com.rafabrito.workshopMongoSpring.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.rafabrito.workshopMongoSpring.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
	//O Próprio MongoRepository, já contei todos os métodos necessários para utilização, não precisamos criar nenhum...
	
	// Estrutura utilizada: { <field>: { $regex: /pattern/, $options: '<options>' } }
	@Query("{ 'title': { $regex: ?0, $options: 'i' } }")
	List<Post> searchTitle(String text);
	
	// Para implementar consultas com Querry Methods do próprio Spring
	List<Post> findByTitleContainingIgnoreCase (String text);
	}
