package com.CezaryZal.manager.builder;

import com.CezaryZal.entity.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class BuilderToken {

    public String buildTokenByUser(User foundUser){
        long currentTimeMillis = System.currentTimeMillis();
        String secret = "dFKYX}&[K;'{{;q";

        return Jwts
                .builder()
                .setSubject("Subject")
                .claim("name", foundUser.getLoginName())
                .claim("role", "ADMIN")
                .setIssuedAt(new Date(currentTimeMillis))
                .setExpiration(new Date(currentTimeMillis + 30000000))
                .signWith(SignatureAlgorithm.HS384, secret.getBytes())
                .compact();

    }

}
