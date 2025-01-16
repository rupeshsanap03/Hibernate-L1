package com.sample.CollectionMap;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class App {

	public static void main(String[] args) {
		Session session = HibernateUtils.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();

		try {
			Address a1 = new Address();
			a1.setStreet("King Cross");
			a1.setCity("London");
			
			Faculty f1 = new Faculty();
			f1.setName("Rupesh");
			f1.setAddress(a1);
			a1.setFaculty(f1);
			
			session.save(a1);

			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback(); // Rollback in case of an error
			}
			e.printStackTrace();
		} finally {
			session.close(); // Ensure the session is closed
		}
	}
}
