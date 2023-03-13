package com.internal.visit.service

import com.internal.visit.model.Visitor
import com.internal.visit.repository.VisitorRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class VisitorService {

    @Autowired
    VisitorRepository visitorRepository

    List<Visitor> getAllVisitorDetails(){
        List<Visitor> visitorsList = new ArrayList<>()
        visitorRepository.findAll().forEach(visitorsList::add)
        return visitorsList
    }

    void postVisitorDetails(Visitor visitor) {
        if(visitor != null){
            visitorRepository.save(visitor)
        }
    }
}
