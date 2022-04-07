package com.gfl1987.wsmongo.services;

import java.util.Date;
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
		return repo.searchTitle(text); //retorna a pesquisa por texto
	}
	
	public List<Post> fullSearch(String text, Date minDate, Date maxDate) { //metodo que retorna uma busca por data e texto
		maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000);
		return repo.fullSearch(text, minDate, maxDate);
	}
}