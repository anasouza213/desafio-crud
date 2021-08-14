package com.g3tecnologia.crud.core.infrastructure.configurations;

import com.g3tecnologia.crud.core.domain.business.users.UserModel;

public class JWTResponseToken {
    private String token;
    private UserModel user;

    public void setUser(UserModel user){
        this.user = user;
    }
    public UserModel getUser(){
        return this.user;
    }
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
