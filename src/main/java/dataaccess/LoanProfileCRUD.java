package dataaccess;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Created by DotinSchool2 on 12/15/2015.
 */
public class LoanProfileCRUD {
    public static void InsertLoanProfileToDatabase(long customerId, int loanId, int amount, int duration) {
        LoanProfile loanProfile = new LoanProfile(customerId, loanId, duration, amount);
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
