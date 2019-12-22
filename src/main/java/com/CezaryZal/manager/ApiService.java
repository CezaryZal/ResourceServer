package com.CezaryZal.manager;

import com.CezaryZal.entity.User;
import com.CezaryZal.entity.UserLogin;
import com.CezaryZal.manager.filters.ParseInput;
import com.CezaryZal.manager.user.server.SearcherInDb;
import com.CezaryZal.manager.builder.BuilderToken;
import com.CezaryZal.manager.filters.Validator;
import org.springframework.stereotype.Service;


@Service
public class ApiService {

    private SearcherInDb searcherInDb;
    private Validator validator;
    private BuilderToken builderToken;
    private ParseInput parseInput;

    private User foundUser;

    public ApiService(SearcherInDb searcherInDb, Validator validator, BuilderToken builderToken, ParseInput parseInput) {
        this.searcherInDb = searcherInDb;
        this.validator = validator;
        this.builderToken = builderToken;
        this.parseInput = parseInput;
    }

    public String getTokenByUserLogin(UserLogin inputUserLogin) {
        handleInputUserLoginIfEmpty(inputUserLogin);
        foundUser = searcherInDb.findByLoginName(inputUserLogin.getLogin());
        handleUserByActive();
        validInputUserLogin(inputUserLogin);
        return builderToken.buildTokenByUser(foundUser);
    }

    private void handleInputUserLoginIfEmpty(UserLogin inputUserLogin){
        if (parseInput.isEmpty(inputUserLogin)) {
            throw new RuntimeException("Przesłany formularz jest pusty");
        } else if (parseInput.areToShortInputsUserLogin(inputUserLogin)){
            throw new RuntimeException("Przesłane dane użytkownika są zakrótkie");
        }
    }

    private void handleUserByActive() {
        if (!foundUser.isActive()) {
            throw new RuntimeException("Poszukiwany użytkownik nie został jeszcze aktywowany");
        }
    }

    private void validInputUserLogin(UserLogin inputUserLogin) {
        validator.setFoundUser(foundUser);
        if (!validator.validInputLogin(inputUserLogin)) {
            throw new RuntimeException("Błedne hasło użytkownika");
        }
    }

}
