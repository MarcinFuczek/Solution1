package com.shcheglov.bank.dao;

import com.shcheglov.bank.domain.ImmutableOperation;

import java.util.Set;

/**
 * @author Anton
 */
public interface OperationDao {

    long save(ImmutableOperation operation);

    Set<ImmutableOperation> getAll();

}
