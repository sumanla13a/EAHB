package edu.mum.hw2.domain;

import javax.persistence.*;
@Entity
public class Actor {
	@Column(name="`character`")
	private String character;
	@Column(name="`rating`")
	private int rating;
	@Column(name="`name`")
	private String name;
	
	public Actor() {
		
	}
	
	public String getCharacter() {
		return character;
	}
	public void setCharacter(String character) {
		this.character = character;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
