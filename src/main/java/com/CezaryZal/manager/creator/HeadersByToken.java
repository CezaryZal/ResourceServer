package com.CezaryZal.manager.creator;

import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

public class HeadersByToken {

    public static MultiValueMap<String, String> createHeadersByToken(String token) {
        String authenticationToken = "Bearer " + token;
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.add("authorization", authenticationToken);

        return headers;
    }
}
