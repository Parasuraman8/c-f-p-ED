package com.vishnuparasu.EnforcementDirectorate.repository;

import com.vishnuparasu.EnforcementDirectorate.entity.EdAdminEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Repository
@EnableJpaRepositories
@Service
public interface EdAdminRepo extends JpaRepository<EdAdminEntity,Integer> {

    @Modifying
    @Query("DELETE FROM EdAdminEntity u WHERE u.edaid = :edaid")
    void deleteByEduid(@Param("edaid") String edaid);

    @Query("SELECT u from EdAdminEntity u where u.edaid = :edaid")
    Optional<EdAdminEntity> findByEduid(@Param("edaid")String edaid);
}
