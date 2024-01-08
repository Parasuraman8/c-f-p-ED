package com.vishnuparasu.EnforcementDirectorate;

import com.vishnuparasu.EnforcementDirectorate.entity.EdRolesEntity;
import com.vishnuparasu.EnforcementDirectorate.entity.EdUserCredentials;
import com.vishnuparasu.EnforcementDirectorate.service.impl.EdAdminServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class EnforcementDirectorateApplication {

	public static void main(String[] args) {

		SpringApplication.run(EnforcementDirectorateApplication.class, args);
	}


}
