package ru.demo.controller;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.demo.entity.Organization;
import ru.demo.entity.Priority;
import ru.demo.service.OrganizationService;
import ru.demo.service.PriorityService;

import java.util.List;

/**
 * Created by yuliya.ditarova on 2017-08-02.
 */
@RestController
@CrossOrigin
@RequestMapping("/priority")
@Api(description = "Work with priority")
public class PriorityController {


    private final PriorityService service;

    @Autowired
    public PriorityController(PriorityService service) {
        this.service = service;
    }

    // GET
    @RequestMapping(method = RequestMethod.GET)
    public List<Priority> getAll() {
        return service.findAll();
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public Priority get(@PathVariable long id) {
        return service.findOne(id);
    }

    //    // POST
    @RequestMapping(method = RequestMethod.POST)
    public void save(@RequestBody Priority priority) {
        service.save(priority);
    }

    // DELETE
    // /leads/:id -> id
    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable long id) {
        service.delete(id);
    }
}
