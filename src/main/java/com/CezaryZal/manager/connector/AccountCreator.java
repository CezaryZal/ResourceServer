package com.CezaryZal.manager.connector;

import com.CezaryZal.entity.health.calendar.ConnectingUser;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AccountCreator {


    public Long createAccountInHealthCalendarAndGetUserId(ConnectingUser connectingUser){
        HttpEntity<ConnectingUser> httpEntity = new HttpEntity<>(connectingUser);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Long> responseEntity = restTemplate.exchange(
                "http://localhost:8081/HealthCalendar/api/user/user-id/new-account",
                HttpMethod.POST,
                httpEntity,
                Long.class);
        return responseEntity.getBody();
    }
}
