package com.CezaryZal.manager.builder;

import com.CezaryZal.constants.SecurityConstants;
import com.CezaryZal.entity.health.calendar.UserAuthentication;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TokenBuilder {

    public String buildTokenByUser(UserAuthentication userAuthentication){
        String secret = SecurityConstants.SECRET_KEY;

        return Jwts
                .builder()
                .setSubject(SecurityConstants.TOKEN_SUBJECT)
                .setIssuer(SecurityConstants.TOKEN_ISSUER)
                .setAudience(SecurityConstants.TOKEN_AUDIENCE)
                .claim(SecurityConstants.NAME_KEY, userAuthentication.getLoginName())
                .claim(SecurityConstants.ROLES_KEY, SecurityConstants.TOKEN_PREFIX_ROLE + userAuthentication.getRoles())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + SecurityConstants.JWT_EXPIRE_IN_MILLISECOND))
                .signWith(SignatureAlgorithm.HS384, secret.getBytes())
                .compact();

    }

}
