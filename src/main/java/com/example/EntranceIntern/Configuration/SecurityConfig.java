package com.example.EntranceIntern.Configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.example.EntranceIntern.User.CustomUserDetailsService;


@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(16);
	}
	 @Autowired
    private CustomUserDetailsService uds;


    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(uds);
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }

	// @Bean
  	// public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
    // return authConfig.getAuthenticationManager();
 	// }

	private static final String[] PUBLIC_WHITELIST = {
        "/",
		"/cart",
		"/login",
		"/logout",
	};	

	private static final String[] AUTH_WHITELIST = {
        "/",
		"/cart",
		"/cart/checkout",
	};	
	private static final String[] ADMIN_WHITELIST = {
        "/",
		"/cart",
		"/cart/checkout",
		"/products/update",
		"/products/create"
	};	


	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
			// .securityMatcher("/api/**")    
			// .exceptionHandling(exception -> exception.authenticationEntryPoint(unauthorizedHandler))
        	// .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))                        
			.authorizeHttpRequests(authorize -> authorize
				.requestMatchers(PUBLIC_WHITELIST).permitAll()    
				.requestMatchers(AUTH_WHITELIST).hasAnyAuthority("ADMIN", "USER")  
				.requestMatchers(ADMIN_WHITELIST).hasAnyAuthority("ADMIN")      // cart/checkout 
				.anyRequest().authenticated()     
			// 	// .anyRequest().permitAll()  
			)
			.formLogin(formLogin -> formLogin
                .loginPage("/login")
                .loginProcessingUrl("/login")
                .defaultSuccessUrl("/")
                .failureUrl("/login?error")
				.permitAll()
            )
			.logout(logout -> logout
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/")
                        .deleteCookies("JSESSIONID")
                        .invalidateHttpSession(true)
                        .clearAuthentication(true)
                        .permitAll())


			.authenticationProvider(authenticationProvider())
			.csrf(csrf -> csrf.disable());
		return http.build();
	}

	
}