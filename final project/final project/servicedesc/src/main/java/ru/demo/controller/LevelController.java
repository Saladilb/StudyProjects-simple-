package ru.demo.controller;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.demo.entity.IncidentHistory;
import ru.demo.entity.Level;
import ru.demo.service.IncidentHistoryService;
import ru.demo.service.LevelService;

import java.util.List;

/**
 * Created by yuliya.ditarova on 2017-08-02.
 */
@RestController
@CrossOrigin
@RequestMapping("/level")
@Api(description = "Work with level")
public class LevelController {


    private final LevelService service;

    @Autowired
    public LevelController(LevelService service) {
        this.service = service;
    }

    // GET
    @RequestMapping(method = RequestMethod.GET)
    public List<Level> getAll() {
        return service.findAll();
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public Level get(@PathVariable long id) {
        return service.findOne(id);
    }

    //    // POST
    @RequestMapping(method = RequestMethod.POST)
    public void save(@RequestBody Level level) {
        service.save(level);
    }

    // DELETE
    // /leads/:id -> id
    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable long id) {
        service.delete(id);
    }
}
