package com.GestionBank.GestionBank.services;

import com.GestionBank.GestionBank.dto.ClientDTO;
import com.GestionBank.GestionBank.entities.Client;

import java.util.List;

public interface ClientService {
    Client createClient(ClientDTO dto);
    List<Client> getAllClient();
    Client getClientById(long id);
    List<Client> searchClientsByKeywords(String keyword);
}
