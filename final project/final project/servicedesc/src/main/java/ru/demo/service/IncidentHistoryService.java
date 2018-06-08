package ru.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.demo.entity.Incident;
import ru.demo.entity.IncidentHistory;
import ru.demo.repository.IncidentHistoryRepository;
import ru.demo.repository.IncidentRepository;

import java.util.List;

/**
 * Created by yuliya.ditarova on 2017-08-02.
 */
@Service
public class IncidentHistoryService {
    private final IncidentHistoryRepository repository;

    @Autowired
    public IncidentHistoryService(IncidentHistoryRepository repository) {
        this.repository = repository;
    }

    public List<IncidentHistory> findAllByIncidentId(long incidentId) {
        return repository.findAllByIncidentId(incidentId);
    }

    public List<IncidentHistory> findAll() {
        return repository.findAll();
    }
    public IncidentHistory findOne(long id) {
        return repository.findOne(id);
    }

    public void save(IncidentHistory incidentHistory) {
        repository.save(incidentHistory);
    }

    public void delete(long id) {
        repository.delete(id);
    }

    public boolean exists(long id) {
        return repository.exists(id);
    }
}
