package com.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.config.filter.JwtRequestFilter;

@Configuration
@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
public class AuthN extends WebSecurityConfigurerAdapter{
	
	@Autowired 
	private SpringUserDetails userDetails;
	
	@Autowired
	private JwtRequestFilter jwtRequestFilter;
	
	/*
	 * @Bean public PasswordEncoder encoder() { return new BCryptPasswordEncoder();
	 * }
	 */
	
	@SuppressWarnings("deprecation")
	@Bean
	public PasswordEncoder encoder() {
		return  NoOpPasswordEncoder.getInstance();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		/* auth.userDetailsService(userDetails).passwordEncoder(encoder());*/
		auth.userDetailsService(userDetails);		
	}
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		/*
		 * http.formLogin() .loginPage("/login") .successHandler(successHandler())
		 * .permitAll();
		 */
		/*
		 * http .authorizeRequests() .antMatchers("/login*") .permitAll() .anyRequest()
		 * .authenticated() .and() .formLogin();
		 */	
	  http.csrf().disable().authorizeRequests().antMatchers("/login","/authN").permitAll().anyRequest().authenticated().and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS); 
	  http.addFilterBefore(jwtRequestFilter,UsernamePasswordAuthenticationFilter.class);
	}
	 
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring();
	}
	
	
	  @Bean
	  @Override public AuthenticationManager authenticationManagerBean() throws
	  Exception { return super.authenticationManagerBean(); }
	 
	
	/*
	 * @Bean public AuthenticationSuccessHandler successHandler() { return new
	 * MyCustomLoginSuccessHandler("/login"); }
	 */
}
