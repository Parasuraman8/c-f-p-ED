package com.vishnuparasu.EnforcementDirectorate.entity;


import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
@Table(name = "ed_user_credential")
public class EdUserCredentials implements Serializable {

    @Id
    @Column(name = "username")
    private String userName;

    @Column(name = "password")
    private String password;

    @Column(name = "eduid")
    private String eduid;

    @Column(name = "edoid")
    private String edoid;

    @Column(name = "edaid")
    private String edaid;


    @ManyToMany
    @JoinTable(name = "ed_user_roles_credential",joinColumns = @JoinColumn(name = "user_id"),inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<EdRolesEntity> edRolesModels = new HashSet<>();


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<EdRolesEntity> getEdRolesModels() {
        return edRolesModels;
    }

    public void setEdRolesModels(Set<EdRolesEntity> edRolesModels) {
        this.edRolesModels = edRolesModels;
    }
}
