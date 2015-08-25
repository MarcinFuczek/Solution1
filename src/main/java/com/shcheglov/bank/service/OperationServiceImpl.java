package com.shcheglov.bank.service;

import com.shcheglov.bank.dao.OperationDao;
import com.shcheglov.bank.domain.ImmutableOperation;
import com.shcheglov.bank.domain.MutableOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Anton
 */
@Service("operationService")
public class OperationServiceImpl implements OperationService {

    @Autowired
    private OperationDao operationDao;

    @Autowired
    private OperationFactory operationFactory;

    @Autowired
    private AccountService accountService;

    @Override
    public void saveOperation(MutableOperation mutableOperation) {
        Set<MutableOperation> relatedOperations = mutableOperation.getType().process(this, mutableOperation);
        accountService.updateBalanceByOperations(relatedOperations);
        saveOperations(relatedOperations);
    }

    @Override
    public Set<ImmutableOperation> getAllOperations() {
        return operationDao.getAll();
    }

    @Override
    public Set<MutableOperation> processDeposit(MutableOperation initialOperation) {
        Set<MutableOperation> operations = new HashSet<>(1);
        operations.add(initialOperation);
        return operations;
    }

    @Override
    public Set<MutableOperation> processWithdraw(MutableOperation initialOperation) {
        Set<MutableOperation> operations = new HashSet<>(1);
        initialOperation.setSum(-initialOperation.getSum());
        operations.add(initialOperation);
        return operations;
    }

    @Override
    public Set<MutableOperation> processTransfer(MutableOperation initialOperation) {
        Set<MutableOperation> operations = new HashSet<>(2);
        MutableOperation relatedOperation =
                operationFactory.getMutableOperation(initialOperation);
        relatedOperation.setAccountNumber(initialOperation.getRecipient());
        relatedOperation.setRecipient(0);
        relatedOperation.setSum(initialOperation.getSum());
        initialOperation.setSum(-initialOperation.getSum());
        operations.add(initialOperation);
        operations.add(relatedOperation);
        return operations;
    }

    private Set<Long> saveOperations(Set<MutableOperation> operations) {
        Set<Long> savedOperationsIds = new HashSet<>();
        for (MutableOperation operation : operations) {
            savedOperationsIds.add(operationDao.save(
                    operationFactory.getImmutableOperation(operation)));
        }
        return savedOperationsIds;
    }

}
