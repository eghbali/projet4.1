package logic;

import dataaccess.entity.Customer;
import org.apache.log4j.Logger;

import static dataaccess.CustomerCRUD.insertNewCustomerToDatabase;


public class NewCustomerlogic {
    public static Logger log = Logger.getLogger(NewCustomerlogic.class);

    public static String manageNewCustomer(Customer customer) {

        String result = "";
        if (FieldChecker.checkFieldsAreNotEmpty(customer)) {
            if (FieldChecker.checkNationalCodeIsUnique(customer.getNationalCode())) {
                insertNewCustomerToDatabase(customer);
                result = "new Customer added";
                log.info("new Customer added");
            } else {
                log.error("National Code is invalid");
                result = "Error\n: National Code is invalid!";
            }
        } else {
            log.error("empty fields");
            result = "Error\n: fields are empty!";
        }
        return result;
    }

}
