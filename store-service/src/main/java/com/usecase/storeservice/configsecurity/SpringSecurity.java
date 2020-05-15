//
//package com.usecase.storeservice.configsecurity;
//
//
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.factory.PasswordEncoderFactories;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//
//@Configuration
//@EnableWebSecurity
//public class SpringSecurity extends WebSecurityConfigurerAdapter {
//	
//	@Override
//	public void configure(AuthenticationManagerBuilder auth) throws Exception {
//		PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
//        auth.inMemoryAuthentication()
//          .withUser("admin")
//          .password(encoder.encode("password"))
//          .roles("ADMIN");
//	}
//	@Override
//	public void configure(HttpSecurity http) throws Exception {
//		http
//		.httpBasic()
//        .and()
//        .authorizeRequests()
//        .antMatchers("/store-service/**").hasRole("USER")
//       // .antMatchers("/**").permitAll()
//		.anyRequest().hasAnyRole("USER","ADMIN");
//				
//	}
//}
//
//
//
//
//
//
//
//
//
