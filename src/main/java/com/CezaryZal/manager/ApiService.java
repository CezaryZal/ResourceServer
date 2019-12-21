package com.CezaryZal.manager;

import com.CezaryZal.entity.User;
import com.CezaryZal.entity.UserLogin;
import com.CezaryZal.manager.dbService.UserService;
import com.CezaryZal.manager.validator.Validator;
import org.springframework.stereotype.Service;

@Service
public class ApiService {

    private UserService userService;
    private Validator validator;

    private User foundUser;

    public ApiService(UserService userService, Validator validator) {
        this.userService = userService;
        this.validator = validator;
    }

    public User getTokenByUserLogin(UserLogin inputUserLogin) {
        findUserByInputLogin(inputUserLogin);
        validator.setFoundUser(foundUser);
        if (validator.validInputLogin(inputUserLogin)){
            return foundUser;
        }
        throw new RuntimeException("Błedne hasło użytkownika");
    }

    private void findUserByInputLogin(UserLogin userLogin) {
        foundUser = userService.findByLoginName(userLogin.getLogin())
                .orElseThrow(() -> new RuntimeException("Poszukiwany użtykownik nie istnieje"));
    }

}
