package com.internal.visit.repository

import com.internal.visit.model.Contacts
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface ContactsRepository extends MongoRepository<Contacts, String>{

}