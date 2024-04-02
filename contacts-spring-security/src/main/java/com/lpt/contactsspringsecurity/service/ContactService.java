package com.lpt.contactsspringsecurity.service;

import com.lpt.contactsspringsecurity.pojo.Contact;

import java.util.List;

public interface ContactService {

    List<Contact> getContacts();
    Contact getContactById(String id);
    void saveContact(Contact contact);
    void deleteContact(String id);
}
