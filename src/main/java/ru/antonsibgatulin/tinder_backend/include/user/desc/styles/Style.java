package ru.antonsibgatulin.tinder_backend.include.user.desc.styles;

import ru.antonsibgatulin.tinder_backend.include.user.IMainInformation;

public enum Style implements IMainInformation {

    I_MANY_WRITE(0,"Много переписываюсь"),
    I_MANY_TALK_ON_CELLPHONE(1,"Общаюсь по телефону"),
    I_LIKE_VIDEOCHAT(2,"Люблю видеочаты"),
    DO_NOT_TYPING(3,"Не люблю чатиться"),
    BETTER_MEETING_YOU(4,"Лучше встречу лично");


    private final int code;
    private final String reasonText;


    Style(int code, String reasonText) {
        this.code = code;
        this.reasonText = reasonText;
    }


    public static Style fromString(String text) {
        for (Style b : Style.values()) {
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
