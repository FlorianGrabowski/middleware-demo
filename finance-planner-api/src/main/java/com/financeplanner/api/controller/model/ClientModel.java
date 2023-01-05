package com.financeplanner.api.controller.model;

import com.financeplanner.api.database.entity.ClientEntity;
import lombok.Data;

import java.util.Date;

@Data
public class ClientModel {

    private Long id;

    private String firstName;

    private String sirName;

    private Date dateOfBirth;

    public ClientModel(ClientEntity entity) {
        this.id = entity.getId();
        this.firstName = entity.getFirstName();
        this.sirName = entity.getSirName();
        this.dateOfBirth = entity.getDateOfBirth();
    }
}
