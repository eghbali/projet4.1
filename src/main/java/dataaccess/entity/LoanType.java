package dataaccess.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Set;

public class LoanType {
    private String name;
    int interestRate;
    private Set conditions;
    private Set profiles;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setConditions(Set conditions) {
        this.conditions = conditions;
    }

    public Set getProfiles() {
        return profiles;
    }

    public void setProfiles(Set profiles) {
        this.profiles = profiles;
    }

    public static void main(String[] args) {
        LoanType loanType = new LoanType("loanname15", 15);
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        try {
            Transaction tx = session.beginTransaction();
            session.save(loanType);
            tx.commit();
        } finally {
            session.close();
        }
    }
}
