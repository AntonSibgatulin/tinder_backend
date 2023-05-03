package ru.antonsibgatulin.tinder_backend.include.user.desc.symbol_zodiac;


import ru.antonsibgatulin.tinder_backend.include.user.IMainInformation;

public enum Symbols implements IMainInformation {

    KOZEROG(0,"Козерог"),

    VODOLEY(1,"Водолей"),
    RIBI(2,"Рыбы"),
    OVEN(3,"Овен"),
    TELEC(4,"Телец"),
    BLIZNECI(5,"Близнецы"),
    RAK(6,"Рак"),
    LEV(7,"Лев"),
    DEVA(8,"Дева"),
    VESI(9,"Весы"),
    SKORPION(10,"Скорпион"),
    STRELEC(11,"Стрелец");


    private final String reasonText;
    private final int code;



    Symbols(int code,String reasonText) {
        this.reasonText = reasonText;
        this.code = code;

    }

    public static Symbols fromString(String text) {
        for (Symbols b : Symbols.values()) {
            if (b.reasonText.equalsIgnoreCase(text)) {
                return b;
            }
        }
        return null;
    }


    @Override
    public String toString() {
        return reasonText;
    }

    @Override
    public int getCode(){
        return code;
    }
}
