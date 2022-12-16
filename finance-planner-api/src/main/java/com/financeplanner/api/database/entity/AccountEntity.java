package com.financeplanner.api.database.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class AccountEntity {

    @Id
    private long id;
}
