package com.lpt.contactsspringsecurity.web;

import com.lpt.contactsspringsecurity.pojo.Contact;
import com.lpt.contactsspringsecurity.service.ContactService;
import com.lpt.contactsspringsecurity.service.ContactServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(path = "/contacts")
public class ContactController {

    private ContactService contactService;

    @GetMapping(path = "/all")
    public ResponseEntity<List<Contact>> getContacts(){
        return new ResponseEntity<>(contactService.getContacts(), HttpStatus.OK);
    }

    @GetMapping(path = "/{contactId}")
    public ResponseEntity<Contact> getContactById(@PathVariable(name = "contactId") String contactId){
        return new ResponseEntity<>(contactService.getContactById(contactId), HttpStatus.FOUND);
    }

    @PostMapping
    public ResponseEntity<HttpStatus> saveContact(@RequestBody Contact contact){
        contactService.saveContact(contact);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{contactId}")
    public ResponseEntity<HttpStatus> deleteContactById(@PathVariable(name = "contactId") String contactId){
        contactService.deleteContact(contactId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
