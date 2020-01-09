package com.CezaryZal.authentication;

import com.CezaryZal.entity.app.UserApp;
import com.CezaryZal.manager.modifier.entity.ContainersCreatorOfUserHcAuth;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class UserAppPrincipal implements UserDetails {

    private UserApp userApp;

    public UserAppPrincipal(UserApp userApp) {
        this.userApp = userApp;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        ContainersCreatorOfUserHcAuth containersCreatorOfUserHcAuth = new ContainersCreatorOfUserHcAuth();
        List<GrantedAuthority> authorities = new ArrayList<>();

        // Extract list of roles (ROLE_name)
        String roles = userApp.getRoles();
        containersCreatorOfUserHcAuth.getRoleList(roles).forEach(r -> {
            GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" + r);
            authorities.add(authority);
        });

        return authorities;
    }

    @Override
    public String getPassword() {
        return userApp.getPassword();
    }

    @Override
    public String getUsername() {
        return userApp.getLoginName();
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
