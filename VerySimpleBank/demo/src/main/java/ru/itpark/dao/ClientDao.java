package ru.itpark.dao;

import ru.itpark.models.Client;

import java.util.List;


public interface ClientDao {
    void insert(Client client);

    Client getById(Integer id);

    List<Client> getAll();

}
