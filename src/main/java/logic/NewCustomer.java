package logic;

import dataaccess.Customer;

/**
 * Created by DotinSchool2 on 12/9/2015.
 */
public class NewCustomer {
    private String firstName;
    private String lastName;
    private String father;
    private String nationalCode;
    private String birthDate;
    private long id;

    public long getId() {
        return id;
    }

    public NewCustomer() {
    }

    public NewCustomer(String nationalCode, String fistName, String lastName, String father, String birthDate) {
        this.firstName = fistName;
        this.lastName = lastName;
        this.father = father;
        this.birthDate = birthDate;
        this.nationalCode = nationalCode;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getNationalCode() {
        return nationalCode;
    }

    public void setNationalCode(String nationalCode) {
        this.nationalCode = nationalCode;
    }

    public String getFather() {
        return father;
    }

    public void setFather(String father) {
        this.father = father;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static Customer creatCustomer(String nationalCode, String fistName, String lastName, String father, String birthDate) {
        return new Customer(nationalCode, fistName, lastName, father, birthDate);

    }
}


