package ru.antonsibgatulin.tinder_backend.include.system.result;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import ru.antonsibgatulin.tinder_backend.include.email.Email;
import ru.antonsibgatulin.tinder_backend.include.user.Profile;
import ru.antonsibgatulin.tinder_backend.include.user.User;


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

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Email getEmail() {
        return email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }
}
