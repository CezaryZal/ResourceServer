package com.CezaryZal.manager;

import com.CezaryZal.entity.User;
import com.CezaryZal.entity.UserLogin;
import com.CezaryZal.manager.ServerUser.SearcherInDb;
import com.CezaryZal.manager.builder.BuilderToken;
import com.CezaryZal.manager.db.service.UserService;
import com.CezaryZal.manager.filters.Validator;
import org.springframework.stereotype.Service;


@Service
public class ApiService {

    private SearcherInDb searcherInDb;
    private Validator validator;
    private BuilderToken builderToken;

    private User foundUser;

    public ApiService(SearcherInDb searcherInDb, Validator validator, BuilderToken builderToken) {
        this.searcherInDb = searcherInDb;
        this.validator = validator;
        this.builderToken = builderToken;
    }

    public String getTokenByUserLogin(UserLogin inputUserLogin) {
        foundUser = searcherInDb.findByLoginName(inputUserLogin.getLogin());
        handleUserByActive();
        validator.setFoundUser(this.foundUser);
        if (validator.validInputLogin(inputUserLogin)){
            return builderToken.buildTokenByUser(this.foundUser);
        }
        throw new RuntimeException("Błedne hasło użytkownika");
    }

    private void handleUserByActive(){
        if (!foundUser.isActive()){
            throw new RuntimeException("Przesłany formularz jest pusty");
        }
    }

}
