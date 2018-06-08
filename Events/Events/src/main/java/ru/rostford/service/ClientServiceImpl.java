package ru.rostford.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.rostford.entity.Client;
import ru.rostford.repository.ClientRepository;

@Service
public class ClientServiceImpl {
    @Autowired
    ClientRepository repository;

    void add(Client client) {
        repository.save(client);
    }
}
