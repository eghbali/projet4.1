package dataaccess;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * Created by DotinSchool2 on 12/14/2015.
 */
public class LoanTypeCRUD {
    public static boolean insertLoanTypeToDatabase(String loanName, int interestRate, String conditions) {
        boolean result = false;
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
            result = true;
            tx.commit();
        } finally {
            session.close();
        }
        System.out.println("end");
        return result;
    }

    public static List selectLoanTypeFromDatabase() {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        LoanType loanType = null;
        try {
            Query query = session.createQuery("FROM LoanType ");
            List loanTypes = query.list();
            if (!loanTypes.isEmpty()) {
                Iterator iterator = loanTypes.iterator();
                loanType = (LoanType) iterator.next();
            }
            return loanTypes;
        } finally {
            session.close();
        }
    }

    public static boolean checkLoanConditions(String amount, String duration, String loanId) {

        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        LoanType loanType = null;
        try {
            Query query = session.createQuery("FROM LoanType where id= :loanId");
            query.setInteger("loanId", Integer.parseInt(loanId));
            List loanTypes = query.list();
            if (!loanTypes.isEmpty()) {
                Iterator iterator = loanTypes.iterator();
                loanType = (LoanType) iterator.next();
                Set conditions = (loanType.getConditions());
                Iterator itr = conditions.iterator();
                while (itr.hasNext()) {
                    LoanCondition condition = (LoanCondition) itr.next();
                    if (((condition.getMinAmount() <= Integer.parseInt(amount)) && (condition.getMaxAmount() >= Integer.parseInt(amount)))
                            && (condition.getMinDuration() <= Integer.parseInt(duration)) && (condition.getMaxDuration() >= Integer.parseInt(duration))) {
                        return true;
                    }
                }
            }

        } finally {
            session.close();
        }
        return false;
    }

    public static void main(String[] args) {

        checkLoanConditions("20", "56", "10");
    }
}

