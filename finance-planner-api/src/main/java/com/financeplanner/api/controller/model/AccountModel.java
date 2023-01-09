package com.financeplanner.api.controller.model;

import com.financeplanner.api.database.entity.AccountEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class AccountModel {
    private Long id;
    private String name;

    public AccountModel(AccountEntity entity) {
        this.id = entity.getId();
        this.name = entity.getName();
    }
}
