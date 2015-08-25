package com.shcheglov.bank.domain;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Anton
 */
public class ImmutableOperation implements Comparable<ImmutableOperation> {

    private final long          id;
    private final long          accountNumber;
    private final OperationType type;
    private final long          sum;
    private final long          finalBalance;
    private final long          date;
    private final String        description;

    public long getId() {
        return id;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public OperationType getType() {
        return type;
    }

    public long getSum() {
        return sum;
    }

    public long getFinalBalance() {
        return finalBalance;
    }

    public long getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    public ImmutableOperation(MutableOperation mutableOperation, long id, long date) {
        this.accountNumber = mutableOperation.getAccountNumber();
        this.type = mutableOperation.getType();
        this.sum = mutableOperation.getSum();
        this.finalBalance = mutableOperation.getFinalBalance();
        this.description = mutableOperation.getDescription();
        this.id = id;
        this.date = date;
    }

    public String getFormattedDate() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(date));
    }

    @Override
    public int compareTo(ImmutableOperation that) {
        return Long.compare(this.id, that.id);
    }

}
