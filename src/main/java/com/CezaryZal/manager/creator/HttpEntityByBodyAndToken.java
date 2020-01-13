package com.CezaryZal.manager.creator;

import org.springframework.http.HttpEntity;
import org.springframework.util.MultiValueMap;

public class HttpEntityByBodyAndToken {

    public static HttpEntity<Object> createHttpEntity (Object body, String clearToken){
        MultiValueMap<String, String> headers = HeadersByToken.createHeadersByToken(clearToken);
        return new HttpEntity<>(body, headers);
    }
}
