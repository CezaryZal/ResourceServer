package com.CezaryZal.test;

import com.CezaryZal.entity.health.calendar.ConnectingUser;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.stream.Stream;

@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("/connection/text")
    public ResponseEntity<String> getStringFromHcApplication(){

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.exchange("http://localhost:8081/HealthCalendar/test/hello",
                HttpMethod.GET,
                null,
                String.class);

        Stream.of(responseEntity.getBody()).forEach(System.out::println);

        return responseEntity;
    }

    @GetMapping("/connection/object")
    public ResponseEntity<ConnectingUser> getUserCreatorFromHcApplication(){

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<ConnectingUser> responseEntity = restTemplate.exchange(
                "http://localhost:8081/HealthCalendar/test/user",
                HttpMethod.GET,
                null,
                ConnectingUser.class);

        return responseEntity;
    }

    @GetMapping("/connection/login")
    public ResponseEntity<String> getLoginFromHc(){
        ConnectingUser tmpUser = new ConnectingUser("Dzielny", "dziel@hh.com");
        HttpEntity<ConnectingUser> httpEntity = new HttpEntity<>(tmpUser);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.exchange(
                "http://localhost:8081/HealthCalendar/test/get/login",
                HttpMethod.POST,
                httpEntity,
                String.class);

        return responseEntity;
    }
}
