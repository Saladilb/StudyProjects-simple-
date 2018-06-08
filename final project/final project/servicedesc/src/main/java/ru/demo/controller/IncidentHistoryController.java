package ru.demo.controller;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.demo.entity.Incident;
import ru.demo.entity.IncidentHistory;
import ru.demo.service.IncidentHistoryService;

import java.util.List;

/**
 * Created by yuliya.ditarova on 2017-08-02.
 */
@RestController
@CrossOrigin
@RequestMapping("/incident/{incidentId}/history")
@Api(description = "Work with incident_history")
public class IncidentHistoryController {

    private final IncidentHistoryService service;

    @Autowired
    public IncidentHistoryController(IncidentHistoryService service) {
        this.service = service;
    }

    // GET
    @RequestMapping(method = RequestMethod.GET)
    public List<IncidentHistory> getAll(@PathVariable long incidentId) {
        return service.findAllByIncidentId(incidentId);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public IncidentHistory get(@PathVariable long id) {
        return service.findOne(id);
    }

    //    // POST
    @RequestMapping(method = RequestMethod.POST)
    public void save(@PathVariable long incidentId, @RequestBody IncidentHistory incidentHistory) {
        incidentHistory.setIncident(new Incident(incidentId));
        service.save(incidentHistory);
    }

    // DELETE
    // /leads/:id -> id
    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable long id) {
        service.delete(id);
    }
}
