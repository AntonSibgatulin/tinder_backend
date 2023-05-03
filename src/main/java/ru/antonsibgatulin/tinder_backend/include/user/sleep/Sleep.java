package ru.antonsibgatulin.tinder_backend.include.user.sleep;

import ru.antonsibgatulin.tinder_backend.include.user.IMainInformation;
import ru.antonsibgatulin.tinder_backend.include.user.plane_on_family.Family;

public enum Sleep implements IMainInformation {
    LARK(0,"Жаворонок"),
    OWL(0,"Сова"),
    AVERAGE(0,"Среднее"),
    ;


    private final int code;
    private final String reasonText;


    Sleep(int code, String reasonText) {
        this.code = code;
        this.reasonText = reasonText;
    }


    public static Sleep fromString(String text) {
        for (Sleep b : Sleep.values()) {
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
