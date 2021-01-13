package com.luv2code.hibernate.demo;

import com.luv2code.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteEmployeeDemo {

    public static void main(String[] args){
        //create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();
        //create session
        Session session = factory.getCurrentSession();

        try{
            //use the session object to save java object


            int employeeId = 6;


            //now get a new session and start transaction
            session = factory.getCurrentSession();
            session.beginTransaction();

            //retrieve student based on id: primary key
            System.out.println("\nGetting employee with id: " + employeeId);
            Employee myEmployee = session.get(Employee.class, employeeId);

            //delete the student
            System.out.println("Deleting employee: "+ myEmployee);
            session.delete(myEmployee);

            //delete student id =7
            System.out.println("Deleting student id =7");

            session.createQuery("delete from Employee where id =7").executeUpdate();

            //commit the transaction - always use transaction for update and for reads
            session.getTransaction().commit();

            System.out.println("Done!");
//            session.createQuery("from Student").getResultList()

        } finally{
            factory.close();
        }

    }
}
