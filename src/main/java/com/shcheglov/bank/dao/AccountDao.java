package com.shcheglov.bank.dao;

import com.shcheglov.bank.domain.Account;

import java.util.Set;

/**
 * @author Anton
 */
public interface AccountDao {

    void save(Account account);

    void update(Account account);

    Set<Account> getAll();

    Account getByNumber(long accountNumber);

}
