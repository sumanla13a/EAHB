package edu.mum.hw2.domain;

import java.util.*;

import javax.persistence.*;

@Entity
public class Movie {
	@Id
	@GeneratedValue
	private int id;
	
	@Column(name="`name`")
	private String name;
	@Column(name="`category`")
	private String category;
	@Column(name="`cover`")
	private byte[] cover;

	@Column(name="`rating`")
	private int rating;
	
	private List<String> comment;	
	private List<Actor> Actors;
	public Movie() {
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}


	public byte[] getCover() {
		return cover;
	}

	public void setCover(byte[] cover) {
		this.cover = cover;
	}

	/*public List<String> getComment() {
		return comment;
	}

	public void setComment(List<String> comment) {
		this.comment = comment;
	}

	public List<Actor> getActors() {
		return Actors;
	}

	public void setActors(List<Actor> actors) {
		Actors = actors;
	}*/

	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
}
