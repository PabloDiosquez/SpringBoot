package com.ecommerce.store.controller;

import com.ecommerce.store.model.Client;
import com.ecommerce.store.service.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(path="api/clients")
public class ClientController {
    @Autowired
    private IClientService clientService;

    @PostMapping(path="/save")
    public String saveClient(@RequestBody Client client){
        this.clientService.saveClient(client);
        return "Success";
    }

    @GetMapping(path="/find")
    @ResponseBody
    public Client findClientById(@RequestParam int clientId){
        return this.clientService.findClientById(clientId);
    }

    @GetMapping(path="/find-all")
    @ResponseBody
    public List<Client> findAllClients(){
        return this.clientService.findAllClients();
    }

    @DeleteMapping(path="/delete")
    @ResponseBody
    public Client deleteClientById(@RequestParam int clientId){
        return this.clientService.deleteClientById(clientId);
    }

    @PutMapping(path="/update")
    @ResponseBody
    public Client updateClient(@RequestBody Client client){
        return this.clientService.updateClient(client);
    }
}
