package com.vishnuparasu.EnforcementDirectorate.entity;

import javax.persistence.*;

@Entity
@Table(name = "ed_user_roles")
public class EdRolesEntity {

    @Id
    @Column(name = "role")
    private String role;

    @Column(name = "roleDesc")
    private String roleDesc;

    public EdRolesEntity() {
    }

    public EdRolesEntity(String role) {
        this.role = role;
    }


    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }


    public void add(EdRolesEntity edRolesEntity) {
        role = edRolesEntity.getRole();
        roleDesc = edRolesEntity.getRoleDesc();
    }
}
