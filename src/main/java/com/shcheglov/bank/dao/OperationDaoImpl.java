package com.shcheglov.bank.dao;

import com.shcheglov.bank.domain.ImmutableOperation;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Anton
 */
@Repository("operationDao")
public class OperationDaoImpl implements OperationDao {

    private Set<ImmutableOperation> operations = new HashSet<>();

    @Override
    public long save(ImmutableOperation immutableOperation) {
        operations.add(immutableOperation);
        return immutableOperation.getId();
    }

    @Override
    public Set<ImmutableOperation> getAll() {
        return operations;
    }

}
