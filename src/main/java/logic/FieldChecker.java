package logic;

import dataaccess.Customer;

import static dataaccess.CustomerCRUD.checkNationalCodeIsValied;

/**
 * Created by DotinSchool2 on 12/1/2015.
 */
public class FieldChecker {

    public static boolean checkFieldsAreNotEmpty(Customer customer) {
        if (customer.getNationalCode().equals("") || customer.getBirthDate().equals("") ||
                customer.getFather().equals("") || customer.getFirstName().equals("") || customer.getLastName().equals("")) {
            return false;
        }
        return true;
    }

    public static boolean checkNationalCodeIsUnique(String nationalCode) {
        return checkNationalCodeIsValied(nationalCode);
    }
}
