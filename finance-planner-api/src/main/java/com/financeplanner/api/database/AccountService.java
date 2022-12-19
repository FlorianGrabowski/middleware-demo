package com.financeplanner.api.database;

import com.financeplanner.api.database.entity.AccountEntity;
import com.financeplanner.api.database.repo.AccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountService {

    private AccountRepo accountRepo;

    @Autowired
    public AccountService(AccountRepo accountRepo) {
        this.accountRepo = accountRepo;
    }

    public AccountEntity getAccount(long id) throws Exception {
        Optional<AccountEntity> optional = accountRepo.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        } else {
            throw new Exception("Not found account with id=" + id + ".");
        }
    }

    public AccountEntity insertAccount(String name) {
        return accountRepo.save(new AccountEntity(name));
    }
}
