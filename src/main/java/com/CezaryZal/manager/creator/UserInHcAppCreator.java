package com.CezaryZal.manager.creator;

import com.CezaryZal.entity.health.calendar.UserConnectingApps;
import com.CezaryZal.entity.health.calendar.UserToHcApp;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class UserInHcAppCreator {


    public static Long createAccountInHealthCalendarAndGetUserIdByInputUser(UserToHcApp userToHcApp, String token){

        UserConnectingApps userConnectingApps = new UserConnectingApps(userToHcApp.getLoginName(), userToHcApp.getEmail());
        HttpEntity<Object> httpEntity = HttpEntityByBodyAndToken.createHttpEntity(userConnectingApps, token);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Long> responseEntity = restTemplate.exchange(
                "http://localhost:8081/HealthCalendar/api/user/user-id/new-account",
//                "http://164.132.97.42:8080/HealthCalendar/api/user/user-id/new-account",
                HttpMethod.POST,
                httpEntity,
                Long.class);
        return responseEntity.getBody();
    }
}
