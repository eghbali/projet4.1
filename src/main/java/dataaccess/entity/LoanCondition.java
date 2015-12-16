package dataaccess.entity;

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


}


