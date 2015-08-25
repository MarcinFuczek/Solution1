package com.shcheglov.bank.domain;

/**
 * @author Anton
 */
public class Account implements Comparable<Account> {

    private long    number;
    private String  name;
    private long    balance;

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    public String getFormattedName() {
        return String.format("%s (%s): %s", number, name, balance);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return number == account.number;
    }

    @Override
    public int hashCode() {
        return (int) (number ^ (number >>> 32));
    }

    @Override
    public String toString() {
        return "Account{" +
                "number=" + number +
                ", name='" + name + '\'' +
                ", balance=" + balance +
                '}';
    }

    @Override
    public int compareTo(Account that) {
        return Long.compare(this.number, that.number);
    }

}
