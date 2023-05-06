package ru.antonsibgatulin.tinder_backend.include.system.result;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import ru.antonsibgatulin.tinder_backend.include.email.Email;
import ru.antonsibgatulin.tinder_backend.include.user.Profile;
import ru.antonsibgatulin.tinder_backend.include.user.TokenUser;
import ru.antonsibgatulin.tinder_backend.include.user.User;

@Data
@Getter
@Setter
@RequiredArgsConstructor
public class Response {

    private String text;
    private int code;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private User user;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Email email;


    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Profile profile;


    @JsonInclude(JsonInclude.Include.NON_NULL)
    private TokenUser tokenUser;


    public Response(String text) {
        this.text = text;
    }

    public Response(int code) {
        this.code = code;
    }

    public Response(String text, int code) {
        this.text = text;
        this.code = code;
    }

    public Response(User user) {
        code = 200;
        this.user = user;
    }

    public Response(Profile profile) {
        code = 200;
        this.profile = profile;
    }


}
