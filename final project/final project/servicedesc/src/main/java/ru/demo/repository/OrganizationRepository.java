package ru.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.demo.entity.Organization;
/**
 * Created by yuliya.ditarova on 2017-07-30.
 */
@Repository
public interface OrganizationRepository  extends JpaRepository<Organization, Long> {
}
