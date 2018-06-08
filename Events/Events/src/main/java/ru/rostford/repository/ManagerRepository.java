package ru.rostford.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.rostford.entity.Manager;

@Repository
public interface ManagerRepository extends JpaRepository<Manager, Integer> {
}
