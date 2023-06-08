package com.karabiner.securityproduct.review.securityConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig{

    @Autowired
    private UserDetailsService userDetailsService;

    private static final String[] WHITE_LIST_URLS= {
            "/",
            "/register",
            "/products",
            "/post/**",
            "/review/**"
    };

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService);
        provider.setPasswordEncoder(new BCryptPasswordEncoder());

        return provider;
    }

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {



        httpSecurity


                .csrf().ignoringAntMatchers("/register")
                .and()
                .csrf().ignoringAntMatchers("/post/**")
                .and()


                .authorizeHttpRequests()
                .antMatchers(WHITE_LIST_URLS).permitAll()

                .antMatchers(HttpMethod.POST, "/products*").permitAll()


                .antMatchers("/post*").hasAuthority("USER")
                .antMatchers("/review/**").hasAuthority("USER")
                .antMatchers("/review/count/productId/").hasAuthority("USER")

                .anyRequest().authenticated()
                .and()
                .httpBasic();


        return httpSecurity.build();

    }

}
