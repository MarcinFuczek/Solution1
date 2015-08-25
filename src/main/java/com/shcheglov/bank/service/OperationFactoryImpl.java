package com.shcheglov.bank.service;

import com.shcheglov.bank.domain.ImmutableOperation;
import com.shcheglov.bank.domain.MutableOperation;
import com.shcheglov.bank.domain.OperationType;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author Anton
 */
@Component("operationFactory")
public class OperationFactoryImpl implements OperationFactory {

    private AtomicLong mutableOperationCounter = new AtomicLong(1);
    private AtomicLong immutableOperationCounter = new AtomicLong(1);

    @Override
    public MutableOperation getMutableOperation() {
        MutableOperation operation = new MutableOperation();
        operation.setId(generateMutableOperationId());
        operation.setAccountNumber(0);
        operation.setRecipient(0);
        operation.setType(OperationType.DEPOSIT);
        operation.setSum(0);
        operation.setDescription("Default description");
        return operation;
    }

    @Override
    public MutableOperation getMutableOperation(MutableOperation mutableOperation) {
        MutableOperation operation = new MutableOperation();
        operation.setId(generateMutableOperationId());
        operation.setAccountNumber(mutableOperation.getAccountNumber());
        operation.setRecipient(mutableOperation.getRecipient());
        operation.setType(mutableOperation.getType());
        operation.setSum(mutableOperation.getSum());
        operation.setDescription(mutableOperation.getDescription());
        return operation;
    }

    @Override
    public ImmutableOperation getImmutableOperation(MutableOperation mutableOperation) {
        return new ImmutableOperation(
                mutableOperation,
                generateImmutableOperationId(),
                new Date().getTime());
    }

    private long generateMutableOperationId() {
        return mutableOperationCounter.getAndIncrement();
    }

    private long generateImmutableOperationId() {
        return immutableOperationCounter.getAndIncrement();
    }

}
