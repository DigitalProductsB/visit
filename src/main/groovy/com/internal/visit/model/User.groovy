package com.internal.visit.model

import lombok.Data
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Data
@Document(value = "User")
class User {

    @Id
    String id

    String username
    String password

}
