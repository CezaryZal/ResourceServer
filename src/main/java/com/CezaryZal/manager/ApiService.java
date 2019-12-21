package com.CezaryZal.manager;

import com.CezaryZal.entity.User;
import com.CezaryZal.entity.UserLogin;
import com.CezaryZal.manager.builder.BuilderToken;
import com.CezaryZal.manager.dbService.UserService;
import com.CezaryZal.manager.validator.Validator;
import org.springframework.stereotype.Service;

@Service
public class ApiService {

    private UserService userService;
    private Validator validator;
    private BuilderToken builderToken;

    private User foundUser;

    public ApiService(UserService userService, Validator validator, BuilderToken builderToken) {
        this.userService = userService;
        this.validator = validator;
        this.builderToken = builderToken;
    }

    public String getTokenByUserLogin(UserLogin inputUserLogin) {
        findUserByInputLogin(inputUserLogin);
        validator.setFoundUser(foundUser);
        if (validator.validInputLogin(inputUserLogin)){
            return builderToken.buildTokenByUser(foundUser);
        }
        throw new RuntimeException("Błedne hasło użytkownika");
    }

    private void findUserByInputLogin(UserLogin userLogin) {
        foundUser = userService.findByLoginName(userLogin.getLogin())
                .orElseThrow(() -> new RuntimeException("Poszukiwany użtykownik nie istnieje"));
    }

}
