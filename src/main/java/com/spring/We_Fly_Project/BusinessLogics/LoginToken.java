package com.spring.We_Fly_Project.BusinessLogics;


import com.spring.We_Fly_Project.DB_Repository.POCO.UserPOCO;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "prototype")
public class LoginToken {
   long id;
   String name;
   String role;
   UserPOCO myself;

    public LoginToken(UserPOCO userPOCO) {
        this.myself = userPOCO;
        this.load_myself_data(userPOCO);
    }
    private void load_myself_data(UserPOCO userPOCO){
        this.name = userPOCO.username;
        this.id = userPOCO.id;
        switch (userPOCO.user_role){
            case 0:
                this.role = "customer";
            case 1:
                this.role = "airline_company";
                break;
            case 2:
                this.role = "admin";
                break;
        }
    }

    public UserPOCO getMyself() {
        return myself;
    }
}
