package com.neosoft.POC2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@SuppressWarnings("deprecation")
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("pk").password("pass").roles("admin");
		auth.inMemoryAuthentication().withUser("rs").password("pass2").roles("student");
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {
//		http.cors().disable();
//		http.authorizeRequests()
//			.antMatchers("/neosoft/student/*").hasAnyRole("student")
//							.anyRequest().fullyAuthenticated().and().httpBasic();
		http.cors().disable();
		http.authorizeRequests() 

	  //.antMatchers("/neosoft/student/").hasAuthority("student")
	    .antMatchers("/neosoft/student/*").hasAnyRole("student")
							.anyRequest().fullyAuthenticated().and().httpBasic();
	}
	
	@Bean
	public static NoOpPasswordEncoder getpassword() {
		return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
	}
}
