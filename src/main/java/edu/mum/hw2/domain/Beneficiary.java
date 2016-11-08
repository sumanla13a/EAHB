package edu.mum.hw2.domain;

import javax.persistence.*;
@Entity
public class Beneficiary {
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private byte[] pic;
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
	public byte[] getPic() {
		return pic;
	}
	public void setPic(byte[] pic) {
		this.pic = pic;
	}
	
}
