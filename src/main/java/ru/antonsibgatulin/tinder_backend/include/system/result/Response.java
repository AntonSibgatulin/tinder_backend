package ru.antonsibgatulin.tinder_backend.include.system.result;

import com.fasterxml.jackson.annotation.JsonInclude;
import ru.antonsibgatulin.tinder_backend.include.target.Target;
import ru.antonsibgatulin.tinder_backend.include.user.User;

public class Response {

    private String text;
    private int code;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private User user;

    public Response() {
    }

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
}
