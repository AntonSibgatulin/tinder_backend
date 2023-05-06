package ru.antonsibgatulin.tinder_backend.dto;

import com.sun.org.apache.xpath.internal.operations.Bool;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import ru.antonsibgatulin.tinder_backend.include.user.EUser;
import ru.antonsibgatulin.tinder_backend.include.user.User;


@Data
@Getter
@Setter
public class UserDTO extends DTO implements IDTO  {
    public String name;
    public String password;

    public Long timeBirth;

    public String gender;
    public String genderToShow;

    public EUser Egender;
    public EUser EgenderToShow;

    public Boolean showMe;


    public UserDTO init(){
        Egender = EUser.valueOf(gender);
        EgenderToShow = EUser.valueOf(genderToShow);

        return this;
    }


    @Override
    public boolean checkError(){

        init();

        if(super.checkError())return true;

        if(name.length()>30){
            return true;
        }
        else if(password.length()>32){
            return true;
        }else if(System.currentTimeMillis()-timeBirth<1000*60*60*24*365*18){
            return true;
        }else if(Egender == null || EgenderToShow == null){
            return true;
        }else if(showMe==null){
            return true;
        }

        return false;
    }
}
