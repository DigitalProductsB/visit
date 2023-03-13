package com.internal.visit.repository

import com.internal.visit.model.User
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository extends MongoRepository<User, String>{
    User findByUsername(String username)
}
