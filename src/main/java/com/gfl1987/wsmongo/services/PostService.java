package com.gfl1987.wsmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gfl1987.wsmongo.domain.Post;
import com.gfl1987.wsmongo.repository.PostRepository;
import com.gfl1987.wsmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository repo;

	public Post findById(String id) { //metodo que retorna usuario por ID
		Optional<Post> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public List<Post> findByTitle(String text) { //metodo que retorna uma busca por titulo
		return repo.findByTitleContainingIgnoreCase(text);
	}
}