package ru.antonsibgatulin.tinder_backend.include.user.education;

import ru.antonsibgatulin.tinder_backend.include.user.IMainInformation;
import ru.antonsibgatulin.tinder_backend.include.user.symbol_zodiac.Symbols;

public enum Education implements IMainInformation {

    BAKALAVR("Бакалавриат",0),
    KOLLEGE("Колледж",0),
    AVE_SCH("Средняя школа",0),
    DOCKTOR("Доктор наук",0),
    ASPIRANT("Аспирантура",0),
    MAGISTRAT("Магистратура",0),
    TECH("Техникум",0);


    private final String reasonText;
    private final int code;

    Education(String reasonText, int code) {
        this.reasonText = reasonText;
        this.code = code;
    }

    public static Education fromString(String text) {
        for (Education b : Education.values()) {
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
