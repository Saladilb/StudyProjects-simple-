package ru.rostford.service;

import ru.rostford.entity.Client;
import ru.rostford.entity.Event;

import java.util.List;

public interface EventService {
    List<Event> findAll();
    Event findById(int id);
    void addClient(int eventId, Client client);
}
