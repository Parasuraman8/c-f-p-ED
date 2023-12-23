package com.vishnuparasu.EnforcementDirectorate.model;

import com.vishnuparasu.EnforcementDirectorate.entity.EdRolesEntity;

import java.util.HashSet;
import java.util.Set;

public class EdLoginResponse {


    private String username;

    private Set<EdRolesEntity> edRolesEntities = new HashSet<>();

    private String jwtToken;

    public EdLoginResponse(String username, Set<EdRolesEntity> roles, String jwtToken) {
        this.username = username;
        this.edRolesEntities = roles;
        this.jwtToken = jwtToken;
    }

    public EdLoginResponse() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Set<EdRolesEntity> getEdRolesEntities() {
        return edRolesEntities;
    }

    public void setEdRolesEntities(Set<EdRolesEntity> edRolesEntities) {
        this.edRolesEntities = edRolesEntities;
    }

    public String getJwtToken() {
        return jwtToken;
    }

    public void setJwtToken(String jwtToken) {
        this.jwtToken = jwtToken;
    }
}
