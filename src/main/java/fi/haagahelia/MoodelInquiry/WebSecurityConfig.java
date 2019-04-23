package fi.haagahelia.MoodelInquiry;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import fi.haagahelia.MoodelInquiry.web.UserDetailServiceImpl;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	@Autowired
	private UserDetailServiceImpl userDetailsService;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
			http.csrf().disable().cors()
		.and()
			.authorizeRequests()
			.antMatchers("/login").permitAll()
			.anyRequest().authenticated()
		.and()
			.formLogin()
			.loginPage("/login")
			.defaultSuccessUrl("/questionList")
			.permitAll()
		.and()
			.logout()
			.permitAll();; 
		}

	@Bean
	CorsConfigurationSource corsConfigurationSource() {
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		CorsConfiguration config = new CorsConfiguration();
			config.setAllowedOrigins(Arrays.asList("*"));
			config.setAllowedMethods(Arrays.asList("*"));
			config.setAllowedHeaders(Arrays.asList("*"));
			config.setAllowCredentials(true);
		config.applyPermitDefaultValues();
		
		source.registerCorsConfiguration("/**", config);
		return source;
	}
	
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
    }
}
