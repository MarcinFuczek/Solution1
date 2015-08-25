package com.shcheglov.bank.service;

import com.shcheglov.bank.dao.AccountDao;
import com.shcheglov.bank.domain.Account;
import com.shcheglov.bank.domain.MutableOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * @author Anton
 */
@Service("accountService")
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;

    @Override
    public void saveOrUpdateAccount(Account account) {
        if (isExistingAccount(account)) {
            accountDao.update(account);
        } else {
            accountDao.save(account);
        }
    }

    @Override
    public Set<Account> getAllAccounts() {
        return accountDao.getAll();
    }

    @Override
    public boolean isExistingAccount(Account account) {
        return accountDao.getAll().contains(account);
    }

    @Override
    public void updateBalanceByOperations(Set<MutableOperation> operations) {
        for (MutableOperation operation : operations) {
            Account currentAccount = accountDao.getByNumber(operation.getAccountNumber());
            currentAccount.setBalance(currentAccount.getBalance() + operation.getSum());
            operation.setFinalBalance(currentAccount.getBalance());
        }
    }

}
