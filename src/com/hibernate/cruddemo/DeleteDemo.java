package com.hibernate.cruddemo;
import com.utils.DateUtils;

import java.sql.SQLSyntaxErrorException;
import java.text.ParseException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Instructor;
import com.hibernate.demo.entity.InstructorDetails;
import com.hibernate.demo.entity.Student;

public class DeleteDemo {

	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory =new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetails.class)
								.buildSessionFactory();
		//create session
		Session session=factory.getCurrentSession();
		
		try
		{
			
			        
			//start transaction
			session.beginTransaction();
			
			//get Instructor by primary key
			int instructorId=1;
			Instructor instructor=session.get(Instructor.class,instructorId);
			
			//return null if object not found
			//delete Instructor
			//Note: will delete "Details" object associated because of CascadeType.All
			System.out.println("Instructor found: "+instructor);
			if(instructor != null)
			{
			System.out.println(" Deleting Instructor found: "+instructor);
			session.delete(instructor);
			}
			
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
