package com.ltp.contacts.web;

import com.ltp.contacts.pojo.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.ltp.contacts.service.ContactService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ContactController {
    @Autowired
    private ContactService contactService;

    @GetMapping(path="/contact/all")
    public ResponseEntity<List<Contact>> getContacts(){
        List<Contact> contacts =  contactService.getContacts();
        return new ResponseEntity<>(contacts, HttpStatus.OK);
    }

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
        return new ResponseEntity<>(contactService.getContactById(contactId), HttpStatus.OK);
    }

    @DeleteMapping(path="contact/{contactId}")
    public ResponseEntity<HttpStatus> deleteContact(@PathVariable String contactId){
        contactService.deleteContact(contactId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
