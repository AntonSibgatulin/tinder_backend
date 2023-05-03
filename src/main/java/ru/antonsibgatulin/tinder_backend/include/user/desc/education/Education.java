package ru.antonsibgatulin.tinder_backend.include.user.desc.education;

import ru.antonsibgatulin.tinder_backend.include.user.IMainInformation;

public enum Education implements IMainInformation {

    BAKALAVR("Бакалавриат",0),
    KOLLEGE("Колледж",1),
    AVE_SCH("Средняя школа",2),
    DOCKTOR("Доктор наук",3),
    ASPIRANT("Аспирантура",4),
    MAGISTRAT("Магистратура",5),
    TECH("Техникум",6);


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
