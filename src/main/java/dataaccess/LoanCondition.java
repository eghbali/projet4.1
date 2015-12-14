package dataaccess;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.HashSet;

/**
 * Created by DotinSchool2 on 12/9/2015.
 */
public class LoanCondition {
    private int id;
    private String name;
    private int minAmount;
    private int maxAmount;
    private int minDuration;
    private int maxDuration;

    public LoanCondition() {
    }

    public LoanCondition(String name, int minAmount, int maxAmount, int minDuration, int maxDuration) {
        this.name = name;
        this.minAmount = minAmount;
        this.maxAmount = maxAmount;
        this.minDuration = minDuration;
        this.maxDuration = maxDuration;

    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getMinAmount() {
        return minAmount;
    }

    public int getMaxAmount() {
        return maxAmount;
    }

    public int getMinDuration() {
        return minDuration;
    }

    public int getMaxDuration() {
        return maxDuration;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMinAmount(int minAmount) {
        this.minAmount = minAmount;
    }

    public void setMaxAmount(int maxAmount) {
        this.maxAmount = maxAmount;
    }

    public void setMinDuration(int minDuration) {
        this.minDuration = minDuration;
    }

    public void setMaxDuration(int maxDuration) {
        this.maxDuration = maxDuration;
    }

    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (!this.getClass().equals(obj.getClass())) return false;
        LoanCondition obj2 = (LoanCondition)obj;
        if((this.id == obj2.getId()) && (this.name.equals(obj2.getName()))&& (this.minAmount==(obj2.getMaxAmount()))&& (this.minAmount==(obj2.getMinAmount()))
                && (this.minDuration==(obj2.getMinDuration()))&& (this.maxDuration==(obj2.getMaxDuration())))
        {
            return true;
        }
        return false;
    }
    public int hashCode() {
        int tmp = 0;
        tmp = ( id + name ).hashCode();
        return tmp;
    }

    public static void main(String[] args) {
    LoanType lt=new LoanType("loanmame",7);
        HashSet set1 = new HashSet();
        set1.add(new LoanCondition("conditionname",1,2,12,13));
        set1.add(new LoanCondition("conditionname2",21,22,22,23)) ;
        set1.add(new LoanCondition("conditionname3",31,32,32,33)) ;
        lt.setConditions(set1);


        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        try {
            Transaction tx = session.beginTransaction();
            session.save(lt);
            tx.commit();
        }
    finally {
            session.close();
        }
//        System.out.println("-------->"+lc.getId());
        System.out.println("end");
    }
    }


