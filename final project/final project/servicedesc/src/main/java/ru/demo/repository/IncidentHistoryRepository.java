package ru.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.demo.entity.IncidentHistory;

import java.util.List;

/**
 * Created by yuliya.ditarova on 2017-07-30.
 */
@Repository
public interface IncidentHistoryRepository extends JpaRepository<IncidentHistory, Long> {
    List<IncidentHistory> findAllByIncidentId(long id);
}
