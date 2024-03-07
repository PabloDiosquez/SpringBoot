package com.ltp.contacts.service;

import com.ltp.contacts.pojo.Contact;
import org.springframework.http.ResponseEntity;

public interface ContactService {

    Contact getContactById(String contactId);
}
