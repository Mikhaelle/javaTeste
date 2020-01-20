
package com.user.APIUser.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;	
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.user.APIUser.models.Users;
import com.user.APIUser.repository.EmailRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;


@Component
public class CustomUserDetail implements UserDetailsService {
    private final EmailRepository emailRepository;

    @Autowired
    public CustomUserDetail(EmailRepository emailRepository) {
        this.emailRepository = emailRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Users user = Optional.ofNullable(emailRepository.findByEmail(email))
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        List<GrantedAuthority> authorityListAdmin = AuthorityUtils.createAuthorityList("ROLE_USER", "ROLE_ADMIN");
        List<GrantedAuthority> authorityListUser = AuthorityUtils.createAuthorityList("ROLE_USER");
        return new org.springframework.security.core.userdetails.User
                (user.getEmail(), user.getSenha(), user.isPerfil() ? authorityListAdmin : authorityListUser);

        
        //add
    }
}
