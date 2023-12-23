package com.vishnuparasu.EnforcementDirectorate.repository;

import com.vishnuparasu.EnforcementDirectorate.entity.EdUserBankEntity;
import org.springframework.boot.autoconfigure.quartz.QuartzDataSource;
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
public interface EdUserBankRepo extends JpaRepository<EdUserBankEntity,Long> {

    @Modifying
    @Query("DELETE FROM EdUserBankEntity u WHERE u.eduid = :eduid")
    void deleteByEduid(@Param("eduid") String eduid);

    @Query("SELECT u from EdUserBankEntity u where u.eduid = :eduid")
    Optional<EdUserBankEntity>findUserBankByEduid(@Param("eduid")String eduid);
}
