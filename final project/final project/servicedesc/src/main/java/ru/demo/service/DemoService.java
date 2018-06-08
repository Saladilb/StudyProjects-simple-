package ru.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.demo.entity.Level;
import ru.demo.entity.User;
import ru.demo.repository.LevelRepository;
import ru.demo.repository.UserRepository;

/**
 * Created by yuliya.ditarova on 2017-07-30.
 */
@Service
public class DemoService {
    private UserRepository userRepository;
    private LevelRepository levelRepository;

    @Autowired
    public DemoService(UserRepository userRepository, LevelRepository levelRepository) {
        this.userRepository = userRepository;
        this.levelRepository = levelRepository;
    }

    @Transactional
    public void demo() {

        /*Level level = new Level("admin");
        levelRepository.save(level);

        Level user = new Level("user");
        levelRepository.save(user);

        User admin = new User("admin", "admin", "adminadmin");
        admin.setLevel(level);
        userRepository.save(admin);

        User sidorov = new User("sidorov", "sidorov", "sidorovsidorov");
        sidorov.setLevel(user);
        userRepository.save(sidorov);

        User petrov = new User("petrov", "petrov", "petrovpetrov");
        petrov.setLevel(user);
        userRepository.save(petrov);*/
    }
}
