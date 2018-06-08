package ru.rostford.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.rostford.entity.Manager;
import ru.rostford.repository.ManagerRepository;

import java.util.List;

@Service
public class ManagerServiceImpl implements ManagerService {
    @Autowired
    private ManagerRepository repository;

    public Manager findById(int id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    }

    public List<Manager> findAll() {
        return repository.findAll();
    }
}
