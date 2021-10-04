package com.hibernate.cruddemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Student;

public class UpdateStudentDemo {

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
			int studentId=1;
		    System.out.println("studentId:"+studentId);
			
			//get session
			session=factory.getCurrentSession();
			
			//transaction
			session.beginTransaction();
			
			//get student using id
			Student theStudent=session.get(Student.class, studentId);
			System.out.println("student by Id:"+theStudent);
			
			//update student
			theStudent.setFirstName("Shubhangi");
			
			//close transaction
			session.getTransaction().commit();
			
			//update email of all student
			
			//get session
			session=factory.getCurrentSession();
			
			//begin transaction
			session.beginTransaction();
			
			System.out.println("update gmail of all records");
			session.createQuery("update Student set email='foo@gmail.com'").executeUpdate();
			
			//commit transaction
			session.getTransaction().commit();
			
		    
			System.out.println("Done");
		}
		finally
		{
			factory.close();
		}

	}

}
