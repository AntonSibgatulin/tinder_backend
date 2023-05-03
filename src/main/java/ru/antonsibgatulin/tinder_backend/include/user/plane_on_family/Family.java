package ru.antonsibgatulin.tinder_backend.include.user.plane_on_family;

import ru.antonsibgatulin.tinder_backend.include.user.IMainInformation;
import ru.antonsibgatulin.tinder_backend.include.user.education.Education;

public enum Family implements IMainInformation {
    I_WANT_KID(0,"Я хочу детей"),
    I_DO_NOT_WANT_KID(1,"Я не хочу детей"),
    I_HAVEA_KID_AND_WANT_KID(2,"У меня есть дети,и я хочу ещё"),
    I_HAVE_A_KID_AND_I_DO_NOT_WANT_KID(3,"У меня есть дети,но больше не хочу"),
    UNTILL_DO_NOT_KNOW(4,"Пока не знаю");


    private final int code;
    private final String responseText;

    Family(int code, String responseText) {
        this.code = code;
        this.responseText = responseText;
    }

    public static Family fromString(String text) {
        for (Family b : Family.values()) {
            if (b.responseText.equalsIgnoreCase(text)) {
                return b;
            }
        }
        return null;
    }

    public String getResponseText() {
        return responseText;
    }

    @Override
    public int getCode() {
        return code;
    }
}
