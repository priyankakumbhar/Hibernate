package com.hibernate.cruddemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Student;

public class ReadStudentDemo {

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
			
			//create student object
			System.out.println("Creating the student object");
			Student student=new Student("Omkar","Kumbhar","omkarkumbhar@gmail.com");
			
			//start transaction
			session.beginTransaction();
			
			//save object
			System.out.println("Saving Student object....");
			System.out.println(student);
			session.save(student);
			
		    //commit transaction
			session.getTransaction().commit();
			
			//Read Object from database
			//find out the primary key i.e Id;
			
			System.out.println("Primary Key:"+student.getId());
			
			//get session
			session=factory.getCurrentSession();
			
			//transaction
			session.beginTransaction();
			
			//get student using id
			Student theStudent=session.get(Student.class, student.getId());
			System.out.println("student by Id:"+theStudent);
			
			//close transaction
			session.getTransaction().commit();
		    
			System.out.println("Done");
		}
		finally
		{
			factory.close();
		}

	}

}
