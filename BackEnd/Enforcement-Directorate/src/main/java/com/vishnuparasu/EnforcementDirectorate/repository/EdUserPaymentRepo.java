package com.vishnuparasu.EnforcementDirectorate.repository;

import com.vishnuparasu.EnforcementDirectorate.entity.EdUserPaymentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
@EnableJpaRepositories
@Repository
public interface EdUserPaymentRepo extends JpaRepository<EdUserPaymentEntity,String> {
}
