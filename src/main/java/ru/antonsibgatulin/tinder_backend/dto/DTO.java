package ru.antonsibgatulin.tinder_backend.dto;

import lombok.Data;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;


public abstract class DTO  {
    @NonNull
    public String token;



    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public boolean checkError(){
        if(token == null){
            return true;
        }
        return false;
    }
}
