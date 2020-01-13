package com.CezaryZal.test;

import com.CezaryZal.entity.app.AuthenticationRequest;
import com.CezaryZal.entity.health.calendar.UserConnectingApps;
import com.CezaryZal.manager.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.security.auth.login.AccountNotFoundException;
import java.util.stream.Stream;

@RestController
@RequestMapping("/test")
public class TestController {

    private LoginService loginService;

    @Autowired
    public TestController(LoginService loginService) {
        this.loginService = loginService;
    }

    @GetMapping("/connection/text")
    public ResponseEntity<String> getStringFromHcApplication(){

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.exchange(
                "http://localhost:8081/HealthCalendar/test/non/hello",
                HttpMethod.GET,
                null,
                String.class);

        Stream.of(responseEntity.getBody()).forEach(System.out::println);

        return responseEntity;
    }

    @GetMapping("/connection/token")
    public ResponseEntity<UserConnectingApps> getUserCreatorFromHcApplication() throws AccountNotFoundException {
        AuthenticationRequest authRequest1 = new AuthenticationRequest("janek", "jan525");
        String clearToken = loginService.getTokenByUserLogin(authRequest1);
        String tmpToken = "Bearer " + clearToken;

        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.add("authorization", tmpToken);
        HttpEntity<String> httpEntity = new HttpEntity<>(headers);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<UserConnectingApps> responseEntity = restTemplate.exchange(
                "http://localhost:8081/HealthCalendar/test/token/user",
                HttpMethod.GET,
                httpEntity,
                UserConnectingApps.class);

        return responseEntity;
    }

    @GetMapping("/connection/login")
    public ResponseEntity<String> getLoginFromHc(){
        UserConnectingApps tmpUser = new UserConnectingApps("Dzielny", "dziel@hh.com");
        HttpEntity<UserConnectingApps> httpEntity = new HttpEntity<>(tmpUser);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.exchange(
                "http://localhost:8081/HealthCalendar/test/non/login",
                HttpMethod.POST,
                httpEntity,
                String.class);

        return responseEntity;
    }
}
