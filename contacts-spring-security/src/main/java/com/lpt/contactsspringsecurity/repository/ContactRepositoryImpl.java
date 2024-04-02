package com.lpt.contactsspringsecurity.repository;

import com.lpt.contactsspringsecurity.pojo.Contact;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class ContactRepositoryImpl implements ContactRepository{

    private final List<Contact> contacts = new ArrayList<>();
    @Override
    public List<Contact> getContacts() {
        return contacts;
    }

    @Override
    public Contact getContact(int index) {
        return contacts.get(index);
    }

    @Override
    public void saveContact(Contact contact) {
        contacts.add(contact);
    }

    @Override
    public void deleteContact(int index) {
        contacts.remove(index);
    }
}
