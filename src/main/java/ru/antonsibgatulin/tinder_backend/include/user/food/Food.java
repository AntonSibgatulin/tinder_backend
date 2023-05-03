package ru.antonsibgatulin.tinder_backend.include.user.food;

import ru.antonsibgatulin.tinder_backend.include.user.IMainInformation;
import ru.antonsibgatulin.tinder_backend.include.user.sport.Sport;

public enum Food implements IMainInformation {
    VEGANISM(0,"Веганство"),
    VEGETARIANISM(0,"Вегетарианство"),
    PESCATARIANISM(0,"Пескетарианство"),
    KOSHER_FOOD(0,"Кошерная еда"),
    HALAL(0,"Халяль"),
    LIKE_BEAF(0,"Люблю мясо"),
    EAT_ALL(0,"Ем всё"),
    ANOTHER(0,"Другое"),
    ;



    private final int code;
    private final String reasonText;


    Food(int code, String reasonText) {
        this.code = code;
        this.reasonText = reasonText;
    }


    public static Food fromString(String text) {
        for (Food b : Food.values()) {
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
