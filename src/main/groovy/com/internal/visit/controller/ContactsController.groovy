package com.internal.visit.controller

import com.internal.visit.exception.DataNotFound
import com.internal.visit.model.Contacts
import com.internal.visit.service.ContactsService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@CrossOrigin
@RequestMapping(value = "/v1", produces = MediaType.APPLICATION_JSON_VALUE)
class ContactsController {

    @Autowired
    ContactsService contactsService

    @GetMapping(value = "/contacts")
    ResponseEntity<List<Contacts>> getAllData(){
        try {
            List<Contacts> contactsList
            contactsList = contactsService.getAllData()
            if(!contactsList.isEmpty()){
                return new ResponseEntity<>(contactsList, HttpStatus.OK)
            }
            else { throw new DataNotFound("No Contacts Found") }
        } catch (Exception e){
            throw new DataNotFound(e.getMessage())
        }
    }

    @PostMapping(value = "/contacts")
    ResponseEntity<Contacts> postData(@RequestBody Contacts contacts){
        try{
            contactsService.postContactsDetails(contacts)
            return new ResponseEntity<Contacts>(contacts, HttpStatus.CREATED)
        } catch(Exception e){
            throw new Exception(e.getMessage())
        }
    }

}
