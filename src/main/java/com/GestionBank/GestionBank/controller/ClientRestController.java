package com.GestionBank.GestionBank.controller;

import com.GestionBank.GestionBank.dto.ClientDTO;
import com.GestionBank.GestionBank.entities.Client;
import com.GestionBank.GestionBank.services.ClientService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1")
@CrossOrigin("*")
public class ClientRestController {
    private final ClientService clientService;

    public ClientRestController(final ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping("/clients")
    public Client createClient(@RequestBody ClientDTO dto) {
        return this.clientService.createClient(dto);
    }

    @GetMapping("/clients")
    public List<Client> findAll() {
        return this.clientService.getAllClient();
    }

    @GetMapping("/clients/{id}")
    public Client findById(@PathVariable("id") long id) {
        try {
            return this.clientService.getClientById(id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
