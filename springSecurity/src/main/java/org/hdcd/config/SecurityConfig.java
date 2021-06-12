package org.hdcd.config;

import org.hdcd.common.security.CustomAccessDeniedHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.access.AccessDeniedHandler;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		log.info("security config ...");
		
		//URL 패턴으로 접근 제한을 설정한다.
		http.authorizeRequests()
		.antMatchers("/board/list")
		.permitAll();
		
		http.authorizeRequests()
		.antMatchers("/board/register")
		.hasRole("MEMBER");
		
		http.authorizeRequests()
		.antMatchers("/notice/list")
		.permitAll();
		
		http.authorizeRequests()
		.antMatchers("/notice/register")
		.hasRole("ADMIN");
		
		//접근 거부 처리자의 URl를 지정
//		http.exceptionHandling()
//		.accessDeniedPage("/accessError");
		
		//등록한 customAceessDeniedHandler를 접근 거부 처리자로 지정한다.
		http.exceptionHandling()
		.accessDeniedHandler(accessDenied());
		
		
		
		//폼 기반 인증 기능을 사용한다.
		http.formLogin();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		//지정된 아이디와 패스워드로 로그인이 가능하도록 설정
		
		auth.inMemoryAuthentication()
		.withUser("member")
		.password("{noop}1234")
		.roles("MEMBER");
		
		auth.inMemoryAuthentication()
		.withUser("admin")
		.password("{noop}1234")
		.roles("ADMIN");
		
	}
	
	
	@Bean
	public AccessDeniedHandler accessDenied() {
		return new CustomAccessDeniedHandler();
	}
	
	
	
	
	
	
	
	
	
}
