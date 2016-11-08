/*package edu.mum.hw2.domain;

import java.util.*;

import javax.persistence.*;

//@Entity
public class Movie {
	private int id;
	private String name;
	private Category category;
	private byte[] cover;

	private int rating;
	
//	private List<String> comment;	
	private List<Actor> Actors;
	public Movie() {
		
	}
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	@Column(name="`name`")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Column(name="`category`")
	@Enumerated(EnumType.STRING)
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}

	@Column(name="`cover`", length=100000)
	public byte[] getCover() {
		return cover;
	}

	public void setCover(byte[] cover) {
		this.cover = cover;
	}
	
	@Override
	public String toString() {
		return "Movie [id=" + id + ", name=" + name + ", category=" + category + ", cover=" + cover
				+ ", rating=" + rating + ", Actors=" + Actors + "]";
	}
	@ElementCollection
	@CollectionTable(name="comments", joinColumns=@JoinColumn(name="movie_id"))
	@Column(name="comment")
	public List<String> getComment() {
		return comment;
	}

	public void setComment(List<String> comment) {
		this.comment = comment;
	}
	
	@ElementCollection
	@CollectionTable(name="Actors", joinColumns=@JoinColumn(name="movie_id"))
	@OneToMany(cascade=CascadeType.ALL)
	@Column(name="actor")
	public List<Actor> getActors() {
		return Actors;
	}

	public void setActors(List<Actor> actors) {
		Actors = actors;
	}
	@Column(name="`rating`")
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
}
*/