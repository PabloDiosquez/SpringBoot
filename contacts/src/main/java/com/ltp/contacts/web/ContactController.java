package com.ltp.contacts.web;

import com.ltp.contacts.pojo.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import com.ltp.contacts.service.ContactService;
import org.springframework.web.bind.annotation.*;

@RestController
public class ContactController {
    @Autowired
    private ContactService contactService;

    @GetMapping(path="/contact/{contactId}")
    public ResponseEntity<Contact> getContactById(@PathVariable String contactId){
        Contact contact;
        contact = contactService.getContactById(contactId);
        return new ResponseEntity<>(contact, HttpStatus.OK);
    }

    @PostMapping(path="/contact")
    public ResponseEntity<HttpStatus> createContact(@RequestBody Contact contact){
        contactService.saveContact(contact);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping(path="/contact/{contactId}")
    public ResponseEntity<Contact> updateContact(@PathVariable String contactId, @RequestBody Contact contact){
        contactService.updateContact(contactId, contact);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
