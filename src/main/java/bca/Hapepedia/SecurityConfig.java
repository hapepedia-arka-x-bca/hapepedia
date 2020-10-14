package bca.Hapepedia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.access.channel.ChannelProcessingFilter;

import bca.Hapepedia.services.AdminService;
import bca.Hapepedia.services.CustomerService;


@EnableWebSecurity
@Configuration
public class SecurityConfig  extends WebSecurityConfigurerAdapter{

	@Autowired
	private AdminService adminService;

	@Autowired
	private CustomerService customerService;
	
	@Autowired
	public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception{
		auth.userDetailsService(adminService);
		auth.userDetailsService(customerService);
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http.addFilterBefore(new CorsConfig(), ChannelProcessingFilter.class);
		
		http.authorizeRequests()
			//.antMatchers("/**").permitAll()
			.antMatchers(HttpMethod.POST, "/api/admin/login").permitAll()
			.antMatchers(HttpMethod.POST, "/api/customer/login").permitAll()
			.antMatchers(HttpMethod.POST, "/api/customer/registration").permitAll()
			.antMatchers(HttpMethod.GET, "/api/customer/").hasAnyAuthority("USER, ADMIN")
			.antMatchers(HttpMethod.GET, "/api/**").authenticated()
			.antMatchers(HttpMethod.POST, "/api/**").authenticated()
			.antMatchers("/actuator/**").permitAll()
			.anyRequest().permitAll()
			.and().httpBasic()
			.and().csrf().disable();
	}
	
	@SuppressWarnings("deprecation")
	@Bean
	public static NoOpPasswordEncoder passwordEncoder() {
		return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
	}
	
}
