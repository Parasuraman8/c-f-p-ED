package com.vishnuparasu.EnforcementDirectorate.configuration;

import com.vishnuparasu.EnforcementDirectorate.jwt.EdRequestEntryPoint;
import com.vishnuparasu.EnforcementDirectorate.jwt.EdRequestFilter;
import com.vishnuparasu.EnforcementDirectorate.repository.EdUserCredentialRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity(debug = true)
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
public class EdJwtConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    EdUserCredentialRepo edUserCredentialRepo;

    @Autowired
    EdRequestEntryPoint edRequestEntryPoint;

    @Bean
    public EdRequestFilter getJwtFilter() {
        return new EdRequestFilter();
    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }


    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(username -> edUserCredentialRepo.findByuserName(username)
                .orElseThrow(() -> new UsernameNotFoundException("user "+username+" not found")));
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        return daoAuthenticationProvider;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }



    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable().exceptionHandling()
                .authenticationEntryPoint(edRequestEntryPoint).and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                .authorizeRequests().antMatchers("/ED/EdJwtController/login","/ED/UserController/createEdUser"
                        ,"/swagger-ui/**", "/swagger-resources/**", "/v2/api-docs").permitAll().anyRequest().authenticated();
        http.addFilterBefore(getJwtFilter(), UsernamePasswordAuthenticationFilter.class);
    }
}
