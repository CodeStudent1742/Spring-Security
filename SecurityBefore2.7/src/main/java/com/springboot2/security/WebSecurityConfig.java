package com.springboot2.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
@Primary
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public PasswordEncoder getPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

    private UserDetailsServiceImpl userDetailsService;

    public WebSecurityConfig(UserDetailsServiceImpl userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        User userAdmin = new User("Jan",
//                getPasswordEncoder().encode("Jan123"),
//                Collections.singleton(new SimpleGrantedAuthority("ROLE_ADMIN")));
//        User userUser = new User ("Karol",
//                getPasswordEncoder().encode("Karol"),
//                Collections.singleton(new SimpleGrantedAuthority("ROLE_USER"))
//        );
//
//        auth.inMemoryAuthentication().withUser(userAdmin);
//        auth.inMemoryAuthentication().withUser(userUser);
        auth.userDetailsService(userDetailsService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests()
                .antMatchers("/forAdmin").hasRole(("ADMIN"))
                .antMatchers("/forUser").hasRole("USER")
                .and()
                .formLogin().permitAll()
                .and()
                .logout().logoutSuccessUrl("/forAll");
    }
}
