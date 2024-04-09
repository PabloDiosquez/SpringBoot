package com.lpt.contactsspringsecurity.service;

import com.lpt.contactsspringsecurity.exception.ContactNotFoundException;
import com.lpt.contactsspringsecurity.pojo.Contact;
import com.lpt.contactsspringsecurity.repository.ContactRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.IntStream;

@AllArgsConstructor
@Service
public class ContactServiceImpl implements ContactService{

    private ContactRepository contactRepository;
    @Override
    public List<Contact> getContacts() {
        return contactRepository.getContacts();
    }

    @Override
    public Contact getContactById(String id) {
        return contactRepository.getContact(findIndexById(id));
    }

    @Override
    public void saveContact(Contact contact) {
        contactRepository.saveContact(contact);
    }

    @Override
    public void deleteContact(String id) {
        contactRepository.deleteContact(findIndexById(id));
    }

    private int findIndexById(String id){
        return IntStream.range(0, contactRepository.getContacts().size())
                .filter(index -> contactRepository.getContacts().get(index).getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ContactNotFoundException(id));
    }
}
