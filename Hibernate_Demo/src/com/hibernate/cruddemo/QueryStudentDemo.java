package com.hibernate.cruddemo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory =new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		//create session
		Session session=factory.getCurrentSession();
		
		try
		{
			//use session object to save java Object
			
			
			//start transaction
			session.beginTransaction();
			//Query Student
			List<Student> theStudents=session.createQuery("from Student").list();
			
			//Display Result
			System.out.println("List of all students");
			displayStudents(theStudents);
			
			//Query FirstName="Priyanka"
			theStudents= session.createQuery("from Student s where s.firstName='Priyanka'").list();
			
			//display student 
			System.out.println("\nStudent with First name is priyanka");
			displayStudents(theStudents);
			
			//query firstname='omkar' or lastname='kumbhar'
			theStudents=session.createQuery("from Student s where" + " s.firstName='omkar' OR s.lastName='kumbhar'").list();
			System.out.println("\nstudents with firstname or lastname");
			displayStudents(theStudents);
			
			//query student like
			theStudents=session.createQuery("from Student s where" + " s.email like '%@gmail.com'").list();
			System.out.println("\nstudents with like");
			displayStudents(theStudents);
			
			//commit transaction
			session.getTransaction().commit();
			System.out.println("Done");
		}
		finally
		{
			factory.close();
		}

	}

	private static void displayStudents(List<Student> theStudents) {
		for(Student theStudent:theStudents)
		{
			System.out.println(theStudent);
		}
	}

}
