package com.internal.visit.model

import lombok.Data
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(value = "Visitor")
@Data
class Visitor {

    @Id
    String id

    String name
    String designation
    String imageUrl
}
