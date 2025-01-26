package com.sample.CollectionMap;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

public class App {

	public static void main(String[] args) {
		Session session = HibernateUtils.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();

		try {
			/*
			 * Employee e1 =new Employee(); e1.setName("Rupesh"); e1.setDept("Software");
			 * 
			 * session.save(e1);
			 */

			/*
			 * Customer c1 = new Customer(); c1.setName("Aditya"); c1.setAcctype("Saving");
			 * 
			 * session.save(c1);
			 * 
			 * // Commit the transaction tx.commit();
			 */

			System.out.println("............HQL Query Example........... ");
			Query myQuery = session.createQuery("from Person");
			List<Person> list = myQuery.list();
			for (Person p : list)
				System.out.println(p.getId() + " " + p.getName());
			System.out.println("\n");

			System.out.println("............HQL Query with paramExample........... ");
			Query myQuery1 = session.createQuery("from Person as per where per.name = :name");
			myQuery1.setString("name", "Rupesh");
			List<Person> listx = myQuery1.list();
			for (Person p1 : listx)
				System.out.println(p1.getId() + " " + p1.getName());
			System.out.println("\n");
			
			System.out.println("............Criteria Api Example........... ");
			Criteria crit = session.createCriteria(Person.class);
			List<Person> Personlist = crit.list();
			for (Person p : Personlist)
				System.out.println(p.getId() + " " + p.getName());
			System.out.println("\n");
			
			System.out.println("............Criteria Api with restriction Example........... ");
			Criteria crit1 = session.createCriteria(Person.class);
			crit1.add(Restrictions.like("name", "A%"));
			List<Person> Personlist1 = crit1.list();
			for (Person p : Personlist1)
				System.out.println(p.getId() + " " + p.getName());
			System.out.println("\n");
			
			System.out.println("............Native SQL Query Example........... ");
			String sql ="select * from person;";
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity("person",Person.class);
			List<Person> personlist2 = query.list();
			for (Person p : personlist2)
				System.out.println(p.getId() + " " + p.getName());
			System.out.println("\n");
			
			System.out.println("............HQL Nested Query Example........... ");
			String sql_query ="select name from Person p where p.id in (select id from Person p)";
			Query query1 = session.createQuery(sql_query);
			for (Iterator it = query1.iterate(); it.hasNext();) {
				Object row = (Object)it.next();
				System.out.println(row);
			}
			System.out.println("\n");
			
			System.out.println("............HQL Query pegination Example........... ");
			Query query2 = session.createQuery("from Person");
			query2.setFirstResult(0);
			query2.setMaxResults(1);
			
			List<Person> personList3 = query2.list();
			for(Person p : personList3)
				System.out.println(p.getId() + " " + p.getName());
			
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
