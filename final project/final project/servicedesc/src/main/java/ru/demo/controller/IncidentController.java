package ru.demo.controller;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.demo.entity.Incident;
import ru.demo.service.IncidentService;

import java.util.List;

/**
 * Created by yuliya.ditarova on 2017-07-30.
 */
@RestController
@CrossOrigin
@RequestMapping("/incident")
@Api(description = "Work with incident")
public class IncidentController {
    private final IncidentService service;

    @Autowired
    public IncidentController(IncidentService service) {
        this.service = service;
    }

    // GET
    @RequestMapping(method = RequestMethod.GET)
    public List<Incident> getAll() {
        return service.findAll();
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public Incident get(@PathVariable long id) {
        return service.findOne(id);
    }

    //    // POST
    @RequestMapping(method = RequestMethod.POST)
    public void save(@RequestBody Incident incident) {
        service.save(incident);
    }

    // DELETE
    // /leads/:id -> id
    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable long id) {
        service.delete(id);
    }
}
