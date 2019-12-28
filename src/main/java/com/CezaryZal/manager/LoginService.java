package com.CezaryZal.manager;

import com.CezaryZal.entity.User;
import com.CezaryZal.entity.UserLogin;
import com.CezaryZal.exceptions.IncorrectInput;
import com.CezaryZal.manager.db.service.UserServiceImp;
import com.CezaryZal.manager.builder.TokenBuilder;
import com.CezaryZal.manager.filters.comparator.PasswordComparator;
import com.CezaryZal.manager.filters.validator.UserLoginValidatorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.security.auth.login.AccountNotFoundException;


@Service
public class LoginService {

    private UserServiceImp userServiceImp;
    private TokenBuilder tokenBuilder;
    private UserLoginValidatorService userLoginValidator;
    private PasswordComparator passwordComparator;

    public LoginService(UserServiceImp userServiceImp, TokenBuilder tokenBuilder,
                        UserLoginValidatorService userLoginValidator, PasswordComparator passwordComparator) {
        this.userServiceImp = userServiceImp;
        this.tokenBuilder = tokenBuilder;
        this.userLoginValidator = userLoginValidator;
        this.passwordComparator = passwordComparator;
    }

    public ResponseEntity<String> getTokenByUserLogin(UserLogin inputUserLogin) {
        String massage = "";
        HttpStatus status = HttpStatus.OK;

        try {
            handleUserLogin(inputUserLogin);
            User foundUser = userServiceImp.findByLoginName(inputUserLogin.getLogin());
            handleUserByActive(foundUser);
            passwordComparator.isEqualsPassword(inputUserLogin.getPassword(), foundUser.getPassword());

            massage = tokenBuilder.buildTokenByUser(foundUser);
        } catch (IncorrectInput wrongInput){
            massage = wrongInput.getMessage();
            status = HttpStatus.EXPECTATION_FAILED;
        } catch (Exception exception) {
            massage = exception.getMessage();
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<>(massage, status);
    }

    private void handleUserLogin(UserLogin inputUserLogin) {
        userLoginValidator.isCorrectUserLogin(inputUserLogin);
    }

    private void handleUserByActive(User foundUser) throws AccountNotFoundException {
        if (!foundUser.isActive()) {
            throw new AccountNotFoundException("The requested user has not been activated");
        }
    }

}
