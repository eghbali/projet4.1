package logic;

import dataaccess.Customer;
import org.apache.log4j.Logger;
import static dataaccess.CustomerCRUD.addNewCustomerToDatabase;


public class NewCustomerManager {
  public   static Logger log = Logger.getLogger(NewCustomerManager.class);

    public static String manageNewCustomer(NewCustomer newCustomer) {

        String result = "";
        Customer customer = new Customer(newCustomer.getNationalCode(), newCustomer.getFirstName(),
                newCustomer.getLastName(), newCustomer.getFather(), newCustomer.getBirthDate());
        if (FieldChecker.checkFieldsAreNotEmpty(customer)) {
            if (FieldChecker.checkNationalCodeIsUnique(customer.getNationalCode())) {
                addNewCustomer(customer);
                result="new Customer added";
                log.info("new Customer added");
            }
            else {
                System.out.println("National Code is invalid");
                result = "Error\n: National Code is invalid!";
            }
        } else {
            System.out.println("empty fields");
            result = "Error\n: fields are empty!";
        }
        return result;
    }

    public static void addNewCustomer(Customer customer) {
        addNewCustomerToDatabase(customer);
    }


}
