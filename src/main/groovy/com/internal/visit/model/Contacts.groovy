package com.internal.visit.model

import lombok.Data
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Data
@Document(value = "Contacts")
class Contacts {

    @Id
    String id

    String name
    String phoneNumber
    String emailID
    String imageUrl
}
