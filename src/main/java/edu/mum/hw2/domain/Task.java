package edu.mum.hw2.domain;

import javax.persistence.*;

@Entity
public class Task {
	private String status;
	private String resources;
	private String skill;
	@ManyToOne
	@JoinColumn(name="project_id")
	private Project project;
	private Task() {
		
	}
	public String getResources() {
		return resources;
	}

	public void setResources(String resources) {
		this.resources = resources;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getSkill() {
		return skill;
	}

	public void setSkill(String skill) {
		this.status = skill;
	}
	
	public Task getInstance(User u) {
		if(u.hasRole("createTask"))
			return new Task();
		else return null;
	}
}
