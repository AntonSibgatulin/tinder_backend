package ru.antonsibgatulin.tinder_backend.include.user.plane_on_family;

import ru.antonsibgatulin.tinder_backend.include.user.IMainInformation;

public enum Family implements IMainInformation {
    I_WANT_KID(0,"Я хочу детей"),
    I_DO_NOT_WANT_KID(0,"Я не хочу детей"),
    I_HAVEA_KID_AND_WANT_KID(0,"У меня есть дети,и я хочу ещё"),
    I_HAVE_A_KID_AND_I_DO_NOT_WANT_KID(0,"У меня есть дети,но больше не хочу"),
    UNTILL_DO_NOT_KNOW(0,"Пока не знаю");


    private final int code;
    private final String responseText;

    Family(int code, String responseText) {
        this.code = code;
        this.responseText = responseText;
    }


    @Override
    public int getCode() {
        return 0;
    }
}
