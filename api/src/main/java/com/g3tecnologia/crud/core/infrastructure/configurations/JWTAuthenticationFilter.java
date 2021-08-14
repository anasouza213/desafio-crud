package com.g3tecnologia.crud.core.infrastructure.configurations;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.g3tecnologia.crud.core.domain.business.users.UserModel;
import com.google.gson.Gson;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import com.g3tecnologia.crud.core.applications.services.userdetails.UserDetail;

import static com.g3tecnologia.crud.core.infrastructure.configurations.SecurityConstants.EXPIRATION_TIME;
import static com.g3tecnologia.crud.core.infrastructure.configurations.SecurityConstants.SECRET;

public class JWTAuthenticationFilter  extends UsernamePasswordAuthenticationFilter {
    private AuthenticationManager authenticationManager;

    public JWTAuthenticationFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;

        setRequiresAuthenticationRequestMatcher(new AntPathRequestMatcher("/auth", "POST"));
        setFilterProcessesUrl("/auth");

    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest req, HttpServletResponse res) throws AuthenticationException {
        try {
            UserModel user = new ObjectMapper()
                    .readValue(req.getInputStream(), UserModel.class);

//            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//            String password = "password";
//            String encodedPassword = passwordEncoder.encode(password);
            return authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            user.getCpf(),
                            user.getPassword(),
                            new ArrayList<>())
            );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest req, HttpServletResponse res, FilterChain chain, Authentication auth) throws IOException, ServletException {

        UserDetail user = ((UserDetail) auth.getPrincipal());
        String token = JWT.create()
                .withSubject(user.getUsername())
                .withExpiresAt(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .sign(Algorithm.HMAC512(SECRET.getBytes()));

        PrintWriter out = res.getWriter();
        res.setContentType("application/json");
        res.setCharacterEncoding("UTF-8");
        Gson gson = new Gson();
        JWTResponseToken responseToken = new JWTResponseToken();
        responseToken.setToken(token);
        responseToken.setUser(user.getUser());
        out.print(gson.toJson(responseToken));
        out.flush();
    }
}

