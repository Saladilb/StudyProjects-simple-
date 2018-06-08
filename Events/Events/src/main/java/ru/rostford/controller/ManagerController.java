package ru.rostford.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.rostford.entity.Client;
import ru.rostford.entity.Event;
import ru.rostford.entity.Manager;
import ru.rostford.service.ClientServiceImpl;
import ru.rostford.service.EventService;
import ru.rostford.service.ManagerService;

@Controller
public class ManagerController {

    @Autowired
    private ManagerService managerService;
    @Autowired
    private EventService eventService;
    @Autowired
    private ClientServiceImpl clientService;

    @GetMapping("/index")
    public String index(Model model) {
        model.addAttribute("events", eventService.findAll());
        return "index";
    }

    @GetMapping("events/{id}/register_client")
    public String registerClient(@PathVariable("id") int id,
                              Model model) {
        model.addAttribute("event", eventService.findById(id));
        return "register_client";
    }

    @PostMapping("events/{id}/register_client")
    public String registerNewClient(@ModelAttribute Client client,
                                    @PathVariable("id") int id) {
        eventService.addClient(id, client);
        return "redirect:/index";
    }

    @GetMapping("/admin/managers")
    @ApiOperation("getAllManagers")
    public String findAllManagers(Model model) {
        model.addAttribute("managers", managerService.findAll());
        return "managers";
    }

    @GetMapping("admin/managers/{id}")
    @ApiOperation("getManagerById")
    public Manager getManagerById(@PathVariable int id) {
        return managerService.findById(id);
    }
}
