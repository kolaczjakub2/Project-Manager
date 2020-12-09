//package com.secondtonone.jk.jiraclone.infrastrure.config.security;
//
//
//import com.secondtonone.jk.jiraclone.infrastrure.config.auth.ApplicationUserService;
//import com.secondtonone.jk.jiraclone.infrastrure.config.jwt.JwtConfig;
//import com.secondtonone.jk.jiraclone.infrastrure.config.jwt.JwtTokenVerifier;
//import com.secondtonone.jk.jiraclone.infrastrure.config.jwt.JwtUsernamePasswordAuthenticationFilter;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.web.cors.CorsConfiguration;
//
//import javax.crypto.SecretKey;
//
//
//@Configuration
//@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
//public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {
//
//    private final PasswordEncoder passwordEncoder;
//    private final ApplicationUserService applicationUserService;
//    private final SecretKey secretKey;
//    private final JwtConfig jwtConfig;
//
//    @Autowired
//    public ApplicationSecurityConfig(PasswordEncoder passwordEncoder, ApplicationUserService applicationUserService, SecretKey secretKey, JwtConfig jwtConfig) {
//        this.passwordEncoder = passwordEncoder;
//        this.applicationUserService = applicationUserService;
//        this.secretKey = secretKey;
//        this.jwtConfig = jwtConfig;
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//
//                http
//                .authorizeRequests()
//                .antMatchers("/**").permitAll();
////        http
////                .csrf().disable()
////                .sessionManagement()
////                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
////                .and()
////                .addFilter(new JwtUsernamePasswordAuthenticationFilter(authenticationManager(), jwtConfig, secretKey))
////                .addFilterAfter(new JwtTokenVerifier(secretKey, jwtConfig), JwtUsernamePasswordAuthenticationFilter.class)
////                .authorizeRequests()
////                .antMatchers("/", "index", "/css/*", "/js/*").permitAll()
////                .anyRequest()
////                .authenticated();
////
////        http.cors().configurationSource(request -> new CorsConfiguration().applyPermitDefaultValues());
//
//    }
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.authenticationProvider(daoAuthenticationProvider());
//    }
//
//    @Bean
//    public DaoAuthenticationProvider daoAuthenticationProvider() {
//        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
//        provider.setPasswordEncoder(passwordEncoder);
//        provider.setUserDetailsService(applicationUserService);
//        return provider;
//    }
//}
