package com.gfl1987.wsmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gfl1987.wsmongo.domain.User;
import com.gfl1987.wsmongo.repository.UserRepository;
import com.gfl1987.wsmongo.services.exception.ObjectNotFoundException;

@Service //anotação para tomar o serviço ingetável a outras classes
public class UserService { //classe de serviços responsaveis por tratar os usuarios

	@Autowired //anotação que instancia o objeto de maneira automatica
	private UserRepository repo; 
	
	public List<User> findAll() { //metodo responsavel por retornar todos os usuarios do banco
		return repo.findAll();
		
	}
	
	public User findById(String id) {
		Optional<User> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
}
