package ru.antonsibgatulin.tinder_backend.include.user.desc.socialnetwork;

import ru.antonsibgatulin.tinder_backend.include.user.IMainInformation;

public enum SocialNetwork implements IMainInformation {

    INFLUENCER(0,"Инфлюенсер"),
    ACTIVE_USER(1,"Аквтивный пользователь"),
    THERE_I_HAVE_NOT(2,"Меня там нет"),
    JUST_SEE(3,"Просто смотрю"),


    ;

    private final int code;
    private final String reasonText;


    SocialNetwork(int code, String reasonText) {
        this.code = code;
        this.reasonText = reasonText;
    }

    public static SocialNetwork fromString(String text) {
        for (SocialNetwork b : SocialNetwork.values()) {
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
