package logic;

import dataaccess.*;
import dataaccess.entity.Customer;
import dataaccess.entity.LoanProfile;
import dataaccess.entity.LoanType;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by DotinSchool2 on 12/15/2015.
 */
public class LoanProfileLogic {
    public static Logger log = Logger.getLogger(LoanProfileLogic.class);

    public static String searchCustomer(String customerId) {
        Customer customer = CustomerCRUD.loadCustomerByCustomerId(customerId);
        if (customer != null) {
            return customer.getFirstName() + "+" + customer.getFirstName();
        } else {
            log.error("no customer found");
            return "";
        }
    }

    public static List<LoanType>  selectAllLoanTypes() {
        List<LoanType> loanTypes = LoanTypeCRUD.loadAllLoanTypes();
//        ArrayList<String> loanInformation = new ArrayList<String>();
//        for (LoanType loanType : loanTypes) {
//            loanInformation.add(loanType.getName() + "+" + loanType.getId() + "+" + loanType.getInterestRate());
//        }
        return loanTypes;
    }

    public static String insertLoanToDatabase(LoanProfile loanProfile) {
        boolean loanCondition = LoanTypeLogic.checkGrantConditions(loanProfile);
        if (loanCondition) {
            dataaccess.LoanProfileCRUD.InsertLoanProfileToDatabase(loanProfile);
            log.info("Loan Profile is Created");
            return "Loan Profile Created";
        } else {
            log.error(" invalid conditions");
            return "Error: invalid conditions";
        }
    }
}
