package com.ltp.contacts.service;

import com.ltp.contacts.pojo.Contact;

import java.util.List;

public interface ContactService {

    Contact getContactById(String contactId);

    void saveContact(Contact contact);

    void updateContact(String contactId, Contact contact);

    void deleteContact(String contactId);

    List<Contact> getContacts();
}
