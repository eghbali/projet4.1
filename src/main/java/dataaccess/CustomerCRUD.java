package dataaccess;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Iterator;
import java.util.List;

public class CustomerCRUD {
    public static boolean checkNationalCodeIsValied(String nationalCode) {
        boolean isUnique = false;
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        try {
            Transaction tx = session.beginTransaction();
            Query query = session.createQuery("FROM Customer where nationalCode = :nationalCode");
            query.setString("nationalCode", nationalCode);
            List customers = query.list();
            if (customers.isEmpty()) {
                System.out.println("unique nationalCode***");
                isUnique = true;
            }

            for (Iterator iterator = customers.iterator(); iterator.hasNext(); ) {
                Customer customer = (Customer) iterator.next();
                System.out.println("First Name: " + customer.getFirstName());
                System.out.println("  Last Name: " + customer.getLastName());
                System.out.println(" ---------------------- ");
            }
            tx.commit();
        } finally {
            session.close();
        }
        return isUnique;
    }

    public static void addNewCustomerToDatabase(Customer customer) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        try {
            Transaction tx = session.beginTransaction();
            session.save(customer);
            tx.commit();
        } finally {
            session.close();
        }
    }

    public static Customer selectCustomer(String customerId) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Customer customer = null;
        try {
            Query query = session.createQuery("FROM Customer where id = :customerId");
            query.setLong("customerId", Long.parseLong(customerId));
            List customers = query.list();
            if (!customers.isEmpty()) {
                Iterator iterator = customers.iterator();
                customer = (Customer) iterator.next();
                System.out.println(customer.getFirstName());
            }
            return customer;
        } finally {
            session.close();
        }
    }
}