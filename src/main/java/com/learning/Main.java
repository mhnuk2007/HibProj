package com.learning;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("My first hibernate project");

        Student s1 = new Student(109, "Kajal", 25);
        addStudent(s1);
        System.out.println(s1);

        Student s2 = getStudent(109);
        System.out.println(s2);

        Student s3 = new Student(110, "Malathi", 23);
        updateStudent(s3);
        System.out.println("Updated successfully");

        Student s4 = getStudent(110);
        System.out.println(s4);

        List<Student> students = getAllStudents();
        students.forEach(System.out::println);


        deleteStudent(110);
        System.out.println("Deleted successfully");
    }

    //CRUD Operations
    //Create Read Update Delete
    public static SessionFactory sf = new Configuration()
            .addAnnotatedClass(com.learning.Student.class)
            .configure()
            .buildSessionFactory();

    // Add student
    public static void addStudent(Student student) {
        Session session = sf.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(student);
        transaction.commit();
        session.close();
    }

    // Get student
    public static Student getStudent(int rollNo) {
        Session session = sf.openSession();
        Transaction transaction = session.beginTransaction();
        Student student = session.get(Student.class, rollNo);
        transaction.commit();
        session.close();
        return student;
    }

    // Update Student
    public static void updateStudent(Student student) {
        Session session = sf.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(student);
        transaction.commit();
        session.close();
    }

    // Delete Student
    public static void deleteStudent(int rollNo) {
        Session session = sf.openSession();
        Transaction transaction = session.beginTransaction();
        Student student = session.get(Student.class, rollNo);
        session.delete(student);
        transaction.commit();
    }

    // Get all students
    public static List<Student> getAllStudents() {
        Session session = sf.openSession();
        Transaction transaction = session.beginTransaction();
        List<Student> students = session.createQuery("from Student").list();
        transaction.commit();
        session.close();
        return students;
    }
}
