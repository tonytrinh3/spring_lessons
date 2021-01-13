package com.luv2code.hibernate.demo;

import com.luv2code.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteStudentDemo {

    public static void main(String[] args){
        //create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
        //create session
        Session session = factory.getCurrentSession();

        try{
            //use the session object to save java object


            int studentId = 2;


            //now get a new session and start transaction
            session = factory.getCurrentSession();
            session.beginTransaction();

            //retrieve student based on id: primary key
            System.out.println("\nGetting student with id: " + studentId);
            Student myStudent = session.get(Student.class, studentId);

            //delete the student
//            System.out.println("Deleting student: "+ myStudent);
//            session.delete(myStudent);

            //delete student id =2
            System.out.println("Deleting student id =2");

            session.createQuery("delete from Student where id =2").executeUpdate();

            //commit the transaction - always use transaction for update and for reads
            session.getTransaction().commit();

            System.out.println("Done!");
//            session.createQuery("from Student").getResultList()

        } finally{
            factory.close();
        }

    }
}
