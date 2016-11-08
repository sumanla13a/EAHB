package edu.mum.hw2.dao;
import java.util.*;

import javax.persistence.*;

import edu.mum.hw2.domain.*;
public class Task {
		
		public List<Task> getTasksPerProject(User u, Project p) {
			Session session = new Session();
			EntityManager em = session.getEM();
			if(u.hasRole("listProject"))
				return em.createQuery("select t from Project p join p.lTask t").getResultList();
			return null;
		}
		
		public List<Task> getTasksForVolunteer(User u) {
			Session session = new Session();
			EntityManager em = session.getEM();
			if(u.hasRole("listTask")) {
				Query q = em.createQuery("from User u join u.lTasks t where Type(u) = :Volunteer orderBy t.project.endDate");
				q.setParameter("Volunteer", "Volunteer");
				return q.getResultList();
			}
				
			return null;
		}
		
		public void offerService (Volunteer v, edu.mum.hw2.domain.Task t) {
			if(v.hasRole("listTask")) {
				v.addTask(t);
				Generic.save(v);
			}
		}
		
		
}
