package ru.rostford.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.rostford.entity.Client;
import ru.rostford.entity.Event;
import ru.rostford.repository.EventRepository;

import java.util.List;

@Service
public class EventServiceImpl implements EventService{
    @Autowired
    EventRepository eventRepository;

    public List<Event> findAll() {
        return eventRepository.findAll();
    }
    public Event findById(int id) {
        return eventRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    }

    public void addClient(int eventId, Client client) {
        Event event = eventRepository.findById(eventId).orElseThrow(() -> new RuntimeException("Event not found"));
        event.getClients().add(client);
        client.getEvents().add(event);
        eventRepository.save(event);
        //eventRepository.updateEvent(eventId, event.getClients());
    }
}
