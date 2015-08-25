package com.shcheglov.bank.service;

import com.shcheglov.bank.domain.Account;
import com.shcheglov.bank.domain.MutableOperation;

import java.util.Set;

/**
 * @author Anton
 */
public interface AccountService {

    void saveOrUpdateAccount(Account account);

    Set<Account> getAllAccounts();

    boolean isExistingAccount(Account account);

    void updateBalanceByOperations(Set<MutableOperation> operations);

}
