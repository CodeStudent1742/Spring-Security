package com.security.up2_7;

import org.springframework.context.annotation.Configuration;

// CONFIG FOR SPRING BOOT < 2.7
@Configuration
public class SpringSecurityConfig {//extends WebSecurityConfigurerAdapter {

//    @Bean
//    public PasswordEncoder getBcryptPasswordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//
//        User user = new User("Jan",
//                getBcryptPasswordEncoder().encode("jan123"),
//                Collections.singleton(new SimpleGrantedAuthority("ROLE_USER")));
//        User admin = new User("admin",
//                getBcryptPasswordEncoder().encode("admin123"),
//                Collections.singleton(new SimpleGrantedAuthority("ROLE_ADMIN")));
//
//        auth.inMemoryAuthentication().withUser(user);
//        auth.inMemoryAuthentication().withUser(admin);
//
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//                .antMatchers("/for-user").hasAnyRole("USER", "ADMIN")
//                .antMatchers("/for-admin").hasAuthority("ROLE_ADMIN")
//                .and()
//                .formLogin().permitAll()
//                .and()
//                .logout().logoutUrl("/bye");
//
//    }
}