package ru.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.demo.entity.Incident;
import ru.demo.entity.User;
import ru.demo.repository.UserRepository;

import java.util.List;

/**
 * Created by yuliya.ditarova on 2017-07-30.
 */
@Service
public class UserService {
    private final UserRepository repository;

    @Autowired
    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public List<User> findAll() {
        return repository.findAll();
    }
    public User findOne(long id) {
        return repository.findOne(id);
    }

    public void save(User user) {
        repository.save(user);
    }

    public void delete(long id) {
        repository.delete(id);
    }

    public boolean exists(long id) {
        return repository.exists(id);
    }
}
