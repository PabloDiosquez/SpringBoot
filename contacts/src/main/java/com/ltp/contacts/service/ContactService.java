package com.ltp.contacts.service;

import com.ltp.contacts.pojo.Contact;
import org.springframework.http.ResponseEntity;

public interface ContactService {

    Contact getContactById(String contactId);

    void saveContact(Contact contact);

    void updateContact(String contactId, Contact contact);
}
