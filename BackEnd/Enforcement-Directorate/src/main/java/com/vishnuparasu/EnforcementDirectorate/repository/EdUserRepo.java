package com.vishnuparasu.EnforcementDirectorate.repository;

import com.vishnuparasu.EnforcementDirectorate.entity.EdUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@EnableJpaRepositories
@Repository
public interface EdUserRepo extends JpaRepository<EdUserEntity,Integer> {

    @Modifying
    @Query("DELETE FROM EdUserEntity u WHERE u.eduid = :eduid")
    void deleteByEduid(@Param("eduid") String eduid);

    @Query("SELECT u from EdUserEntity u where u.eduid = :eduid")
    Optional<EdUserEntity> findByEduid(@Param("eduid")String eduid);
}
