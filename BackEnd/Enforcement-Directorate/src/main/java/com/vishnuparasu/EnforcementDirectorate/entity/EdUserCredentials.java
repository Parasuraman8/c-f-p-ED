package com.vishnuparasu.EnforcementDirectorate.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
@Table(name = "ed_user_credential")
public class EdUserCredentials implements UserDetails,Serializable {

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

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        for (EdRolesEntity role : edRolesModels) {
            authorities.add(new SimpleGrantedAuthority(role.getRole()));
        }
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }


    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<EdRolesEntity> getEdRolesModels() {
        return  edRolesModels;
    }

    public void setEdRolesModels(Set<EdRolesEntity> edRolesModels) {
        this.edRolesModels = edRolesModels;
    }

    public void addEdRole(EdRolesEntity rolesEntities) {
        edRolesModels.add(rolesEntities);
    }
}
