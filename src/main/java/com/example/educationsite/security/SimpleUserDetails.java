package com.example.educationsite.security;
import com.example.educationsite.models.UserEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

public class SimpleUserDetails implements UserDetails{
        private final UserEntity userEntity;

        public SimpleUserDetails(UserEntity userEntity) {
            this.userEntity = userEntity;
        }

        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
            return Collections.emptyList(); // No roles or permissions needed
        }

        @Override
        public String getPassword() {
            return userEntity.getPassword();
        }

        @Override
        public String getUsername() {
            return userEntity.getUsername();
        }

        @Override
        public boolean isAccountNonExpired() {
            return true; // Adjust if needed
        }

        @Override
        public boolean isAccountNonLocked() {
            return true; // Adjust if needed
        }

        @Override
        public boolean isCredentialsNonExpired() {
            return true; // Adjust if needed
        }

        @Override
        public boolean isEnabled() {
            return true; // Adjust if needed
        }
}
