package logic;

import static dataaccess.LoanTypeCRUD.insertLoanTypeToDatabase;

/**
 * Created by DotinSchool2 on 12/14/2015.
 */
public class LoanTypeManager {


    public static boolean  saveLoanType(String loanName, int interestRate, String conditions) {
      return insertLoanTypeToDatabase(loanName,interestRate,conditions);
    }
}
