package com.sample.CollectionMap;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.HashSet;
import java.util.Set;

public class App {

    protected void add(Story story, Session session) {
        session.save(story);
    }

    protected void add(Writer writer, Session session) {
        session.save(writer);
    }

    public static void main(String[] args) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        try {
            // Create a new Writer
            Writer writer = new Writer("Rupesh Sanap");

            // Create Stories
            Set<Story> stories = new HashSet<>(); // Use generics for type safety
            Story story1 = new Story("The Village");
            Story story2 = new Story("The Politics");

            // Associate stories with the writer
            story1.setWriter(writer);
            story2.setWriter(writer);

            // Add stories to the writer
            stories.add(story1);
            stories.add(story2);
            writer.setStories(stories);

            // Save the writer (this will also save the stories due to cascade)
            new App().add(writer, session);
//            new App().add(story1, session);
//            new App().add(story2, session);

            // Commit the transaction
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
