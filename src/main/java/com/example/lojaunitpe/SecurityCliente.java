package com.example.lojaunitpe;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configurable
@EnableWebSecurity
@Order(1)
public class SecurityCliente extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource dataSource;

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure (AuthenticationManagerBuilder auth) throws Exception {
		// neste metodo que vamos tratar os usuarios do banco
///////////////////////JONATA: O PROF PEDIU PARA APAGAR MAS EU VOU DEIXAR COMENTADO //////
//		auth.inMemoryuthentication().withUser ("user")
//		.password(new BCryptPasswordEncoder().encode("123")).roles("USER")
//		.and().withUser("admin")
//		.password (new BCryptPasswordEncoder()
//		.encode("admin")).roles("USER","ADMIN");
		
		auth.jdbcAuthentication().dataSource(dataSource)
		.userByUsernameQuery (
				"select email as username, senha as password, 1 as enable from cliente where email=?"
				.authoritiesByUsernameQuery(
				 "select email as username, 'cliente' as authority from cliente where email=?"
				.passwordEncoder (new BCryptPasswordEncoder ());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
///////////////////////JONATA: O PROF PEDIU PARA APAGAR MAS EU VOU DEIXAR COMENTADO //////
//		http.csrf().disable().authorizeRequests()
//		.antMatchers("/administrativo/**").hasAuthority("gerente")
//		.and().formLogin().loginPage("/login").permitAll().and().logout()
//		.logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/administrativo").and()

		http.antMatcher("/finalizar/**").authorizeRequests().anyRequest().hasAnyAuthority("cliente").and().csrf()
				.disable().formLogin().loginPage("/cliente/cadastrar").permitAll().failureUrl("/cliente/cadastrar")
				.loginProcessingUrl("/finalizar/login").defaultSuccessUrl("/finalizar").usernameParameter("username")
				.passwordParameter("password").and().logout()
				.logoutRequestMatcher(new AntPathRequestMatcher("/finalizar/logout")).logoutSuccessUrl("/").permitAll()
				.and().exceptionHandling().accessDeniedPage("/negadoCliente");
	}
}
