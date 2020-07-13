package com.rafabrito.workshopMongoSpring.repository;

import java.util.Date;
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
	
	//Consulta com Vários Critérios e Completa em qualquer lugar do Post
	//Consultar documentação https://docs.mongodb.com/manual/reference/operator/query
	// Nesse caso procuraremos um texto com datas minimas e máximas
	// Operador de Maior que = gte ... O de Menor que = lte ... o ? é pra referenciar o parâmetro
	// Pesquisando no titulo do Post, Pesquisando no comentário do Post,Pesquisando no corpo do Post, o Comments é uma lista, por isso temos que acessar o text
	@Query("{ $and: [ { date: {$gte: ?1} }, { date: { $lte: ?2} } , { $or: [ { 'title': { $regex: ?0, $options: 'i' } }, { 'body': { $regex: ?0, $options: 'i' } }, { 'comments.text': { $regex: ?0, $options: 'i' } } ] } ] }")
	List<Post> fullSearch(String text, Date minDate, Date maxDate);
	}
