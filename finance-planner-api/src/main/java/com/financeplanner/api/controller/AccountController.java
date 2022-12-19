package com.financeplanner.api.controller;

import com.financeplanner.api.controller.model.AccountModel;
import com.financeplanner.api.database.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/account")
@RestController
public class AccountController {

    private AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    /**
     * GET
     *
     * @return existing products
     */
    @GetMapping(path = "/{accountId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AccountModel> getAccountById(@PathVariable long accountId) throws Exception {
        return ResponseEntity.ok(new AccountModel(accountService.getAccount(accountId)));
    }

    @PostMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AccountModel> addAccount(@RequestBody String name) {
        return ResponseEntity.ok(new AccountModel(accountService.insertAccount(name)));
    }
}
