package com.financeplanner.api.controller;

import com.financeplanner.api.controller.model.ClientModel;
import com.financeplanner.api.database.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/client")
@RestController
public class ClientController {

    private ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    /**
     * GET
     *
     * @return existing Client
     */
    @GetMapping(path = "/{clientId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ClientModel> getClientById(@PathVariable long clientId) throws Exception {
        return ResponseEntity.ok(new ClientModel(clientService.getClient(clientId)));
    }

    @PostMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ClientModel> addClient(@RequestBody String firstName, String sirName, Date dateOfBirth) {
        return ResponseEntity.ok(new ClientModel(clientService.insertClient(firstName, sirName, dateOfBirth)));
    }
}
