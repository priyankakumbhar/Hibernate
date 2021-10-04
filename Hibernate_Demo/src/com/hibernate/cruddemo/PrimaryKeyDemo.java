package com.hibernate.cruddemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

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
			//use session object to save 3 java Object
			
			//create student object
			System.out.println("Creating the 3 student object");
			Student student=new Student("Priyanka","Kumbhar","priyankakumbhat@gmail.com");
			Student student1=new Student("Pratibha","Kumbhar","pratibhakumbhat@gmail.com");
			Student student2=new Student("Nisha","Kumbhar","nishakumbhat@gmail.com");
			
			
			//start transaction
			session.beginTransaction();
			
			//save object
			System.out.println("Saving 3 Student object....");
			session.save(student);
			session.save(student1);
			session.save(student2);
			
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
