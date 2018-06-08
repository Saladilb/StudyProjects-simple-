package ru.demo.controller;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.demo.entity.Level;
import ru.demo.entity.Organization;
import ru.demo.service.LevelService;
import ru.demo.service.OrganizationService;

import java.util.List;

/**
 * Created by yuliya.ditarova on 2017-08-02.
 */
@RestController
@CrossOrigin
@RequestMapping("/organization")
@Api(description = "Work with organization")
public class OrganizationController {


    private final OrganizationService service;

    @Autowired
    public OrganizationController(OrganizationService service) {
        this.service = service;
    }

    // GET
    @RequestMapping(method = RequestMethod.GET)
    public List<Organization> getAll() {
        return service.findAll();
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public Organization get(@PathVariable long id) {
        return service.findOne(id);
    }

    //    // POST
    @RequestMapping(method = RequestMethod.POST)
    public void save(@RequestBody Organization organization) {
        service.save(organization);
    }

    // DELETE
    // /leads/:id -> id
    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable long id) {
        service.delete(id);
    }
}
