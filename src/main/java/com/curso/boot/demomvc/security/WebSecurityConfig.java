package com.curso.boot.demomvc.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private CustomLogoutSuccessHandler logoutSuccessHandler;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/departamentos/cadastrar").hasAnyRole("ADMIN")
		.antMatchers("/cargos/cadastrar").hasAnyRole("ADMIN")
		.antMatchers("/funcionarios/cadastrar").hasAnyRole("ADMIN")
		.anyRequest().authenticated()
		.and()
			.formLogin().loginPage("/login").permitAll()
		.and()
			.logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
			.logoutSuccessHandler(logoutSuccessHandler); //para redirecionar após realizar logout no sistema;
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
			.withUser("rodrigo").password("{noop}123").roles("ADMIN")
			.and()
			.withUser("gustavo").password("{noop}123").roles("USER");
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		// TODO Auto-generated method stub
		super.configure(web);
	}
}
