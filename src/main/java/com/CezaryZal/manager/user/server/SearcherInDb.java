package com.CezaryZal.manager.user.server;

import com.CezaryZal.entity.User;
import com.CezaryZal.manager.db.service.UserService;
import org.springframework.stereotype.Component;

@Component
public class SearcherInDb {

    private UserService userService;

    public SearcherInDb(UserService userService) {
        this.userService = userService;
    }

    public User findByLoginName(String loginName){
        return userService.findByLoginName(loginName)
                .orElseThrow(() -> new RuntimeException("Poszukiwany użtykownik nie istnieje"));
    }
}
