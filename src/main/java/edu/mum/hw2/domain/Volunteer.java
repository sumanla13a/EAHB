package edu.mum.hw2.domain;
import java.util.*;
public class Volunteer extends User {
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
