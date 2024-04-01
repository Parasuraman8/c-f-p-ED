package com.vishnuparasu.EnforcementDirectorate.repository;

import com.vishnuparasu.EnforcementDirectorate.entity.EdRolesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;


@Repository
@EnableJpaRepositories
@Service
public interface EdRolesRepo extends JpaRepository<EdRolesEntity,String> {

}
