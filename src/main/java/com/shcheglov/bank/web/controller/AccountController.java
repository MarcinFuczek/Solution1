package com.shcheglov.bank.web.controller;

import com.shcheglov.bank.domain.Account;
import com.shcheglov.bank.service.AccountService;
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
@SessionAttributes("account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @RequestMapping(value = "addAccount", method = RequestMethod.GET)
    public String addAccount(Model model) {
        Account account = new Account();
        account.setNumber(1);
        account.setName("John Doe");
        model.addAttribute("account", account);
        return "addAccount";
    }

    @RequestMapping(value = "addAccount", method = RequestMethod.POST)
    public String saveAccount(@ModelAttribute("account") Account account, BindingResult result) {
        if (result.hasErrors()) {
            account = null;
            return "addAccount";
        } else {
            accountService.saveOrUpdateAccount(account);
        }
        return "redirect:getAccounts.html";
    }

    @RequestMapping(value = "getAccounts", method = RequestMethod.GET)
    public String getAccounts(Model model) {
        Set<Account> accounts = new TreeSet<>(accountService.getAllAccounts());
        model.addAttribute("accounts", accounts);
        return "getAccounts";
    }

}
