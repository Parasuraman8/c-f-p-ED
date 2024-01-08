package com.vishnuparasu.EnforcementDirectorate.service;

import com.vishnuparasu.EnforcementDirectorate.entity.EdAdminEntity;
import com.vishnuparasu.EnforcementDirectorate.entity.EdRolesEntity;
import com.vishnuparasu.EnforcementDirectorate.entity.EdUserCredentials;

import java.util.List;

public interface EdAdminService {

    EdAdminEntity getAdmin(String edaid);

    List<EdAdminEntity> getAllAdmin();

    String removeAdmin(String edaid);

    EdAdminEntity modifyAdmin(EdAdminEntity edAdminEntity, String edaid);

    EdAdminEntity createAdmin(EdAdminEntity edAdminEntity);

    EdUserCredentials getUserCredential(String userid);

    List<EdUserCredentials> getAllUserCredentials();

    EdUserCredentials modifyUserCredentials(EdUserCredentials edUserCredentials, String userid);

    EdRolesEntity getRole(String roleName);

    List<EdRolesEntity> getAllRoles();

    String removeRole(String roleName);

    EdRolesEntity createRole(EdRolesEntity edRolesEntity);

    EdRolesEntity modifyRole(String roleName, EdRolesEntity edRolesEntity);

    long getNoRow();

}
