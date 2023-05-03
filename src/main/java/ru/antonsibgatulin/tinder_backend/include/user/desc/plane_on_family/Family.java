package ru.antonsibgatulin.tinder_backend.include.user.desc.plane_on_family;

import ru.antonsibgatulin.tinder_backend.include.user.IMainInformation;

public enum Family implements IMainInformation {
    I_WANT_KID(0,"Я хочу детей"),
    I_DO_NOT_WANT_KID(1,"Я не хочу детей"),
    I_HAVEA_KID_AND_WANT_KID(2,"У меня есть дети,и я хочу ещё"),
    I_HAVE_A_KID_AND_I_DO_NOT_WANT_KID(3,"У меня есть дети,но больше не хочу"),
    UNTILL_DO_NOT_KNOW(4,"Пока не знаю");


    private final int code;
    private final String reasonText;

    Family(int code, String reasonText) {
        this.code = code;
        this.reasonText = reasonText;
    }

    public static Family fromString(String text) {
        for (Family b : Family.values()) {
            if (b.reasonText.equalsIgnoreCase(text)) {
                return b;
            }
        }
        return null;
    }


    @Override
    public int getCode() {
        return code;
    }
}
