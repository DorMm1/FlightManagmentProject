package com.spring.We_Fly_Project.DB_Repository.POCO;


import org.springframework.context.annotation.Scope;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Component
@Scope(value = "prototype")
public class UserPOCO implements POCO, UserDetails {

    public long id;
    public String username;
    public String userpassword;
    public String email;
    public int user_role;

    public UserPOCO(long id, String username, String userpassword, String email, int user_role) {
        this.id = id;
        this.username = username;
        this.userpassword = userpassword;
        this.email = email;
        this.user_role = user_role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserPOCO)) return false;
        UserPOCO userPOCO = (UserPOCO) o;
        return id == userPOCO.id && user_role == userPOCO.user_role && Objects.equals(username, userPOCO.username) && Objects.equals(userpassword, userPOCO.userpassword) && Objects.equals(email, userPOCO.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, userpassword, email, user_role);
    }

    @Override
    public String toString() {
        return "UserPOCO{" +
                "user_id=" + id +
                ", username='" + username + '\'' +
                ", userpassword='" + userpassword + '\'' +
                ", email='" + email + '\'' +
                ", user_role_id=" + user_role +
                '}';
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<GrantedAuthority> set = new HashSet<>();
        GrantedAuthority ga = new GrantedAuthority() {
            int inside_role = user_role;
            @Override
            public String getAuthority() {
                switch (inside_role){
                    case 2:
                        return "ROLE_ADMIN";
                    case 1:
                        return "ROLE_AIRLINE";
                    default:
                        return "ROLE_CUSTOMER";
                }
            }
        };
        set.add(ga);
        return set;
    }

    @Override
    public String getPassword() {
        return this.userpassword;
    }

    @Override
    public String getUsername() {
        return this.username;
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
}
