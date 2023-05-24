package lt.codeacademy.learn.universitysecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import static lt.codeacademy.learn.universitysecurity.Roles.*;

@Configuration
@EnableWebSecurity
public class SecSecurityConfig {
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http
		.authorizeRequests()
		.antMatchers("/student/**").hasAnyRole(STUDENT, ADMIN)
		.antMatchers("/teacher/**").hasAnyRole(TEACHER, ADMIN)
		.antMatchers("/**").permitAll()
		 .and().formLogin();
		return http.build();
	}

	@Bean
	public InMemoryUserDetailsManager userDetailsService() {
		UserDetails admin = User.withUsername("admin").password(passwordEncoder().encode("admin")).roles(ADMIN).build();
		UserDetails student = User.withUsername("student").password(passwordEncoder().encode("student")).roles(STUDENT).build();
		UserDetails teacher = User.withUsername("teacher").password(passwordEncoder().encode("teacher")).roles(TEACHER).build();

		return new InMemoryUserDetailsManager(admin,student,teacher);
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}