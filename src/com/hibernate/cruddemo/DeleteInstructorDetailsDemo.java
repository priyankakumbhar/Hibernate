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

public class DeleteInstructorDetailsDemo {

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
			
			//get instructor details object
			int theId=3;
			InstructorDetails instructorDetails=session.get(InstructorDetails.class, theId);
			
			//print instructor details object
			System.out.println("Instructor details: "+instructorDetails);
			
			//print the associated instructor
			System.out.println("Associated Instructor is: "+instructorDetails.getInstructor());
			
			//break the link between instructor-details objects
			instructorDetails.getInstructor().setInstructorDetails(null);
			
			//delete instructor details object
			session.delete(instructorDetails);
		    
			//commit transaction
			session.getTransaction().commit();
			System.out.println("Done");
		}
		catch(Exception e)
		{
			e.getStackTrace();
		}
		finally
		{
			session.close();
			factory.close();
		}

	}

}
