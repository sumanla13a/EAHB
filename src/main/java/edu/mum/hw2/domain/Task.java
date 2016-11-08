package edu.mum.hw2.domain;

import javax.persistence.*;

@Entity
public class Task {
	@Id
	@GeneratedValue
	private int id;
	private String status;
	private String resources;
	@Column(name="`skill`")
	private String skill;
	@ManyToOne
	@JoinColumn(name="project_id")
	private Project project;
	public Task() {
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Project getProject() {
		return project;
	}
	public void setProject(Project project) {
		this.project = project;
	}
	public String getResources() {
		return resources;
	}

	public void setResources(String resources) {
		this.resources = resources;
	}

	@Override
	public String toString() {
		return "Task [id=" + id + ", status=" + status + ", resources=" + resources + ", skill=" + skill + ", project="
				+ project + "]";
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
		this.skill = skill;
	}
}
