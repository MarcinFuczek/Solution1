package com.shcheglov.bank.web.controller;

import com.shcheglov.bank.domain.ImmutableOperation;
import com.shcheglov.bank.domain.MutableOperation;
import com.shcheglov.bank.service.AccountService;
import com.shcheglov.bank.service.OperationFactory;
import com.shcheglov.bank.service.OperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.Set;
import java.util.TreeSet;

/**
 * @author Anton
 */
@Controller
@SessionAttributes("operation")
public class OperationController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private OperationFactory operationFactory;

    @Autowired
    private OperationService operationService;

    @RequestMapping(value = "addOperation", method = RequestMethod.GET)
    public String depositOrWithdraw(Model model) {
        MutableOperation mutableOperation = operationFactory.getMutableOperation();
        model.addAttribute("operation", mutableOperation);
        model.addAttribute("availableAccounts", accountService.getAllAccounts());
        return "addOperation";
    }

    @RequestMapping(value = "addOperation", method = RequestMethod.POST)
    public String saveOperation(@ModelAttribute("operation") MutableOperation mutableOperation, BindingResult result) {
        if (result.hasErrors()) {
            mutableOperation = null;
            return "addOperation";
        } else {
            operationService.saveOperation(mutableOperation);
        }
        return "redirect:getOperations.html";
    }

    @RequestMapping(value = "getOperations", method = RequestMethod.GET)
    public String getOperations(Model model) {
        Set<ImmutableOperation> operations = new TreeSet<>(operationService.getAllOperations());
        model.addAttribute("operations", operations);
        return "getOperations";
    }

}
