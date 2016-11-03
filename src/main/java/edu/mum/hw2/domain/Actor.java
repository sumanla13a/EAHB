package edu.mum.hw2.domain;

import java.io.Serializable;

import javax.persistence.*;
@Entity
//@Embeddable
public class Actor {

	private int id;
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	private String character;
	
	private int rating;
	
	@Override
	public String toString() {
		return "Actor [id=" + id + ", character=" + character + ", rating=" + rating + ", name=" + name + "]";
	}
	private String name;
	
	public Actor() {
		
	}
	@Column(name="`character`")
	public String getCharacter() {
		return character;
	}
	public void setCharacter(String character) {
		this.character = character;
	}
	@Column(name="`rating`")
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	@Column(name="`name`")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
