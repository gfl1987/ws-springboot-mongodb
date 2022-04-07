package com.gfl1987.wsmongo.dto;

import java.io.Serializable;

import com.gfl1987.wsmongo.domain.User;

public class AuthorDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String id; //objeto ID
	private String name; //objeto name
 
	public AuthorDTO() { //construtor vazio
	}

	public AuthorDTO(User obj) { //constrturor com argumento
		id = obj.getId();
		name = obj.getName();
	}

	public String getId() { //inicio dos gets e sets
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) { //fim dos gets e sets
		this.name = name;
	}
}