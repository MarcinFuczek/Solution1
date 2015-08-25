package com.shcheglov.bank.service;

import com.shcheglov.bank.domain.ImmutableOperation;
import com.shcheglov.bank.domain.MutableOperation;

/**
 * @author Anton
 */
public interface OperationFactory {

    MutableOperation getMutableOperation();

    MutableOperation getMutableOperation(MutableOperation mutableOperation);

    ImmutableOperation getImmutableOperation(MutableOperation mutableOperation);

}
