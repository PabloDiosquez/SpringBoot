package com.lpt.contactsspringsecurity.web;

import com.lpt.contactsspringsecurity.pojo.Contact;
import com.lpt.contactsspringsecurity.service.ContactService;
import com.lpt.contactsspringsecurity.service.ContactServiceImpl;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
public class ContactController {

    private ContactService contactService;

    @GetMapping(path = "/contacts")
    public ResponseEntity<List<Contact>> getContacts(){
        return new ResponseEntity<>(contactService.getContacts(), HttpStatus.OK);
    }

    @GetMapping(path = "/contact/{contactId}")
    public ResponseEntity<Contact> getContact(@PathVariable(name = "contactId") String contactId){
        return new ResponseEntity<>(contactService.getContactById(contactId), HttpStatus.FOUND);
    }

    @PostMapping(path = "/contact")
    public ResponseEntity<HttpStatus> createContact(@Valid @RequestBody Contact contact){
        contactService.saveContact(contact);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/contact/{contactId}")
    public ResponseEntity<HttpStatus> deleteContact(@PathVariable(name = "contactId") String contactId){
        contactService.deleteContact(contactId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
