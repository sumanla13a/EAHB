package edu.mum.hw2.domain;
import java.util.*;

import javax.persistence.*;
@Entity
public class Volunteer extends User {
	
	@OneToMany
	private List<Task> lTasks;

	public List<Task> getlTasks() {
		return lTasks;
	}

	public void setlTasks(List<Task> lTasks) {
		this.lTasks = lTasks;
	}
	
	public void addTask(Task t) {
		lTasks.add(t);
	}
}
