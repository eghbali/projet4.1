package dataaccess;

import dataaccess.entity.LoanProfile;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class LoanProfileCRUD {
    public static void InsertLoanProfileToDatabase(LoanProfile loanProfile) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        try {
            Transaction tx = session.beginTransaction();
            session.save(loanProfile);
            tx.commit();
        } finally {
            session.close();
        }

    }
}
