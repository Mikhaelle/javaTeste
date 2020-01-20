package com.user.APIUser.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.user.APIUser.service.CustomUserDetail;

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class security extends WebSecurityConfigurerAdapter {
	@Autowired
	private CustomUserDetail customUserDetail;
	@Override
	protected void configure(HttpSecurity http) throws Exception{
        http.authorizeRequests()
        .anyRequest()
        .authenticated()
        .and()
        .httpBasic()
        .and()
        .csrf().disable();

	}
	@Autowired
	public void configureGlobal (AuthenticationManagerBuilder auth) throws Exception {

        auth.userDetailsService(customUserDetail).passwordEncoder(new BCryptPasswordEncoder());
		//auth.userDetailsService(customUserDetail).passwordEncoder(new BCryptPasswordEncoder());
	    /*  auth.inMemoryAuthentication()
          .withUser("user").password("{noop}user123").roles("USER")
          .and()
          .withUser("admin").password("{noop}adm123").roles("ADMIN");*/

}

	
	
}
