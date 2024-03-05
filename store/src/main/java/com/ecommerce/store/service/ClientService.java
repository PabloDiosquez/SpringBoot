package com.ecommerce.store.service;

import com.ecommerce.store.model.Client;
import com.ecommerce.store.repository.IClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService implements IClientService{
    @Autowired
    private IClientRepository clientRepository;

    @Override
    public void saveClient(Client client) {
        this.clientRepository.save(client);
    }
}
