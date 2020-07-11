package com.rafabrito.workshopMongoSpring.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.rafabrito.workshopMongoSpring.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
	//O Próprio MongoRepository, já contei todos os métodos necessários para utilização, não precisamos criar nenhum...
	}
