package com.spring.We_Fly_Project.Security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;
import java.util.stream.Stream;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;
import static org.springframework.http.HttpStatus.FORBIDDEN;

public class CustomAuthorizationFilter extends OncePerRequestFilter {
    
    //Checking the users role with JWT + checking if valid token
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        //grants access to paths that doesnt require logging in.
        if (request.getServletPath().equals("/user/**") ||request.getServletPath().equals("/login") ) {
            filterChain.doFilter(request, response);
        } else {
            String auth_header = request.getHeader(AUTHORIZATION);
            if (auth_header != null && auth_header.startsWith("Bearer ")) {
                try {
                    String token = auth_header.substring("Bearer ".length());
                    Algorithm algorithm = Algorithm.HMAC256("Dor's-custom-cypher".getBytes());
                    JWTVerifier verifier = JWT.require(algorithm).build();
                    DecodedJWT decodedJWT = verifier.verify(token);
                    String username = decodedJWT.getSubject();
                    String[] roles = decodedJWT.getClaim("roles").asArray(String.class);
                    Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
                    Arrays.stream(roles).forEach(role -> authorities.add(new SimpleGrantedAuthority(role)));
                    UsernamePasswordAuthenticationToken authenticationToken =
                            new UsernamePasswordAuthenticationToken(username, null, authorities);
                    SecurityContextHolder.getContext().setAuthentication(authenticationToken);
                    filterChain.doFilter(request, response);
                } catch (Exception e) {
                    System.out.println("ERROR:INVALID TOKEN");
                    System.out.println(e.getMessage());
                    response.setHeader("error",e.getMessage());
                    response.sendError(FORBIDDEN.value());
                }
            } else {
                filterChain.doFilter(request, response);
            }


        }
    }
}
