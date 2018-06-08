package ru.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.demo.entity.Organization;
import ru.demo.entity.Priority;
import ru.demo.repository.OrganizationRepository;
import ru.demo.repository.PriorityRepository;

import java.util.List;

/**
 * Created by yuliya.ditarova on 2017-08-02.
 */
@Service
public class PriorityService {
    private final PriorityRepository repository;

    @Autowired
    public PriorityService(PriorityRepository repository) {
        this.repository = repository;
    }

    public List<Priority> findAll() {
        return repository.findAll();
    }
    public Priority findOne(long id) {
        return repository.findOne(id);
    }

    public void save(Priority priority) {
        repository.save(priority);
    }

    public void delete(long id) {
        repository.delete(id);
    }

    public boolean exists(long id) {
        return repository.exists(id);
    }
}
