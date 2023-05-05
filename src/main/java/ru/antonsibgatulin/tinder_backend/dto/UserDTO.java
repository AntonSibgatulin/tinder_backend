package ru.antonsibgatulin.tinder_backend.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import ru.antonsibgatulin.tinder_backend.include.user.EUser;
import ru.antonsibgatulin.tinder_backend.include.user.User;


@Data
@Getter
@Setter
public class UserDTO  {
    public String name;
    public String password;

    public Long timeBirth;

    public String gender;
    public String genderToShow;

    public EUser Egender;
    public EUser EgenderToShow;

    public boolean showMe;

    public String email;

    public UserDTO init(){
        Egender = EUser.valueOf(gender);
        EgenderToShow = EUser.valueOf(genderToShow);

        return this;
    }
}
