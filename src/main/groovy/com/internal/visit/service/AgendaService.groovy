package com.internal.visit.service

import com.internal.visit.model.Agenda
import com.internal.visit.repository.AgendaRepository
import com.internal.visit.utils.Constants
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import java.util.stream.Collectors

@Service
class AgendaService {

    @Autowired AgendaRepository agendaRepository


    void postAgendaDetails(Agenda agenda) {
        if(agenda !== null) {
            agendaRepository.save(agenda)
        }
    }

    List<Agenda> getAllData(String username){
        List<Agenda> visitContainerList = new ArrayList<>()
        agendaRepository.findAll().forEach(visitContainerList::add)

        if(Constants.filterList.contains(username)){
            return visitContainerList.stream().sorted(Comparator.comparingInt(Agenda::getSortOrder)).filter(agenda -> !Constants.filteredDates.contains(agenda.getDateOfVisit())).collect(Collectors.toList())
        }
        return visitContainerList.stream().sorted(Comparator.comparingInt(Agenda::getSortOrder)).collect(Collectors.toList())
    }
}
