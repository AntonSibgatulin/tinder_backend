package ru.antonsibgatulin.tinder_backend.include.user.desc.smoking;

import ru.antonsibgatulin.tinder_backend.include.user.IMainInformation;

public enum Smoking implements IMainInformation {
    SMOKING_FOR_CAMPANY(0,"Курю за компанию"),
    SMOKING_WHEN_I_DRUNK(1,"Курю, когда выпью"),
    DO_NOT_SMOKING(2,"Не курю"),
    SMOKING(3,"Курю"),
    THROWS(4,"Бросаю"),

    ;


    private final int code;
    private final String reasonText;

    Smoking(int code, String reasonText) {
        this.code = code;
        this.reasonText = reasonText;
    }


    public static Smoking fromString(String text) {
        for (Smoking b : Smoking.values()) {
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
