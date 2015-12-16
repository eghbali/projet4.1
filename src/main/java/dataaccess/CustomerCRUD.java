package dataaccess;

import dataaccess.entity.Customer;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class CustomerCRUD {
    public static boolean checkNationalCodeIsValied(String nationalCode) {
        boolean isUnique = false;
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        try {
            Query query = session.createQuery("FROM Customer where nationalCode = :nationalCode");
            query.setString("nationalCode", nationalCode);
            Customer customer = (Customer) query.uniqueResult();
            if (customer == null) {
                isUnique = true;
            }
        } finally {
            session.close();
        }
        return isUnique;
    }

    public static void insertNewCustomerToDatabase(Customer customer) {
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

    public static Customer loadCustomerByCustomerId(String customerId) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        try {
            Query query = session.createQuery("FROM Customer where id = :customerId");
            query.setLong("customerId", Long.parseLong(customerId));
            return (Customer) query.uniqueResult();
        } finally {
            session.close();
        }
    }
}