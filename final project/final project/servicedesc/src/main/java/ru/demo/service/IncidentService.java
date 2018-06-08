package ru.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.demo.entity.Incident;
import ru.demo.repository.IncidentRepository;

import java.util.List;

/**
 * Created by yuliya.ditarova on 2017-07-30.
 */
@Service
public class IncidentService {
    private final IncidentRepository repository;

    @Autowired
    public IncidentService(IncidentRepository repository) {
        this.repository = repository;
    }

    public List<Incident> findAll() {
        return repository.findAll();
    }
    public Incident findOne(long id) {
        return repository.findOne(id);
    }

    public void save(Incident incident) {
        repository.save(incident);
    }

    public void delete(long id) {
        repository.delete(id);
    }

    public boolean exists(long id) {
        return repository.exists(id);
    }

}
