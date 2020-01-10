package com.CezaryZal.config;

import com.CezaryZal.authentication.UserAppPrincipalDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private UserAppPrincipalDetailsService detailsService;
    private PasswordEncoder passwordEncoder;

    public SecurityConfig(UserAppPrincipalDetailsService userAppPrincipalDetailsService, PasswordEncoder passwordEncoder){
        this.detailsService = userAppPrincipalDetailsService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth){
        auth.authenticationProvider(authenticationProvider());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .httpBasic()
                .and()
                .authorizeRequests()
                .antMatchers("/admin/user/**").hasRole("ADMIN")
                .antMatchers("/api/**").hasAnyRole("MODERATOR", "ADMIN")
//                .antMatchers("/api/**").permitAll()
                .antMatchers("/test").permitAll()
                .antMatchers("/swagger-ui.html").permitAll()
                .and()
                .formLogin().permitAll()
                .and()
                //{default URL}/logout - spring logout from actual role
                .logout().permitAll()
                .and()
                .csrf().disable();
    }

    @Bean
    DaoAuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder);
        daoAuthenticationProvider.setUserDetailsService(detailsService);

        return daoAuthenticationProvider;
    }
}
