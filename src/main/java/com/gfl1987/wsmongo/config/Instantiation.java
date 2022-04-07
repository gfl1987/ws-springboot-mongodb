package com.gfl1987.wsmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.gfl1987.wsmongo.domain.Post;
import com.gfl1987.wsmongo.domain.User;
import com.gfl1987.wsmongo.dto.AuthorDTO;
import com.gfl1987.wsmongo.repository.PostRepository;
import com.gfl1987.wsmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postReposiroty;
	
	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); //formatacao da data
		sdf.setTimeZone(TimeZone.getTimeZone("GMT")); //formatacao da hora

		userRepository.deleteAll();
		postReposiroty.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com"); //instanciacao dos usuarios
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		userRepository.saveAll(Arrays.asList(maria, alex, bob)); //salva os usuarios
		
		Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu viagem", "Vou viajar para São Paulo. Abraços!", new AuthorDTO(maria)); //instanciacao dos Posts
		Post post2 = new Post(null, sdf.parse("23/03/2018"), "Bom dia", "Acordei feliz hoje!", new AuthorDTO(maria));
		
		postReposiroty.saveAll(Arrays.asList(post1, post2)); //salva os posts
		
		maria.getPosts().addAll(Arrays.asList(post1, post2)); //inclui os posts na lista do usuario Maria
		userRepository.save(maria); //salva no usuario Maria
	}
}
