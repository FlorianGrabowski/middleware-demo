package com.financeplanner.api.database;

import com.financeplanner.api.database.entity.ClientEntity;
import com.financeplanner.api.database.repo.ClientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class ClientService {

    private ClientRepo clientRepo;

    @Autowired
    public ClientService(ClientRepo clientRepo) {
        this.clientRepo = clientRepo;
    }

    public ClientEntity getClient(long id) throws Exception {
        Optional<ClientEntity> optional = clientRepo.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        } else {
            throw new Exception("Not found client with id=" + id + ".");
        }
    }

    public ClientEntity insertClient(String firstName, String sirName, Date dateOfBirth) {
        return clientRepo.save(new ClientEntity(firstName, sirName, dateOfBirth));
    }
}
