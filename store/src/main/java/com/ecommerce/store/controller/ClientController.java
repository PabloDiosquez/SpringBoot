package com.ecommerce.store.controller;

import com.ecommerce.store.service.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientController {
    @Autowired
    private IClientService clientService;
}
