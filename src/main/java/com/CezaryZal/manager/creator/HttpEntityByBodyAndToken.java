package com.CezaryZal.manager.creator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;

@Service
public class HttpEntityByBodyAndToken {

    private HeadersByToken headersByToken;

    @Autowired
    public HttpEntityByBodyAndToken(HeadersByToken headersByToken) {
        this.headersByToken = headersByToken;
    }

    public HttpEntity<Object> createHttpEntity (Object body, String clearToken){
        MultiValueMap<String, String> headers = headersByToken.createHeadersByToken(clearToken);
        return new HttpEntity<>(body, headers);
    }
}
