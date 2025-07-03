package com.learning;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        System.out.println("My first hibernate project");

        SessionFactory sf = new Configuration()
                .addAnnotatedClass(com.learning.Student.class)
                .configure()
                .buildSessionFactory();

        Session session = sf.openSession();

        Transaction transaction = session.beginTransaction();

        Student s = session.get(Student.class, 102); // load from DB
        if (s != null) {
            session.remove(s);  // delete from DB
            System.out.println("Deleted: " + s);
        } else {
            System.out.println("Student not found.");
        }

        transaction.commit();
        session.close();
        sf.close();
    }
}
