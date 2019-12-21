package com.CezaryZal.manager.validator;

import com.CezaryZal.entity.User;
import com.CezaryZal.entity.UserLogin;
import com.CezaryZal.manager.dbService.UserService;
import org.springframework.stereotype.Component;

@Component
public class Validator {

    private UserService userService;

    public Validator(UserService userService) {
        this.userService = userService;
    }

    public User findUserByInputLogin(UserLogin userLogin){
        User foundUser = userService.findByLoginName(userLogin.getLogin())
                .orElseThrow(() -> new RuntimeException("Poszukiwany użtykownik nie istnieje"));
        if (foundUser.getPassword().equals(userLogin.getPassword())){
            return foundUser;
        }
        throw new RuntimeException("Błedne hasło użytkownika");

    }

}
