package com.internal.visit.repository

import com.internal.visit.model.Agenda
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface AgendaRepository extends MongoRepository<Agenda, String> {
}