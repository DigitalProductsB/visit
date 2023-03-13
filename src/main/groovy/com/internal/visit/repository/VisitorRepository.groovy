package com.internal.visit.repository

import com.internal.visit.model.Visitor
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface VisitorRepository extends MongoRepository<Visitor, String>{

}