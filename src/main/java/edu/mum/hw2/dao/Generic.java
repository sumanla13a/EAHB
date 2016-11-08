package edu.mum.hw2.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import edu.mum.hw2.domain.Volunteer;

public class Generic {
	public static void  save (Object obj) {
		System.out.println(obj.toString());
		Session session = new Session();
		EntityManager em = session.getEM();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			System.out.println(obj);
			em.persist(obj);
			tx.commit();
		} catch (Throwable e) {
			if ((tx != null) && (tx.isActive())) tx.rollback();
		} finally {
			if ((em != null) && (em.isOpen())) em.close();
		}
	}
}
