package com.CezaryZal.manager.builder;

import com.CezaryZal.config.SecurityConstants;
import com.CezaryZal.entity.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class TokenBuilder {

    public String buildTokenByUser(User foundUser){
        long currentTimeMillis = System.currentTimeMillis();
        String secret = SecurityConstants.SECRET_KEY;

        return Jwts
                .builder()
                .setSubject(SecurityConstants.TOKEN_SUBJECT)
                .setIssuer(SecurityConstants.TOKEN_ISSUER)
                .setAudience(SecurityConstants.TOKEN_AUDIENCE)
                .claim(SecurityConstants.NAME_KEY, foundUser.getLoginName())
                .claim(SecurityConstants.ROLES_KEY, SecurityConstants.TOKEN_PREFIX_ROLE + foundUser.getRoles())
                .setIssuedAt(new Date(currentTimeMillis))
                .setExpiration(new Date(currentTimeMillis + SecurityConstants.JWT_EXPIRE_IN_MILLISECOND))
                .signWith(SignatureAlgorithm.HS384, secret.getBytes())
                .compact();

    }

}
