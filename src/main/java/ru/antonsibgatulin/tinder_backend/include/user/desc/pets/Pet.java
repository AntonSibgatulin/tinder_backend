package ru.antonsibgatulin.tinder_backend.include.user.desc.pets;

import ru.antonsibgatulin.tinder_backend.include.user.IMainInformation;

public enum Pet implements IMainInformation {
    DOG(0,"Собака"),
    CAT(1,"Кошка"),
    REPTILE(2,"Рептилия"),
    AMPHIBIAN(3,"Амфибия"),
    BIRD(4,"Птица"),
    FISH(5,"Рыбки"),
    NOT_BUT_I_NEED(6,"Нет,но хочу"),
    ANOTHER(7,"Другое"),
    TURTLE(8,"Черепаха"),
    HAMSTER(9,"Хомяк"),
    RABBIT(10,"Кролик"),
    I_HAVE_NOT(11,"Нет питомцев"),
    ALL(12,"Все перечисленные"),
    I_WANT_PET(13,"Я хочу питомца"),
    I_ALLERGIC(14,"У меня аллергия")
    ;

    private final int code;
    private final String reasonText;


    Pet(int code, String reasonText) {
        this.code = code;
        this.reasonText = reasonText;
    }


    public static Pet fromString(String text) {
        for (Pet b : Pet.values()) {
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
