package dataaccess;

import org.hibernate.mapping.Set;

/**
 * Created by DotinSchool2 on 12/9/2015.
 */
public class LoanType {
    private String name;
    int interestRate;
    private Set conditions;
    private int id;
    public LoanType() {
    }
    public LoanType(String name, int interestRate) {
        this.name = name;
        this.interestRate = interestRate;
    }

    public String getName() {
        return name;
    }

    public int getInterestRate() {
        return interestRate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setInterestRate(int interestRate) {
        this.interestRate = interestRate;
    }

    public Set getConditions() {
        return conditions;
    }

    public void setConditions(Set conditions) {
        this.conditions = conditions;
    }

    public int getId() {
        return id;
    }

}
