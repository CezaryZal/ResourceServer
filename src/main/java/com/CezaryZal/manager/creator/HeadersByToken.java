package com.CezaryZal.manager.creator;

import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

@Service
public class HeadersByToken {

    public MultiValueMap<String, String> createHeadersByToken(String token) {
        String authenticationToken = "Bearer " + token;
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.add("authorization", authenticationToken);

        return headers;
    }
}
