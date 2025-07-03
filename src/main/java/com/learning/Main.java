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

        Student s2 = null;



        SessionFactory sf = new Configuration()
                .addAnnotatedClass(com.learning.Student.class)
                .configure()
                .buildSessionFactory();

        Session session = sf.openSession();

        s2 = session.get(Student.class,109);

        session.close();
        sf.close();
        if (s2 != null) {
            System.out.println(s2);
        } else {
            System.out.println("Student not found.");
        }

    }
}