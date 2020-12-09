//package com.secondtonone.jk.jiraclone.infrastrure.config.jwt;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import io.jsonwebtoken.Jwts;
//import org.apache.commons.lang3.time.DateUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
//import javax.crypto.SecretKey;
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.util.Date;
//
//public class JwtUsernamePasswordAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
//
//    private final AuthenticationManager authenticationManager;
//    private final JwtConfig jwtConfig;
//    private final SecretKey secretKey;
//
//    @Autowired
//    public JwtUsernamePasswordAuthenticationFilter(AuthenticationManager authenticationManager, JwtConfig jwtConfig, SecretKey secretKey) {
//        this.authenticationManager = authenticationManager;
//        this.jwtConfig = jwtConfig;
//        this.secretKey = secretKey;
//    }
//
//    @Override
//    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
//
//        try {
//            UsernameAndPasswordAuthenticationRequest authenticationRequest = new ObjectMapper()
//                    .readValue(request.getInputStream(), UsernameAndPasswordAuthenticationRequest.class);
//            Authentication authentication = new UsernamePasswordAuthenticationToken(
//                    authenticationRequest.getUsername(),
//                    authenticationRequest.getPassword()
//            );
//
//            return authenticationManager.authenticate(authentication);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    @Override
//    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
//        Date targetTime = new Date(); //now
//        targetTime = DateUtils.addMinutes(targetTime, jwtConfig.getTokenExpirationAfterMinutes()); //add minute
//        String token = Jwts.builder()
//                .setSubject(authResult.getName())
//                .claim("authorities", authResult.getAuthorities())
//                .setIssuedAt(new Date())
//                .setExpiration(targetTime)
//                .signWith(secretKey)
//                .compact();
//
//        response.addHeader(jwtConfig.getAuthorizationHeader(), jwtConfig.getTokenPrefix() + " " + token);
//        response.addHeader("Access-Control-Allow-Headers", "Authorization, x-xsrf-token, Access-Control-Allow-Headers, Origin, Accept, X-Requested-With, " +
//                "Content-Type, Access-Control-Request-Method, Access-Control-Request-Headers");
//        response.addHeader("access-control-expose-headers", "Authorization");
//    }
//}
