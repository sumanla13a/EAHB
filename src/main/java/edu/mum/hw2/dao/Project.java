package edu.mum.hw2.dao;
import java.util.*;

import javax.persistence.*;

import edu.mum.hw2.domain.Task;
import edu.mum.hw2.domain.User;
public class Project {
	public List<Project> getProjects(User u) {
		Session session = new Session();
		EntityManager em = session.getEM();
		if(u.hasRole("listProject"))
			return em.createQuery("from Project").getResultList();
		return null;
	}
	public List<Project> getProjectsByStatus(User u, String s) {
		Session session = new Session();
		EntityManager em = session.getEM();
		if(u.hasRole("listProject"))
			return em.createQuery("from Project p where p.status = " + s).getResultList();
		return null;
	}
	public List<Project> getProjectsBySkill(User u, String s) {
		Session session = new Session();
		EntityManager em = session.getEM();
		if(u.hasRole("listProject"))
			return em.createQuery("Select distinct(p) from Project p join p.lTask lT where lT.skill = " + s).getResultList();
		return null;
	}
	
	public List<Task> getTasks(User u, Project p) {
		Session session = new Session();
		EntityManager em = session.getEM();
		if(u.hasRole("listProject"))
			return em.createQuery("select t from Project p join p.lTask t").getResultList();
		return null;
	}
}
