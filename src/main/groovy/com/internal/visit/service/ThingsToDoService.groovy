package com.internal.visit.service

import com.internal.visit.model.Agenda
import com.internal.visit.model.ThingsToDo
import com.internal.visit.repository.ThingsToDoRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ThingsToDoService {

    @Autowired
    ThingsToDoRepository thingsToDoRepository

    void postThingsToDoDetails(ThingsToDo thingsToDo) {
        if(thingsToDo !== null) {
            thingsToDoRepository.save(thingsToDo)
        }
    }

    List<Agenda> getAllData(){
        List<ThingsToDo> thingsToDoArrayList = new ArrayList<>()
        thingsToDoRepository.findAll().forEach(thingsToDoArrayList::add)
        return thingsToDoArrayList
    }
}
