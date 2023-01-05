package com.financeplanner.api.database.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@Getter
@Entity(name = "Client")
@Table(name = "clients")
public class ClientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "firstName")
    private String firstName;
    @Column(name = "sirName")
    private String sirName;
    @Column(name = "dateOfBirth")
    private Date dateOfBirth;

    public ClientEntity(String firstName, String sirName, Date dateOfBirth) {
        this.id = null;// generated
        this.firstName = firstName;
        this.sirName = sirName;
        this.dateOfBirth = dateOfBirth;
    }
}
