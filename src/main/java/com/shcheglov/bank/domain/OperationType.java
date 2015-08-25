package com.shcheglov.bank.domain;

import com.shcheglov.bank.service.OperationService;

import java.util.Set;

/**
 * @author Anton
 */
public enum OperationType {

    DEPOSIT {
        @Override
        public Set<MutableOperation> process(OperationService operationService,
                                             MutableOperation mutableOperation) {
            return operationService.processDeposit(mutableOperation);
        }
    },

    WITHDRAW {
        @Override
        public Set<MutableOperation> process(OperationService operationService,
                                             MutableOperation mutableOperation) {
            return operationService.processWithdraw(mutableOperation);
        }
    },

    TRANSFER {
        @Override
        public Set<MutableOperation> process(OperationService operationService,
                                             MutableOperation mutableOperation) {
            return operationService.processTransfer(mutableOperation);
        }
    };

    public abstract Set<MutableOperation>
    process(OperationService operationService, MutableOperation mutableOperation);

}
