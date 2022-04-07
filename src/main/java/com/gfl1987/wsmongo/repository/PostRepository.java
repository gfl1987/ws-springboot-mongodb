package com.gfl1987.wsmongo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.gfl1987.wsmongo.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
	
	@Query("{ 'title': { $regex: ?0, $options: 'i' } }") //anotação que permite entrar com a consulta no MongoDB na forma de Json
	List<Post> searchTitle(String text);
	
	List<Post> findByTitleContainingIgnoreCase(String text); //metodo de busca que retorna uma lista de posts

}