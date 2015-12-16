package logic;

import dataaccess.entity.LoanCondition;
import dataaccess.entity.LoanProfile;
import dataaccess.entity.LoanType;
import dataaccess.LoanTypeCRUD;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Set;

import static dataaccess.LoanTypeCRUD.insertLoanTypeToDatabase;

/**
 * Created by DotinSchool2 on 12/14/2015.
 */
public class LoanTypeLogic {

    public static Logger log = Logger.getLogger(LoanTypeLogic.class);

    public static boolean saveLoanType(String loanName, int interestRate, String conditions) {
        boolean isSaved = insertLoanTypeToDatabase(loanName, interestRate, conditions);
        if (isSaved) {
            log.info("new loan type defined.");
        }
        return isSaved;

    }

    public static boolean checkGrantConditions(LoanProfile loanProfile) {
        int amount=loanProfile.getAmount();
        int duration=loanProfile.getDuration();
        int loanId=loanProfile.getId();
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        try {
            LoanType loanType = LoanTypeCRUD.loadLoanTypeById(loanId);
            if (loanType != null) {
                Set<LoanCondition> conditions = loanType.getConditions();
                for (LoanCondition condition : conditions) {
                    if (((condition.getMinAmount() <= amount) && (condition.getMaxAmount() >= amount))
                            && (condition.getMinDuration() <= duration) && (condition.getMaxDuration() >= duration)) {
                        return true;
                    }
                }
            }
        } finally {
            session.close();
        }
        return false;
    }
}
