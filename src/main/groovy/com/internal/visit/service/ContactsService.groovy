package com.internal.visit.service

import com.internal.visit.model.Contacts
import com.internal.visit.repository.ContactsRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ContactsService {

    @Autowired
    ContactsRepository contactsRepository

    void postContactsDetails(Contacts contacts) {
        if(contacts !== null) {
            contactsRepository.save(contacts)
        }
    }

    List<Contacts> getAllData(){
        List<Contacts> contactsList = new ArrayList<>()
        contactsRepository.findAll().forEach(contactsList::add)
        return contactsList
    }
}
