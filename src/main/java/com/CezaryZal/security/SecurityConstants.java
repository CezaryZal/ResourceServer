package com.CezaryZal.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SecurityConstants {

    public static final String TOKEN_SUBJECT = "Subject";
    public static final String TOKEN_ISSUER = "secure-api";
    public static final String TOKEN_AUDIENCE = "secure-app";
    public static final String NAME_KEY = "name";
    public static final String ROLES_KEY = "roles";
    public static final String TOKEN_PREFIX_ROLE = "ROLE_";
    public static String SECRET_KEY;
    public static Long JWT_EXPIRE_IN_MILLISECOND;

    public SecurityConstants() {
    }

    @Value("${authorization.jwt.token.expire.time.in.millisecond}")
    private void setJwtExpireInMinutes(Long jwtExpireInMinutes) {
        JWT_EXPIRE_IN_MILLISECOND = jwtExpireInMinutes;
    }


    @Value("${authorization.jwt.secret.key}")
    private void setSecretKey(String secretKey) {
        SECRET_KEY = secretKey;
    }
}
