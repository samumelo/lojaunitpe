package com.example.lojaunitpe;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configurable
@EnableWebSecurity

public class BasicConfiguration extends WebSecurityConfigurerAdapter	{

	@Autowired
	private DataSource dataSource;
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder () {
		return new BCryptPasswordEncoder ();
	}
	
	@Override
	protected void configure (AuthenticationManagerBuilder auth) throws Exception {
		// neste metodo que vamos tratar os usuarios do banco
		auth.inMemoryuthentication().withUser ("user")
		.password(new BCryptPasswordEncoder().encode("123")).roles("USER")
		.and().withUser("admin")
		.password (new BCryptPasswordEncoder()
		.encode("admin")).roles("USER","ADMIN");
		
		auth.jdbcAuthentication().dataSource(dataSource)
		.userByUsernameQuery (
				"select email as username, senha as password, 1 as enable from funcionario where email=?"
				.authoritiesByUsernameQuery(
				 "select funcionario.email as username, papel.nome as authority from permissoes inner join funcionario.id=permissoes.funcionario_id inner join papel on permissoes.papel_id=papel.id where funcionario.email=?"
				.passwordEncoder (new BCryptPasswordEncoder ());
	}
	
	@Override
	protected void configure (HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests()
		.antMatchers("/administrativo/**").hasAuthority("gerente")
		.and().formLogin().loginPage("/login").permitAll().and().logout()
		.logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/administrativo").and()
	
	} 
}
