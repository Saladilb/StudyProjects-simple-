package ru.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.demo.entity.Level;
import ru.demo.entity.Organization;
import ru.demo.repository.LevelRepository;
import ru.demo.repository.OrganizationRepository;

import java.util.List;

/**
 * Created by yuliya.ditarova on 2017-08-02.
 */
@Service
public class OrganizationService {
    private final OrganizationRepository repository;

    @Autowired
    public OrganizationService(OrganizationRepository repository) {
        this.repository = repository;
    }

    public List<Organization> findAll() {
        return repository.findAll();
    }
    public Organization findOne(long id) {
        return repository.findOne(id);
    }

    public void save(Organization organization) {
        repository.save(organization);
    }

    public void delete(long id) {
        repository.delete(id);
    }

    public boolean exists(long id) {
        return repository.exists(id);
    }
}
