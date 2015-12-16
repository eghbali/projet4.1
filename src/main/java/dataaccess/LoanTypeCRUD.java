package dataaccess;

import dataaccess.entity.LoanCondition;
import dataaccess.entity.LoanType;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.HashSet;
import java.util.List;

/**
 * Created by DotinSchool2 on 12/14/2015.
 */
public class LoanTypeCRUD {
    public static boolean insertLoanTypeToDatabase(String loanName, int interestRate, String conditions) {
        boolean result = false;
        LoanType loanType = new LoanType(loanName, interestRate);
        HashSet<LoanCondition> conditionSet = new HashSet<LoanCondition>();
        String[] loanConditions = conditions.split("\\+");
        for (String loanCondition : loanConditions) {
            String[] condition = loanCondition.split("\\*");
            conditionSet.add(new LoanCondition(condition[0], Integer.parseInt(condition[1]), Integer.parseInt(condition[2]),
                    Integer.parseInt(condition[3]), Integer.parseInt(condition[4])));
        }
        loanType.setConditions(conditionSet);
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        try {
            Transaction tx = session.beginTransaction();
            session.save(loanType);
            tx.commit();
            result = true;
        } finally {
            session.close();
        }
        System.out.println("end");
        return result;
    }

    public static List<LoanType> loadAllLoanTypes() {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        try {
            Query query = session.createQuery("FROM LoanType ");
            return query.list();
        } finally {
            session.close();
        }
    }

    public static LoanType loadLoanTypeById(int loanId) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        try {
            Query query = session.createQuery("FROM LoanType where id= :loanId");
            query.setInteger("loanId", loanId);
            return (LoanType) query.uniqueResult();
        } finally {
            session.close();
        }
    }
}

