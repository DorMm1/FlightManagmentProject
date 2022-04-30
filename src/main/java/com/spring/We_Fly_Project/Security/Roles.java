package com.spring.We_Fly_Project.Security;

public enum Roles {
    ADMIN(2),
    AIRLINE(1),
    CUSTOMER(0);
    
    final int role_id;
    Roles(int role_id){
        this.role_id = role_id;
    }

}
