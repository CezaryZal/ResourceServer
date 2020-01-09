package com.CezaryZal.test;

import com.CezaryZal.entity.health.calendar.UserCreator;
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
    public ResponseEntity<UserCreator> getUserCreatorFromHcApplication(){

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<UserCreator> responseEntity = restTemplate.exchange("http://localhost:8081/HealthCalendar/test/user",
                HttpMethod.GET,
                null,
                UserCreator.class);

        Stream.of(responseEntity.getBody()).forEach(System.out::println);

        return responseEntity;
    }
}
