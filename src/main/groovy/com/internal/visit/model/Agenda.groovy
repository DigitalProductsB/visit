package com.internal.visit.model

import lombok.Data
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Data
@Document(collection = "Agenda")
class Agenda {

    @Id
    String id

    String dateOfVisit
    String agendaTime
    String agendaLocation
    String agendaActivityTitle
    String agendaActivityDetails
    String agendaHostingDetails
    Integer sortOrder
    Boolean parallelAgenda

}
