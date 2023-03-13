package com.internal.visit.repository

import com.internal.visit.model.ThingsToDo
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface ThingsToDoRepository extends MongoRepository<ThingsToDo, String>{
}
