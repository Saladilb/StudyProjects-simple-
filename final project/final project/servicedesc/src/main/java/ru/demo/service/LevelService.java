package ru.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.demo.entity.Level;
import ru.demo.entity.User;
import ru.demo.repository.LevelRepository;
import ru.demo.repository.UserRepository;

import java.util.List;

/**
 * Created by yuliya.ditarova on 2017-08-02.
 */
@Service
public class LevelService {
    private final LevelRepository repository;

    @Autowired
    public LevelService(LevelRepository repository) {
        this.repository = repository;
    }

    public List<Level> findAll() {
        return repository.findAll();
    }
    public Level findOne(long id) {
        return repository.findOne(id);
    }

    public void save(Level level) {
        repository.save(level);
    }

    public void delete(long id) {
        repository.delete(id);
    }

    public boolean exists(long id) {
        return repository.exists(id);
    }
}
