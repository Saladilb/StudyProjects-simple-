package ru.demo.controller;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.demo.entity.User;
import ru.demo.service.UserService;

import java.util.List;

/**
 * Created by yuliya.ditarova on 2017-07-30.
 */
@RestController
@CrossOrigin
@RequestMapping("/users")
@Api(description = "Work with users")
public class UserController {
    private final UserService service;

    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }

    // GET
    @RequestMapping(method = RequestMethod.GET)
    public List<User> getAll() {
        return service.findAll();
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public User get(@PathVariable long id) {
        return service.findOne(id);
    }

    //    // POST
    @RequestMapping(method = RequestMethod.POST)
    public void save(@RequestBody User user) {
        service.save(user);
    }

    // DELETE
    // /leads/:id -> id
    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable long id) {
        service.delete(id);
    }

}
