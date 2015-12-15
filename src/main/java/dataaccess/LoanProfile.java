package dataaccess;

/**
 * Created by DotinSchool2 on 12/15/2015.
 */
public class LoanProfile {

    private long  customerId;
    private int loanId;
    private int  id;
    private int  duration;
    private int amount;

    public LoanProfile(long customerId, int loanId, int duration, int amount) {
        this.customerId = customerId;
        this.loanId = loanId;
        this.duration = duration;
        this.amount = amount;
    }

    public LoanProfile() {
    }

    public long getCustomerId() {
        return customerId;
    }

    public int getLoanId() {
        return loanId;
    }

    public int getId() {
        return id;
    }

    public int getDuration() {
        return duration;
    }

    public int getAmount() {
        return amount;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public void setLoanId(int loanId) {
        this.loanId = loanId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
