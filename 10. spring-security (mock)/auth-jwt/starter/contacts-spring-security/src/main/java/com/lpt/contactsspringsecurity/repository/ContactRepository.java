package com.lpt.contactsspringsecurity.repository;

import com.lpt.contactsspringsecurity.pojo.Contact;
import java.util.List;

public interface ContactRepository {
    List<Contact> getContacts();

    Contact getContact(int index);

    void saveContact(Contact contact);

    void deleteContact(int index);
}
