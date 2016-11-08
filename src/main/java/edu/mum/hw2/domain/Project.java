package edu.mum.hw2.domain;
import java.util.*;

import javax.persistence.*;
@Entity
public class Project {
	@Id
	@GeneratedValue
	private int id;
	@Temporal(TemporalType.DATE)
	private Date endDate;
	@Temporal(TemporalType.DATE)
	private Date startDate;
	private String description;
	private String status;
	public String getStatus(User u) {
		if(u.hasRole("listProject"))
			return status;
		return null;
	}
	public void setStatus(String status, User u) {
		if(u.hasRole("createProject"))
			this.status = status;
	}
	@OneToMany(mappedBy="project")
	private List<Task> lTask;
	private Project() {
		
	}
	public Project getInstance(User u) {
		if(u.hasRole("createProject"))
			return new Project();
		else return null;
	}
	public Date getEndDate(User u) {
		if(u.hasRole("listProject"))
			return endDate;
		return null;
	}
	public void setEndDate(Date endDate, User u) {
		if(u.hasRole("createProject"))
			this.endDate = endDate;
	}
	public Date getStartDate(User u) {
		if(u.hasRole("listProject"))
			return startDate;
		return null;
	}
	public void setStartDate(Date startDate, User u) {
		if(u.hasRole("createProject"))
			this.startDate = startDate;
	}
	public String getDescription(User u) {
		if(u.hasRole("listProject"))
			return description;
		return null;
	}
	public void setDescription(String description, User u) {
		if(u.hasRole("createProject"))
			this.description = description;
	}
	public List<Task> getlTask(User u) {
		if(u.hasRole("listTask"))
			return lTask;
		return null;
	}
	public void setlTask(List<Task> lTask, User u) {
		if(u.hasRole("createProject"))
			this.lTask = lTask;
	}
}