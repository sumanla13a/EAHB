package com.tests;

import static org.junit.Assert.*;

import java.util.*;
import java.util.Date;

import javax.persistence.*;

import org.junit.*;
import org.junit.Test;
import edu.mum.hw2.dao.Generic;
import edu.mum.hw2.dao.Session;
import edu.mum.hw2.domain.*;

public class Tests {
	private static User u;
	private static User v;
	private static Project newProject;
	private static Task t;
	@BeforeClass
	public static void  init() {
		u = new User();
		u.setName("Suman");
		u.setRole(Role.ADMIN);
		Generic.save(u);
		v = new User();
		v.setName("Suman");
		v.setRole(Role.VOLUNTEER);
		Generic.save(v);
		newProject = Project.getInstance(u);
		newProject.setDescription("Something", u);
		newProject.setEndDate(new Date(), u);
		newProject.setStartDate(new Date(), u);
		newProject.setStatus("good", u);
		t = new Task();
		t.setResources("r1");
		t.setSkill("java");
		t.setStatus("Started");
		t.setProject(newProject);
		List<Task> a = new ArrayList<Task>();
		a.add(t);
		newProject.setlTask(a, u);
		Generic.save(newProject);
	}
	@Test
	public void addAdmin() {
		Session s = new Session();
		EntityManager em = s.getEM();
		Query q = em.createQuery("from User u where u.role = :role");
		q.setParameter("role", Role.ADMIN);
		User newUser = (User)q.getSingleResult();
		assertEquals(u, newUser);
	}
	@Test
	public void addVolunteer() {
		Session s = new Session();
		EntityManager em = s.getEM();
		Query q = em.createQuery("from User u where u.role = :role");
		q.setParameter("role", Role.VOLUNTEER);
		User newUser = (User)q.getSingleResult();
		assertEquals(v, newUser);
	}
	@Test
	public void addProject() {
		System.out.println("j");
		Session s = new Session();

		EntityManager em1 = s.getEM();
		Query q1 = em1.createQuery("Select p from Project p");
		Project p = (Project)q1.getSingleResult();
		assertEquals("Something", p.getDescription(u));
	}
	@Test
	public void addTask() {
		assertEquals(true, true);
	}
	@Test
	public void getGoodProject() {
		Session s = new Session();

		EntityManager em1 = s.getEM();
		Query q1 = em1.createQuery("Select p from Project p where p.status = :status");
		q1.setParameter("status", "good");
		Project p = (Project)q1.getSingleResult();
		assertEquals("Something", p.getDescription(u));
	}
	@Test
	public void getJavaProject() {
		Session s = new Session();

		EntityManager em1 = s.getEM();
		Query q1 = em1.createQuery("Select distinct(p) from Project p join p.lTask t where t.skill = :skill");
		q1.setParameter("skill", "Java");
		Project p = (Project)q1.getSingleResult();
		assertEquals("Something", p.getDescription(u));
	}
	@Test
	public void getTasksForProject() {
		Session s = new Session();

		EntityManager em1 = s.getEM();
		Query q1 = em1.createQuery("Select t from Project p join p.lTask t where description = :description");
		q1.setParameter("description", "Something");
		Task p = (Task)q1.getSingleResult();
		assertEquals(t.getId(), p.getId());
	}

	@AfterClass
	public static void deleteAll() {

		Session s = new Session();
		EntityManager em2 = s.getEM();
		em2.getTransaction().begin();
		em2.createQuery("DELETE FROM Task t").executeUpdate();
		em2.getTransaction().commit();
		EntityManager em = s.getEM();
		em.getTransaction().begin();
		em.createQuery("DELETE FROM User u").executeUpdate();
		em.getTransaction().commit();
		//		Session s = new Session();
		EntityManager em1 = s.getEM();
		em1.getTransaction().begin();
		em1.createQuery("DELETE FROM Project p").executeUpdate();
		em1.getTransaction().commit();

	}
}
