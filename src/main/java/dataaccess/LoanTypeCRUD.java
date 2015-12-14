package dataaccess;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.HashSet;

/**
 * Created by DotinSchool2 on 12/14/2015.
 */
public class LoanTypeCRUD {
    public static boolean insertLoanTypeToDatabase(String loanName, int interestRate, String conditions) {
        boolean result=false;
        LoanType loanType = new LoanType(loanName, interestRate);
        HashSet conditionSet = new HashSet();
        String[] loanConditions = conditions.split("\\+");
        for (int i = 0; i < loanConditions.length; i++) {
            String[] condition = loanConditions[i].split("\\*");
            conditionSet.add(new LoanCondition(condition[0], Integer.parseInt(condition[1]), Integer.parseInt(condition[2]),
                    Integer.parseInt(condition[3]), Integer.parseInt(condition[4])));
        }
        loanType.setConditions(conditionSet);
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        try {
            Transaction tx = session.beginTransaction();
            session.save(loanType);
           result=true;
            tx.commit();
        } finally {
            session.close();
        }
        System.out.println("end");
        return result;
    }

}

