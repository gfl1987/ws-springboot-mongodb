package com.gfl1987.wsmongo.dto;

import java.io.Serializable;
import java.util.Date;

public class CommentDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String text; //inicio dos atributos
	private Date date;
	private AuthorDTO author; //fim dos atributos

	public CommentDTO() { //construtor vazio
	}

	public CommentDTO(String text, Date date, AuthorDTO author) { //construtor com argumentos
		super();
		this.text = text;
		this.date = date;
		this.author = author;
	}

	public String getText() { //inicio dos gets e sets
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public AuthorDTO getAuthor() {
		return author;
	}

	public void setAuthor(AuthorDTO author) { //fim dos gets e sets
		this.author = author;
	}
}