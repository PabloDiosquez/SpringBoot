package com.ecommerce.store.service;

import com.ecommerce.store.model.Client;
import com.ecommerce.store.repository.IClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService implements IClientService{
    @Autowired
    private IClientRepository clientRepository;

    @Override
    public void saveClient(Client client) {
        this.clientRepository.save(client);
    }

    @Override
    public Client findClientById(int clientId) {
        return this.clientRepository.findById(clientId).orElse(null);
    }

    @Override
    public List<Client> findAllClients() {
        return this.clientRepository.findAll();
    }

    @Override
    public Client deleteClientById(int clientId) {
        Client client = this.findClientById(clientId);
        this.clientRepository.deleteById(clientId);
        return client;
    }

    @Override
    public Client updateClient(Client client) {
        this.clientRepository.save(client);
        return this.findClientById(client.getClientId());
    }
}
