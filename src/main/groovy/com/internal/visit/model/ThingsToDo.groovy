package com.internal.visit.model

import lombok.Data
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Data
@Document(value = "ThingsToDo")
class ThingsToDo {

    @Id
    String id

    String location
    String attraction
    String attractionDescription
    String imageUrl
    String siteUrl
}
