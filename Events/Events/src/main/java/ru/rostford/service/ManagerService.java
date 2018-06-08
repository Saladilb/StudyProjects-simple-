package ru.rostford.service;

import ru.rostford.entity.Manager;

import java.util.List;

public interface ManagerService {
    Manager findById(int id);
    List<Manager> findAll();
}
