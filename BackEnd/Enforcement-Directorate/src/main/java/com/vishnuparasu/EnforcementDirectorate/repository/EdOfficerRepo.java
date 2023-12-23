package com.vishnuparasu.EnforcementDirectorate.repository;

import com.vishnuparasu.EnforcementDirectorate.entity.EdOfficerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@EnableJpaRepositories
@Repository
@Service
public interface EdOfficerRepo extends JpaRepository<EdOfficerEntity,Integer> {

    @Modifying
    @Query("delete from EdOfficerEntity u where u.edoid = :edoid")
    void deleteOfficerByEdoid(@Param("edoid") String edoid);

    @Query("select u from EdOfficerEntity u where u.edoid = :edoid")
    Optional<EdOfficerEntity> findOfficerByEdoid(@Param("edoid") String edoid);

}
