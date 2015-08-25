package com.shcheglov.bank.dao;

import com.shcheglov.bank.domain.Account;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Anton
 */
@Repository("accountDao")
public class AccountDaoImpl implements AccountDao {

    private Set<Account> accounts = new HashSet<>();

    @Override
    public void save(Account account) {
        accounts.add(account);
    }

    @Override
    public void update(Account account) {
        accounts.remove(account);
        accounts.add(account);
    }

    @Override
    public Set<Account> getAll() {
        return accounts;
    }

    @Override
    public Account getByNumber(long accountNumber) {
        Account account = null;
        for (Account currentAccount : accounts) {
            if (currentAccount.getNumber() == accountNumber)
                account = currentAccount;
        }
        return account;
    }

}
