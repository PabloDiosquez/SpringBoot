package com.ecommerce.store.service;

import com.ecommerce.store.model.Client;

import java.util.List;

public interface IClientService {
    void saveClient(Client client);

    Client findClientById(int clientId);

    List<Client> findAllClients();

    Client deleteClientById(int clientId);

    Client updateClient(Client client);
}
