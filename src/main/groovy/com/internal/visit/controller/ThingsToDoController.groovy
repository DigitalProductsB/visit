package com.internal.visit.controller

import com.internal.visit.exception.DataNotFound
import com.internal.visit.model.ThingsToDo
import com.internal.visit.service.ThingsToDoService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@CrossOrigin
@RequestMapping(value = "/v1", produces = MediaType.APPLICATION_JSON_VALUE)
class ThingsToDoController {

    @Autowired
    ThingsToDoService thingsToDoService

    @GetMapping(value = "/thingstodo")
    ResponseEntity<List<ThingsToDo>> getAllData(){
        try {
            List<ThingsToDo> thingsToDoList
            thingsToDoList = thingsToDoService.getAllData()
            if(!thingsToDoList.isEmpty()){
                return new ResponseEntity<>(thingsToDoList, HttpStatus.OK)
            }
            else { throw new DataNotFound("No Items Found") }
        } catch (Exception e){
            throw new DataNotFound(e.getMessage())
        }
    }

    @PostMapping(value = "/thingstodo")
    ResponseEntity<ThingsToDo> postData(@RequestBody ThingsToDo thingsToDo){
        try{
            thingsToDoService.postThingsToDoDetails(thingsToDo)
            return new ResponseEntity<ThingsToDo>(thingsToDo, HttpStatus.CREATED)
        } catch(Exception e){
            throw new Exception(e.getMessage())
        }
    }

}
