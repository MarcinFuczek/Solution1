package com.shcheglov.bank.domain;

/**
 * @author Anton
 */
public class MutableOperation implements Comparable<MutableOperation> {

    private long            id;
    private long            accountNumber;
    private long            recipient;
    private OperationType   type;
    private long            sum;
    private long            finalBalance;
    private String          description;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public long getRecipient() {
        return recipient;
    }

    public void setRecipient(long recipient) {
        this.recipient = recipient;
    }

    public OperationType getType() {
        return type;
    }

    public void setType(OperationType type) {
        this.type = type;
    }

    public long getSum() {
        return sum;
    }

    public void setSum(long sum) {
        this.sum = sum;
    }

    public long getFinalBalance() {
        return finalBalance;
    }

    public void setFinalBalance(long finalBalance) {
        this.finalBalance = finalBalance;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MutableOperation mutableOperation = (MutableOperation) o;
        return id == mutableOperation.id;
    }

    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }

    @Override
    public String toString() {
        return "MutableOperation{" +
                "id=" + id +
                ", accountNumber=" + accountNumber +
                ", recipient=" + recipient +
                ", type=" + type +
                ", sum=" + sum +
                ", description='" + description + '\'' +
                '}';
    }

    @Override
    public int compareTo(MutableOperation that) {
        return Long.compare(this.id, that.id);
    }

}
