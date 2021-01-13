package com.luv2code.hibernate.demo;

import com.luv2code.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class QueryEmployeeDemo {

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

            //start a transaction
            session.beginTransaction();

            //query students
            List<Employee> theEmployee = session.createQuery("from Employee").list();

            //display the students
            displayEmployees(theEmployee);

//

//            //query students : lastName = "Doe"
            theEmployee = session.createQuery("from Employee s where s.lastName = 'Wall'").list();

//            //display the students
            System.out.println("\n\nEmployee who have last name of Doe");
            displayEmployees(theEmployee);

            //query students: lastName = "Doe" OR firstName = "Daffy"
            theEmployee = session.createQuery("from Employee s where s.lastName = 'Wall' OR s.firstName = 'Daffy'").list();

            System.out.println("\n\nEmployee who have last name of Wall OR first name Daffy");
            displayEmployees(theEmployee);

            // query Employee where email LIKE '%luv2code.com'
            theEmployee = session.createQuery("from Employee s where s.company LIKE 'Apple'").list();
            System.out.println("\n\nEmployee whose company ends with Apple");
            displayEmployees(theEmployee);

            //commit transaction
            session.getTransaction().commit();
            System.out.println("Done!");

        } finally{
            factory.close();
        }

    }

    private static void displayEmployees(List<Employee> theEmployee) {
        for (Employee tempEmployee: theEmployee){ //so iterate through theStudents and keep tempStudent class
            System.out.println(tempEmployee); //this prints out Student.toString() method defined in the Student class
        }
    }


}
