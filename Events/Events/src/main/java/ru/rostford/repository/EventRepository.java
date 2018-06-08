package ru.rostford.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.rostford.entity.Client;
import ru.rostford.entity.Event;

import java.beans.Transient;
import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event, Integer> {
//    @Modifying
//    @Transactional
//    @Query("update Event event set event.clients = ?2 where event.id = ?1")
//    void updateEvent(int id, List<Client> clients);

}
