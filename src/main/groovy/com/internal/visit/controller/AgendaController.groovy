package com.internal.visit.controller

import com.internal.visit.exception.DataNotFound
import com.internal.visit.model.Agenda
import com.internal.visit.service.AgendaService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@CrossOrigin
@RequestMapping(value = "/v1", produces = MediaType.APPLICATION_JSON_VALUE)
class AgendaController {

    @Autowired
    AgendaService agendaService

    @GetMapping(value = "/agendas")
    ResponseEntity<List<Agenda>> getAllData(@RequestParam(required = false) String username){
        try {
            List<Agenda> agendaList
            agendaList = agendaService.getAllData(username)
            if(!agendaList.isEmpty()){
                return new ResponseEntity<>(agendaList, HttpStatus.OK)
            }
            else { throw new DataNotFound("No Agendas Found") }
        } catch (Exception e){
            throw new DataNotFound(e.getMessage())
        }
    }

    @PostMapping(value = "/agendas")
    ResponseEntity<Agenda> postData(@RequestBody Agenda agenda){
        try{
            agendaService.postAgendaDetails(agenda)
            return new ResponseEntity<Agenda>(agenda, HttpStatus.CREATED)
        } catch(Exception e){
            throw new Exception(e.getMessage())
        }
    }
}
