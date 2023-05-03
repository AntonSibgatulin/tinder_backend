package ru.antonsibgatulin.tinder_backend.include.user.drink;

import ru.antonsibgatulin.tinder_backend.include.user.IMainInformation;
import ru.antonsibgatulin.tinder_backend.include.user.styles.Style;

public enum Drink implements IMainInformation {
    IT_IS_NOT_FOR_ME(0,"Это не для меня"),
    I_AM_NOT_DRINK(1,"Я не пью"),
    I_FOR_NORMILIZE(2,"Я за трезвость"),
    SOMETIMES(3,"По особым случаям"),
    IN_WEEKEND(4,"В компании по выходным"),
    EVERY_EVENING(5,"Почти каждый вечер"),
    ;


    private final int code;
    private final String reasonText;


    Drink(int code, String reasonText) {
        this.code = code;
        this.reasonText = reasonText;
    }

    public static Drink fromString(String text) {
        for (Drink b : Drink.values()) {
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
