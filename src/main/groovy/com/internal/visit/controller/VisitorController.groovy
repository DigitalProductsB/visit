package com.internal.visit.controller

import com.internal.visit.exception.DataNotFound
import com.internal.visit.model.Visitor
import com.internal.visit.service.VisitorService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@CrossOrigin
@RequestMapping(value = "/v1", produces = MediaType.APPLICATION_JSON_VALUE)
class VisitorController {

    @Autowired
    VisitorService visitorService

    @GetMapping("/visitors")
    ResponseEntity<List<Visitor>> getVisitorsDetails(){
        try {
            List<Visitor> visitorsList
            visitorsList = visitorService.getAllVisitorDetails()
            if(!visitorsList.isEmpty()){
                return new ResponseEntity<>(visitorsList, HttpStatus.OK)
            }
            else { throw new DataNotFound("No Visitors Found") }
        } catch (Exception e){
            throw new DataNotFound(e.getMessage())
        }
    }

    @PostMapping(value = "/visitors")
    ResponseEntity<Visitor> postData(@RequestBody Visitor visitor){
        try{
            visitorService.postVisitorDetails(visitor)
            return new ResponseEntity<Visitor>(visitor, HttpStatus.CREATED)
        } catch(Exception e){
            throw new Exception(e.getMessage())
        }
    }
}
