package ru.antonsibgatulin.tinder_backend.include.user.sport;

import ru.antonsibgatulin.tinder_backend.include.user.IMainInformation;
import ru.antonsibgatulin.tinder_backend.include.user.smoking.Smoking;

public enum Sport implements IMainInformation {
    EVERY_DAY(0,"Каждый день"),
    OFTEN  (1,"Часто"),
    SOMETIMES (2,"Иногда"),
    NEVER(3,"Никогда"),

    ;


    private final int code;
    private final String reasonText;


    Sport(int code, String reasonText) {
        this.code = code;
        this.reasonText = reasonText;
    }


    public static Sport fromString(String text) {
        for (Sport b : Sport.values()) {
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
