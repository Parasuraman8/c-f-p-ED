package com.vishnuparasu.EnforcementDirectorate.service.impl;

import com.vishnuparasu.EnforcementDirectorate.entity.EdAdminEntity;
import com.vishnuparasu.EnforcementDirectorate.entity.EdRolesEntity;
import com.vishnuparasu.EnforcementDirectorate.entity.EdUserCredentials;
import com.vishnuparasu.EnforcementDirectorate.repository.EdAdminRepo;
import com.vishnuparasu.EnforcementDirectorate.repository.EdRolesRepo;
import com.vishnuparasu.EnforcementDirectorate.repository.EdUserCredentialRepo;
import com.vishnuparasu.EnforcementDirectorate.service.EdAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

@Service
public class EdAdminServiceImpl implements EdAdminService {

    @Autowired
    private EdAdminRepo edAdminRepo;

    @Autowired
    private EdUserCredentialRepo edUserCredentialRepo;

    @Autowired
    private EdRolesRepo edRolesRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Bean
    public CommandLineRunner roleCrete() {
        return args -> {
            if (!edRolesRepo.findById("EDA").isPresent()) {
                EdRolesEntity admin = new EdRolesEntity();
                admin.setRole("EDA");
                admin.setRoleDesc("ADMIN");
                edRolesRepo.save(admin);

            }
        };
    }

    @Bean
    public CommandLineRunner rootUser() {
        return  args -> {
            if (!edUserCredentialRepo.findByuserName("root").isPresent()) {
                EdUserCredentials rootUser = new EdUserCredentials();
                Set<EdRolesEntity> roles = new HashSet<>();
                EdRolesEntity rolesEntity = new EdRolesEntity();

                rolesEntity.setRoleDesc("admin");
                rolesEntity.setRole("EDA");

                roles.add(rolesEntity);
                rootUser.setEdRolesModels(roles);
                rootUser.setUserName("root");
                rootUser.setPassword(passwordEncoder.encode("root"));

                edUserCredentialRepo.save(rootUser);
            }
        };
    }
    @Override
    public EdAdminEntity getAdmin(String edaid) {
        Optional<EdAdminEntity> oneAdmin = edAdminRepo.findByEduid(edaid);
        return oneAdmin.get();
    }

    @Override
    public List<EdAdminEntity> getAllAdmin() {
        List<EdAdminEntity> listOfAllAdmin = new ArrayList<>();
        edAdminRepo.findAll().forEach(listOfAllAdmin::add);
        return listOfAllAdmin;
    }

    @Transactional
    @Override
    public String removeAdmin(String edaid) {
        edAdminRepo.deleteByEduid(edaid);
        edUserCredentialRepo.deleteAdminByEduid(edaid);
        return edaid;
    }

    @Override
    public EdAdminEntity modifyAdmin(EdAdminEntity edAdminEntity, String edaid) {
        Optional<EdAdminEntity> adminEntity = edAdminRepo.findByEduid(edaid);
        if (adminEntity.isPresent()) {
            EdAdminEntity edAdminEntity1 = adminEntity.get();
            edAdminEntity1.setDob(edAdminEntity.getDob());
            edAdminEntity1.setFname(edAdminEntity.getFname());
            edAdminEntity1.setAdharNumber(edAdminEntity.getAdharNumber());
            edAdminEntity1.setName(edAdminEntity.getName());
            edAdminEntity1.setGmail(edAdminEntity.getGmail());
            edAdminEntity1.setPho(edAdminEntity.getPho());
            edAdminEntity1.setGender(edAdminEntity.getGender());
            return edAdminRepo.save(edAdminEntity1);
        }
        return null;
    }

    @Override
    public EdAdminEntity createAdmin(EdAdminEntity edAdminEntity) {
        EdAdminEntity entity = edAdminEntity;
        entity.setEdaid(getNoRow());
        EdUserCredentials userCredentials =  entity.getEdUserCredentials().iterator().next();
        userCredentials.setPassword(passwordEncoder.encode(entity.getDob().toString()));
        userCredentials.setUserName(entity.getEdaid());
        EdRolesEntity roles = userCredentials.getEdRolesModels().iterator().next();
        roles.setRoleDesc("ADMIN");
        roles.setRole("EDA");
        return edAdminRepo.save(entity);
    }

    @Override
    public EdUserCredentials getUserCredential(String userName) {
        Optional<EdUserCredentials> oneUserCredential = edUserCredentialRepo.findById(userName);
        return oneUserCredential.get();
    }

    @Override
    public List<EdUserCredentials> getAllUserCredentials() {
        List<EdUserCredentials> listOfAllUserCredentials = new ArrayList<>();
        edUserCredentialRepo.findAll().forEach(listOfAllUserCredentials::add);
        return listOfAllUserCredentials;
    }

    @Override
    public EdUserCredentials modifyUserCredentials(EdUserCredentials edUserCredentials, String userid) {
        Optional<EdUserCredentials> userCredentials = edUserCredentialRepo.findById(userid);
        if (userCredentials.isPresent()) {
            EdUserCredentials edUserCredentials1 = userCredentials.get();
            edUserCredentials1.setPassword(passwordEncoder.encode(edUserCredentials.getPassword()));
            edUserCredentials1.setEdRolesModels(edUserCredentials.getEdRolesModels());
            return edUserCredentialRepo.save(edUserCredentials1);
        }
        return null;
    }

    @Override
    public EdRolesEntity getRole(String roleName) {
        Optional<EdRolesEntity> oneRole = edRolesRepo.findById(roleName);
        return oneRole.get();
    }

    @Override
    public List<EdRolesEntity> getAllRoles() {
        List<EdRolesEntity> listOfRoll = new ArrayList<>();
        edRolesRepo.findAll().forEach(listOfRoll::add);
        return listOfRoll;
    }

    @Override
    public String removeRole(String roleName) {
        edRolesRepo.deleteById(roleName);
        return roleName;
    }

    @Override
    public EdRolesEntity createRole(EdRolesEntity edRolesEntity) {
        return edRolesRepo.save(edRolesEntity);
    }

    @Override
    public EdRolesEntity modifyRole(String roleName, EdRolesEntity edRolesModel) {
        Optional<EdRolesEntity> rolesEntity = edRolesRepo.findById(roleName);
        if (rolesEntity.isPresent()) {
            EdRolesEntity modifyRole = rolesEntity.get();
            modifyRole.setRole(edRolesModel.getRole());
            modifyRole.setRoleDesc(edRolesModel.getRoleDesc());
            return edRolesRepo.save(modifyRole);
        }
        return null;
    }

    @Override
    public String getNoRow() {
        return "EDAID"+(edAdminRepo.count()+1);
    }
}
