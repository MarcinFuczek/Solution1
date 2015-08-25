package com.shcheglov.bank.service;

import com.shcheglov.bank.domain.ImmutableOperation;
import com.shcheglov.bank.domain.MutableOperation;

import java.util.Set;

/**
 * @author Anton
 */
public interface OperationService {

    void saveOperation(MutableOperation mutableOperation);

    Set<ImmutableOperation> getAllOperations();

    Set<MutableOperation> processDeposit(MutableOperation initialOperation);

    Set<MutableOperation> processWithdraw(MutableOperation initialOperation);

    Set<MutableOperation> processTransfer(MutableOperation initialOperation);

}
