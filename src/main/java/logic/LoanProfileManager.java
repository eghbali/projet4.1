package logic;

import dataaccess.Customer;
import dataaccess.LoanType;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static dataaccess.CustomerCRUD.selectCustomer;
import static dataaccess.LoanTypeCRUD.checkLoanConditions;
import static dataaccess.LoanTypeCRUD.selectLoanTypeFromDatabase;

/**
 * Created by DotinSchool2 on 12/15/2015.
 */
public class LoanProfileManager {
    public static String searchCustomer(String customerId){
        Customer customer=selectCustomer(customerId);
        if (customer!=null)
        return customer.getFirstName()+"+"+customer.getFirstName();
        else
            return "";
    }
    public static ArrayList<String> selectLoanType(){
       List loanType= selectLoanTypeFromDatabase();
        ArrayList loanInformation=new ArrayList();
        Iterator iterator=loanType.iterator();
        while(iterator.hasNext())
        {
            LoanType loan=(LoanType) iterator.next();
            loanInformation.add(loan.getName()+"+"+loan.getId()+"+"+loan.getInterestRate());
        }
        return loanInformation;
    }

 public static   void ManageLoan(String customerId,String amount,String duration,String loanId){
        int loanCondition=checkLoanConditions(amount,duration,loanId);
        if(loanCondition!=-1){
            makeLoanProfile(Long.parseLong(customerId),loanCondition,amount,duration);
        }
         else{

        }
   }
}
