package com.vishnuparasu.EnforcementDirectorate.repository;

import com.vishnuparasu.EnforcementDirectorate.entity.EdUserCredentials;
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
public interface EdUserCredentialRepo extends JpaRepository<EdUserCredentials,String> {



    @Query("SELECT u FROM EdUserCredentials u WHERE u.userName = :userName")
    Optional<EdUserCredentials> findByuserName(String userName);

    @Modifying
    @Query("DELETE FROM EdUserCredentials u WHERE u.eduid = :eduid")
    void deleteUserByEduid(@Param("eduid") String eduid);

    @Modifying
    @Query("DELETE FROM EdUserCredentials u WHERE u.edoid = :edoid")
    void deleteOfficerByEduid(@Param("edoid") String edoid);

    @Modifying
    @Query("DELETE FROM EdUserCredentials u WHERE u.edaid = :edaid")
    void deleteAdminByEduid(@Param("edaid") String edaid);




}
