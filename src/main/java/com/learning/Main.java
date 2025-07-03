package com.learning;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class Main {
    public static void main(String[] args) {
        System.out.println("My first hibernate project");

        Student s1 = new Student();
        s1.setRollNo(108);
        s1.setsName("Hitesh");
        s1.setsAge(25);



        SessionFactory sf = new Configuration()
                .addAnnotatedClass(com.learning.Student.class)
                .configure()
                .buildSessionFactory();

        Session session = sf.openSession();

        Transaction transaction = session.beginTransaction();

        session.persist(s1);

        transaction.commit();

        session.close();
        sf.close();



        System.out.println(s1);


    }
}