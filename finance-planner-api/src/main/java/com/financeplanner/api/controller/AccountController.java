package com.financeplanner.api.controller;

import com.financeplanner.api.controller.model.AccountModel;
import com.financeplanner.api.database.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
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
     * @return existing Account
     */
    @GetMapping(path = "/{accountId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AccountModel> getAccountById(@PathVariable long accountId) throws Exception {
        return ResponseEntity.ok(new AccountModel(accountService.getAccount(accountId)));
    }

    @PostMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AccountModel> addAccount(@RequestBody AccountModel accountWithName) {
        return ResponseEntity.ok(new AccountModel(accountService.insertAccount(accountWithName.getName())));
    }
}
