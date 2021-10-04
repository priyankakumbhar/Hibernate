package com.hibernate.cruddemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Student;

public class DeleteStudentDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//create session factory
				SessionFactory factory =new Configuration()
										.configure("hibernate.cfg.xml")
										.addAnnotatedClass(Student.class)
										.buildSessionFactory();
				
				
				try{
					//create session
					Session session=factory.getCurrentSession();
					
				/*	//begin transaction
					session.beginTransaction();
					
					//execute query to delete record
					session.createQuery("Delete Student where id=2").executeUpdate();
					System.out.println("Student id 2 deleted successfully..");
					
					//close transaction
					session.getTransaction().commit();*/
					
					int studentId=1;
					System.out.println("Student Id: "+studentId);
					//begin Transaction
					session.beginTransaction();
					//get student by id
					Student student = session.get(Student.class, studentId);
					//delete student
					session.delete(student);
					System.out.println("Student Deleted Successfully...");
					//commit transaction
					session.getTransaction().commit();
				}
				finally
				{
					factory.close();
				}
	}

}
