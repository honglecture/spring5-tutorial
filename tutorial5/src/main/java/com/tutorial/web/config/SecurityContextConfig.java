package com.tutorial.web.config;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity // 이 어노테이션으로 시큐리티 활성화
public class SecurityContextConfig extends WebSecurityConfigurerAdapter  {

	@Autowired
	private BasicDataSource dataSource;

	@Autowired
	private UserDetailsService userDetailsService;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.headers()
			.frameOptions()
			.sameOrigin()
			.and()
		.csrf().disable()
		.authorizeRequests() // 인터셉터 설정
			.antMatchers("/*/admin/**").authenticated() //이 요청은 인증을 해야해
			.anyRequest().permitAll() // 나머지는 권한이 필요없어
			.and()
		.formLogin() //폼을 이용해서 로그인
			.defaultSuccessUrl("/index")
			.loginPage("/member/login") // 내가 만든 login page
			.loginProcessingUrl("/member/login") //로그인 처리 url
		.and()
		.logout() //로그아웃 설정
			.logoutUrl("/member/logout")
			.logoutSuccessUrl("/index");
	}
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		// 3. jdbc : dao를 이용한 사용자 정보
		auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder()); // 패스워드 인코딩 방식
		
		// 2. jdbc : query를 직접 사용한 사용자 정보
/*		auth.jdbcAuthentication()
		.dataSource(dataSource)
		.usersByUsernameQuery("select id, pwd password, 1 enabled from Member where id=?") // 사용자 쿼리
		.authoritiesByUsernameQuery("select memberId id, roleName authority  from MemberRole where memberId=?") //권한 테이블 쿼리
		.passwordEncoder(new BCryptPasswordEncoder()); // 패스워드 인코딩 방식
*/
		
	}
	
}