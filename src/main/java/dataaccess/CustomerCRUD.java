package dataaccess;

import com.sun.org.apache.xpath.internal.SourceTree;
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
            if (customers.isEmpty()){
                System.out.println("unique nationalCode***");
                isUnique = true;}

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
        System.out.println("**********");
            SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        try {
        Transaction tx = session.beginTransaction();
            session.save(customer);
            tx.commit();
        } finally {
            session.close();
        }
        System.out.println("-------->"+customer.getId());
    }


    }

//    public static void main(String[] args) {
//        SessionFactory factory = new Configuration().configure().buildSessionFactory();
//        Session session = factory.openSession();
//        String a="q";
//        try {
//            Transaction tx = session.beginTransaction();
//           Query query=session.createQuery("FROM Customer where nationalCode = :nationalCode");
//            query.setString("nationalCode", a);
//            List customers =query.list();
//            if(customers.isEmpty())
//                System.out.println("uniqu nationalCode***");
//            for (Iterator iterator = customers.iterator(); iterator.hasNext(); ) {
//                Customer customer = (Customer) iterator.next();
//                System.out.println("First Name: " + customer.getFirstName());
//                System.out.println("  Last Name: " + customer.getLastName());
//                System.out.println(" ---------------------- ");
//
//            }
//
//            tx.commit();
//        } finally {
//            session.close();
//        }
//
//    }

