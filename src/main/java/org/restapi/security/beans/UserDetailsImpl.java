package org.restapi.security.beans;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class UserDetailsImpl implements UserDetails {
    private Integer systemUserId;
    private String username;
    private String password;
    private Collection<? extends GrantedAuthority> roles;
    private String status;


    public UserDetailsImpl(String password, String username, Integer systemUserId, String status, String roles) {
        this.password = password;
        this.username = username;
        this.systemUserId = systemUserId;
        this.status = status;
        this.roles = List.of(new SimpleGrantedAuthority(roles));
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }


    @Override
    public boolean isAccountNonExpired() {
        return !status.equals("E");
    }

    @Override
    public boolean isAccountNonLocked() {
        return !status.equals("L");
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return !status.equals("E");
    }

    @Override
    public boolean isEnabled() {
        return status.equals("A");
    }
}
