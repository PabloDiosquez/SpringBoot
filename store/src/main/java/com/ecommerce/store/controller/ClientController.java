package com.ecommerce.store.controller;

import com.ecommerce.store.model.Client;
import com.ecommerce.store.service.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="api/clients")
public class ClientController {
    @Autowired
    private IClientService clientService;

    @PostMapping(path="/save")
    public String saveClient(@RequestParam Client client){
        this.clientService.saveClient(client);
        return "Success";
    }
}
