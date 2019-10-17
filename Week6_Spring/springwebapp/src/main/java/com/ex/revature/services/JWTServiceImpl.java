package com.ex.revature.services;

import com.ex.revature.entities.EmployeeBean;
import com.ex.revature.entities.Role;
import io.jsonwebtoken.JwtBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.stream.Collectors;

@Service("jwtService")
@Primary
public class JWTServiceImpl implements JWTServices{

    JwtBuilder builder;

    @Autowired
    public void setBuilder(JwtBuilder jwtsBuilder) {
        this.builder = jwtsBuilder;
    }

    @Override
    public String build(EmployeeBean emp) {
        Calendar c = Calendar.getInstance();
        System.out.println(c.getTime());
        Date now = c.getTime();

        c.add(Calendar.DAY_OF_YEAR, 1);
        System.out.println(c.getTime());
        Date tom = c.getTime();
        return builder
                .setSubject(emp.getEmail())
                .setIssuedAt(now)
                .setExpiration(tom)
                .claim("name", String.format("%s %s", emp.getFirstName(), emp.getLastName()))
                .claim("roles", emp.getRoles()
                    .stream()
                        .map(role -> role.getName())
                        .collect(Collectors.toList()))
                .compact();
    }

    @Override
    public EmployeeBean verify(String token) {
        return null;
    }
}
